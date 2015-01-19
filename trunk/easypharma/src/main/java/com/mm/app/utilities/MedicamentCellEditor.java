package com.mm.app.utilities;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.swing.AbstractCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableCellEditor;

import com.mm.app.view.SaleView;

public class MedicamentCellEditor extends AbstractCellEditor implements
		TableCellEditor, ActionListener {

	private static final long serialVersionUID = 1L;

	private String designation;
	private Set<String> listDesignation;
	private SaleView saleView;

	public MedicamentCellEditor(Set<String> listCountry, SaleView saleView) {
		this.listDesignation = listCountry;
		this.saleView = saleView;
	}

	@Override
	public Object getCellEditorValue() {
		return this.designation;
	}

	@Override
	public Component getTableCellEditorComponent(JTable table, Object value,
			boolean isSelected, int row, int column) {
		if (value instanceof String) {
			this.designation = (String) value;
		}

		final JComboBox<String> comboDesignation = new JComboBox<String>();
		comboDesignation.setEditable(true);
		comboDesignation.getEditor().getEditorComponent()
				.addKeyListener(new KeyAdapter() {

					String lastTypedText = "";
					List<String> comboBoxModel = new ArrayList<String>();

					@SuppressWarnings({ "rawtypes", "unchecked" })
					@Override
					public void keyReleased(KeyEvent e) {

						if (e.getKeyChar() == KeyEvent.VK_ENTER) {
							
							saleView.updateProductLine(designation);

						} else {
							JTextField typedTextField = (JTextField) comboDesignation
									.getEditor().getEditorComponent();
							if (typedTextField.getText() != null
									&& !comboBoxModel.contains(typedTextField
											.getText())
									&& !typedTextField.getText().equals(
											lastTypedText)) {
								comboBoxModel.clear();
								lastTypedText = typedTextField.getText();
								if (!lastTypedText.equals("")) {
									comboBoxModel.add(lastTypedText);
								}
								for (String key : listDesignation) {
									if (key.toLowerCase().startsWith(
											lastTypedText.toLowerCase())) {
										comboBoxModel.add(key);
									}
								}
								comboDesignation
										.setModel(new DefaultComboBoxModel(
												comboBoxModel.toArray()));
								comboDesignation.showPopup();
							}
						}
					}

				});

		/*
		 * for (String aCountry : listCountry) { comboCountry.addItem(aCountry);
		 * }
		 * 
		 * comboCountry.setSelectedItem(country);
		 */
		comboDesignation.addActionListener(this);

		if (isSelected) {
			comboDesignation.setBackground(table.getSelectionBackground());
		} else {
			comboDesignation.setBackground(table.getSelectionForeground());
		}

		return comboDesignation;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		@SuppressWarnings("unchecked")
		JComboBox<String> comboCountry = (JComboBox<String>) event.getSource();
		this.designation = (String) comboCountry.getSelectedItem();
	}

}
