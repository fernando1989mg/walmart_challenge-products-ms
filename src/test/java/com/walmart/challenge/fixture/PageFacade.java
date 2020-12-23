package com.walmart.challenge.fixture;

import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.walmart.challenge.domain.Product;

public class PageFacade implements Page<Product> {

	@Override
	public int getNumber() {
		return 0;
	}

	@Override
	public int getSize() {
		return 0;
	}

	@Override
	public int getNumberOfElements() {
		return 0;
	}

	@Override
	public List<Product> getContent() {
		return DomainFixture.productList();
	}

	@Override
	public boolean hasContent() {
		return false;
	}

	@Override
	public Sort getSort() {
		return null;
	}

	@Override
	public boolean isFirst() {
		return false;
	}

	@Override
	public boolean isLast() {
		return false;
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasPrevious() {
		return false;
	}

	@Override
	public Pageable nextPageable() {
		return null;
	}

	@Override
	public Pageable previousPageable() {
		return null;
	}

	@Override
	public Iterator<Product> iterator() {
		return null;
	}

	@Override
	public int getTotalPages() {
		return 1;
	}

	@Override
	public long getTotalElements() {
		return 3;
	}

	@Override
	public <U> Page<U> map(Function<? super Product, ? extends U> converter) {
		return null;
	}

}
