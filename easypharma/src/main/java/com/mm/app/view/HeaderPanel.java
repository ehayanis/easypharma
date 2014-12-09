package com.mm.app.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.mm.app.model.Operator;

public class HeaderPanel extends JPanel {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = -4803295226273222399L;
	private HeaderButton client;
    private JLabel op;
    private HeaderButton produit;
    private HeaderButton impression;
    private HeaderButton paiement;
	
    private Operator operator;
    
	public HeaderPanel(Operator operator) {
		this.operator = operator;
		initComponents();
		setBackground(Color.WHITE);
	}
	
	private void initComponents() {
        op = new JLabel(operator.getFirstName() + " " + operator.getLastname());
        op.setFont(new Font("Arial", 1, 12));
        client = new HeaderButton("Client", "/img/jbutton1.png", "Client");
        produit = new HeaderButton("Médicaments", "/img/jbutton3.png", "Médicaments");
        paiement = new HeaderButton("Payement", "/img/jbutton5.png", "Paiement");
        impression = new HeaderButton("Impression", "/img/jbutton4.png", "Impression");
        
        
        client.activateButton(false);
        produit.activateButton(false);
        impression.activateButton(false);
        paiement.activateButton(false);
        
//        operator.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				client.activateButton(true);
//				
//				Component[] internalFrames = ((SaleView) getParent().getParent().getParent().getParent()).getjPanel1().getComponents();
//				if(internalFrames != null){
//					for(Component comp : internalFrames){
//						if(comp instanceof InternalFrameWidget){
//							((InternalFrameWidget) comp).activateComponents();
//						}
//					}
//				}
//			}
//		});
        
        GroupLayout jPanelLayout = new javax.swing.GroupLayout(this);
        setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
        		jPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(op)
                .addGap(340, 340, 340)
                .addComponent(client, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(produit, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(paiement, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(impression, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelLayout.setVerticalGroup(
        		jPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addGroup(jPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(client, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                    .addComponent(op, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                    .addComponent(produit, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                    .addComponent(paiement, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                    .addComponent(impression, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
	}

	public HeaderButton getClient() {
		return client;
	}

	public void setClient(HeaderButton client) {
		this.client = client;
	}

	public HeaderButton getProduit() {
		return produit;
	}

	public void setProduit(HeaderButton produit) {
		this.produit = produit;
	}

	public HeaderButton getImpression() {
		return impression;
	}

	public void setImpression(HeaderButton impression) {
		this.impression = impression;
	}

	public HeaderButton getPaiement() {
		return paiement;
	}

	public void setPaiement(HeaderButton paiement) {
		this.paiement = paiement;
	}

		
}
