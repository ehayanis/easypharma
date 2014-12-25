package com.mm.app.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.mm.app.model.Medecin;
import com.mm.app.model.Vente;
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
	
	private JPanel buttonPanel;
	private JButton editButton;
	private JButton newButton;
	
	private MedecinService medecinService;
	private EntityManager em;
	private Vente vente;
	
	public MedecinWidget(EntityManager em, Vente vente) {
		this.em = em;
		this.vente = vente;
		
		medecinService = new MedecinServiceImpl(em);
		
		initComponent();
		
		getContentPane().setBackground(Color.WHITE);
		
		setFrameIcon(new ImageIcon(getClass().getResource("/img/graphite.png")));
		setTitle("Médecin");
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
		
		final Map<String, String> data = new HashMap<String, String>();
		data.put("", "");
		List<Medecin> result = medecinService.getMedecins();
		if(result != null && result.size() > 0){
			for(Medecin m : result){
				System.out.println(m.getFirstName() + " " + m.getLastName() + " " + String.valueOf(m.getId()));
				data.put(m.getFirstName() + " " + m.getLastName(), String.valueOf(m.getId()));
			}
		}
		
		firstName = new Java2sAutoComboBox(data);
		firstName.setDataList(data);
		firstName.setMaximumRowCount(3);

		firstName.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyChar() == KeyEvent.VK_ENTER) {
					String selectedValue = (String) firstName.getSelectedItem();
					System.out.println("Selected Value : " + selectedValue);
					int id = Integer.valueOf(data.get(selectedValue));
					System.out.println("ID : " + id);
					Medecin medecin = medecinService.findMedecin(id);
					
					em.getTransaction().begin();
					vente = em.find(Vente.class, vente.getId());
					vente.setMedecin(medecin);
					em.getTransaction().commit();
					
					reference.setText(String.valueOf(medecin.getId()));
					speciality.setText(medecin.getSpeciality());
					phone.setText(medecin.getPhone());
					nrcc.setText(medecin.getNrcc());
				}
			}
		});
		
		FlowLayout gl = new FlowLayout();
		gl.setHgap(5);
		gl.setVgap(0);
		
		buttonPanel = new JPanel(gl);
		buttonPanel.setBackground(Color.WHITE);
		
		editButton = new HeaderButton("/img/edit.gif", "editButton");
		newButton = new HeaderButton("/img/add.gif", "newButton");
		
		
		editButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                editActionPerformed(evt);
            }
        });
		newButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                newActionPerformed(evt);
            }
        });
		
		
		firstName.setPreferredSize(new Dimension(203, 20));
		buttonPanel.add(firstName);
		buttonPanel.add(editButton);
		buttonPanel.add(newButton);
		
		add(Utilities.createFilledSimplePanel("Nom & Prénom", buttonPanel));
		add(Utilities.createFilledSimplePanel("Spécialité", speciality));
		add(Utilities.createFilledSimplePanel("Tél.", phone));
		add(Utilities.createFilledSimplePanel("NRCC", nrcc));
		add(Utilities.createFilledSimplePanel("Réference", reference));
		
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
	
	public Vente getVente() {
		return vente;
	}

	public void setVente(Vente vente) {
		this.vente = vente;
	}

	private void editActionPerformed(ActionEvent evt) {                                         
		MedecinManagementView medecinManagementView = new MedecinManagementView(em, vente);
        
        if(!"".equals(reference.getText())){
        	medecinManagementView.getSearchField().setEnabled(false);
        	medecinManagementView.getSearchTable().setEnabled(false);
        	
        	Medecin medecin = medecinService.findMedecin(Integer.valueOf(reference.getText()));
        	
        	if(medecin != null){
        		medecinManagementView.getFirstName().setText(Utilities.isEmpty(medecin.getFirstName()));
        		medecinManagementView.getLastName().setText(Utilities.isEmpty(medecin.getLastName()));
        		medecinManagementView.getReference().setText(Utilities.isEmpty(medecin.getReference()));
        		medecinManagementView.getNrcc().setText(Utilities.isEmpty(medecin.getNrcc()));
        		medecinManagementView.getNumNC().setText(Utilities.isEmpty(medecin.getNc()));
        		medecinManagementView.getFixe().setText(Utilities.isEmpty(medecin.getPhone()));
        		medecinManagementView.getFax().setText(Utilities.isEmpty(medecin.getFax()));
        		medecinManagementView.getSpeciality().setText(Utilities.isEmpty(medecin.getSpeciality()));
        		medecinManagementView.getEmail().setText(Utilities.isEmpty(medecin.getEmail()));
        		medecinManagementView.getAddress().setText(Utilities.isEmpty(medecin.getAddress()));
        		
        		medecinManagementView.setIdMedecin(medecin.getId());
        		
        		medecinManagementView.setEdit(true);
        		
        		medecinManagementView.setVisible(true);
        	}
        
        }else{
        	JOptionPane.showMessageDialog(this, "Veuillez séléctionner un médecin pour pouvoir le modifier!");
        }
        
    } 
	
	private void newActionPerformed(ActionEvent evt) {                                         
		 JFrame medecinManagementView = new MedecinManagementView(em, vente);
		 medecinManagementView.setVisible(true);
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
