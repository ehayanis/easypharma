package com.mm.app.view;

import java.awt.Color;

import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;

public class FooterPanel extends JPanel{

    private MyJLabel paiement;
    private MyJLabel impression;
    private MyJLabel posologie;
    private MyJLabel assurance;
    private MyJLabel client;
    private MyJLabel medecin;
    private MyJLabel produit;
    private JLabel totalLabel;
    private JLabel totalValue;
    private JPanel totalPanel;
    
	public FooterPanel() {
		initComponents();
	}
	
	private void initComponents() {
		this.setBackground(Color.white);
		totalLabel = new JLabel();
        assurance = new MyJLabel("Assur... : F1");
        client = new MyJLabel("Client : F2");
        medecin = new MyJLabel("Medecin : F4");
        produit = new MyJLabel("Produits : F6");
        paiement = new MyJLabel("Paiement : Esc");
        impression = new MyJLabel("Imprés... : F7");
        posologie = new MyJLabel("Posologie : F9");
        totalPanel = new JPanel();
        totalValue = new JLabel();
        
        
        totalLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        totalLabel.setText("TOTAL:");

//        assurance.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
//        assurance.setText("Assur... : F1");
//
//        client.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
//        client.setText("Client : F2");
//
//        medecin.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
//        medecin.setText("Medecin : F3");
//
//        produit.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
//        produit.setText("Produits : F4");
//
//        paiement.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
//        paiement.setText("Paiement : Esc");
//
//        impression.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
//        impression.setText("Imprés... : F6");
//
//        posologie.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
//        posologie.setText("Posologie : F9");

        totalPanel.setBackground(new java.awt.Color(51, 51, 51));

        totalValue.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        totalValue.setForeground(new java.awt.Color(153, 255, 255));
//        totalValue.setText(" jLabel3");

        GroupLayout jPanel5Layout = new GroupLayout(totalPanel);
        totalPanel.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(totalValue, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(totalValue, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
        );
        
        

        GroupLayout jPanel4Layout = new GroupLayout(this);
        setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(               
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(assurance, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(client, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(medecin, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(produit, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(paiement, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(impression, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(posologie, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(totalLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(totalPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
           jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(totalPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(assurance, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(client, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(medecin, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(produit, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(paiement, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(impression, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(posologie, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(totalLabel)))
                .addGap(0, 0, Short.MAX_VALUE))
        );


	}

	public MyJLabel getPaiement() {
		return paiement;
	}

	public void setPaiement(MyJLabel paiement) {
		this.paiement = paiement;
	}

	public MyJLabel getImpression() {
		return impression;
	}

	public void setImpression(MyJLabel impression) {
		this.impression = impression;
	}

	public MyJLabel getPosologie() {
		return posologie;
	}

	public void setPosologie(MyJLabel posologie) {
		this.posologie = posologie;
	}

	public MyJLabel getAssurance() {
		return assurance;
	}

	public void setAssurance(MyJLabel assurance) {
		this.assurance = assurance;
	}

	public MyJLabel getClient() {
		return client;
	}

	public void setClient(MyJLabel client) {
		this.client = client;
	}

	public MyJLabel getMedecin() {
		return medecin;
	}

	public void setMedecin(MyJLabel medecin) {
		this.medecin = medecin;
	}

	public MyJLabel getProduit() {
		return produit;
	}

	public void setProduit(MyJLabel produit) {
		this.produit = produit;
	}

	public JLabel getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(JLabel totalValue) {
		this.totalValue = totalValue;
	}
	
}
