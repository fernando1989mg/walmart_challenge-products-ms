package com.walmart.challenge.repositories;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.walmart.challenge.domain.Product;

public interface ProductsRepository extends MongoRepository<Product, Integer>{
	@Query("{ 'id' : ?0 }")
	public Optional<Product> findById(Integer id);
	  
	@Query("{ '$or':[ {'brand' : { $regex: ?0 }}, {'description' : { $regex: ?0 }} ] }")
	public Page<Product> findByRegex(String regexp, Pageable pageable);
}
