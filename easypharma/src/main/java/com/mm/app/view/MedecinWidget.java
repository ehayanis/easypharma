package com.mm.app.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JTextField;

import com.mm.app.utilities.Utilities;

public class MedecinWidget extends JInternalFrame implements InternalFrameWidget{

	private static final long serialVersionUID = -1528594567776851222L;
	
	private JTextField firstName;
	private JComboBox<String> speciality;
	private JTextField reference;
	private JTextField phone;
	private JTextField nrcc;
	
	public MedecinWidget() {
		
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
		
		firstName = new JTextField();
		reference = new JTextField();
		phone = new JTextField();
		nrcc = new JTextField();
		String[] specialities = { "Pédiatrie", "Ophtamologie" };
		speciality = new JComboBox<String>(specialities);
		
		
		add(Utilities.createFilledSimplePanel("Référence", reference));
		add(Utilities.createFilledSimplePanel("Nom & Prénom", firstName));
		add(Utilities.createFilledSimplePanel("Spécialité", speciality));
		add(Utilities.createFilledSimplePanel("Tél.", phone));
		add(Utilities.createFilledSimplePanel("NRCC", nrcc));
		
	}

	public JTextField getFirstName() {
		return firstName;
	}

	public void setFirstName(JTextField firstName) {
		this.firstName = firstName;
	}

	public JComboBox<String> getSpeciality() {
		return speciality;
	}

	public void setSpeciality(JComboBox<String> speciality) {
		this.speciality = speciality;
	}

	public JTextField getReference() {
		return reference;
	}

	public void setReference(JTextField reference) {
		this.reference = reference;
	}

	public JTextField getPhone() {
		return phone;
	}

	public void setPhone(JTextField phone) {
		this.phone = phone;
	}

	public JTextField getNrcc() {
		return nrcc;
	}

	public void setNrcc(JTextField nrcc) {
		this.nrcc = nrcc;
	}

	@Override
	public void activateComponents(){
		reference.setEnabled(true);
		firstName.setEnabled(true);
		firstName.setEditable(false);
		speciality.setEnabled(true);
		speciality.setEditable(false);
		phone.setEnabled(true);
		phone.setEditable(false);
		nrcc.setEnabled(true);
		nrcc.setEditable(false);
	}

}
