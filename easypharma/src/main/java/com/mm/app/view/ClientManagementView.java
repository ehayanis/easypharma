package com.mm.app.view;

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
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.WindowConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import com.mm.app.model.Client;
import com.mm.app.model.Ordonnance;
import com.mm.app.model.Product;
import com.mm.app.service.ClientService;
import com.mm.app.service.impl.ClientServiceImpl;
import com.mm.app.utilities.ClientTableModel;


public class ClientManagementView extends JFrame {

	private static final long serialVersionUID = 1L;

	private EntityManager em;
	private ClientService service;
	private Client client = null;

	public ClientManagementView(EntityManager em) {
		this.em = em;
		service = new ClientServiceImpl(em);

		initComponents();
		ImageIcon img = new ImageIcon(getClass().getResource("/img/logo.png"));
		setIconImage(img.getImage());
	}

	@SuppressWarnings({ "unchecked", "serial", "rawtypes" })
	private void initComponents() {

		jPanel1 = new JPanel();
		searchField = new JTextField();
		jScrollPane1 = new JScrollPane();
		jTable1 = new JTable();
		jPanel3 = new JPanel();
		jPanel4 = new JPanel();
		jLabel1 = new JLabel();
		firstName = new JTextField();
		jPanel5 = new JPanel();
		jLabel4 = new JLabel();
		lastName = new JTextField();
		jPanel9 = new JPanel();
		jLabel7 = new JLabel();
		dateOfBirth = new JTextField();
		jPanel10 = new JPanel();
		jLabel8 = new JLabel();
		reference = new JTextField();
		jPanel11 = new JPanel();
		jLabel9 = new JLabel();
		jRadioButton1 = new JRadioButton();
		jRadioButton2 = new JRadioButton();
		jPanel12 = new JPanel();
		jLabel10 = new JLabel();
		age = new JTextField();
		jPanel14 = new JPanel();
		jLabel12 = new JLabel();
		email = new JTextField();
		jPanel15 = new JPanel();
		jLabel13 = new JLabel();
		rpi = new JTextField();
		jPanel16 = new JPanel();
		jLabel14 = new JLabel();
		avs = new JTextField();
		jPanel17 = new JPanel();
		jLabel15 = new JLabel();
		mobile = new JTextField();
		jPanel18 = new JPanel();
		jLabel16 = new JLabel();
		fixe = new JTextField();
		jPanel19 = new JPanel();
		jLabel17 = new JLabel();
		fax = new JTextField();
		jPanel2 = new JPanel();
		jLabel3 = new JLabel();
		jScrollPane2 = new JScrollPane();
		listOrdonnance = new JList();
		jScrollPane3 = new JScrollPane();
		jTable2 = new JTable();
		jButton1 = new JButton();
		jButton2 = new JButton();
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

		jTable1.setModel(new DefaultTableModel(
				new Object [][] {
						{null, null, null, null, null, null}
				},
				new String [] {
						"Id", "R�ference", "Nom", "Pr�nom", "Age", "Date de Naissance"
				}
				) {
			boolean[] canEdit = new boolean [] {
					false, false, false, false, false
			};

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit [columnIndex];
			}
		});
		jScrollPane1.setViewportView(jTable1);

		jTable1.setCellSelectionEnabled(true);
		ListSelectionModel cellSelectionModel = jTable1.getSelectionModel();
		cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);


		cellSelectionModel.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				Integer selectedData = 0;

				int[] selectedRow = jTable1.getSelectedRows();
				int[] selectedColumns = jTable1.getSelectedColumns();

				for (int i = 0; i < selectedRow.length; i++) {
					for (int j = 0; j < selectedColumns.length; j++) {
						selectedData = (Integer) jTable1.getValueAt(selectedRow[i], selectedColumns[j]);
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


					List<Ordonnance> ordonnances = client.getOrdonnances();

					String[] data = new String[ordonnances.size()];
					int i  = 0;
					DateFormat df = DateFormat.getDateInstance();
					for(Ordonnance ordonnance : ordonnances){
						data[i] = df.format(ordonnance.getStartDate()) + "(" + ordonnance.getId() + ")";
						i++;
					}

					listOrdonnance.setListData(data);
				}
			}
		});


		searchField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				searchActionPerformed(evt);
			}
		});

		jLabel1.setText("Nom:");

		GroupLayout jPanel4Layout = new GroupLayout(jPanel4);
		jPanel4.setLayout(jPanel4Layout);
		jPanel4Layout.setHorizontalGroup(
				jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel4Layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jLabel1)
						.addGap(18, 18, 18)
						.addComponent(firstName, GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
						.addContainerGap())
				);
		jPanel4Layout.setVerticalGroup(
				jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(jLabel1, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
						.addComponent(firstName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				);

		jLabel4.setText("Pr�nom: ");

		GroupLayout jPanel5Layout = new GroupLayout(jPanel5);
		jPanel5.setLayout(jPanel5Layout);
		jPanel5Layout.setHorizontalGroup(
				jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel5Layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jLabel4)
						.addGap(18, 18, 18)
						.addComponent(lastName, GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
						.addContainerGap())
				);
		jPanel5Layout.setVerticalGroup(
				jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(jLabel4, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
						.addComponent(lastName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				);

		jLabel7.setText("Date de naissance:");

		GroupLayout jPanel9Layout = new GroupLayout(jPanel9);
		jPanel9.setLayout(jPanel9Layout);
		jPanel9Layout.setHorizontalGroup(
				jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel9Layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jLabel7)
						.addGap(18, 18, 18)
						.addComponent(dateOfBirth, GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
						.addContainerGap())
				);
		jPanel9Layout.setVerticalGroup(
				jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(jLabel7, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
						.addComponent(dateOfBirth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				);

		jLabel8.setText("R�ference:");

		GroupLayout jPanel10Layout = new GroupLayout(jPanel10);
		jPanel10.setLayout(jPanel10Layout);
		jPanel10Layout.setHorizontalGroup(
				jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel10Layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jLabel8)
						.addGap(18, 18, 18)
						.addComponent(reference, GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
						.addContainerGap())
				);
		jPanel10Layout.setVerticalGroup(
				jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(jLabel8, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
						.addComponent(reference, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				);

		jLabel9.setText("Sexe: ");

		jRadioButton1.setText("Homme");

		jRadioButton2.setText("Femme");

		GroupLayout jPanel11Layout = new GroupLayout(jPanel11);
		jPanel11.setLayout(jPanel11Layout);
		jPanel11Layout.setHorizontalGroup(
				jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel11Layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jLabel9)
						.addGap(18, 18, 18)
						.addComponent(jRadioButton1)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(jRadioButton2)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);
		jPanel11Layout.setVerticalGroup(
				jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(jLabel9, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(jRadioButton1)
						.addComponent(jRadioButton2))
				);

		jLabel10.setText("Age:");

		GroupLayout jPanel12Layout = new GroupLayout(jPanel12);
		jPanel12.setLayout(jPanel12Layout);
		jPanel12Layout.setHorizontalGroup(
				jPanel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel12Layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jLabel10)
						.addGap(18, 18, 18)
						.addComponent(age, GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
						.addContainerGap())
				);
		jPanel12Layout.setVerticalGroup(
				jPanel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(jLabel10, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
						.addComponent(age, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				);

		jLabel12.setText("Email: ");

		GroupLayout jPanel14Layout = new GroupLayout(jPanel14);
		jPanel14.setLayout(jPanel14Layout);
		jPanel14Layout.setHorizontalGroup(
				jPanel14Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel14Layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jLabel12)
						.addGap(18, 18, 18)
						.addComponent(email, GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
						.addContainerGap())
				);
		jPanel14Layout.setVerticalGroup(
				jPanel14Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(jLabel12, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
						.addComponent(email, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				);

		jLabel13.setText("N� RPI: ");

		GroupLayout jPanel15Layout = new GroupLayout(jPanel15);
		jPanel15.setLayout(jPanel15Layout);
		jPanel15Layout.setHorizontalGroup(
				jPanel15Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel15Layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jLabel13)
						.addGap(18, 18, 18)
						.addComponent(rpi, GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
						.addContainerGap())
				);
		jPanel15Layout.setVerticalGroup(
				jPanel15Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel15Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(jLabel13, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
						.addComponent(rpi, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				);

		jLabel14.setText("N� AVS: ");

		GroupLayout jPanel16Layout = new GroupLayout(jPanel16);
		jPanel16.setLayout(jPanel16Layout);
		jPanel16Layout.setHorizontalGroup(
				jPanel16Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel16Layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jLabel14)
						.addGap(18, 18, 18)
						.addComponent(avs, GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
						.addContainerGap())
				);
		jPanel16Layout.setVerticalGroup(
				jPanel16Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel16Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(jLabel14, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
						.addComponent(avs, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				);

		jLabel15.setText("Mobile:");

		GroupLayout jPanel17Layout = new GroupLayout(jPanel17);
		jPanel17.setLayout(jPanel17Layout);
		jPanel17Layout.setHorizontalGroup(
				jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel17Layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jLabel15)
						.addGap(18, 18, 18)
						.addComponent(mobile, GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
						.addContainerGap())
				);
		jPanel17Layout.setVerticalGroup(
				jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(jLabel15, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
						.addComponent(mobile, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				);

		jLabel16.setText("Fix: ");

		GroupLayout jPanel18Layout = new GroupLayout(jPanel18);
		jPanel18.setLayout(jPanel18Layout);
		jPanel18Layout.setHorizontalGroup(
				jPanel18Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel18Layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jLabel16)
						.addGap(18, 18, 18)
						.addComponent(fixe, GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
						.addContainerGap())
				);
		jPanel18Layout.setVerticalGroup(
				jPanel18Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel18Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(jLabel16, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
						.addComponent(fixe, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				);

		jLabel17.setText("Fax: ");

		GroupLayout jPanel19Layout = new GroupLayout(jPanel19);
		jPanel19.setLayout(jPanel19Layout);
		jPanel19Layout.setHorizontalGroup(
				jPanel19Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel19Layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jLabel17)
						.addGap(18, 18, 18)
						.addComponent(fax, GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
						.addContainerGap())
				);
		jPanel19Layout.setVerticalGroup(
				jPanel19Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel19Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(jLabel17, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
						.addComponent(fax, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				);

		GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
		jPanel3.setLayout(jPanel3Layout);
		jPanel3Layout.setHorizontalGroup(
				jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel3Layout.createSequentialGroup()
						.addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(jPanel3Layout.createSequentialGroup()
										.addComponent(jPanel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(jPanel5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGroup(jPanel3Layout.createSequentialGroup()
												.addComponent(jPanel10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(jPanel9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
												.addGroup(jPanel3Layout.createSequentialGroup()
														.addComponent(jPanel18, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(jPanel17, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
														.addComponent(jPanel14, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(jPanel19, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
																.addGroup(jPanel3Layout.createSequentialGroup()
																		.addComponent(jPanel12, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(ComponentPlacement.RELATED)
																		.addComponent(jPanel11, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
																		.addGroup(jPanel3Layout.createSequentialGroup()
																				.addComponent(jPanel16, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																				.addPreferredGap(ComponentPlacement.RELATED)
																				.addComponent(jPanel15, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
																				.addGap(0, 0, Short.MAX_VALUE))
				);
		jPanel3Layout.setVerticalGroup(
				jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel3Layout.createSequentialGroup()
						.addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(jPanel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(jPanel5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addComponent(jPanel10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(jPanel9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
												.addComponent(jPanel12, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(jPanel11, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(jPanel14, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
														.addComponent(jPanel16, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(jPanel15, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
														.addPreferredGap(ComponentPlacement.RELATED)
														.addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
																.addComponent(jPanel18, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																.addComponent(jPanel17, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
																.addPreferredGap(ComponentPlacement.RELATED)
																.addComponent(jPanel19, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);

		jLabel3.setText("Liste Ordonnances");

		jScrollPane2.setViewportView(listOrdonnance);

		listOrdonnance.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent evt) {
				listOrdonnanceValueChanged(evt);
			}
		});

		jTable2.setModel(new DefaultTableModel(
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
		jScrollPane3.setViewportView(jTable2);

		GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout.setHorizontalGroup(
				jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
						.addGap(0, 9, Short.MAX_VALUE)
						.addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(jLabel3)
								.addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
								.addComponent(jScrollPane3, GroupLayout.PREFERRED_SIZE, 266, GroupLayout.PREFERRED_SIZE)))
				);
		jPanel2Layout.setVerticalGroup(
				jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel2Layout.createSequentialGroup()
						.addComponent(jLabel3)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(jScrollPane3, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);

		jButton1.setText("Valider");

		jButton2.setText("Annuler");

		jButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				validateActionPerformed(evt);	
			}
		});

		jButton2.addActionListener(new ActionListener() {
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

		GroupLayout jPanel6Layout = new GroupLayout(jPanel6);
		jPanel6.setLayout(jPanel6Layout);
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
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addComponent(jPanel2, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
												.addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
												.addGap(18, 18, 18)
												.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
												.addContainerGap())))
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
								.addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jPanel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addGroup(layout.createSequentialGroup()
												.addGap(0, 0, Short.MAX_VALUE)
												.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
														.addComponent(jButton1)
														.addComponent(jButton2)))
														.addComponent(jPanel6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
		jTable2.setModel(dtm);
	}

	private void validateActionPerformed(ActionEvent evt){
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
			jTable1.setModel(model);
		}

	}

	public JList getListOrdonnance() {
		return listOrdonnance;
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

	private JButton jButton1;
	private JButton jButton2;
	private JLabel jLabel1;
	private JLabel jLabel10;
	private JLabel jLabel11;
	private JLabel jLabel12;
	private JLabel jLabel13;
	private JLabel jLabel14;
	private JLabel jLabel15;
	private JLabel jLabel16;
	private JLabel jLabel17;
	private JLabel jLabel18;
	private JLabel jLabel19;
	private JLabel jLabel2;
	private JLabel jLabel20;
	private JLabel jLabel21;
	private JLabel jLabel22;
	private JLabel jLabel23;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JLabel jLabel7;
	private JLabel jLabel8;
	private JLabel jLabel9;
	private JList listOrdonnance;
	private JPanel jPanel1;
	private JPanel jPanel10;
	private JPanel jPanel11;
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
	private JRadioButton jRadioButton1;
	private JRadioButton jRadioButton2;
	private JScrollPane jScrollPane1;
	private JScrollPane jScrollPane2;
	private JScrollPane jScrollPane3;
	private JScrollPane jScrollPane4;
	private JScrollPane jScrollPane5;
	private JScrollPane jScrollPane6;
	private JTabbedPane jTabbedPane1;
	private JTable jTable1;
	private JTable jTable2;
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
}
