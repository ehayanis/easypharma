package com.mm.app.utilities;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.mm.app.model.Client;

public class ClientTableModel extends AbstractTableModel{

	List<Client> clientsList;
	String headerList[] = new String[]{"Id", "Réference", "Nom", "Prénom", "Age", "Date de Naissance"};

	public ClientTableModel(List list) {
		clientsList = list;
	}

	public int getColumnCount() {
		return 6;
	}

	public int getRowCount() {
		return clientsList.size();
	}

	public Object getValueAt(int row, int column) {
		Client entity = null;
		entity= clientsList.get(row);

		switch (column) {
		case 0:
			return entity.getId();
		case 1:
			return entity.getReference();
		case 2:
			return entity.getFirstName();
		case 3:
			return entity.getLastName();
		case 4:
			return entity.getAge();
		case 5:
			return entity.getBirthDate();
		default:
			return ""; 
		}

	}

	public String getColumnName(int col) {
		return headerList[col];
	}

}