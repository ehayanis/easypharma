package com.mm.app.utilities;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.mm.app.model.Assurance;
import com.mm.app.model.AssuranceClient;

public class SubAssuranceTableModel extends AbstractTableModel{

	List<AssuranceClient> assurancesList;
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
		AssuranceClient entity = null;
		entity= assurancesList.get(row);

		switch (column) {
		case 0:
			return entity.getAssurance().getId();
		case 1:
			return entity.getAssurance().getName();
		default:
			return ""; 
		}

	}

	public String getColumnName(int col) {
		return headerList[col];
	}

}