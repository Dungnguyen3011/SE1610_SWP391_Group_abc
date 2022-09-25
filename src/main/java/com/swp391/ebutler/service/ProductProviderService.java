package com.swp391.ebutler.service;

import java.util.List;

import com.swp391.ebutler.entities.ProductProvider;

public interface ProductProviderService {
	public List<ProductProvider> listAll();

	public ProductProvider save(ProductProvider pProvider);

	public ProductProvider delete(int id);

	public ProductProvider update(ProductProvider pProvider);

	public ProductProvider getById(int id);
}
