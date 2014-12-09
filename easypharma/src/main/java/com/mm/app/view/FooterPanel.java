package com.mm.app.view;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;

public class FooterPanel extends JPanel{

    private JButton paiement;
    private JButton impression;
    private JButton posologie;
    private JButton assurance;
    private JButton client;
    private JButton medecin;
    private JButton produit;
    private JLabel totalLabel;
    private JLabel totalValue;
    private JPanel totalPanel;
    
	public FooterPanel() {
		initComponents();
	}
	
	private void initComponents() {
		totalLabel = new JLabel();
        assurance = new JButton();
        client = new JButton();
        medecin = new JButton();
        produit = new JButton();
        paiement = new JButton();
        impression = new JButton();
        posologie = new JButton();
        totalPanel = new JPanel();
        totalValue = new JLabel();
        
        
        totalLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        totalLabel.setText("TOTAL:");

        assurance.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        assurance.setText("Assur... : F1");

        client.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        client.setText("Client : F2");

        medecin.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        medecin.setText("Medecin : F3");

        produit.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        produit.setText("Produits : F4");

        paiement.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        paiement.setText("Paiement : Esc");

        impression.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        impression.setText("Imprés... : F6");

        posologie.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        posologie.setText("Posologie : F9");

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
                    jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(assurance, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(client, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(medecin, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(produit, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(paiement, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(impression, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(posologie, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(totalLabel)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(totalPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))
                );
                jPanel4Layout.setVerticalGroup(
                    jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(totalPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(assurance, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                                .addComponent(client, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                                .addComponent(medecin, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                                .addComponent(produit, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                                .addComponent(paiement, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                                .addComponent(impression, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                                .addComponent(posologie, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                                .addComponent(totalLabel)))
                        .addGap(0, 22, Short.MAX_VALUE))
                );


	}

	public JButton getPaiement() {
		return paiement;
	}

	public void setPaiement(JButton paiement) {
		this.paiement = paiement;
	}

	public JButton getImpression() {
		return impression;
	}

	public void setImpression(JButton impression) {
		this.impression = impression;
	}

	public JButton getPosologie() {
		return posologie;
	}

	public void setPosologie(JButton posologie) {
		this.posologie = posologie;
	}

	public JButton getAssurance() {
		return assurance;
	}

	public void setAssurance(JButton assurance) {
		this.assurance = assurance;
	}

	public JButton getClient() {
		return client;
	}

	public void setClient(JButton client) {
		this.client = client;
	}

	public JButton getMedecin() {
		return medecin;
	}

	public void setMedecin(JButton medecin) {
		this.medecin = medecin;
	}

	public JButton getProduit() {
		return produit;
	}

	public void setProduit(JButton produit) {
		this.produit = produit;
	}

	public JLabel getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(JLabel totalValue) {
		this.totalValue = totalValue;
	}
	
}
