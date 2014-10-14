package com.mm.app.utilities;

import java.awt.Color;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;

public class Utilities {

	public static JPanel createFilledSimplePanel(String label, JComponent field){
		JPanel pan = new JPanel();
		pan.setBackground(Color.WHITE);
		JLabel jLabel = new JLabel(label);
		
		jLabel.setFont(new Font("Arial", 0, 12));
		field.setFont(new Font("Arial", 0, 12));
		field.setEnabled(false);
		
		GroupLayout layout = new GroupLayout(pan);
		pan.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, 110)
                .addGap(18, 18, 18)
                .addComponent(field, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, 250)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(field, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        
        return pan;
	}
	
	public static JPanel createFilledAdvancedPanel(String label, JComponent field, JButton jButton1, JButton jButton2){
		JPanel pan = new JPanel();
		pan.setBackground(Color.WHITE);
		JLabel jLabel = new JLabel(label);
		
		jLabel.setFont(new Font("Arial", 0, 12));
		field.setFont(new Font("Arial", 0, 12));
		field.setEnabled(false);
		
		GroupLayout layout = new GroupLayout(pan);
		pan.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
            		.addContainerGap()
                    .addComponent(jLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, 110)
                    .addGap(18, 18, 18)
                    .addComponent(field, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, 220)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jButton1)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jButton2)
                    .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
            		.addGap(22, 22, 22)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel, 5, GroupLayout.DEFAULT_SIZE, 25)
                        .addComponent(field, 5, GroupLayout.DEFAULT_SIZE, 25)
                        .addComponent(jButton1)
                        .addComponent(jButton2))
                    .addContainerGap(24, Short.MAX_VALUE))
        );
        
        return pan;
	}
}
