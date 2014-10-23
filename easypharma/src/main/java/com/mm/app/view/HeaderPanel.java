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
	private HeaderButton assurance;
    private HeaderButton jButton2;
    private HeaderButton medecin;
    private HeaderButton payment;
    private HeaderButton impression;
	
	public HeaderPanel() {
		initComponents();
		setBackground(Color.WHITE);
	}
	
	private void initComponents() {
        jButton2 = new HeaderButton(" ", "/img/jbutton2.png", "Activer la vente sur Ordonnance");
        jButton2.setVisible(false);
        assurance = new HeaderButton("Client", "/img/jbutton1.png", "Assurance");
        medecin = new HeaderButton("Médicaments", "/img/jbutton3.png", "Médecin");
        payment = new HeaderButton("Impression", "/img/jbutton4.png", "Payment");
        impression = new HeaderButton("Payement", "/img/jbutton5.png", "Impréssion");
        
        
        assurance.activateButton(false);
        medecin.activateButton(false);
        payment.activateButton(false);
        impression.activateButton(false);
        
        jButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				assurance.activateButton(true);
				
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
                .addComponent(assurance, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(medecin, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(impression, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(payment, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelLayout.setVerticalGroup(
        		jPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addGroup(jPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(assurance, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                    .addComponent(medecin, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                    .addComponent(impression, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                    .addComponent(payment, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
	}
}
