package com.walmart.challenge.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;

import com.walmart.challenge.domain.Product;
import com.walmart.challenge.fixture.DomainFixture;

@RunWith(MockitoJUnitRunner.class)
public class CampaignPalindromoServiceTest {
	@InjectMocks
	private CampaignPalindromoServiceImpl campaignPalindromoServiceImpl;
	
    @Before
    public void setUp() {
		ReflectionTestUtils.setField(campaignPalindromoServiceImpl, "campaignPalindromoEnable", true);
		ReflectionTestUtils.setField(campaignPalindromoServiceImpl, "campaignPalindromoDiscount", 50);
    }
    
    @Test(expected = IllegalStateException.class)
    public void applyDiscount() {
    	campaignPalindromoServiceImpl.applyDiscount(null);
    }
    
    @Test
    public void applyDiscount2() {
    	List<Product> products = campaignPalindromoServiceImpl.setSearchText("").applyDiscount(null);
    	
    	Assert.assertEquals(0, products.size());
    }
    
    @Test
    public void applyDiscountNoPalindromo() {
    	List<Product> products = 
    			campaignPalindromoServiceImpl.setSearchText("").applyDiscount(DomainFixture.productList());
    	
    	Assert.assertEquals(3, products.size());
    	Assert.assertEquals(1000, products.get(0).getPrice());
    	Assert.assertEquals(500, products.get(1).getPrice());
    }
    
    @Test
    public void applyDiscountPalindromoAndDescription() {
    	List<Product> products = 
    			campaignPalindromoServiceImpl.setSearchText("adsda").applyDiscount(DomainFixture.productList());
    	
    	Assert.assertEquals(3, products.size());
    	Assert.assertEquals(500, products.get(0).getPrice());
    	Assert.assertEquals(250, products.get(1).getPrice());
    	Assert.assertEquals(250, products.get(2).getPrice());
    }
}
