package com.mm.app.utilities;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.mm.app.model.PrescriptionProduct;
import com.mm.app.model.Product;

public class PrescriptionProductTableModel extends AbstractTableModel {

	private static final long serialVersionUID = -9086590657086338119L;
	private List<PrescriptionProduct> listPrescriptionProducts;
	private String[] columns;

	public PrescriptionProductTableModel(List<PrescriptionProduct> prescriptionProducts) {
		super();
		listPrescriptionProducts = prescriptionProducts;
		columns = new String[] { "Id", "Désignation", "Réglement", "Prix Usine", "Date Péremption", "Qté" };
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
		return listPrescriptionProducts.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		PrescriptionProduct prescriptionProduct = listPrescriptionProducts.get(row);
		Product product = prescriptionProduct.getProduct();
		switch (col) {
		case 0:
			return product != null ? product.getId() : null;
		case 1:
			return product != null ? product.getDesignation() : null;
		case 2:
			return product != null ? product.getReglement() : null;
		case 3:
			return product != null ? product.getPrixUsine() : null;
		case 4:
			return product != null ? product.getDatePermeption() : null;
		case 5:
			return prescriptionProduct.getQte();
		default:
			return null;
		}
	}

	@Override
	public String getColumnName(int col) {
		return columns[col];
	}

}