package com.walmart.challenge.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.Pageable;

import com.walmart.challenge.fixture.DomainFixture;
import com.walmart.challenge.fixture.PageFacade;
import com.walmart.challenge.repositories.ProductsRepository;

@RunWith(MockitoJUnitRunner.class)
public class SearchServiceTest {

	@InjectMocks
	private SearchServiceImpl searchServiceImpl;
	
	@Mock
	private ProductsRepository productsRepository;
	
	@Mock
	private CampaignService campaignService;
	
	@Test
	public void getBySearchCheckInvalidParameters() {
        when(productsRepository.findByRegex(any(String.class), any(Pageable.class)))
        .thenReturn(new PageFacade());
        
        when(campaignService.setSearchText(any(String.class)))
        .thenReturn(campaignService);
        
        when(campaignService.applyDiscount(any(List.class)))
        .thenReturn(DomainFixture.productList());
        
		searchServiceImpl.getBySearch(null, 0, 0);
	}
	
	@Test
	public void getBySearchNumberParameter() {
        
        when(campaignService.setSearchText(any(String.class)))
        .thenReturn(campaignService);
        
        when(campaignService.applyDiscount(any(List.class)))
        .thenReturn(DomainFixture.productList());
        
		Map<String, Object> result = searchServiceImpl.getBySearch("174", 0, 0);
		
		Assert.assertEquals(result.get("currentPage"), 0);
		Assert.assertEquals(result.get("totalItems"), 1);
		Assert.assertEquals(result.get("totalPages"), 1);
	}
	
	@Test
	public void getBySearchStringParameter() {
        when(productsRepository.findByRegex(any(String.class), any(Pageable.class)))
        .thenReturn(new PageFacade());
        
        when(campaignService.setSearchText(any(String.class)))
        .thenReturn(campaignService);
        
        when(campaignService.applyDiscount(any(List.class)))
        .thenReturn(DomainFixture.productList());
        
        Map<String, Object> result = searchServiceImpl.getBySearch("adsda", 0, 0);
		
		Assert.assertEquals(0, result.get("currentPage"));
		Assert.assertEquals(Long.valueOf(3), result.get("totalItems"));
		Assert.assertEquals(1, result.get("totalPages"));
	}
}
