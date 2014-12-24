package com.mm.app.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

import com.mm.app.model.Assurance;
import com.mm.app.model.AssuranceClient;
import com.mm.app.model.Client;
import com.mm.app.model.Vente;
import com.mm.app.service.ClientService;
import com.mm.app.service.VenteService;
import com.mm.app.service.impl.ClientServiceImpl;
import com.mm.app.service.impl.VenteServiceImpl;
import com.mm.app.utilities.ClientTableModel;
import com.mm.app.utilities.Java2sAutoComboBox;
import com.mm.app.utilities.SubAssuranceTableModel;
import com.mm.app.utilities.Utilities;

public class ClientWidget extends JInternalFrame implements InternalFrameWidget{

	private static final long serialVersionUID = -1528594567776851222L;

	private JTextField firstName;
	private Java2sAutoComboBox reference;
	private JTextField dateOfBirth;
	private JTextField phone;
	private JTextField age;
	
	private JPanel buttonPanel;
	private JButton editButton;
	private JButton newButton;
	
	private ClientService clientService;
	private VenteService venteService;
	private Vente vente;
	private EntityManager em;
	
	public ClientWidget(EntityManager em, Vente vente) {
		this.em = em;
		this.vente = vente;
		clientService = new ClientServiceImpl(em);
		venteService = new VenteServiceImpl(em);
		
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

		firstName = new JTextField();
		dateOfBirth = new JTextField();
		age = new JTextField();
		phone = new JTextField();

		ArrayList<String> data = new ArrayList<String>();   
		data.add("");
		List<Client> result = clientService.getClients();
		if(result != null && result.size() > 0){
			for(Client c : result){
				data.add(c.getReference());
			}
		}

		reference = new Java2sAutoComboBox(data);
		reference.setDataList(data);
		reference.setMaximumRowCount(3);

		reference.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyChar() == KeyEvent.VK_ENTER) {
					String selectedValue = (String) reference.getSelectedItem();
					Client client = clientService.findClientByReference(selectedValue);

					em.getTransaction().begin();
					vente = em.find(Vente.class, vente.getId());
					vente.setClient(client);
					em.getTransaction().commit();

					firstName.setText(client.getFirstName() + " " + client.getLastName());
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
						}
					}
					
					headerPanel.getClient().activateButton(true);
					
					JTextField assuranceField = null;
					JTextField hiddenField = null;
					JButton newAssurance = null;
					
					List<Assurance> assurances = clientService.getClientAssurances(client);
					if(assurances != null && assurances.size() > 0){
						for(Assurance assurance : assurances){
							TypeAssurance type = assurance.getType();
						
							assuranceWidget.getNewAssur1().setEnabled(true);
							assuranceWidget.getNewAssur2().setEnabled(true);
							assuranceWidget.getNewAssur3().setEnabled(true);
							
							switch (type) {
							case OBLIGATOIRE:
								assuranceField = assuranceWidget.getAssurance1();
								hiddenField = assuranceWidget.getHiddenField1();
								newAssurance = assuranceWidget.getNewAssur1();
								break;
							case ACCIDENT:
								assuranceField = assuranceWidget.getAssurance2();
								hiddenField = assuranceWidget.getHiddenField2();
								newAssurance = assuranceWidget.getNewAssur2();
								break;
							case COMPLEMENTAIRE:
								assuranceField = assuranceWidget.getAssurance3();
								hiddenField = assuranceWidget.getHiddenField3();
								newAssurance = assuranceWidget.getNewAssur3();
								break;
							default:
								break;
							}
							
							assuranceField.setText(assurance.getName());
							hiddenField.setText(String.valueOf(assurance.getId()));
							newAssurance.setEnabled(false);
						}
					}

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
		
		reference.setPreferredSize(new Dimension(203, 20));
		buttonPanel.add(reference);
		buttonPanel.add(editButton);
		buttonPanel.add(newButton);
		
		
		add(Utilities.createFilledSimplePanel("Référence", buttonPanel));
		add(Utilities.createFilledSimplePanel("Nom & Prénom", firstName));
		add(Utilities.createFilledSimplePanel("Date de Naissance", dateOfBirth));
		add(Utilities.createFilledSimplePanel("Age", age));
		add(Utilities.createFilledSimplePanel("Tél.", phone));

	}

	public JTextField getFirstName() {
		return firstName;
	}

	public void setFirstName(JTextField firstName) {
		this.firstName = firstName;
	}

	public Java2sAutoComboBox getReference() {
		return reference;
	}

	public void setReference(Java2sAutoComboBox reference) {
		this.reference = reference;
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
	
	private void editActionPerformed(ActionEvent evt) {
		String ref = (String) reference.getSelectedItem();
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
					data[i] = "(" + vente.getId() + ") -- " + dateFormat.format(vente.getDateCreation()) + " -- " + vente.getMedecin().getMedecinName();
					i++;
				}
			}
			
			List<Assurance> assurances = clientService.getClientAssurances(client);
			if(assurances != null && assurances.size() > 0){
				AbstractTableModel model = new SubAssuranceTableModel(assurances);
				clientManagementView.getAssuranceTable().setModel(model);
			}
			
			clientManagementView.getListOrdonnance().setListData(data);
			clientManagementView.setVisible(true);
		}
		else{
			JOptionPane.showMessageDialog(this, "Veuillez séléctionner un client pour pouvoir le modifier!");
		}
    } 
	
	private void newActionPerformed(ActionEvent evt) {                                         
		ClientManagementView clientManagementView = new ClientManagementView(em, vente);
		clientManagementView.setEdit(true);
	    clientManagementView.setVisible(true);
    }

	@Override
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
