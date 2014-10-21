package com.mm.app.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.mm.app.dao.ProductDao;
import com.mm.app.model.Product;

public class ProductDaoImpl implements ProductDao{
	
	private EntityManager em;
	
	public ProductDaoImpl(EntityManager em) {
		this.em = em;
	}

	@Override
	public List<Product> getProducts() {
		TypedQuery<Product> query = em.createQuery("SELECT p FROM Product p", Product.class);
		return query.getResultList();
	}

	@Override
	public Product findProduct(int id) {
		return em.find(Product.class, id);
	}

	@Override
	public Product findProductByReference(String selectedValue) {
		Product p = (Product) em.createNamedQuery("findProductByReference").setParameter("reference", selectedValue).getSingleResult();
		return p;
	}

}
