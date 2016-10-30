package com.mm.app.view;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

public class MyJLabel extends JLabel{

	public MyJLabel(String value) {
		this.setFont(new Font("Tahoma", 1, 12)); // NOI18N
		this.setText(value);
		this.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
//		this.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

	}
	
}
