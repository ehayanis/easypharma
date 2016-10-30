package com.mm.app.utilities;

import java.awt.Component;
import java.awt.event.ActionListener;
import javax.swing.ComboBoxEditor;
import javax.swing.JTextField;

public class MyComboEditor implements ComboBoxEditor {
  JTextField textFeild;
  String myObject;
  String myReturnObject;

public MyComboEditor(){
    textFeild = new JTextField();     
}

public Component getEditorComponent() {
    return textFeild;
}

public void setItem(Object anObject) {

    if(anObject != null){
        myObject = (String) anObject;
        myReturnObject = (String) anObject;            
        textFeild.setText(myObject);
     }
     else{ 
       myReturnObject = (String) anObject;
     }
}

public Object getItem() {
    String objectTxt = myObject;
    String feildTxt = textFeild.getText();

    if(objectTxt.equals(feildTxt)){
        return myReturnObject;
    }
    else{
        return new Object[]{"0",textFeild.getText()};
    }
}

public void selectAll() {
    throw new UnsupportedOperationException(
            "Not supported yet. in select All");
}

public void addActionListener(ActionListener l) {
    textFeild.addActionListener(l);     
}

public void removeActionListener(ActionListener l) {
    textFeild.removeActionListener(l);
}    
}
