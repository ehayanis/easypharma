package com.mm.app.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
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
import com.mm.app.model.AssuranceClient;
import com.mm.app.model.Client;
import com.mm.app.model.Vente;
import com.mm.app.service.AssuranceService;
import com.mm.app.service.ClientService;
import com.mm.app.service.impl.AssuranceServiceImpl;
import com.mm.app.service.impl.ClientServiceImpl;
import com.mm.app.utilities.Utilities;


public class AssuranceWidget extends JInternalFrame implements InternalFrameWidget, FocusListener{

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

	private EntityManager em;
	private AssuranceService service;
	private ClientService clientService;
	private Vente vente;
	
	public AssuranceWidget(EntityManager em, Vente vente) {
		this.em = em;
		this.vente = vente;
		
		service = new AssuranceServiceImpl(em);
		clientService = new ClientServiceImpl(em);
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
		
		editAssur1 = new HeaderButton("/img/edit.png", "Edit Assur1");
		editAssur1.addFocusListener(this);
		editAssur2 = new HeaderButton("/img/edit.png", "Edit Assur2");
		editAssur2.addFocusListener(this);
		editAssur3 = new HeaderButton("/img/edit.png", "Edit Assur3");
		editAssur3.addFocusListener(this);
		
		editAssur1.setEnabled(false);
		editAssur2.setEnabled(false);
		editAssur3.setEnabled(false);
		
		editAssur1.setActionCommand("editAssur1");
		editAssur2.setActionCommand("editAssur2");
		editAssur3.setActionCommand("editAssur3");
		
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
		
		///////////// TO BE REMOVED ///////////////////
		///////////////////////////////////////////////
		JButton hiddenBtn1 = new JButton();
		hiddenBtn1.setVisible(false);
		JButton hiddenBtn3 = new JButton();
		hiddenBtn3.setVisible(false);
		
		
		add(Utilities.createFilledAdvancedPanel("Assurance Obligatoire", assurance1, editAssur1));
		add(Utilities.createFilledAdvancedPanel("Assurance Accident", assurance2, editAssur2));
		add(Utilities.createFilledAdvancedPanel("Assurance Complémentaire", assurance3, editAssur3));
		add(Utilities.createFilledAdvancedPanel(" ", new JLabel(), hiddenBtn1));
		add(Utilities.createFilledAdvancedPanel(" ", new JLabel(), hiddenBtn3));
		
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

	public Vente getVente() {
		return vente;
	}

	public void setVente(Vente vente) {
		this.vente = vente;
	}
	
	public JButton getEditAssur1() {
		return editAssur1;
	}

	public void setEditAssur1(JButton editAssur1) {
		this.editAssur1 = editAssur1;
	}

	public JButton getEditAssur2() {
		return editAssur2;
	}

	public void setEditAssur2(JButton editAssur2) {
		this.editAssur2 = editAssur2;
	}

	public JButton getEditAssur3() {
		return editAssur3;
	}

	public void setEditAssur3(JButton editAssur3) {
		this.editAssur3 = editAssur3;
	}

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
//		JTextField hiddenField = null;
//		switch (typeAssurance) {
//		case OBLIGATOIRE:
//			assuranceField = assurance1;
//			hiddenField = hiddenField1;
//			break;
//		case ACCIDENT:
//			assuranceField = assurance2;
//			hiddenField = hiddenField2;
//			break;
//		case COMPLEMENTAIRE:
//			assuranceField = assurance3;
//			hiddenField = hiddenField3;
//			break;
//		default:
//			break;
//		}
		
		String coverCard = ((JTextField) evt.getSource()).getText();
		
		if(!"".equals(coverCard)){
			AssuranceClient assuranceClient = service.findAssuranceByCoverCard(coverCard);
			if(assuranceClient != null){
//				assuranceField.setText(assurance.getAssurance().getName());
//				hiddenField.setText(String.valueOf(assurance.getAssurance().getId()));
				
				Client client = assuranceClient.getClient();
				
				if(client != null){
					for (Frame frame : Frame.getFrames()) {
						if (frame.getTitle().equals("EasyPharma: Gestion Pharmacies ")) {
							SaleView saleView = (SaleView) frame;
							ClientWidget clientWidget = (ClientWidget) saleView.getClientWidget();
							clientWidget.getFirstName().setSelectedItem(client.getFirstName() + " " + client.getLastName());
							clientWidget.getReference().setText(client.getReference());
							clientWidget.getDateOfBirth().setText(DateFormat.getDateInstance().format(client.getBirthDate()));
							clientWidget.getPhone().setText(client.getPhone());
							clientWidget.getAge().setText(String.valueOf(client.getAge()));
							
							editAssur1.setEnabled(true);
							editAssur1.setEnabled(true);
							editAssur1.setEnabled(true);

							JTextField assuranceField = null;
							JTextField hiddenField = null;
							
							List<AssuranceClient> assurances = clientService.getClientAssurances(client);
							if(assurances != null && assurances.size() > 0){

								for(AssuranceClient assurance : assurances){
									TypeAssurance type = assurance.getType();
									
									switch (type) {
									case OBLIGATOIRE:
										assuranceField = assurance1;
										hiddenField = hiddenField1;
										break;
									case ACCIDENT:
										assuranceField = assurance2;
										hiddenField = hiddenField2;
										break;
									case COMPLEMENTAIRE:
										assuranceField = assurance3;
										hiddenField = hiddenField3;
										break;
									default:
										break;
									}
									
									assuranceField.setText(assurance.getAssurance().getName());
									hiddenField.setText(String.valueOf(assurance.getAssurance().getId()));
								}
							}
							
							saleView.setVisible(true);
						}
					}
				}
			}
		}
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
        		assuranceManagementView.getValidationDate().setValue(assurance.getValidationDate());
        		assuranceManagementView.getCardValidity().setValue(assurance.getCardValidity());
        		assuranceManagementView.getValidationNumber().setText(Utilities.isEmpty(assurance.getValidationNumber()));
        		assuranceManagementView.getAddress().setText(Utilities.isEmpty(assurance.getAddress()));
//        		assuranceManagementView.getAos().setText(assurance.getAos());
        		
        		assuranceManagementView.setEdit(true);
        		
        		assuranceManagementView.setVisible(true);
        	}
        }else{
        	assuranceManagementView.setTypeAssurance(typeAssurance);
            assuranceManagementView.setVisible(true);
        }
        
    } 
	
	public void focusLost(FocusEvent evt) {
			((JButton) evt.getSource()).setIcon(new ImageIcon(getClass().getResource("/img/edit.png")));
	}
	
	public void focusGained(FocusEvent evt) {
		((JButton) evt.getSource()).setIcon(new ImageIcon(getClass().getResource("/img/edit-hover.png")));
	}
	
}
