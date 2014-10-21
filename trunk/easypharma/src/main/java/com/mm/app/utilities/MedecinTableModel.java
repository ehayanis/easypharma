package com.mm.app.utilities;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import com.mm.app.model.Assurance;
import com.mm.app.model.Medecin;

public class MedecinTableModel extends AbstractTableModel{

	List<Medecin> medecinsList;
	String headerList[] = new String[]{"Id", "Réference", "Nom", "Prénom", "Spécialité", "N° NRCC"};

	public MedecinTableModel(List list) {
		medecinsList = list;
	}

	@Override
	public int getColumnCount() {
		return 6;
	}

	@Override
	public int getRowCount() {
		return medecinsList.size();
	}

	@Override
	public Object getValueAt(int row, int column) {
		Medecin entity = null;
		entity= medecinsList.get(row);

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
			return entity.getSpeciality();
		case 5:
			return entity.getNrcc();
		default:
			return ""; 
		}

	}

	public String getColumnName(int col) {
		return headerList[col];
	}

}