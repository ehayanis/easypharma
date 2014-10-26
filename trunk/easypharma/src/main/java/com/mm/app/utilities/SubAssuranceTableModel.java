package com.mm.app.utilities;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import com.mm.app.model.Assurance;

public class SubAssuranceTableModel extends AbstractTableModel{

	List<Assurance> assurancesList;
	String headerList[] = new String[]{"Réference", "Assurance"};

	public SubAssuranceTableModel(List list) {
		assurancesList = list;
	}

	@Override
	public int getColumnCount() {
		return 2;
	}

	@Override
	public int getRowCount() {
		return assurancesList.size();
	}

	@Override
	public Object getValueAt(int row, int column) {
		Assurance entity = null;
		entity= assurancesList.get(row);

		switch (column) {
		case 0:
			return entity.getId();
		case 1:
			return entity.getName();
		default:
			return ""; 
		}

	}

	public String getColumnName(int col) {
		return headerList[col];
	}

}