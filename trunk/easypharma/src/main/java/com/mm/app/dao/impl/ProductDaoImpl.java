package com.mm.app.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import com.mm.app.dao.ProductDao;
import com.mm.app.model.Product;
import com.mm.app.model.VenteProduit;

public class ProductDaoImpl implements ProductDao{
	
	private EntityManager em;
	
	public ProductDaoImpl(EntityManager em) {
		this.em = em;
	}

	public List<Product> getProducts() {
		List<Product> result = em.createQuery("SELECT p FROM Product p ORDER BY p.designation", Product.class).getResultList();
		return result; 
	}

	public Product findProduct(int id) {
		return em.find(Product.class, id);
	}

	public Product findProductByReference(String selectedValue) {
		Product p = (Product) em.createNamedQuery("findProductByReference").setParameter("reference", selectedValue).getSingleResult();
		return p;
	}

	public VenteProduit getVenteProduitByClientAndProduitId(Integer venteId, Integer produitId) {
		VenteProduit vp = (VenteProduit) em.createNamedQuery("findVenteProduitByClientProduit").setParameter("venteId", venteId).setParameter("produitId", produitId).getSingleResult();
		return vp;
	}

	public List<Product> findProductByCriteria(String criteria) {
		List<Product> products = em.createNamedQuery("findProductByCriteria").setParameter("criteria", "%" + criteria + "%").setMaxResults(5).getResultList();
		return products;
	}

	public List<VenteProduit> findHistoriqueProductForClient(Integer productId, Integer id) {
		List<VenteProduit> products = em.createNamedQuery("findHistoriqueProductForClient").setParameter("productId", productId).setParameter("clientId", id).getResultList();
		return products;
	}

}
