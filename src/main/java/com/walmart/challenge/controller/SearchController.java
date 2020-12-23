package com.walmart.challenge.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.walmart.challenge.service.SearchService;

@RestController
public class SearchController {

	@Autowired
	private SearchService searchService;
	
    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    public ResponseEntity<Map<String, Object>> searchProducts(
    		@RequestParam(value="q") String request,
    		@RequestParam(defaultValue = "0") int page,
    		@RequestParam(defaultValue = "8") int size) {
    	
    	Map<String, Object> products = searchService.getBySearch(request, page, size);
    	
    	return new ResponseEntity<>(products, HttpStatus.OK);
    }
}
