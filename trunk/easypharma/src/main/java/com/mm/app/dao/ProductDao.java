package com.mm.app.dao;

import java.util.List;

import com.mm.app.model.Product;
import com.mm.app.model.VenteProduit;

public interface ProductDao {
	
	public List<Product> getProducts();
	
	public Product findProduct(int id);

	public Product findProductByReference(String selectedValue);
	
	public VenteProduit getVenteProduitByClientAndProduitId(Integer venteId, Integer produitId);
}
