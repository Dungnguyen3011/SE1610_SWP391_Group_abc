package com.swp391.ebutler.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swp391.ebutler.entities.Product;
import com.swp391.ebutler.entities.ProductProvider;
import com.swp391.ebutler.entities.Provider;
import com.swp391.ebutler.model.dto.ProductProviderDTO;
import com.swp391.ebutler.model.mapper.ProductProviderMapper;
import com.swp391.ebutler.repositories.ProductProviderRepository;
import com.swp391.ebutler.repositories.ProductRepository;
import com.swp391.ebutler.repositories.ProviderRepository;
import com.swp391.ebutler.service.ProductProviderService;

@Service
public class ProductProviderServiceImp implements ProductProviderService {
	@Autowired
	ProductProviderRepository pProviderRepo;
	@Autowired
	ProductRepository productRepo;
	@Autowired
	ProviderRepository providerRepo;
	
	
	@Override
	public List<ProductProviderDTO> listAll(){
		List<ProductProvider> result = pProviderRepo.findAll();
		List<ProductProviderDTO> listDTO = new ArrayList<>();
		result.forEach(v -> listDTO.add(ProductProviderMapper.toProductCategoryDTO(v)) );
		return listDTO;
	}

	@Override
	public ProductProviderDTO save(ProductProviderDTO pProviderDTO) {
		ProductProvider pProvider = toProductProvider(pProviderDTO);
		return ProductProviderMapper.toProductCategoryDTO(pProviderRepo.save(pProvider));	
	}

	@Override
	public ProductProviderDTO delete(int id) {
		ProductProvider pProvider = getById(id);
		if(pProvider != null) {
			pProvider.setStatus(false);
			return ProductProviderMapper.toProductCategoryDTO(pProviderRepo.save(pProvider));
		}
		return null;
	}

	@Override
	public ProductProviderDTO getByIdDTO(int id) {
		ProductProvider result = pProviderRepo.findById(id).get();
		return ProductProviderMapper.toProductCategoryDTO(result);
	}

	@Override
	public ProductProvider getById(int id) {
		return pProviderRepo.findById(id).get();
	}
	
	public ProductProvider toProductProvider(ProductProviderDTO pProviderDTO) {
		ProductProvider pProvider = new ProductProvider();
		pProvider.setProductproviderId(pProviderDTO.getProductproviderId());
		pProvider.setRating(pProviderDTO.getRating());
		pProvider.setUnitPrice(pProviderDTO.getUnitPrice());
		pProvider.setQuantity(pProviderDTO.getQuantity());
		pProvider.setStatus(pProviderDTO.getStatus());
		pProvider.setProduct(getProductById(pProviderDTO.getProduct_id()));
		pProvider.setProvider(getProviderById(pProviderDTO.getProvider_id()));
		return pProvider;
	}
	
	public Product getProductById(int id) {
		return productRepo.findById(id).get();
	}
	
	public Provider getProviderById(int id) {
		return providerRepo.findById(id).get();
	}
}
