package com.ecom.collection;

import java.util.List;

import com.ecom.dao.ProductDao;
import com.ecom.model.Product;
public class ProductCollection implements ICollection<Product> {

	private static ProductCollection productCollection;
	private List<Product> productList;
	private ProductDao productDao;
	

	public ProductCollection() {
		super();
		this.productDao = productDao.getProductDao();
	}

	public static ProductCollection getProductCollection() {
		if (productCollection == null) {
			synchronized (ProductCollection.class) {
				if (productCollection == null) {
					productCollection = new ProductCollection();
				}
			}
		}
		return productCollection;
	}

	@Override
	public List<Product> findAll() {

		productList = productDao.findAll();
		return productList;
	}

	@Override
	public Product findOne(int productId) {

		Product product = productDao.findOne(productId);
		return product;
	}

	@Override
	public boolean createNew(Product product) {

		return productDao.createNew(product);
	}

	@Override
	public boolean findOneAndDelete(int productId) {

		return productDao.findOneAndDelete(productId);
	}

	@Override
	public boolean findOneAndUpdate(int productId, Product product) {

		return productDao.findOneAndUpdate(productId, product);
	}
}
