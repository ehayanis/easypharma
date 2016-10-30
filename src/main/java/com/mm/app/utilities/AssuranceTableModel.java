package com.mm.app.utilities;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import com.mm.app.model.Assurance;

public class AssuranceTableModel extends AbstractTableModel{

	List<Assurance> assurancesList;
	String headerList[] = new String[]{"Réf", "Agence", "N° OFAS", "N° EAN", "N° RCC"};

	public AssuranceTableModel(List list) {
		assurancesList = list;
	}

	public int getColumnCount() {
		return 5;
	}

	public int getRowCount() {
		return assurancesList.size();
	}

	public Object getValueAt(int row, int column) {
		Assurance entity = null;
		entity= assurancesList.get(row);

		switch (column) {
		case 0:
			return entity.getId();
		case 1:
			return entity.getAgence();
		case 2:
			return entity.getOfas();
		case 3:
			return entity.getEan();
		case 4:
			return entity.getRcc();
		default:
			return ""; 
		}

	}

	public String getColumnName(int col) {
		return headerList[col];
	}

}