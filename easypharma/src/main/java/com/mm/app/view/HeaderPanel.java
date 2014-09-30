package com.mm.app.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;

public class HeaderPanel extends JPanel {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = -4803295226273222399L;
	private HeaderButton jButton1;
    private HeaderButton jButton2;
    private HeaderButton jButton3;
    private HeaderButton jButton4;
    private HeaderButton jButton5;
	
	public HeaderPanel() {
		initComponents();
		setBackground(Color.WHITE);
	}
	
	private void initComponents() {
        jButton2 = new HeaderButton(" ", "/img/jbutton2.png", "Activer la vente sur Ordonnance");
        jButton1 = new HeaderButton("Assurance", "/img/jbutton1.png", "Assurance");
        jButton3 = new HeaderButton("Médecin", "/img/jbutton3.png", "Médecin");
        jButton4 = new HeaderButton("Payment", "/img/jbutton4.png", "Payment");
        jButton5 = new HeaderButton("Impréssion", "/img/jbutton5.png", "Impréssion");
        
        
        jButton1.activateButton(false);
        jButton3.activateButton(false);
        jButton4.activateButton(false);
        jButton5.activateButton(false);
        
        jButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jButton1.activateButton(true);
				
				Component[] internalFrames = ((SaleView) getParent().getParent().getParent().getParent()).getjPanel1().getComponents();
				if(internalFrames != null){
					for(Component comp : internalFrames){
						if(comp instanceof InternalFrameWidget){
							((InternalFrameWidget) comp).activateComponents();
						}
					}
				}
			}
		});
        
        GroupLayout jPanelLayout = new javax.swing.GroupLayout(this);
        setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
        		jPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jButton2)
                .addGap(340, 340, 340)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelLayout.setVerticalGroup(
        		jPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addGroup(jPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
	}
}
