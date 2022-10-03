package com.swp391.ebutler.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swp391.ebutler.entities.Manufacturer;
import com.swp391.ebutler.entities.Product;
import com.swp391.ebutler.entities.ProductCategory;
import com.swp391.ebutler.model.dto.ProductDTO;
import com.swp391.ebutler.model.mapper.ProductMapper;
import com.swp391.ebutler.repositories.ManufacturerRepository;
import com.swp391.ebutler.repositories.ProductCategoryRepository;
import com.swp391.ebutler.repositories.ProductRepository;
import com.swp391.ebutler.service.ProductService;

@Service
public class ProductServiceImp implements ProductService{
	@Autowired
	ProductRepository productRepo;
	@Autowired
	ProductCategoryRepository procateRepo;
	@Autowired
	ManufacturerRepository manuRepo;
	
	@Override
	public List<ProductDTO> listAll(){
		List<Product> result = productRepo.findAll();
		List<ProductDTO> listDTO = new ArrayList<>();
		result.forEach(v -> listDTO.add(ProductMapper.toProductDTO(v)));
		return listDTO;
	}

	@Override
	public ProductDTO save(ProductDTO productDTO) {
		Product product = toProduct(productDTO);
		return ProductMapper.toProductDTO(productRepo.save(product));	
	}

	@Override
	public ProductDTO delete(int id) {
		Product product = getById(id);
		if(product != null) {
			product.setStatus(false);
			return ProductMapper.toProductDTO(productRepo.save(product)) ;
		}
		return null;
	}

	@Override
	public Product getById(int id) {
		return productRepo.findById(id).get();
	}

	@Override
	public ProductDTO getByIdDTO(int id) {
		Product product = productRepo.findById(id).get();
		if(product != null) {
			return ProductMapper.toProductDTO(product);
		}
		return null;
	}
	
	public Product toProduct(ProductDTO productDTO) {
		Product product = new Product();
		product.setProductId(productDTO.getProductId());
		product.setProductName(productDTO.getProductName());
		product.setDescription(productDTO.getDescription());
		product.setImage(productDTO.getImage());
		product.setStatus(productDTO.getStatus());
		product.setManu(getManuById(productDTO.getManufacturerId()));
		product.setProCategory(getProCateId(productDTO.getProductcategoryId()));
		return product;
	}
	
	public Manufacturer getManuById(int id) {
		return manuRepo.findById(id).get();
	}
	
	public ProductCategory getProCateId(int id) {
		return procateRepo.findById(id).get();
	}

	@Override
	public List<ProductDTO> searchByName(String name) {
		List<Product> result = productRepo.findByProductNameContaining(name);
		List<ProductDTO> listDTO = new ArrayList<>();
		result.forEach(v -> listDTO.add(ProductMapper.toProductDTO(v)));
		return listDTO;
	}

	@Override
	public List<ProductDTO> listByCate(int cid) {
		ProductCategory procate = getProCateId(cid);
		List<Product> result = productRepo.findByProCategory(procate);
		List<ProductDTO> listDTO = new ArrayList<>();
		result.forEach(v -> listDTO.add(ProductMapper.toProductDTO(v)));
		return listDTO;
	}

	@Override
	public List<ProductDTO> listByManu(int mid) {
		Manufacturer manu = getManuById(mid);
		List<Product> result = productRepo.findByManu(manu);
		List<ProductDTO> listDTO = new ArrayList<>();
		result.forEach(v -> listDTO.add(ProductMapper.toProductDTO(v)));
		return listDTO;
	}

	
}
