package com.mm.app.utilities;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.mm.app.model.Client;
import com.mm.app.model.Product;

public class ProductTableModel extends AbstractTableModel{

	List<Product> productList;
	String headerList[] = new String[]{"Id", "Désignation", "Réglement", "Prix Usine", "Date Péremption"};

	public ProductTableModel(List list) {
		productList = list;
	}

	public int getColumnCount() {
		return 5;
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
			return entity.getReglement();
		case 3:
			return entity.getPrixUsine();
		case 4:
			return entity.getDatePermeption();
		default:
			return ""; 
		}

	}

	public String getColumnName(int col) {
		return headerList[col];
	}
	
}