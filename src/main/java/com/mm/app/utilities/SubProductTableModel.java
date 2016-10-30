package com.mm.app.utilities;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import com.mm.app.model.Assurance;
import com.mm.app.model.Product;

public class SubProductTableModel extends AbstractTableModel{

	List<Product> produitsTable;
	String headerList[] = new String[]{"Réference", "Libellé"};

	public SubProductTableModel(List list) {
		produitsTable = list;
	}

	public int getColumnCount() {
		return 2;
	}

	public int getRowCount() {
		return produitsTable.size();
	}

	public Object getValueAt(int row, int column) {
		Product entity = null;
		entity= produitsTable.get(row);

		switch (column) {
		case 0:
			return entity.getId();
		case 1:
			return entity.getDesignation();
		default:
			return ""; 
		}

	}

	public String getColumnName(int col) {
		return headerList[col];
	}

}