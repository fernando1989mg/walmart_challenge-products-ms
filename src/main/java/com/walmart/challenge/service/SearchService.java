package com.walmart.challenge.service;

import java.util.Map;

public interface SearchService {
	public Map<String, Object> getBySearch(String searchText, int page, int size);
}
