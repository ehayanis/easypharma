package com.mm.app.utilities;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.mm.app.model.Client;
import com.mm.app.model.Product;

public class ProductTableModel extends AbstractTableModel{

	List<Product> productList;
	String headerList[] = new String[]{"Identifiant", "Désignation", "Réference", "Prix"};

	public ProductTableModel(List list) {
		productList = list;
	}

	public int getColumnCount() {
		return 4;
	}

	public int getRowCount() {
		return productList.size();
	}

	public Object getValueAt(int row, int column) {
		Product entity = null;
		entity= productList.get(row);

		switch (column) {
		case 0:
			return entity.getId();
		case 1:
			return entity.getDesignation();
		case 2:
			return entity.getReference();
		case 3:
			return entity.getPu();
		default:
			return ""; 
		}

	}

	public String getColumnName(int col) {
		return headerList[col];
	}
	
}