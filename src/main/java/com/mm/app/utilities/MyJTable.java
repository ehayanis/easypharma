package com.mm.app.utilities;

import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.TableColumn;

public class MyJTable extends JTable{
	
	private static final long serialVersionUID = 6431174577095592896L;

	public MyJTable(){
		super();
	}
	
	@Override
	public void changeSelection(    int row, int column, boolean toggle, boolean extend)
	{
	    super.changeSelection(row, column, toggle, extend);
	 
	    if (editCellAt(row, column))
	    {
	    	Component editor = null;
	        if(column == 0){
	        	TableColumn tableColumn = this.getColumnModel().getColumn(0);
	        	MedicamentCellEditor comboEditor = (MedicamentCellEditor) tableColumn.getCellEditor();
	        	editor = comboEditor.getTableCellEditorComponent(this, null, true, row, column);
	        }
	        else{
	        	editor = getEditorComponent();
	        }
	        if(editor != null){
	        	editor.requestFocusInWindow();
	        }
	    }
	}
}
