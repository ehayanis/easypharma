package com.mm.app.view;

import java.awt.Color;
import java.awt.Font;
import java.beans.PropertyVetoException;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JTextField;

import com.mm.app.utilities.Utilities;

public class AssuranceWidget extends JInternalFrame implements InternalFrameWidget{

	private static final long serialVersionUID = -1528594567776851222L;
	
	private JTextField agence;
	private JTextField ofas;
	private JTextField ean;
	private JTextField phone;
	private JTextField coverCard;
	
	public AssuranceWidget() {
		
		initComponent();
		
		getContentPane().setBackground(Color.WHITE);
		
		setFrameIcon(new ImageIcon(getClass().getResource("/img/graphite.png")));
		setTitle("Assurance");
		setBorder(javax.swing.BorderFactory.createEtchedBorder());
        setVisible(true);
        setFont(new Font("Agency FB", 0, 9));
	}
	
	private void initComponent() {
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		
		agence = new JTextField();
		ofas = new JTextField();
		ean = new JTextField();
		phone = new JTextField();
		coverCard = new JTextField();
		
		add(Utilities.createFilledSimplePanel("Cover Card", coverCard));
		add(Utilities.createFilledSimplePanel("Agence", agence));
		add(Utilities.createFilledSimplePanel("OFAS", ofas));
		add(Utilities.createFilledSimplePanel("EAN", ean));
		add(Utilities.createFilledSimplePanel("Tél.", phone));
		
	}

	public JTextField getAgence() {
		return agence;
	}

	public void setAgence(JTextField agence) {
		this.agence = agence;
	}

	public JTextField getOfas() {
		return ofas;
	}

	public void setOfas(JTextField ofas) {
		this.ofas = ofas;
	}

	public JTextField getEan() {
		return ean;
	}

	public void setEan(JTextField ean) {
		this.ean = ean;
	}

	public JTextField getPhone() {
		return phone;
	}

	public void setPhone(JTextField phone) {
		this.phone = phone;
	}

	public JTextField getCoverCard() {
		return coverCard;
	}

	public void setCoverCard(JTextField coverCard) {
		this.coverCard = coverCard;
	}
	
	@Override
	public void activateComponents(){
		coverCard.setEnabled(true);
		agence.setEnabled(true);
		agence.setEditable(true);
		ofas.setEnabled(true);
		ofas.setEditable(true);
		ean.setEnabled(true);
		ean.setEditable(true);
		phone.setEnabled(true);
		phone.setEditable(true);
	}

}
