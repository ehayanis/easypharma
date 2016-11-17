package com.mm.app.utilities;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.mm.app.model.Client;
import com.mm.app.model.Medecin;
import com.mm.app.model.Prescription;

public class PrescriptionTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 4790656057324147469L;
	private List<Prescription> prescriptions;
	private String[] columns;

	public PrescriptionTableModel(List<Prescription> aClubList) {
		super();
		prescriptions = aClubList;
		columns = new String[] { "Référence", "Client", "Médcin", "Date début de validité", "Date fin de validité", "Nombre de vente" };
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	@Override
	public int getColumnCount() {
		return columns.length;
	}

	@Override
	public int getRowCount() {
		return prescriptions.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		Prescription prescription = prescriptions.get(row);
		Client client = prescription.getClient();
		Medecin medecin = prescription.getMedecin();
		switch (col) {
		case 0:
			return prescription.getRef();
		case 1:
			return client != null ? client.getLastName() : null;
		case 2:
			return medecin != null ? medecin.getLastName() : null;
		case 3:
			return prescription.getStartDate();
		case 4:
			return prescription.getEndDate();
		default:
			return null;
		}
	}

	@Override
	public String getColumnName(int col) {
		return columns[col];
	}

}