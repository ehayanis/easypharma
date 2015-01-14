package com.mm.app.service.impl;

import java.util.List;

import javax.persistence.EntityManager;

import com.mm.app.dao.ProductDao;
import com.mm.app.dao.impl.ProductDaoImpl;
import com.mm.app.model.Product;
import com.mm.app.model.VenteProduit;
import com.mm.app.service.ProductService;

public class ProductServiceImpl implements ProductService{
	
	private EntityManager em;
	private ProductDao dao;
	
	public ProductServiceImpl(EntityManager em) {
		this.em = em;
		dao = new ProductDaoImpl(em);
	}

	@Override
	public List<Product> getProducts() {
		return dao.getProducts();
	}

	@Override
	public Product findProduct(int id) {
		return dao.findProduct(id);
	}

	@Override
	public Product findProductByReference(String selectedValue) {
		return dao.findProductByReference(selectedValue);
	}

	@Override
	public VenteProduit getVenteProduitByClientAndProduitId(Integer venteId, Integer produitId) {
		return dao.getVenteProduitByClientAndProduitId(venteId, produitId);
	}

}
