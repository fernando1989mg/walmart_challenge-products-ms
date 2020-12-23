package com.walmart.challenge.service;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.walmart.challenge.domain.Product;
import com.walmart.challenge.repositories.ProductsRepository;

@Service
public class SearchServiceImpl implements SearchService {
	
	@Autowired
	private ProductsRepository productsRepository;
	
	@Autowired
	private CampaignService campaignService;

	@Override
	public Map<String, Object> getBySearch(String searchText, int page, int size) {
		List<Product> products = Collections.emptyList();
		Map<String, Object> response = new HashMap<>();
		
		searchText = searchText == null ? "":searchText;
		size = size < 1 ? 1:size;
		
		if(StringUtils.isNumeric(searchText)) {
			products = this.getById(searchText);
			
			response.put("currentPage", 0);
			response.put("totalItems", 1);
			response.put("totalPages", 1);
		}else {
			Pageable paging = PageRequest.of(page, size);
			
			Page<Product> prodObj = productsRepository.findByRegex(searchText.toLowerCase(), paging);
			
			if(searchText.isEmpty()) {
				//random result when searchText is empty
				prodObj = productsRepository.findByRegex(searchText, PageRequest.of((int)(Math.random() * prodObj.getTotalPages()), size));
			}
			
			products = prodObj.getContent();
			response.put("currentPage", prodObj.getNumber());
			response.put("totalItems", prodObj.getTotalElements());
			response.put("totalPages", prodObj.getTotalPages());
		}
		
		response.put("products", campaignService.setSearchText(searchText).applyDiscount(products));
		
		return response;
	}
	
	
	private List<Product> getById(String search){
		Optional<Product> product = productsRepository.findById(Integer.parseInt(search));
		
		if(product.isPresent()) {
			return Arrays.asList(product.get());
		}
		 
		return Collections.emptyList();
	}

}
