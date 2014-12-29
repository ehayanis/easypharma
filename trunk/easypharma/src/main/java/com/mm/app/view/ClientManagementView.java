package com.mm.app.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.persistence.EntityManager;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.ListSelectionModel;
import javax.swing.WindowConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import com.mm.app.model.AssuranceClient;
import com.mm.app.model.Client;
import com.mm.app.model.Vente;
import com.mm.app.model.VenteProduit;
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
	private boolean isEdit = false;
	private boolean isNew = false;
	
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
		jPanel1 = new MyJPanel();
		searchField = new JTextField();
		jScrollPane1 = new JScrollPane();
		searchTable = new JTable();
		jPanel3 = new MyJPanel();
		jPanel4 = new MyJPanel();
		firstNameLabel = new JLabel();
		firstName = new JTextField();
		jPanel5 = new MyJPanel();
		lastNameLabel = new JLabel();
		lastName = new JTextField();
		jPanel9 = new MyJPanel();
		dateOfBirthLabel = new JLabel();
		dateOfBirth = new JTextField();
		jPanel10 = new MyJPanel();
		referenceLabel = new JLabel();
		reference = new JTextField();
		hiddenId = new JTextField();
		sexePanel = new MyJPanel();
		sexeLabel = new JLabel();
		sexeHomme = new JRadioButton();
		sexeFemme = new JRadioButton();
		jPanel12 = new MyJPanel();
		ageLabel = new JLabel();
		age = new JTextField();
		jPanel14 = new MyJPanel();
		emailLabel = new JLabel();
		email = new JTextField();
		jPanel15 = new MyJPanel();
		rpiLabel = new JLabel();
		rpi = new JTextField();
		jPanel16 = new MyJPanel();
		avsLabel = new JLabel();
		avs = new JTextField();
		jPanel17 = new MyJPanel();
		mobileLabel = new JLabel();
		mobile = new JTextField();
		jPanel18 = new MyJPanel();
		fixeLabel = new JLabel();
		fixe = new JTextField();
		jPanel19 = new MyJPanel();
		faxLabel = new JLabel();
		fax = new JTextField();
		jPanel2 = new MyJPanel();
		listVenteLabel = new JLabel();
		jScrollPane2 = new JScrollPane();
		listVente = new JList();
		jScrollPane3 = new JScrollPane();
		tableProduct = new JTable();
		validate = new JButton();
		cancel = new JButton();
		jPanel6 = new MyJPanel();
		adresseTabbedPane = new JTabbedPane();
		jPanel7 = new MyJPanel();
		jPanel21 = new MyJPanel();
		jLabel2 = new JLabel();
		jTextField4 = new JTextField();
		jPanel22 = new MyJPanel();
		jLabel5 = new JLabel();
		jTextField5 = new JTextField();
		jPanel23 = new MyJPanel();
		jLabel11 = new JLabel();
		jScrollPane4 = new JScrollPane();
		jTextArea1 = new JTextArea();
		jPanel24 = new MyJPanel();
		jPanel25 = new MyJPanel();
		jLabel18 = new JLabel();
		jTextField9 = new JTextField();
		jPanel26 = new MyJPanel();
		jLabel19 = new JLabel();
		jTextField11 = new JTextField();
		jPanel27 = new MyJPanel();
		jLabel20 = new JLabel();
		jScrollPane5 = new JScrollPane();
		jTextArea2 = new JTextArea();
		jPanel28 = new MyJPanel();
		jPanel29 = new MyJPanel();
		jLabel21 = new JLabel();
		jTextField18 = new JTextField();
		jPanel30 = new MyJPanel();
		jLabel22 = new JLabel();
		jTextField19 = new JTextField();
		panelLivraison = new MyJPanel();
		panelFacturation = new MyJPanel();
		panelPrincipal = new MyJPanel();
		labelAddrLivraison = new JLabel();
		labelAddrFacturation = new JLabel();
		labelAddrPrincipal = new JLabel();
		jSPAddrLivraison = new JScrollPane();
		jSPAddrFacturation = new JScrollPane();
		jSPAddrPrincipal = new JScrollPane();
		addrLivraison = new JTextArea();
		addrFacturation = new JTextArea();
		addrPrincipal = new JTextArea();
		assuranceTable = new JTable();
		jPanel13 = new MyJPanel();
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
					addrPrincipal.setText(client.getAddrPrincipal());
					addrFacturation.setText(client.getAddrFacturation());
					addrLivraison.setText(client.getAddrLivraison());
					hiddenId.setText(String.valueOf(client.getId()));
					isNew = false;
					
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
					
					listVente.setListData(data);
					
					List<AssuranceClient> assurances = service.getClientAssurances(client);
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

		firstNameLabel.setText("Nom*:");
		lastNameLabel.setText("Prénom*: ");
		dateOfBirthLabel.setText("Date de naissance:");
		referenceLabel.setText("Réference*:");
		ageLabel.setText("Age*:");
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


		listVenteLabel.setText("Liste Ordonnances");
		listVenteLabel.setFont(new Font("Tahoma", 1, 11));
		jScrollPane2.setViewportView(listVente);

		listVente.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent evt) {
				listVenteValueChanged(evt);
			}
		});

		
		tableProduct.setModel(new DefaultTableModel(
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
		jScrollPane3.setViewportView(tableProduct);
		jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
		
		jScrollPane2.setPreferredSize(new Dimension(266, 93));
		
		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 2, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(listVenteLabel)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                        .addComponent(jScrollPane2)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(listVenteLabel)
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

        labelAddrPrincipal.setText("Addresse: ");

        addrPrincipal.setColumns(20);
        addrPrincipal.setRows(5);
        jSPAddrPrincipal.setViewportView(addrPrincipal);

        GroupLayout panelPrincipalLayout = new GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelAddrPrincipal)
                .addGap(18, 18, 18)
                .addComponent(jSPAddrPrincipal, GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE))
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addGroup(panelPrincipalLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(labelAddrPrincipal, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSPAddrPrincipal, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        GroupLayout jPanel7Layout = new GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelPrincipal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelPrincipal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
		
		adresseTabbedPane.addTab("Addr. Principale", jPanel7);

		labelAddrFacturation.setText("Addresse: ");

        addrFacturation.setColumns(20);
        addrFacturation.setRows(5);
        jSPAddrFacturation.setViewportView(addrFacturation);

        GroupLayout panelFacturationLayout = new GroupLayout(panelFacturation);
        panelFacturation.setLayout(panelFacturationLayout);
        panelFacturationLayout.setHorizontalGroup(
            panelFacturationLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panelFacturationLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelAddrFacturation)
                .addGap(18, 18, 18)
                .addComponent(jSPAddrFacturation, GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE))
        );
        panelFacturationLayout.setVerticalGroup(
            panelFacturationLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panelFacturationLayout.createSequentialGroup()
                .addGroup(panelFacturationLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(labelAddrFacturation, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSPAddrFacturation, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        GroupLayout jPanel24Layout = new GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelFacturation, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelFacturation, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        adresseTabbedPane.addTab("Addr. Facturation", jPanel24);

        labelAddrLivraison.setText("Addresse: ");

        addrLivraison.setColumns(20);
        addrLivraison.setRows(5);
        jSPAddrLivraison.setViewportView(addrLivraison);

        GroupLayout panelLivraisonLayout = new GroupLayout(panelLivraison);
        panelLivraison.setLayout(panelLivraisonLayout);
        panelLivraisonLayout.setHorizontalGroup(
            panelLivraisonLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panelLivraisonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelAddrLivraison)
                .addGap(18, 18, 18)
                .addComponent(jSPAddrLivraison, GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE))
        );
        panelLivraisonLayout.setVerticalGroup(
            panelLivraisonLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panelLivraisonLayout.createSequentialGroup()
                .addGroup(panelLivraisonLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(labelAddrLivraison, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSPAddrLivraison, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        GroupLayout jPanel28Layout = new GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelLivraison, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelLivraison, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        adresseTabbedPane.addTab("Addr. Livraison", jPanel28);

        GroupLayout jPanel6Layout = new GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(adresseTabbedPane)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(adresseTabbedPane, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 22, Short.MAX_VALUE))
        );
		
		listAssurancesLabel.setText("Liste Assurances");
		listAssurancesLabel.setFont(new java.awt.Font("Tahoma", 1, 11));
		
        assuranceTable.setModel(new DefaultTableModel(
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

        jPanel13.setBorder(BorderFactory.createEtchedBorder());
        
        GroupLayout jPanel13Layout = new GroupLayout(jPanel13);
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

	private void listVenteValueChanged(ListSelectionEvent evt) {
		String selected = listVente.getSelectedValue().toString();
		String venteId = selected.substring(selected.indexOf("(") + 1, selected.indexOf(")"));

		System.out.println(venteId);

		List<VenteProduit> venteProduits = em.createQuery("SELECT p FROM Vente v JOIN v.produits p WHERE v.id = :id", VenteProduit.class).setParameter("id", Integer.valueOf(venteId)).getResultList();
		Object[][] data = null;

		if(venteProduits != null && venteProduits.size() > 0){
			data = new Object[venteProduits.size()][2];
			int i = 0;
			for(VenteProduit vp : venteProduits){
				data[i][0] = vp.getProduct().getDesignation();
				data[i][1] = vp.getProduct().getPu();
				i++;
			}
		}

		String[] columnNames =  {"Designation", "PU"};

		DefaultTableModel dtm = new DefaultTableModel(data, columnNames){
			public Class getColumnClass(int c) {
				return getValueAt(0, c).getClass();
			}
		};
		tableProduct.setModel(dtm);
	}

	private void validateActionPerformed(ActionEvent evt){
		for (Frame frame : Frame.getFrames()) {
			if (frame.getTitle().equals("EasyPharma: Gestion Pharmacies ")) {
				SaleView saleView = (SaleView) frame;

				ClientWidget clientWidget = ((ClientWidget) saleView.getClientWidget());
				if(!hiddenId.getText().equals("")){
					client = em.find(Client.class, Integer.valueOf(hiddenId.getText()));
				}else{
					client = new Client();
				}
				
//				if(isEdit){
					client.setFirstName(Utilities.isEmpty(firstName.getText()));
					client.setLastName(Utilities.isEmpty(lastName.getText()));
					client.setReference(Utilities.isEmpty(reference.getText()));
					try {
						client.setBirthDate(DateFormat.getInstance().parse(Utilities.isEmpty(dateOfBirth.getText())));
					} catch (ParseException e) {
						System.out.println("Error when parsing client date of birth");
					}
					client.setAge(Integer.valueOf(Utilities.isNumberEmpty(age.getText())));
					client.setEmail(Utilities.isEmpty(email.getText()));
					client.setMpi(Integer.valueOf(Utilities.isNumberEmpty(rpi.getText())));
					client.setFix(Utilities.isEmpty(fixe.getText()));
					client.setAvs(Integer.valueOf(Utilities.isNumberEmpty(avs.getText())));
					client.setFax(Utilities.isEmpty(fax.getText()));
					client.setPhone(Utilities.isEmpty(mobile.getText()));
//				}

				em.getTransaction().begin();
				vente = em.find(Vente.class, vente.getId());
				vente.setClient(client);
				em.getTransaction().commit();

				saleView.getHeaderPanel().getClient().activateButton(true);
				
				if(isNew){
					clientWidget.getData().put(client.getFirstName() + " " + client.getLastName(), client.getReference());
					clientWidget.getFirstName().setDataList(clientWidget.getData());
				}
				clientWidget.getReference().setText(Utilities.isEmpty(client.getReference()));
				clientWidget.getFirstName().setSelectedItem(client.getFirstName() + " " + client.getLastName());
				if(client.getBirthDate() != null){
					clientWidget.getDateOfBirth().setText(DateFormat.getInstance().format(client.getBirthDate()));
				}
				clientWidget.getAge().setText(Utilities.isEmpty(client.getAge()));
				clientWidget.getPhone().setText(Utilities.isEmpty(client.getPhone()));

				AssuranceWidget assuranceWidget = (AssuranceWidget) saleView.getAssuranceWidget();
				JTextField assuranceField = null;
				JTextField hiddenField = null;
				JButton newAssurance = null;

				assuranceWidget.getNewAssur1().setEnabled(true);
				assuranceWidget.getNewAssur2().setEnabled(true);
				assuranceWidget.getNewAssur3().setEnabled(true);
				assuranceWidget.getAssurance1().setText("");
				assuranceWidget.getAssurance2().setText("");
				assuranceWidget.getAssurance3().setText("");

				List<AssuranceClient> assurances = service.getClientAssurances(client);
				if(assurances != null && assurances.size() > 0){
					for(AssuranceClient assurance : assurances){
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

						assuranceField.setText(assurance.getAssurance().getName());
						hiddenField.setText(String.valueOf(assurance.getAssurance().getId()));
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
		return listVente;
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

	public boolean isEdit() {
		return isEdit;
	}

	public void setEdit(boolean isEdit) {
		this.isEdit = isEdit;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	public JTextArea getAddrLivraison() {
		return addrLivraison;
	}

	public void setAddrLivraison(JTextArea addrLivraison) {
		this.addrLivraison = addrLivraison;
	}

	public JTextArea getAddrFacturation() {
		return addrFacturation;
	}

	public void setAddrFacturation(JTextArea addrFacturation) {
		this.addrFacturation = addrFacturation;
	}

	public JTextArea getAddrPrincipal() {
		return addrPrincipal;
	}

	public void setAddrPrincipal(JTextArea addrPrincipal) {
		this.addrPrincipal = addrPrincipal;
	}

	public boolean isNew() {
		return isNew;
	}

	public void setNew(boolean isNew) {
		this.isNew = isNew;
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
	private JLabel labelAddrLivraison;
	private JLabel labelAddrPrincipal;
	private JLabel labelAddrFacturation;
	private JLabel listVenteLabel;
	private JLabel lastNameLabel;
	private JLabel jLabel5;
	private JLabel dateOfBirthLabel;
	private JLabel referenceLabel;
	private JLabel sexeLabel;
	private JList listVente;
	private MyJPanel jPanel1;
	private MyJPanel jPanel10;
	private MyJPanel sexePanel;
	private MyJPanel jPanel12;
	private MyJPanel jPanel14;
	private MyJPanel jPanel15;
	private MyJPanel jPanel16;
	private MyJPanel jPanel17;
	private MyJPanel jPanel18;
	private MyJPanel jPanel19;
	private MyJPanel jPanel2;
	private MyJPanel jPanel21;
	private MyJPanel jPanel22;
	private MyJPanel jPanel23;
	private MyJPanel jPanel24;
	private MyJPanel jPanel25;
	private MyJPanel jPanel26;
	private MyJPanel jPanel27;
	private MyJPanel jPanel28;
	private MyJPanel jPanel29;
	private MyJPanel jPanel3;
	private MyJPanel jPanel30;
	private MyJPanel panelLivraison;
	private MyJPanel panelFacturation;
	private MyJPanel panelPrincipal;
	private MyJPanel jPanel4;
	private MyJPanel jPanel5;
	private MyJPanel jPanel6;
	private MyJPanel jPanel7;
	private MyJPanel jPanel9;
	private JRadioButton sexeHomme;
	private JRadioButton sexeFemme;
	private JScrollPane jScrollPane1;
	private JScrollPane jScrollPane2;
	private JScrollPane jScrollPane3;
	private JScrollPane jScrollPane4;
	private JScrollPane jScrollPane5;
	private JScrollPane jSPAddrLivraison;
	private JScrollPane jSPAddrFacturation;
	private JScrollPane jSPAddrPrincipal;
	private JTabbedPane adresseTabbedPane;
	private JTable searchTable;
	private JTable tableProduct;
	private JTextArea jTextArea1;
	private JTextArea jTextArea2;
	private JTextArea addrLivraison;
	private JTextArea addrFacturation;
	private JTextArea addrPrincipal;
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
	private MyJPanel jPanel13;
	private JLabel listAssurancesLabel;
	private JScrollPane jScrollPane7;
}
