package com.mm.app.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
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

import com.mm.app.model.Client;
import com.mm.app.model.Ordonnance;
import com.mm.app.service.ClientService;
import com.mm.app.service.impl.ClientServiceImpl;
import com.mm.app.utilities.Java2sAutoComboBox;
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
	
	private EntityManager em;
	
	public ClientWidget(EntityManager em) {
		this.em = em;
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
					
					firstName.setText(client.getFirstName() + " " + client.getLastName());
					dateOfBirth.setText(DateFormat.getInstance().format(client.getBirthDate()));
					age.setText(String.valueOf(client.getAge()));
					phone.setText(client.getPhone());
					

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
		ClientManagementView clientManagementView = new ClientManagementView(em);
        
		if(!"".equals(ref)){
			clientManagementView.getSearchField().setEnabled(false);
			clientManagementView.getSearchTable().setEnabled(false);
			
			Client client = clientService.findClientByReference(ref);
			clientManagementView.getFirstName().setText(client.getFirstName());
			clientManagementView.getLastName().setText(client.getLastName());
			clientManagementView.getReference().setText(client.getReference());
			clientManagementView.getDateOfBirth().setText(DateFormat.getInstance().format(client.getBirthDate()));
			clientManagementView.getAge().setText(String.valueOf(client.getAge()));
			clientManagementView.getEmail().setText(String.valueOf(client.getEmail()));
			clientManagementView.getRpi().setText(String.valueOf(client.getMpi()));
			clientManagementView.getFixe().setText(client.getPhone());
			
			List<Ordonnance> ordonnances = client.getOrdonnances();
			
			String[] data = new String[ordonnances.size()];
			int i  = 0;
			DateFormat df = DateFormat.getDateInstance();
			for(Ordonnance ordonnance : ordonnances){
				data[i] = df.format(ordonnance.getStartDate()) + "(" + ordonnance.getId() + ")";
				i++;
			}
			
			clientManagementView.getListOrdonnance().setListData(data);
			clientManagementView.setVisible(true);
		}
		else{
			JOptionPane.showMessageDialog(this, "Veuillez séléctionner un client pour pouvoir le modifier!");
		}
    } 
	
	private void newActionPerformed(ActionEvent evt) {                                         
		 JFrame clientManagementView = new ClientManagementView(em);
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
