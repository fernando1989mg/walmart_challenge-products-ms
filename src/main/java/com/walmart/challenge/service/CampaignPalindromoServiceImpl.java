package com.walmart.challenge.service;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.walmart.challenge.domain.Product;
import com.walmart.challenge.exception.ExceptionControllerAdvice;

/*
 * La lógica de campaña debería estar en otro servicio
 * en virtud del tiempo de entrega la dejamos aquí para  
 * apurar el desarrollo solamente
 * */
@Service
public class CampaignPalindromoServiceImpl implements CampaignService {
	private static final Logger LOGGER = LoggerFactory.getLogger(CampaignPalindromoServiceImpl.class);
	
	@Value("${campaign.palindromo.enable}")
	private Boolean campaignPalindromoEnable;
	
	@Value("${campaign.palindromo.discount}")
	private Integer campaignPalindromoDiscount;
	
	private String searchText;

	@Override
	public List<Product> applyDiscount(List<Product> products) {
		if(products == null) {
			LOGGER.error("[CampaignPalindromoServiceImpl][applyDiscount][lista de productos es null]");
			products = Collections.emptyList();
		}
		if(!campaignPalindromoEnable) {
			return products;
		}
		if(searchText==null) {
			//esta implementación de CampaignService requiere primero invocar a setSearchText
			throw new IllegalStateException("you must first invoke setTextSearch before invoking this method, e.g.: obj.setTextSearch (..). applyDiscount (..)");
		}
		
		return products.stream().map(product -> {
			
			if(this.searchText.length() > 3 &&		
				this.searchText.equals(StringUtils.reverse(this.searchText)) &&
				  (product.getBrand().contains(this.searchText) ||
				   product.getDescription().contains(this.searchText))) {
				
				product.setOldPrice(product.getPrice());
				product.setPrice((product.getPrice() * campaignPalindromoDiscount) / 100);
				product.setDiscountRate(campaignPalindromoDiscount);
			}
			
			return product;
		})
	    .collect(Collectors.toList());
	}

	@Override
	public CampaignService setSearchText(String searchText) {
		this.searchText = searchText;
		return this;
	}

	public String getSearchText() {
		return searchText;
	}
}
