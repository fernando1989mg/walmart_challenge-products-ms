package com.walmart.challenge.fixture;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.walmart.challenge.domain.Product;

public class DomainFixture {
	public static Map<String, Object> SearchingOK(){
		return new HashMap<String, Object>()
		{
			private static final long serialVersionUID = 1L;

			{
		        put("totalItems", Integer.valueOf(1));
		        put("totalPages", Integer.valueOf(1));
		        put("currentPage", Integer.valueOf(0));
		        put("products", Arrays.asList(new Product(), new Product()));
		    }
		};
	}

	public static String SearchingRequest() {
		return "texto";
	}
	
	public static List<Product> productList() {
		return Arrays.asList(
				new Product(174,"adsda", "dasdsd", "http://imagen",1000,0,0), 
				new Product(175,"adsda", "xccxzc5", "http://imagen",500,1000,50),
				new Product(175,"dsd", "adsda", "http://imagen",500,1000,50)
		);
	}
}
