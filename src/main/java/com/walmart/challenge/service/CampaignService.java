package com.walmart.challenge.service;

import java.util.List;

import com.walmart.challenge.domain.Product;

public interface CampaignService {
	public CampaignService setSearchText(String searchText);
	public List<Product> applyDiscount(List<Product> products);
}
