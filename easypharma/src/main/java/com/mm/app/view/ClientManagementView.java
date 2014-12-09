package com.mm.app.view;

import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.util.List;

import javax.persistence.EntityManager;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.WindowConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import com.mm.app.model.Assurance;
import com.mm.app.model.AssuranceClient;
import com.mm.app.model.Client;
import com.mm.app.model.Product;
import com.mm.app.model.Vente;
import com.mm.app.service.ClientService;
import com.mm.app.service.impl.ClientServiceImpl;
import com.mm.app.utilities.ClientTableModel;
import com.mm.app.utilities.SubAssuranceTableModel;
import com.mm.app.utilities.Utilities;


public class ClientManagementView extends JFrame {

	private static final long serialVersionUID = 1L;

	private EntityManager em;
	private ClientService service;
	private Client client = null;
	private Vente vente;
	
	public ClientManagementView(EntityManager em, Vente vente) {
		this.em = em;
		this.vente = vente;
		service = new ClientServiceImpl(em);

		initComponents();
		getContentPane().setBackground(Color.WHITE);
		ImageIcon img = new ImageIcon(getClass().getResource("/img/logo.png"));
		setIconImage(img.getImage());
	}

	@SuppressWarnings({ "unchecked", "serial", "rawtypes" })
	private void initComponents() {

		jPanel1 = new JPanel();
		searchField = new JTextField();
		jScrollPane1 = new JScrollPane();
		searchTable = new JTable();
		jPanel3 = new JPanel();
		jPanel4 = new JPanel();
		firstNameLabel = new JLabel();
		firstName = new JTextField();
		jPanel5 = new JPanel();
		lastNameLabel = new JLabel();
		lastName = new JTextField();
		jPanel9 = new JPanel();
		dateOfBirthLabel = new JLabel();
		dateOfBirth = new JTextField();
		jPanel10 = new JPanel();
		referenceLabel = new JLabel();
		reference = new JTextField();
		hiddenId = new JTextField();
		sexePanel = new JPanel();
		sexeLabel = new JLabel();
		sexeHomme = new JRadioButton();
		sexeFemme = new JRadioButton();
		jPanel12 = new JPanel();
		ageLabel = new JLabel();
		age = new JTextField();
		jPanel14 = new JPanel();
		emailLabel = new JLabel();
		email = new JTextField();
		jPanel15 = new JPanel();
		rpiLabel = new JLabel();
		rpi = new JTextField();
		jPanel16 = new JPanel();
		avsLabel = new JLabel();
		avs = new JTextField();
		jPanel17 = new JPanel();
		mobileLabel = new JLabel();
		mobile = new JTextField();
		jPanel18 = new JPanel();
		fixeLabel = new JLabel();
		fixe = new JTextField();
		jPanel19 = new JPanel();
		faxLabel = new JLabel();
		fax = new JTextField();
		jPanel2 = new JPanel();
		listOrdonnanceLabel = new JLabel();
		jScrollPane2 = new JScrollPane();
		listOrdonnance = new JList();
		jScrollPane3 = new JScrollPane();
		tableOrdonnance = new JTable();
		validate = new JButton();
		cancel = new JButton();
		jPanel6 = new JPanel();
		jTabbedPane1 = new JTabbedPane();
		jPanel7 = new JPanel();
		jPanel21 = new JPanel();
		jLabel2 = new JLabel();
		jTextField4 = new JTextField();
		jPanel22 = new JPanel();
		jLabel5 = new JLabel();
		jTextField5 = new JTextField();
		jPanel23 = new JPanel();
		jLabel11 = new JLabel();
		jScrollPane4 = new JScrollPane();
		jTextArea1 = new JTextArea();
		jPanel24 = new JPanel();
		jPanel25 = new JPanel();
		jLabel18 = new JLabel();
		jTextField9 = new JTextField();
		jPanel26 = new JPanel();
		jLabel19 = new JLabel();
		jTextField11 = new JTextField();
		jPanel27 = new JPanel();
		jLabel20 = new JLabel();
		jScrollPane5 = new JScrollPane();
		jTextArea2 = new JTextArea();
		jPanel28 = new JPanel();
		jPanel29 = new JPanel();
		jLabel21 = new JLabel();
		jTextField18 = new JTextField();
		jPanel30 = new JPanel();
		jLabel22 = new JLabel();
		jTextField19 = new JTextField();
		jPanel31 = new JPanel();
		jLabel23 = new JLabel();
		jScrollPane6 = new JScrollPane();
		jTextArea3 = new JTextArea();
		assuranceTable = new JTable();
		jPanel13 = new JPanel();
		listAssurancesLabel = new JLabel();
		jScrollPane7 = new JScrollPane();

		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setTitle("Gestion des Clients");
		setResizable(false);

		GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(
				jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addGap(232, 232, 232)
						.addComponent(searchField, GroupLayout.PREFERRED_SIZE, 327, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);
		jPanel1Layout.setVerticalGroup(
				jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(searchField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);

		searchTable.setModel(new DefaultTableModel(
				new Object [][] {
						{null, null, null, null, null, null},
						{null, null, null, null, null, null},
						{null, null, null, null, null, null},
						{null, null, null, null, null, null}
				},
				new String [] {
						"Id", "Réference", "Nom", "Prénom", "Age", "Date de Naissance"
				}
				) {
			boolean[] canEdit = new boolean [] {
					false, false, false, false, false
			};

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit [columnIndex];
			}
		});
		jScrollPane1.setViewportView(searchTable);
		
		searchTable.setCellSelectionEnabled(true);
		ListSelectionModel cellSelectionModel = searchTable.getSelectionModel();
		cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);


		cellSelectionModel.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				Integer selectedData = 0;

				int[] selectedRow = searchTable.getSelectedRows();
				int[] selectedColumns = searchTable.getSelectedColumns();

				for (int i = 0; i < selectedRow.length; i++) {
					for (int j = 0; j < selectedColumns.length; j++) {
						selectedData = (Integer) searchTable.getValueAt(selectedRow[i], selectedColumns[j]);
					}
				}

				client = service.findClient(selectedData);

				if(client != null){
					age.setText(String.valueOf(client.getAge()));
					email.setText(String.valueOf(client.getEmail()));
					rpi.setText(String.valueOf(client.getMpi()));
					avs.setText(String.valueOf(client.getAvs()));
					mobile.setText(client.getPhone());
					fixe.setText(client.getFix());
					fax.setText(client.getFax());
					firstName.setText(client.getFirstName());
					lastName.setText(client.getLastName());
					dateOfBirth.setText(client.getLastName());
					reference.setText(client.getReference());
					hiddenId.setText(String.valueOf(client.getId()));
					
					
					List<Vente> ventes = client.getVentes();
					
					String[] data = new String[ventes.size()];
					int i  = 0;
					for(Vente vente : ventes){
						data[i] = vente.getId() + " (" + vente.getOperator().getFirstName() + ")";
						i++;
					}
					
					listOrdonnance.setListData(data);

					List<Assurance> assurances = service.getClientAssurances(client);
					if(assurances != null && assurances.size() > 0){
						AbstractTableModel model = new SubAssuranceTableModel(assurances);
						assuranceTable.setModel(model);
					}
					
				}
			}
		});


		searchField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				searchActionPerformed(evt);
			}
		});

		firstNameLabel.setText("Nom:");
		lastNameLabel.setText("Prénom: ");
		dateOfBirthLabel.setText("Date de naissance:");
		referenceLabel.setText("Réference:");
		ageLabel.setText("Age:");
		rpiLabel.setText("N° RPI: ");
		avsLabel.setText("N° AVS: ");
		mobileLabel.setText("Mobile:");
		fixeLabel.setText("Fix: ");
		faxLabel.setText("Fax: ");
		emailLabel.setText("Email: ");

		GridLayout gridLayout = new GridLayout(6, 2, 0, 0);
		gridLayout.setHgap(0);
		gridLayout.setVgap(0);
		jPanel3.setLayout(gridLayout);

		jPanel3.add(Utilities.createFilledSimpleInnerPanel(firstNameLabel, firstName));
		jPanel3.add(Utilities.createFilledSimpleInnerPanel(lastNameLabel, lastName));
		jPanel3.add(Utilities.createFilledSimpleInnerPanel(dateOfBirthLabel, dateOfBirth));
		jPanel3.add(Utilities.createFilledSimpleInnerPanel(referenceLabel, reference));
		jPanel3.add(Utilities.createFilledSimpleInnerPanel(ageLabel, age));
		jPanel3.add(Utilities.createFilledSimpleInnerPanel(rpiLabel, rpi));
		jPanel3.add(Utilities.createFilledSimpleInnerPanel(avsLabel, avs));
		jPanel3.add(Utilities.createFilledSimpleInnerPanel(mobileLabel, mobile));
		jPanel3.add(Utilities.createFilledSimpleInnerPanel(fixeLabel, fixe));
		jPanel3.add(Utilities.createFilledSimpleInnerPanel(faxLabel, fax));
		jPanel3.add(Utilities.createFilledSimpleInnerPanel(emailLabel, email));


//		sexeLabel.setText("Sexe: ");
//		sexeHomme.setText("Homme");
//		sexeFemme.setText("Femme");
//
//		GroupLayout jPanel11Layout = new GroupLayout(sexePanel);
//		sexePanel.setLayout(jPanel11Layout);
//		jPanel11Layout.setHorizontalGroup(
//				jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
//				.addGroup(jPanel11Layout.createSequentialGroup()
//						.addContainerGap()
//						.addComponent(sexeLabel)
//						.addGap(18, 18, 18)
//						.addComponent(sexeHomme)
//						.addPreferredGap(ComponentPlacement.UNRELATED)
//						.addComponent(sexeFemme)
//						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
//				);
//		jPanel11Layout.setVerticalGroup(
//				jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
//				.addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
//						.addComponent(sexeLabel, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
//						.addComponent(sexeHomme)
//						.addComponent(sexeFemme))
//				);
//
//		jPanel3.add(Utilities.createFilledSimpleInnerPanel(sexeLabel, sexePanel));


		listOrdonnanceLabel.setText("Liste Ordonnances");
		listOrdonnanceLabel.setFont(new java.awt.Font("Tahoma", 1, 11));
		jScrollPane2.setViewportView(listOrdonnance);

		listOrdonnance.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent evt) {
//				listOrdonnanceValueChanged(evt);
			}
		});

		tableOrdonnance.setModel(new DefaultTableModel(
				new Object [][] {
						{null, null},
						{null, null},
						{null, null}
				},
				new String [] {
						"Designation", "PU"
				}
				) {
			boolean[] canEdit = new boolean [] {
					false, false
			};

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit [columnIndex];
			}
		});
		jScrollPane3.setViewportView(tableOrdonnance);
		jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
		jPanel2.setBackground(Color.WHITE);

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 2, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(listOrdonnanceLabel)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(listOrdonnanceLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        
		validate.setText("Valider");

		cancel.setText("Annuler");

		validate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				validateActionPerformed(evt);	
			}
		});

		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				cancelActionPerformed(evt);	
			}
		});

		jLabel2.setText("Ville:");

		GroupLayout jPanel21Layout = new GroupLayout(jPanel21);
		jPanel21.setLayout(jPanel21Layout);
		jPanel21Layout.setHorizontalGroup(
				jPanel21Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel21Layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jLabel2)
						.addGap(18, 18, 18)
						.addComponent(jTextField4)
						.addContainerGap())
				);
		jPanel21Layout.setVerticalGroup(
				jPanel21Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel21Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(jLabel2, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
						.addComponent(jTextField4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				);

		jLabel5.setText("Code Postale: ");

		GroupLayout jPanel22Layout = new GroupLayout(jPanel22);
		jPanel22.setLayout(jPanel22Layout);
		jPanel22Layout.setHorizontalGroup(
				jPanel22Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel22Layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jLabel5)
						.addGap(18, 18, 18)
						.addComponent(jTextField5, GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
						.addContainerGap())
				);
		jPanel22Layout.setVerticalGroup(
				jPanel22Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel22Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(jLabel5, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
						.addComponent(jTextField5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				);

		jLabel11.setText("Addresse: ");

		jTextArea1.setColumns(20);
		jTextArea1.setRows(5);
		jScrollPane4.setViewportView(jTextArea1);

		GroupLayout jPanel23Layout = new GroupLayout(jPanel23);
		jPanel23.setLayout(jPanel23Layout);
		jPanel23Layout.setHorizontalGroup(
				jPanel23Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel23Layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jLabel11)
						.addGap(18, 18, 18)
						.addComponent(jScrollPane4, GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE))
				);
		jPanel23Layout.setVerticalGroup(
				jPanel23Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel23Layout.createSequentialGroup()
						.addGroup(jPanel23Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(jLabel11, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(jScrollPane4, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))
								.addContainerGap())
				);

		GroupLayout jPanel7Layout = new GroupLayout(jPanel7);
		jPanel7.setLayout(jPanel7Layout);
		jPanel7Layout.setHorizontalGroup(
				jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel7Layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(jPanel7Layout.createSequentialGroup()
										.addComponent(jPanel23, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGap(0, 10, Short.MAX_VALUE))
										.addGroup(jPanel7Layout.createSequentialGroup()
												.addComponent(jPanel21, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addGap(18, 18, 18)
												.addComponent(jPanel22, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
												.addContainerGap())
				);
		jPanel7Layout.setVerticalGroup(
				jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel7Layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(jPanel22, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(jPanel21, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(jPanel23, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);

		jPanel21.setBackground(Color.WHITE);
		jPanel22.setBackground(Color.WHITE);
		jPanel23.setBackground(Color.WHITE);
		jPanel7.setBackground(Color.WHITE);
		
		jTabbedPane1.addTab("Addr. Principale", jPanel7);

		jLabel18.setText("Ville:");

		GroupLayout jPanel25Layout = new GroupLayout(jPanel25);
		jPanel25.setLayout(jPanel25Layout);
		jPanel25Layout.setHorizontalGroup(
				jPanel25Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel25Layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jLabel18)
						.addGap(18, 18, 18)
						.addComponent(jTextField9)
						.addContainerGap())
				);
		jPanel25Layout.setVerticalGroup(
				jPanel25Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel25Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(jLabel18, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
						.addComponent(jTextField9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				);

		jLabel19.setText("Code Postale: ");

		GroupLayout jPanel26Layout = new GroupLayout(jPanel26);
		jPanel26.setLayout(jPanel26Layout);
		jPanel26Layout.setHorizontalGroup(
				jPanel26Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel26Layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jLabel19)
						.addGap(18, 18, 18)
						.addComponent(jTextField11, GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
						.addContainerGap())
				);
		jPanel26Layout.setVerticalGroup(
				jPanel26Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel26Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(jLabel19, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
						.addComponent(jTextField11, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				);

		jLabel20.setText("Addresse: ");

		jTextArea2.setColumns(20);
		jTextArea2.setRows(5);
		jScrollPane5.setViewportView(jTextArea2);

		GroupLayout jPanel27Layout = new GroupLayout(jPanel27);
		jPanel27.setLayout(jPanel27Layout);
		jPanel27Layout.setHorizontalGroup(
				jPanel27Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel27Layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jLabel20)
						.addGap(18, 18, 18)
						.addComponent(jScrollPane5, GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE))
				);
		jPanel27Layout.setVerticalGroup(
				jPanel27Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel27Layout.createSequentialGroup()
						.addGroup(jPanel27Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(jLabel20, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(jScrollPane5, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))
								.addContainerGap())
				);

		GroupLayout jPanel24Layout = new GroupLayout(jPanel24);
		jPanel24.setLayout(jPanel24Layout);
		jPanel24Layout.setHorizontalGroup(
				jPanel24Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel24Layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(jPanel24Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(jPanel24Layout.createSequentialGroup()
										.addComponent(jPanel27, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGap(0, 10, Short.MAX_VALUE))
										.addGroup(jPanel24Layout.createSequentialGroup()
												.addComponent(jPanel25, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addGap(18, 18, 18)
												.addComponent(jPanel26, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
												.addContainerGap())
				);
		jPanel24Layout.setVerticalGroup(
				jPanel24Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel24Layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(jPanel24Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(jPanel26, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(jPanel25, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(jPanel27, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);

		jTabbedPane1.addTab("Addr. Facturation", jPanel24);
		
		jPanel24.setBackground(Color.WHITE);
		jPanel25.setBackground(Color.WHITE);
		jPanel26.setBackground(Color.WHITE);
		jPanel27.setBackground(Color.WHITE);
		
		jLabel21.setText("Ville:");

		GroupLayout jPanel29Layout = new GroupLayout(jPanel29);
		jPanel29.setLayout(jPanel29Layout);
		jPanel29Layout.setHorizontalGroup(
				jPanel29Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel29Layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jLabel21)
						.addGap(18, 18, 18)
						.addComponent(jTextField18)
						.addContainerGap())
				);
		jPanel29Layout.setVerticalGroup(
				jPanel29Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel29Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(jLabel21, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
						.addComponent(jTextField18, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				);

		jLabel22.setText("Code Postale: ");

		GroupLayout jPanel30Layout = new GroupLayout(jPanel30);
		jPanel30.setLayout(jPanel30Layout);
		jPanel30Layout.setHorizontalGroup(
				jPanel30Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel30Layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jLabel22)
						.addGap(18, 18, 18)
						.addComponent(jTextField19, GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
						.addContainerGap())
				);
		jPanel30Layout.setVerticalGroup(
				jPanel30Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel30Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(jLabel22, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
						.addComponent(jTextField19, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				);

		jLabel23.setText("Addresse: ");

		jTextArea3.setColumns(20);
		jTextArea3.setRows(5);
		jScrollPane6.setViewportView(jTextArea3);

		GroupLayout jPanel31Layout = new GroupLayout(jPanel31);
		jPanel31.setLayout(jPanel31Layout);
		jPanel31Layout.setHorizontalGroup(
				jPanel31Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel31Layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jLabel23)
						.addGap(18, 18, 18)
						.addComponent(jScrollPane6, GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE))
				);
		jPanel31Layout.setVerticalGroup(
				jPanel31Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel31Layout.createSequentialGroup()
						.addGroup(jPanel31Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(jLabel23, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(jScrollPane6, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))
								.addContainerGap())
				);

		GroupLayout jPanel28Layout = new GroupLayout(jPanel28);
		jPanel28.setLayout(jPanel28Layout);
		jPanel28Layout.setHorizontalGroup(
				jPanel28Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel28Layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(jPanel28Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(jPanel28Layout.createSequentialGroup()
										.addComponent(jPanel31, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGap(0, 10, Short.MAX_VALUE))
										.addGroup(jPanel28Layout.createSequentialGroup()
												.addComponent(jPanel29, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addGap(18, 18, 18)
												.addComponent(jPanel30, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
												.addContainerGap())
				);
		jPanel28Layout.setVerticalGroup(
				jPanel28Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel28Layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(jPanel28Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(jPanel30, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(jPanel29, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(jPanel31, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);

		jTabbedPane1.addTab("Addr. Livraison", jPanel28);
		
		jPanel28.setBackground(Color.WHITE);
		jPanel29.setBackground(Color.WHITE);
		jPanel30.setBackground(Color.WHITE);
		jPanel31.setBackground(Color.WHITE);
		
		GroupLayout jPanel6Layout = new GroupLayout(jPanel6);
		jPanel6.setLayout(jPanel6Layout);
		jPanel6.setBackground(Color.WHITE);
		jPanel6Layout.setHorizontalGroup(
				jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(jTabbedPane1)
				);
		jPanel6Layout.setVerticalGroup(
				jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel6Layout.createSequentialGroup()
						.addComponent(jTabbedPane1, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
						.addGap(0, 0, Short.MAX_VALUE))
				);
		
		listAssurancesLabel.setText("Liste Assurances");
		listAssurancesLabel.setFont(new java.awt.Font("Tahoma", 1, 11));
		
        assuranceTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Réference", "Assurance"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });

        jScrollPane7.setViewportView(assuranceTable);

        jPanel13.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel13.setBackground(Color.WHITE);
        
        javax.swing.GroupLayout jPanel13Layout = new GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(listAssurancesLabel)
                    .addComponent(jScrollPane7, GroupLayout.PREFERRED_SIZE, 266, GroupLayout.PREFERRED_SIZE)))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(listAssurancesLabel)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane7, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        
        jPanel1.setBackground(Color.WHITE);
        jPanel3.setBackground(Color.WHITE);
        
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, GroupLayout.Alignment.TRAILING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(cancel, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(validate, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addComponent(jPanel13, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel13, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(validate)
                            .addComponent(cancel)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

		pack();
		setLocationRelativeTo(null);
	}// </editor-fold>                        

	private void listOrdonnanceValueChanged(ListSelectionEvent evt) {
		String selected = listOrdonnance.getSelectedValue().toString();
		String ordonnaceId = selected.substring(selected.indexOf("(") + 1, selected.indexOf(")"));

		System.out.println(ordonnaceId);

		List<Product> products = em.createQuery("SELECT o.products FROM Ordonnance o WHERE o.id = :id", Product.class).setParameter("id", Integer.valueOf(ordonnaceId)).getResultList();
		Object[][] data = null;

		if(products != null && products.size() > 0){
			data = new Object[products.size()][2];
			int i = 0;
			for(Product p : products){
				data[i][0] = p.getDesignation();
				data[i][1] = p.getPu();
				i++;
			}
		}

		String[] columnNames =  {"Designation", "PU"};

		DefaultTableModel dtm = new DefaultTableModel(data, columnNames){
			public Class getColumnClass(int c) {
				return getValueAt(0, c).getClass();
			}
		};
		tableOrdonnance.setModel(dtm);
	}

	private void validateActionPerformed(ActionEvent evt){
		for (Frame frame : Frame.getFrames()) {
			if (frame.getTitle().equals("EasyPharma: Gestion Pharmacies ")) {
				SaleView saleView = (SaleView) frame;
				
				ClientWidget clientWidget = ((ClientWidget) saleView.getClientWidget());
				
				if(hiddenId.getText() != ""){
					client = em.find(Client.class, Integer.valueOf(hiddenId.getText()));
				}
				
				em.getTransaction().begin();
				vente = em.find(Vente.class, vente.getId());
				vente.setClient(client);
				em.getTransaction().commit();
				
				saleView.getHeaderPanel().getClient().activateButton(true);
				
				clientWidget.getReference().setSelectedItem(client.getReference());
				clientWidget.getFirstName().setText(client.getFirstName() + " " + client.getLastName());
				clientWidget.getDateOfBirth().setText(DateFormat.getInstance().format(client.getBirthDate()));
				clientWidget.getAge().setText(String.valueOf(client.getAge()));
				clientWidget.getPhone().setText(client.getPhone());
				
				AssuranceWidget assuranceWidget = (AssuranceWidget) saleView.getAssuranceWidget();
				JTextField assuranceField = null;
				JTextField hiddenField = null;
				JButton newAssurance = null;
				
				List<Assurance> assurances = service.getClientAssurances(client);
				if(assurances != null && assurances.size() > 0){
					for(Assurance assurance : assurances){
						TypeAssurance type = assurance.getType();
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
				
				saleView.setVisible(true);
			}
		}
		setVisible(false);
		dispose();
	}

	private void cancelActionPerformed(ActionEvent evt){
		setVisible(false);
		dispose();
	}

	private void searchActionPerformed(ActionEvent evt) {                                         
		String value = searchField.getText();
		List<Client> clients = service.findClientsByCriteria(value);
		if(clients != null && clients.size() > 0){
			AbstractTableModel model = new ClientTableModel(clients);
			searchTable.setModel(model);
		}

	}

	public JList getListOrdonnance() {
		return listOrdonnance;
	}
	
	public JTable getSearchTable() {
		return searchTable;
	}

	public JTextField getSearchField() {
		return searchField;
	}

	public JTextField getAge() {
		return age;
	}

	public JTextField getEmail() {
		return email;
	}

	public JTextField getRpi() {
		return rpi;
	}

	public JTextField getAvs() {
		return avs;
	}

	public JTextField getMobile() {
		return mobile;
	}

	public JTextField getFixe() {
		return fixe;
	}

	public JTextField getFax() {
		return fax;
	}

	public JTextField getLastName() {
		return lastName;
	}

	public JTextField getDateOfBirth() {
		return dateOfBirth;
	}

	public JTextField getReference() {
		return reference;
	}

	public JTextField getFirstName() {
		return firstName;
	}
	
	public JTable getAssuranceTable() {
		return assuranceTable;
	}
	
	public JTextField gethiddenId(){
		return hiddenId;
	}



	private JButton validate;
	private JButton cancel;
	private JLabel firstNameLabel;
	private JLabel ageLabel;
	private JLabel jLabel11;
	private JLabel emailLabel;
	private JLabel rpiLabel;
	private JLabel avsLabel;
	private JLabel mobileLabel;
	private JLabel fixeLabel;
	private JLabel faxLabel;
	private JLabel jLabel18;
	private JLabel jLabel19;
	private JLabel jLabel2;
	private JLabel jLabel20;
	private JLabel jLabel21;
	private JLabel jLabel22;
	private JLabel jLabel23;
	private JLabel listOrdonnanceLabel;
	private JLabel lastNameLabel;
	private JLabel jLabel5;
	private JLabel dateOfBirthLabel;
	private JLabel referenceLabel;
	private JLabel sexeLabel;
	private JList listOrdonnance;
	private JPanel jPanel1;
	private JPanel jPanel10;
	private JPanel sexePanel;
	private JPanel jPanel12;
	private JPanel jPanel14;
	private JPanel jPanel15;
	private JPanel jPanel16;
	private JPanel jPanel17;
	private JPanel jPanel18;
	private JPanel jPanel19;
	private JPanel jPanel2;
	private JPanel jPanel21;
	private JPanel jPanel22;
	private JPanel jPanel23;
	private JPanel jPanel24;
	private JPanel jPanel25;
	private JPanel jPanel26;
	private JPanel jPanel27;
	private JPanel jPanel28;
	private JPanel jPanel29;
	private JPanel jPanel3;
	private JPanel jPanel30;
	private JPanel jPanel31;
	private JPanel jPanel4;
	private JPanel jPanel5;
	private JPanel jPanel6;
	private JPanel jPanel7;
	private JPanel jPanel9;
	private JRadioButton sexeHomme;
	private JRadioButton sexeFemme;
	private JScrollPane jScrollPane1;
	private JScrollPane jScrollPane2;
	private JScrollPane jScrollPane3;
	private JScrollPane jScrollPane4;
	private JScrollPane jScrollPane5;
	private JScrollPane jScrollPane6;
	private JTabbedPane jTabbedPane1;
	private JTable searchTable;
	private JTable tableOrdonnance;
	private JTextArea jTextArea1;
	private JTextArea jTextArea2;
	private JTextArea jTextArea3;
	private JTextField searchField;
	private JTextField age;
	private JTextField jTextField11;
	private JTextField email;
	private JTextField rpi;
	private JTextField avs;
	private JTextField mobile;
	private JTextField fixe;
	private JTextField fax;
	private JTextField jTextField18;
	private JTextField jTextField19;
	private JTextField firstName;
	private JTextField lastName;
	private JTextField jTextField4;
	private JTextField jTextField5;
	private JTextField dateOfBirth;
	private JTextField reference;
	private JTextField jTextField9;
	private JTextField hiddenId;
	private JTable assuranceTable;
	private JPanel jPanel13;
	private JLabel listAssurancesLabel;
	private JScrollPane jScrollPane7;
}
