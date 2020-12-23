package com.walmart.challenge.controller;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.walmart.challenge.fixture.DomainFixture;
import com.walmart.challenge.service.SearchService;

@RunWith(MockitoJUnitRunner.class)
public class SearchControllerTest {
    @InjectMocks
    private SearchController searchController;

    @Mock
    private SearchService searchService;

    @Test
    public void shouldReturnSearchingOK(){
        when(searchService.getBySearch(any(String.class), any(Integer.class), any(Integer.class)))
        .thenReturn(DomainFixture.SearchingOK());
        
        ResponseEntity<Map<String, Object>> respuesta = searchController.searchProducts(DomainFixture.SearchingRequest(),0,1);
        
        Assert.assertTrue(respuesta.getBody().containsKey("totalItems"));
        Assert.assertTrue(respuesta.getBody().containsKey("totalPages"));
        Assert.assertTrue(respuesta.getBody().containsKey("currentPage"));
        Assert.assertTrue(respuesta.getBody().containsKey("products"));
    }
}
