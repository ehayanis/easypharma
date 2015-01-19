package com.mm.app.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.persistence.EntityManager;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

import com.mm.app.model.AssuranceClient;
import com.mm.app.model.Client;
import com.mm.app.model.Medecin;
import com.mm.app.model.Vente;
import com.mm.app.service.ClientService;
import com.mm.app.service.impl.ClientServiceImpl;
import com.mm.app.utilities.SubAssuranceTableModel;
import com.mm.app.utilities.Utilities;

public class ClientWidget extends JInternalFrame implements InternalFrameWidget{

	private static final long serialVersionUID = -1528594567776851222L;

	private JTextField reference;
	private JComboBox<String> firstName;
	private JTextField dateOfBirth;
	private JTextField phone;
	private JTextField age;
	
	private JPanel buttonPanel;
	private HeaderButton editButton;
	
	private ClientService clientService;
	private Vente vente;
	private EntityManager em;
	private SortedMap<String, String> data;
	
	public ClientWidget(EntityManager em, Vente vente) {
		this.em = em;
		this.vente = vente;
		clientService = new ClientServiceImpl(em);
		
		initComponent();
		getContentPane().setBackground(Color.WHITE);
		
		setFrameIcon(new ImageIcon(getClass().getResource("/img/graphite.png")));
		setTitle("Client");
		setBorder(javax.swing.BorderFactory.createEtchedBorder());
		setVisible(true);
		setFont(new Font("Agency FB", 0, 9));
	}

	private void initComponent() {
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

		reference = new JTextField();
		dateOfBirth = new JTextField();
		age = new JTextField();
		phone = new JTextField();

		data = new TreeMap<String, String>();
		data.put("", "");
		List<Client> result = clientService.getClients();
		if(result != null && result.size() > 0){
			for(Client c : result){
				data.put(c.getFirstName() + " " + c.getLastName(), c.getReference());
			}
		}

		firstName = new JComboBox<String>();
		firstName.setMaximumRowCount(5);
		firstName.setSelectedItem("");
		firstName.setEditable(true);
		firstName.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String referencePram = null;
				String lastTypedText = "";
				List<String> comboBoxModel = new ArrayList<String>();
				if (e.getKeyChar() == KeyEvent.VK_ENTER) {
					
					String selectedValue = (String) firstName.getSelectedItem();
					referencePram = data.get(selectedValue);
					Client client = clientService.findClientByReference(referencePram);

					em.getTransaction().begin();
					vente = em.find(Vente.class, vente.getId());
					vente.setClient(client);
					em.getTransaction().commit();

					reference.setText(client.getReference());
					dateOfBirth.setText(DateFormat.getInstance().format(client.getBirthDate()));
					age.setText(String.valueOf(client.getAge()));
					phone.setText(client.getPhone());

					AssuranceWidget assuranceWidget = null;
					HeaderPanel headerPanel = null;
					for (Frame frame : Frame.getFrames()) {
						if (frame.getTitle().equals("EasyPharma: Gestion Pharmacies ")) {
							SaleView saleView = (SaleView) frame;
							assuranceWidget = (AssuranceWidget) saleView.getAssuranceWidget();
							headerPanel = saleView.getHeaderPanel();
							
							headerPanel.getClient().activateButton(true);
							
							JTextField assuranceField = null;
							JTextField hiddenField = null;
							
							assuranceWidget.getEditAssur1().setEnabled(true);
							assuranceWidget.getEditAssur2().setEnabled(true);
							assuranceWidget.getEditAssur3().setEnabled(true);
							assuranceWidget.getAssurance1().setText("");
							assuranceWidget.getAssurance2().setText("");
							assuranceWidget.getAssurance3().setText("");
							
							List<AssuranceClient> assurances = clientService.getClientAssurances(client);
							if(assurances != null && assurances.size() > 0){
								for(AssuranceClient assurance : assurances){
									TypeAssurance type = assurance.getType();
									
									switch (type) {
									case OBLIGATOIRE:
										assuranceField = assuranceWidget.getAssurance1();
										hiddenField = assuranceWidget.getHiddenField1();
										break;
									case ACCIDENT:
										assuranceField = assuranceWidget.getAssurance2();
										hiddenField = assuranceWidget.getHiddenField2();
										break;
									case COMPLEMENTAIRE:
										assuranceField = assuranceWidget.getAssurance3();
										hiddenField = assuranceWidget.getHiddenField3();
										break;
									default:
										break;
									}
									
									assuranceField.setText(assurance.getAssurance().getName());
									hiddenField.setText(String.valueOf(assurance.getAssurance().getId()));
								}
							}
						}
					}
					

				}
				else {
					JTextField typedTextField = (JTextField) firstName
							.getEditor().getEditorComponent();
					if (typedTextField.getText() != null
							&& !comboBoxModel.contains(typedTextField
									.getText())
							&& !typedTextField.getText().equals(
									lastTypedText)) {
						comboBoxModel.clear();
						lastTypedText = typedTextField.getText();
						if (!lastTypedText.equals("")) {
							comboBoxModel.add(lastTypedText);
						}
						for (String key : data.keySet()) {
							if (key.toLowerCase().startsWith(
									lastTypedText.toLowerCase())) {
								comboBoxModel.add(key);
							}
						}
						firstName.setModel(new DefaultComboBoxModel(
								comboBoxModel.toArray()));
						// firstName.setSelectedItem(lastTypedText);
						firstName.showPopup();
					}
				}
			}
		});
		
		FlowLayout gl = new FlowLayout();
		gl.setHgap(5);
		gl.setVgap(0);
		
		buttonPanel = new JPanel(gl);
		buttonPanel.setBackground(Color.WHITE);
		
		editButton = new HeaderButton("/img/edit.png", "Edit Button");
		
		editButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                editActionPerformed(evt);
            }
        });
		
		editButton.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent evt) {
					((JButton) evt.getSource()).setIcon(new ImageIcon(getClass().getResource("/img/edit.png")));
			}
			
			public void focusGained(FocusEvent evt) {
				((JButton) evt.getSource()).setIcon(new ImageIcon(getClass().getResource("/img/edit-hover.png")));
			}
		});
		
		firstName.setPreferredSize(new Dimension(216, 20));
		buttonPanel.add(firstName);
		buttonPanel.add(editButton);
		
		//add(Utilities.createFilledSimplePanel("Référence", buttonPanel));
		//add(Utilities.createFilledSimplePanel("Nom & Prénom", firstName));
		add(Utilities.createFilledSimplePanel("Nom & Prénom", buttonPanel));
		add(Utilities.createFilledSimplePanel("Référence", reference));
		add(Utilities.createFilledSimplePanel("Date de Naissance", dateOfBirth));
		add(Utilities.createFilledSimplePanel("Age", age));
		add(Utilities.createFilledSimplePanel("Tél.", phone));

	}

	public JTextField getReference() {
		return reference;
	}

	public void setReference(JTextField reference) {
		this.reference = reference;
	}

	public JComboBox<String> getFirstName() {
		return firstName;
	}

	public void setFirstName(JComboBox<String> firstName) {
		this.firstName = firstName;
	}

	public JTextField getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(JTextField dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public JTextField getPhone() {
		return phone;
	}

	public void setPhone(JTextField phone) {
		this.phone = phone;
	}
	
	public JTextField getAge() {
		return age;
	}

	public void setAge(JTextField age) {
		this.age = age;
	}
	
	public Vente getVente() {
		return vente;
	}

	public void setVente(Vente vente) {
		this.vente = vente;
	}

	public SortedMap<String, String> getData() {
		return data;
	}

	public void setData(SortedMap<String, String> data) {
		this.data = data;
	}
	
	public HeaderButton getEditButton() {
		return editButton;
	}

	public void setEditButton(HeaderButton editButton) {
		this.editButton = editButton;
	}

	private void editActionPerformed(ActionEvent evt) {
		String ref = (String) reference.getText();
		ClientManagementView clientManagementView = new ClientManagementView(em, vente);
        
		if(!"".equals(ref)){
			clientManagementView.getSearchField().setEnabled(false);
			clientManagementView.getSearchTable().setEnabled(false);
			
			Client client = clientService.findClientByReference(ref);

			clientManagementView.getFirstName().setText(Utilities.isEmpty(client.getFirstName()));
			clientManagementView.getLastName().setText(Utilities.isEmpty(client.getLastName()));
			clientManagementView.getReference().setText(Utilities.isEmpty(client.getReference()));
			clientManagementView.getDateOfBirth().setText(Utilities.isEmpty(client.getBirthDate()));
			clientManagementView.getAge().setText(Utilities.isEmpty(client.getAge()));
			clientManagementView.getEmail().setText(Utilities.isEmpty(client.getEmail()));
			clientManagementView.getRpi().setText(Utilities.isEmpty(client.getMpi()));
			clientManagementView.getFixe().setText(Utilities.isEmpty(client.getPhone()));
			clientManagementView.getFax().setText(Utilities.isEmpty(client.getFax()));
			clientManagementView.getAvs().setText(Utilities.isEmpty(client.getAvs()));
			clientManagementView.getMobile().setText(Utilities.isEmpty(client.getPhone()));
			clientManagementView.getAddrPrincipal().setText(Utilities.isEmpty(client.getAddrFacturation()));
			clientManagementView.getAddrFacturation().setText(Utilities.isEmpty(client.getAddrFacturation()));
			clientManagementView.getAddrLivraison().setText(Utilities.isEmpty(client.getAddrLivraison()));
			clientManagementView.gethiddenId().setText(Utilities.isEmpty(client.getId()));
			
			clientManagementView.setEdit(true);
			
			List<Vente> ventes = client.getVentes();
			
			String[] data = new String[ventes.size()];
			int i  = 0;
			for(Vente vente : ventes){
				if("COMPLETE".equals(vente.getStatus())){
					DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
					Medecin tempMedecin = vente.getMedecin();
					String medecinName = tempMedecin == null?"Aucun Médecin":tempMedecin.getMedecinName();
					data[i] = "(" + vente.getId() + ") -- " + dateFormat.format(vente.getDateCreation()) + " -- " + medecinName;
					i++;
				}
			}
			
			List<AssuranceClient> assurances = clientService.getClientAssurances(client);
			if(assurances != null && assurances.size() > 0){
				AbstractTableModel model = new SubAssuranceTableModel(assurances);
				clientManagementView.getAssuranceTable().setModel(model);
			}
			
			clientManagementView.getListOrdonnance().setListData(data);
			clientManagementView.setVisible(true);
		}
		else{
			clientManagementView.setNew(true);
		    clientManagementView.setVisible(true);
		}
    } 
	

	public void activateComponents(){
		firstName.setEnabled(true);
		firstName.setEditable(false);
		reference.setEnabled(true);
		dateOfBirth.setEnabled(true);
		dateOfBirth.setEditable(false);
		phone.setEnabled(true);
		phone.setEditable(false);
	}

}
