package com.mm.app.view;

import java.awt.Color;
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
	
	public MedecinWidget(EntityManager em) {
		this.em = em;
		medecinService = new MedecinServiceImpl(em);
		
		initComponent();
		
		getContentPane().setBackground(Color.WHITE);
		
		setFrameIcon(new ImageIcon(getClass().getResource("/img/graphite.png")));
		setTitle("M�decin");
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
		
//		ArrayList<String> data = new ArrayList<String>(); 
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
					
					reference.setText(String.valueOf(medecin.getId()));
					speciality.setText(medecin.getSpeciality());
					phone.setText(medecin.getPhone());
					nrcc.setText(medecin.getNrcc());
				}
			}
		});
		
		buttonPanel = new JPanel();
		buttonPanel.setBackground(Color.WHITE);
		
		editButton = new HeaderButton("Edition", "/img/edit.gif", false, false);
		newButton = new HeaderButton("Nouveau", "/img/add.gif", false, false);
		
		
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
		
		
		buttonPanel.add(editButton);
		buttonPanel.add(newButton);
		
		add(Utilities.createFilledSimplePanel("Nom & Pr�nom", firstName));
		add(Utilities.createFilledSimplePanel("Sp�cialit�", speciality));
		add(Utilities.createFilledSimplePanel("T�l.", phone));
		add(Utilities.createFilledSimplePanel("NRCC", nrcc));
		add(Utilities.createFilledSimplePanel(" ", buttonPanel));
		
		reference.setVisible(false);
		add(reference);
		
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
	
	private void editActionPerformed(ActionEvent evt) {                                         
		MedecinManagementView medecinManagementView = new MedecinManagementView(em);
        
        if(!"".equals(reference.getText())){
        	Medecin medecin = medecinService.findMedecin(Integer.valueOf(reference.getText()));
        	
        	medecinManagementView.getFirstName().setText(medecin.getFirstName());
        	medecinManagementView.getLastName().setText(medecin.getLastName());
        	medecinManagementView.getReference().setText(medecin.getReference());
        	medecinManagementView.getNrcc().setText(medecin.getNrcc());
        	medecinManagementView.getNumNC().setText(medecin.getNc());
        	medecinManagementView.getFixe().setText(medecin.getPhone());
        	medecinManagementView.getFax().setText(medecin.getFax());
        	medecinManagementView.getSpeciality().setText(medecin.getSpeciality());
        	
        	
        	medecinManagementView.setVisible(true);
        }else{
        	JOptionPane.showMessageDialog(this, "Veuillez s�l�ctionner un m�decin pour pouvoir le modifier!");
        }
        
    } 
	
	private void newActionPerformed(ActionEvent evt) {                                         
		 JFrame medecinManagementView = new MedecinManagementView(em);
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
