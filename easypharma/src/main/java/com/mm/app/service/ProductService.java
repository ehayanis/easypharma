package com.mm.app.service;

import java.util.List;

import com.mm.app.model.Product;
import com.mm.app.model.VenteProduit;


public interface ProductService {

	public List<Product> getProducts();
	
	public Product findProduct(int id);

	public Product findProductByReference(String selectedValue);
	
	public List<Product> findProductByCriteria(String criteria);
	
	public VenteProduit getVenteProduitByClientAndProduitId(Integer venteId, Integer produitId);

	public List<VenteProduit> findHistoriqueProductForClient(Integer productId, Integer id);

}

