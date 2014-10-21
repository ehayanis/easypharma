package com.mm.app.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.util.List;

import javax.persistence.EntityManager;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.mm.app.model.Assurance;
import com.mm.app.model.Client;
import com.mm.app.service.AssuranceService;
import com.mm.app.service.impl.AssuranceServiceImpl;
import com.mm.app.utilities.Utilities;

public class AssuranceWidget extends JInternalFrame implements InternalFrameWidget{

	private static final long serialVersionUID = -1528594567776851222L;
	
	private JTextField assurance1;
	private JTextField hiddenField1;
	private JTextField assurance2;
	private JTextField hiddenField2;
	private JTextField assurance3;
	private JTextField hiddenField3;
	
	private JButton editAssur1;
	private JButton editAssur2; 
	private JButton editAssur3;
	private JButton newAssur1;
	private JButton newAssur2;
	private JButton newAssur3;
	
	private EntityManager em;
	private AssuranceService service;
	
	public AssuranceWidget(EntityManager em) {
		this.em = em;
		service = new AssuranceServiceImpl(em);
		
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
		
		assurance1 = new JTextField();
		hiddenField1 = new JTextField();
		assurance2 = new JTextField();
		hiddenField2 = new JTextField();
		assurance3 = new JTextField();
		hiddenField3 = new JTextField();
		
		editAssur1 = new HeaderButton("/img/edit.gif", "editAssur1");
		editAssur2 = new HeaderButton("/img/edit.gif", "editAssur2");
		editAssur3 = new HeaderButton("/img/edit.gif", "editAssur3");
		newAssur1 = new HeaderButton("/img/add.gif", "newAssur1");
		newAssur2 = new HeaderButton("/img/add.gif", "newAssur2");
		newAssur3 = new HeaderButton("/img/add.gif", "newAssur3");
		
		assurance1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				searchActionPerformed(evt);
			}
		});
		
		editAssur1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                editActionPerformed(evt);
            }
        });
		editAssur2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                editActionPerformed(evt);
            }
        });
		editAssur3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                editActionPerformed(evt);
            }
        });
		
		newAssur1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                newActionPerformed(evt);
            }
        });
		newAssur2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                newActionPerformed(evt);
            }
        });
		newAssur3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                newActionPerformed(evt);
            }
        });
		
		add(Utilities.createFilledAdvancedPanel("Assurance Obligatoire", assurance1, editAssur1, newAssur1));
		add(Utilities.createFilledAdvancedPanel("Assurance Accident", assurance2, editAssur2, newAssur2));
		add(Utilities.createFilledAdvancedPanel("Assurance Complémentaire", assurance3, editAssur3, newAssur3));
		
		hiddenField1.setVisible(false);
		add(hiddenField1);
		hiddenField2.setVisible(false);
		add(hiddenField2);
		hiddenField3.setVisible(false);
		add(hiddenField3);
	}

	public JTextField getAssurance1() {
		return assurance1;
	}

	public void setAssurance1(JTextField assurance) {
		this.assurance1 = assurance;
	}

	public JTextField getAssurance2() {
		return assurance2;
	}

	public void setAssurance2(JTextField assurance) {
		this.assurance2 = assurance;
	}

	public JTextField getAssurance3() {
		return assurance3;
	}
	
	public JTextField getHiddenField1() {
		return hiddenField1;
	}

	public void setAssurance3(JTextField assurance) {
		this.assurance3 = assurance;
	}

	@Override
	public void activateComponents(){
		assurance1.setEnabled(true);
		assurance1.setEditable(true);
		assurance2.setEnabled(true);
		assurance2.setEditable(true);
		assurance3.setEnabled(true);
		assurance3.setEditable(true);
	}
	
	private void searchActionPerformed(ActionEvent evt) {
		String coverCard = assurance1.getText();
		if(!"".equals(coverCard)){
			Assurance assurance = service.findAssuranceByCoverCard(coverCard);
			if(assurance != null){
				assurance1.setText(assurance.getName());
				hiddenField1.setText(String.valueOf(assurance.getId()));
				
				List<Client> clients = assurance.getClients();
				if(clients != null && clients.size() > 0){
					Client client = clients.get(0);
					
					for (Frame frame : Frame.getFrames()) {
						if (frame.getTitle().equals("EasyPharma: Gestion Pharmacies ")) {
							SaleView saleView = (SaleView) frame;
							ClientWidget clientWidget = (ClientWidget) saleView.getClientWidget();
							clientWidget.getFirstName().setText(client.getFirstName() + " " + client.getLastName());
							clientWidget.getReference().setSelectedItem(client.getReference());
							clientWidget.getDateOfBirth().setText(DateFormat.getDateInstance().format(client.getBirthDate()));
							clientWidget.getPhone().setText(client.getPhone());
							
							
							saleView.setVisible(true);
						}
					}
				}
			}
		}
	}
	
	private void editActionPerformed(ActionEvent evt) {                                         
		AssuranceManagementView assuranceManagementView = new AssuranceManagementView(em);
        String HiddenId = "";
        
        if("editAssur1".equals(evt.getActionCommand())){
        	HiddenId = hiddenField1.getText();
        }
        if("editAssur2".equals(evt.getActionCommand())){
        	HiddenId = hiddenField2.getText();
        }
        if("editAssur3".equals(evt.getActionCommand())){
        	HiddenId = hiddenField3.getText();
        }
        
        
        if(!"".equals(HiddenId)){
        	Assurance assurance = service.findAssurance(Integer.valueOf(HiddenId));
        	if(assurance != null){
        		assuranceManagementView.getNom().setText(assurance.getName());
        		assuranceManagementView.getAgence().setText(assurance.getAgence());
        		assuranceManagementView.getOfas().setText(assurance.getOfas());
        		assuranceManagementView.getEan().setText(assurance.getEan());
        		assuranceManagementView.getRcc().setText(assurance.getRcc());
        		assuranceManagementView.getCoverCard().setText(assurance.getCoverCard());
        		assuranceManagementView.getNpa().setText(assurance.getNpa());
        		assuranceManagementView.getPhone().setText(assurance.getPhone());
        		assuranceManagementView.getValidationDate().setText(DateFormat.getDateInstance().format(assurance.getValidationDate()));
        		assuranceManagementView.getCardValidity().setText(DateFormat.getDateInstance().format(assurance.getCardValidity()));
        		assuranceManagementView.getValidationNumber().setText(String.valueOf(assurance.getValidationNumber()));
        		assuranceManagementView.getAddress().setText(assurance.getAddress());
        		
        		assuranceManagementView.setVisible(true);
        	}
        }else{
			JOptionPane.showMessageDialog(this, "Veuillez séléctionner une assurance pour pouvoir la modifier!");
        }
        
        
    } 
	
	private void newActionPerformed(ActionEvent evt) {                                         
        JFrame assuranceManagementView = new AssuranceManagementView(em);
        assuranceManagementView.setVisible(true);
    } 

}
