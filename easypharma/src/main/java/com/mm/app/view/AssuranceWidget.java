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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.omg.CORBA.COMM_FAILURE;

import com.mm.app.model.Assurance;
import com.mm.app.model.Client;
import com.mm.app.model.Vente;
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
	private Vente vente;
	
	public AssuranceWidget(EntityManager em, Vente vente) {
		this.em = em;
		this.vente = vente;
		
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
				searchActionPerformed(evt, TypeAssurance.OBLIGATOIRE);
			}
		});
		
		assurance2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				searchActionPerformed(evt, TypeAssurance.ACCIDENT);
			}
		});
		
		assurance3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				searchActionPerformed(evt, TypeAssurance.COMPLEMENTAIRE);
			}
		});
		
		editAssur1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                editActionPerformed(evt, TypeAssurance.OBLIGATOIRE);
            }
        });
		editAssur2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                editActionPerformed(evt, TypeAssurance.ACCIDENT);
            }
        });
		editAssur3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                editActionPerformed(evt, TypeAssurance.COMPLEMENTAIRE);
            }
        });
		
		newAssur1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                newActionPerformed(evt, TypeAssurance.OBLIGATOIRE);
            }
        });
		newAssur2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                newActionPerformed(evt, TypeAssurance.ACCIDENT);
            }
        });
		newAssur3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                newActionPerformed(evt, TypeAssurance.COMPLEMENTAIRE);
            }
        });
		
		///////////// TO BE REMOVED ///////////////////
		///////////////////////////////////////////////
		JButton hiddenBtn1 = new JButton();
		hiddenBtn1.setVisible(false);
		JButton hiddenBtn2 = new JButton();
		hiddenBtn2.setVisible(false);
		JButton hiddenBtn3 = new JButton();
		hiddenBtn3.setVisible(false);
		JButton hiddenBtn4 = new JButton();
		hiddenBtn4.setVisible(false);
		
		
		add(Utilities.createFilledAdvancedPanel("Assurance Obligatoire", assurance1, editAssur1, newAssur1));
		add(Utilities.createFilledAdvancedPanel("Assurance Accident", assurance2, editAssur2, newAssur2));
		add(Utilities.createFilledAdvancedPanel("Assurance Complémentaire", assurance3, editAssur3, newAssur3));
		add(Utilities.createFilledAdvancedPanel(" ", new JLabel(), hiddenBtn1, hiddenBtn2));
		add(Utilities.createFilledAdvancedPanel(" ", new JLabel(), hiddenBtn3, hiddenBtn4));
		
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
	
	public JTextField getHiddenField2() {
		return hiddenField2;
	}
	
	public JTextField getHiddenField3() {
		return hiddenField3;
	}

	public void setAssurance3(JTextField assurance) {
		this.assurance3 = assurance;
	}
	public JButton getNewAssur1() {
		return newAssur1;
	}

	public void setNewAssur1(JButton newAssur1) {
		this.newAssur1 = newAssur1;
	}

	public JButton getNewAssur2() {
		return newAssur2;
	}

	public void setNewAssur2(JButton newAssur2) {
		this.newAssur2 = newAssur2;
	}

	public JButton getNewAssur3() {
		return newAssur3;
	}

	public void setNewAssur3(JButton newAssur3) {
		this.newAssur3 = newAssur3;
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
	
	private void searchActionPerformed(ActionEvent evt, TypeAssurance typeAssurance) {
		
//		JTextField assuranceField = null;
//		switch (typeAssurance) {
//		case OBLIGATOIRE:
//			assuranceField = assurance1;
//			break;
//		case ACCIDENT:
//			assuranceField = assurance2;
//			break;
//		case COMPLEMENTAIRE:
//			assuranceField = assurance3;
//			break;
//		default:
//			break;
//		}
//		
		String coverCard = ((JTextField) evt.getSource()).getText();
		
		if(!"".equals(coverCard)){
			// CODE TO CALL THE WEB SERVICE TO RETREIVE BOTH THE CLIENT AND THE ASSURANCE
			Client c = null;
			Assurance a = null;
			
			// service to check if a client exists 
				// if exists OK 
				// if not, add it as new client
			// service to check if an insurrance exists 
				// if not exist, add assurance 
				// if exists, check if it already associated 
					// if not, associate it and then return the name and the assurance ID 
					// Field the CLient widget fields 
			
		}
		
//		if(!"".equals(coverCard)){
//			Assurance assurance = service.findAssuranceByCoverCard(coverCard);
//			if(assurance != null){
//				assurance1.setText(assurance.getName());
//				hiddenField1.setText(String.valueOf(assurance.getId()));
//				
//				List<Client> clients = assurance.getClients();
//				if(clients != null && clients.size() > 0){
//					Client client = clients.get(0);
//					
//					for (Frame frame : Frame.getFrames()) {
//						if (frame.getTitle().equals("EasyPharma: Gestion Pharmacies ")) {
//							SaleView saleView = (SaleView) frame;
//							ClientWidget clientWidget = (ClientWidget) saleView.getClientWidget();
//							clientWidget.getFirstName().setText(client.getFirstName() + " " + client.getLastName());
//							clientWidget.getReference().setSelectedItem(client.getReference());
//							clientWidget.getDateOfBirth().setText(DateFormat.getDateInstance().format(client.getBirthDate()));
//							clientWidget.getPhone().setText(client.getPhone());
//							clientWidget.getAge().setText(String.valueOf(client.getAge()));
//							
//							
//							saleView.setVisible(true);
//						}
//					}
//				}
//			}
//		}
	}
	
	private void editActionPerformed(ActionEvent evt, TypeAssurance typeAssurance) {                                         
		AssuranceManagementView assuranceManagementView = new AssuranceManagementView(em, vente);
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
        		assuranceManagementView.getSearchField().setEnabled(false);
        		assuranceManagementView.getTableSearch().setEnabled(false);
        		assuranceManagementView.setTypeAssurance(typeAssurance);
        		assuranceManagementView.setIdAssurance(assurance.getId());
        		
        		assuranceManagementView.getNom().setText(Utilities.isEmpty(assurance.getName()));
        		assuranceManagementView.getAgence().setText(Utilities.isEmpty(assurance.getAgence()));
        		assuranceManagementView.getOfas().setText(Utilities.isEmpty(assurance.getOfas()));
        		assuranceManagementView.getEan().setText(Utilities.isEmpty(assurance.getEan()));
        		assuranceManagementView.getRcc().setText(Utilities.isEmpty(assurance.getRcc()));
//        		assuranceManagementView.getCoverCard().setText(assurance.getCoverCard());
        		assuranceManagementView.getNpa().setText(Utilities.isEmpty(assurance.getNpa()));
        		assuranceManagementView.getPhone().setText(Utilities.isEmpty(assurance.getPhone()));
        		assuranceManagementView.getValidationDate().setText(Utilities.isEmpty(assurance.getValidationDate()));
        		assuranceManagementView.getCardValidity().setText(Utilities.isEmpty(assurance.getCardValidity()));
        		assuranceManagementView.getValidationNumber().setText(Utilities.isEmpty(assurance.getValidationNumber()));
        		assuranceManagementView.getAddress().setText(Utilities.isEmpty(assurance.getAddress()));
//        		assuranceManagementView.getAos().setText(assurance.getAos());
        		
        		assuranceManagementView.setEdit(true);
        		
        		assuranceManagementView.setVisible(true);
        	}
        }else{
			JOptionPane.showMessageDialog(this, "Veuillez séléctionner une assurance pour pouvoir la modifier!");
        }
        
    } 
	
	private void newActionPerformed(ActionEvent evt, TypeAssurance assurance) {                                         
		AssuranceManagementView assuranceManagementView = new AssuranceManagementView(em, vente);
        assuranceManagementView.setTypeAssurance(assurance);
        assuranceManagementView.setVisible(true);
    } 

}
