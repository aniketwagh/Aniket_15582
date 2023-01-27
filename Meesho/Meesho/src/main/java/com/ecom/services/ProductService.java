package com.ecom.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ecom.dao.IProductRepository;
import com.ecom.dto.ProductData;
import com.ecom.model.Product;

@Service
public class ProductService implements IProductService {

	@Autowired
	private IProductRepository productRepository;

	private Product getProductEntity(ProductData productData) {
		Product product = new Product();
		product.setProductId(productData.getProductId());
		product.setProductName(productData.getProductName());
		product.setQuntity(productData.getQuntity());
		product.setProductDescription(productData.getProductDescription());
		product.setProductImage(productData.getProductImage());
		product.setProductPrice(productData.getProductPrice());
		product.setProductCategories(productData.getProductCategories());
		
		return product;
	}

	private ProductData getProductData(Product product) {
		ProductData productData = new ProductData();
		productData.setProductId(product.getProductId());
		productData.setProductName(product.getProductName());
		productData.setQuntity(product.getQuntity());
		productData.setProductDescription(product.getProductDescription());
		productData.setProductImage(product.getProductImage());
		productData.setProductPrice(product.getProductPrice());
		productData.setProductCategories(product.getProductCategories());
		return productData;
	}

	public List<ProductData> findAll() {
		List<ProductData> productDataList = new ArrayList<>();
		List<Product> products = productRepository.findAll();
		products.forEach(product -> {
			productDataList.add(getProductData(product));
		});
		return productDataList;
	}

	public ProductData findById(Long id) {
		Optional<Product> productOptional = productRepository.findById(id);
		if (productOptional == null) {
			new EntityNotFoundException("ProductNotFound");
		}
		return getProductData(productOptional.get());
	}

	public ProductData create(ProductData productData) {
		Product product = getProductEntity(productData);
		return getProductData(productRepository.save(product));
	}

	public boolean delete(Long id) {
		Product product = productRepository.findById(id).get();
		if (product != null) {
			productRepository.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public boolean findOneAndUpdate(Long id, ProductData productData) {
		Product product = productRepository.findById(id).orElse(null);
		if(product !=null) {
			product.setProductName(productData.getProductName());
			product.setProductCategories(productData.getProductCategories());
			product.setProductDescription(productData.getProductDescription());
			product.setProductId(productData.getProductId());
			product.setProductImage(productData.getProductImage());
			product.setProductPrice(productData.getProductPrice());
			product.setQuntity(productData.getQuntity());
			productRepository.save(product);
		}
		return true;
	}
}
