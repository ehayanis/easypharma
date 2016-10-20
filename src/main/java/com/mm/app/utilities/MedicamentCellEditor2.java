package com.mm.app.utilities;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.AbstractCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableColumn;

import com.mm.app.view.SaleView;
import com.mm.app.view.SaleView2;

public class MedicamentCellEditor2 extends AbstractCellEditor implements
		TableCellEditor, ActionListener {

	private static final long serialVersionUID = 1L;

	private String designation;
	private Set<String> listDesignation;
	private SaleView2 saleView;
	private Map<Integer, JComboBox<String>> tableCellsEditor;

	public MedicamentCellEditor2(Set<String> listDesignation, SaleView2 saleView) {
		System.err.println(" New MedicamentCellEditor");
		this.listDesignation = listDesignation;
		this.saleView = saleView;
		this.tableCellsEditor = new HashMap<Integer, JComboBox<String>>();
	}

	@Override
	public Object getCellEditorValue() {
		return this.designation;
	}

	@Override
	public Component getTableCellEditorComponent(JTable table, Object value,
			boolean isSelected, int row, int column) {
		
		System.err.println("getTableCellEditorComponent is called "+value+" At Row : "+row);
		
		if (value instanceof String) {
			this.designation = (String) value;
		}
		
		final JComboBox<String> comboDesignation;
		boolean rowExist = false;
		for (Integer rowNum : tableCellsEditor.keySet()) {
			if (rowNum.equals(row)) {
				rowExist = true;
			}
		}
		if (!rowExist) {
			comboDesignation = new JComboBox<String>();
			comboDesignation.setEditable(true);
			tableCellsEditor.put(row,comboDesignation);
		}
		else {
			comboDesignation = tableCellsEditor.get(row); 
		}
		if(table.getValueAt(row, 2) == null){
			comboDesignation.setSelectedItem(null);
			System.err.println("row / mohammed : " + row);
//			System.err.println("comboDesignation.requestFocusInWindow() : " + comboDesignation.requestFocusInWindow()); 
			System.out.println("comboDesignation.getSelectedItem()  :  "+comboDesignation.getSelectedItem()); 
		}
		
		comboDesignation.getEditor().getEditorComponent()
				.addKeyListener(new KeyAdapter() {

					String lastTypedText = "";
					List<String> comboBoxModel = new ArrayList<String>();

					@SuppressWarnings({ "rawtypes", "unchecked" })
					@Override
					public void keyReleased(KeyEvent e) {

						if (e.getKeyChar() == KeyEvent.VK_ENTER && designation != null) {
							
							System.out.println("ENTER Event : " + designation);
							saleView.updateProductLine(designation,comboDesignation);
							fireEditingStopped(); //Make the renderer reappear.
							 int lastIndex = saleView.getjTable1().getRowCount()-1;
		                	 System.out.println("lastIndex   :    "+lastIndex);
		                	 System.out.println(saleView.getjTable1().getValueAt(lastIndex, 0));
		                	 if((saleView.getjTable1().getValueAt(lastIndex, 0) != null) && (saleView.getjTable1().getValueAt(lastIndex, 2) != null)){
		                		 DefaultTableModel model = (DefaultTableModel) saleView.getjTable1().getModel();
		                    	 model.addRow(new Object[]{null, null, null, null, null, null});
		                    	saleView.getjTable1().editCellAt(lastIndex+1, 0); 
		                    	TableColumn tableColumn = saleView.getjTable1().getColumnModel().getColumn(0);
		         	        	MedicamentCellEditor2 comboEditor = (MedicamentCellEditor2) tableColumn.getCellEditor();
		         	        	Component editor = comboEditor.getTableCellEditorComponent(saleView.getjTable1(), null, true, lastIndex+1, 0);
		         	        	saleView.getjTable1().changeSelection(lastIndex+1, 0, false, false);
		         	        	editor.requestFocusInWindow();
		                    	// model.get
		                    //	 tableCellsEditor.get(lastIndex+1).setSelectedItem(null); 
//		                    	 saleView.getjTable1().editCellAt(lastIndex+1, 0);
		                	 }

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
		JComboBox<String> comboDesignation = (JComboBox<String>) event.getSource();
		this.designation = (String) comboDesignation.getSelectedItem();
	}

	@SuppressWarnings("unchecked")
	public void clear(int row) {
		JComboBox<String> comboDesignation = tableCellsEditor.get(row);
		comboDesignation.setModel(new DefaultComboBoxModel(
				(new ArrayList<String>()).toArray()));
		//tableCellsEditor.remove(row);
		
	}

}
