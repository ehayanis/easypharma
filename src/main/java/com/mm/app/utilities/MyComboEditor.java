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

@Override
public Component getEditorComponent() {
    return textFeild;
}

@Override
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

@Override
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

@Override
public void selectAll() {
    throw new UnsupportedOperationException(
            "Not supported yet. in select All");
}

@Override
public void addActionListener(ActionListener l) {
    textFeild.addActionListener(l);     
}

@Override
public void removeActionListener(ActionListener l) {
    textFeild.removeActionListener(l);
}    
}
