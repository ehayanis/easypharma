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

	public List<Product> getProducts() {
		return dao.getProducts();
	}

	public Product findProduct(int id) {
		return dao.findProduct(id);
	}

	public Product findProductByReference(String selectedValue) {
		return dao.findProductByReference(selectedValue);
	}

	public VenteProduit getVenteProduitByClientAndProduitId(Integer venteId, Integer produitId) {
		return dao.getVenteProduitByClientAndProduitId(venteId, produitId);
	}

	public List<Product> findProductByCriteria(String criteria) {
		return dao.findProductByCriteria(criteria);
	}

	public List<VenteProduit> findHistoriqueProductForClient(Integer productId, Integer id) {
		return dao.findHistoriqueProductForClient(productId, id);
	}

}
