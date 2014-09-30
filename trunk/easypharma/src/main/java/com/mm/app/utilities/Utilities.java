package com.mm.app.utilities;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Utilities {

	public static JPanel createFilledSimplePanel(String label, JComponent field){
		JPanel pan = new JPanel();
		pan.setBackground(Color.WHITE);
		JLabel jLabel = new JLabel(label);
		
		jLabel.setFont(new Font("Arial", 0, 12));
		field.setFont(new Font("Arial", 0, 12));
		field.setEnabled(false);
		
		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(pan);
		pan.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, 110)
                .addGap(18, 18, 18)
                .addComponent(field, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, 250)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel, 5, javax.swing.GroupLayout.DEFAULT_SIZE, 25)
                    .addComponent(field, 5, javax.swing.GroupLayout.DEFAULT_SIZE, 25))
                .addContainerGap(5, Short.MAX_VALUE))
        );
        
        return pan;
	}
}
