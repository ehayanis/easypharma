package com.mm.app.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.mm.app.model.Client;
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
	
	private JPanel buttonPanel;
	private JButton editButton;
	private JButton newButton;
	
	private ClientService clientService;
	
	public ClientWidget(EntityManager em) {
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
					phone.setText(client.getPhone());
					

				}
			}
		});
		
		buttonPanel = new JPanel();
		buttonPanel.setBackground(Color.WHITE);
		
		editButton = new HeaderButton("Edition", "/img/edit.gif", false, false);
		newButton = new HeaderButton("Nouveau", "/img/add.gif", false, false);
		
		buttonPanel.add(editButton);
		buttonPanel.add(newButton);
		
		
		add(Utilities.createFilledSimplePanel("R�f�rence", reference));
		add(Utilities.createFilledSimplePanel("Nom & Pr�nom", firstName));
		add(Utilities.createFilledSimplePanel("Date de Naissance", dateOfBirth));
		add(Utilities.createFilledSimplePanel("T�l.", phone));
		add(Utilities.createFilledSimplePanel(" ", buttonPanel));

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
