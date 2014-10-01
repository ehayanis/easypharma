package com.mm.app.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JTextField;

import com.mm.app.model.Medecin;
import com.mm.app.service.MedecinService;
import com.mm.app.service.impl.MedecinServiceImpl;
import com.mm.app.utilities.Java2sAutoComboBox;
import com.mm.app.utilities.Utilities;

public class MedecinWidget extends JInternalFrame implements InternalFrameWidget{

	private static final long serialVersionUID = -1528594567776851222L;
	
	private Java2sAutoComboBox firstName;
	private JTextField speciality;
	private JTextField reference;
	private JTextField phone;
	private JTextField nrcc;
	
	private MedecinService medecinService;
	
	public MedecinWidget(EntityManager em) {
		medecinService = new MedecinServiceImpl(em);
		
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
		
		reference = new JTextField();
		phone = new JTextField();
		nrcc = new JTextField();
		speciality = new JTextField();
		
		ArrayList<String> data = new ArrayList<String>();   
		data.add("");
		List<Medecin> result = medecinService.getMedecins();
		if(result != null && result.size() > 0){
			for(Medecin m : result){
				data.add(m.getFirstName() + " " + m.getLastName());
			}
		}
		
		firstName = new Java2sAutoComboBox(data);
		firstName.setDataList(data);
		firstName.setMaximumRowCount(3);

//		firstName.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
//			@Override
//			public void keyPressed(KeyEvent e) {
//				if (e.getKeyChar() == KeyEvent.VK_ENTER) {
//					String selectedValue = (String) firstName.getSelectedItem();
//					Medecin medecin = medecinService.findMedecinByName(selectedValue);
//					
//					reference.setText(medecin.getReference());
//					speciality.setText(medecin.getSpeciality());
//					phone.setText(medecin.getPhone());
//					nrcc.setText(medecin.getNrcc());
//				}
//			}
//		});
		
		add(Utilities.createFilledSimplePanel("Nom & Prénom", firstName));
		add(Utilities.createFilledSimplePanel("Référence", reference));
		add(Utilities.createFilledSimplePanel("Spécialité", speciality));
		add(Utilities.createFilledSimplePanel("Tél.", phone));
		add(Utilities.createFilledSimplePanel("NRCC", nrcc));
		
	}

	public Java2sAutoComboBox getFirstName() {
		return firstName;
	}

	public void setFirstName(Java2sAutoComboBox firstName) {
		this.firstName = firstName;
	}

	public JTextField getSpeciality() {
		return speciality;
	}

	public void setSpeciality(JTextField speciality) {
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
		firstName.setEnabled(true);
		reference.setEnabled(true);
		reference.setEditable(false);
		speciality.setEnabled(true);
		speciality.setEditable(false);
		phone.setEnabled(true);
		phone.setEditable(false);
		nrcc.setEnabled(true);
		nrcc.setEditable(false);
	}

}
