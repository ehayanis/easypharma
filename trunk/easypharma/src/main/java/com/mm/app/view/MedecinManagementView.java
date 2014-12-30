package com.mm.app.view;

import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.persistence.EntityManager;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
import com.mm.app.model.Medecin;
import com.mm.app.model.Vente;
import com.mm.app.service.MedecinService;
import com.mm.app.service.impl.MedecinServiceImpl;
import com.mm.app.utilities.MedecinTableModel;
import com.mm.app.utilities.Utilities;


/**
 *
 * @author A574266
 */
public class MedecinManagementView extends JFrame {

	private EntityManager em;
	private MedecinService service;
	private Medecin medecin = null;
	private Vente vente; 
	private boolean isEdit = false;
	private boolean isNew = false;
	private int idMedecin = 0;
	
	private static final long serialVersionUID = 5336224759833199368L;

	public MedecinManagementView(EntityManager em, Vente vente) {
		this.em = em;
		this.vente = vente;
		service = new MedecinServiceImpl(em);
		
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
        labelFirstName = new JLabel();
        firstName = new JTextField();
        jPanel5 = new MyJPanel();
        labelLastName = new JLabel();
        lastName = new JTextField();
        jPanel9 = new MyJPanel();
        labelNrcc = new JLabel();
        nrcc = new JTextField();
        jPanel10 = new MyJPanel();
        labelReference = new JLabel();
        reference = new JTextField();
        jPanel12 = new MyJPanel();
        labelSpeciality = new JLabel();
        speciality = new JTextField();
        jPanel14 = new MyJPanel();
        labelEmail = new JLabel();
        email = new JTextField();
        jPanel16 = new MyJPanel();
        labelNumNc = new JLabel();
        numNC = new JTextField();
        jPanel17 = new MyJPanel();
        labelFax = new JLabel();
        fax = new JTextField();
        jPanel18 = new MyJPanel();
        labelFixe = new JLabel();
        fixe = new JTextField();
        validate = new JButton();
        cancel = new JButton();
        addrPrincipale = new JTabbedPane();
        jPanel7 = new MyJPanel();
        jPanel21 = new MyJPanel();
        jPanel22 = new MyJPanel();
        panelAddress = new MyJPanel();
        labelAddress = new JLabel();
        scrollPaneAddress = new JScrollPane();
        address = new JTextArea();
        hiddenId = new JTextField();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gestion des Médecins");
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
                "Id", "Réference", "Nom", "Prénom", "Spécialité", "N° NRCC"
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
              
              
              System.out.println("Selected: " + selectedData);
              
              medecin = service.findMedecin(selectedData);
              
        	  numNC.setText(Utilities.isEmpty(medecin.getNc()));
        	  fax.setText(Utilities.isEmpty(medecin.getFax()));
        	  fixe.setText(Utilities.isEmpty(medecin.getPhone()));
        	  firstName.setText(Utilities.isEmpty(medecin.getFirstName()));
        	  lastName.setText(Utilities.isEmpty(medecin.getLastName()));
        	  nrcc.setText(Utilities.isEmpty(medecin.getNrcc()));
        	  reference.setText(Utilities.isEmpty(medecin.getReference()));
        	  speciality.setText(Utilities.isEmpty(medecin.getSpeciality()));
        	  address.setText(Utilities.isEmpty(medecin.getAddress()));
        	  email.setText(Utilities.isEmpty(medecin.getEmail()));
        	  hiddenId.setText(String.valueOf(medecin.getId()));
        	  isNew = false;
            		  
            }
        });
        
        labelFirstName.setText("Nom*:");
        labelLastName.setText("Prénom*: ");
        labelNrcc.setText("N° NRCC:");
        labelReference.setText("Réference*:");
        labelSpeciality.setText("Spécialité: ");
        labelEmail.setText("Email: ");
        labelNumNc.setText("N° NC:");
        labelFax.setText("Fax:");
        labelFixe.setText("Fix: ");
        
        validate.setText("Valider");
        cancel.setText("Annuler");
        GridLayout gridLayout = new GridLayout(5, 3, 0, 0);
        gridLayout.setHgap(10);
        gridLayout.setVgap(14);
        jPanel3.setLayout(gridLayout);
        
        jPanel3.add(Utilities.createFilledSimpleInnerPanel(labelFirstName, firstName));
        jPanel3.add(Utilities.createFilledSimpleInnerPanel(labelLastName, lastName));
        jPanel3.add(Utilities.createFilledSimpleInnerPanel(labelNrcc, nrcc));
        jPanel3.add(Utilities.createFilledSimpleInnerPanel(labelReference, reference));
        jPanel3.add(Utilities.createFilledSimpleInnerPanel(labelSpeciality, speciality));
        jPanel3.add(Utilities.createFilledSimpleInnerPanel(labelEmail, email));
        jPanel3.add(Utilities.createFilledSimpleInnerPanel(labelNumNc, numNC));
        jPanel3.add(Utilities.createFilledSimpleInnerPanel(labelFax, fax));
        jPanel3.add(Utilities.createFilledSimpleInnerPanel(labelFixe, fixe));
        
        
        labelAddress.setText("Addresse: ");

        address.setColumns(15);
        address.setRows(5);
        scrollPaneAddress.setViewportView(address);

        GroupLayout panelAddressLayout = new GroupLayout(panelAddress);
        panelAddress.setLayout(panelAddressLayout);
        panelAddressLayout.setHorizontalGroup(
            panelAddressLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panelAddressLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelAddress)
                .addGap(18, 18, 18)
                .addComponent(scrollPaneAddress, GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelAddressLayout.setVerticalGroup(
            panelAddressLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panelAddressLayout.createSequentialGroup()
                .addGroup(panelAddressLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(labelAddress, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                    .addComponent(scrollPaneAddress, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        GroupLayout jPanel7Layout = new GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelAddress, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelAddress, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        addrPrincipale.addTab("Addr. Principale", jPanel7);
        
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, GroupLayout.Alignment.TRAILING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(cancel, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(validate, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))
                    .addComponent(addrPrincipale, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 338, GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(addrPrincipale, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(validate)
                    .addComponent(cancel))
                .addContainerGap())
        );
        
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
        
        searchField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
                searchActionPerformed(evt);
			}
		});
        
        pack();
        setLocationRelativeTo(null);
    }                        
    
    private void searchActionPerformed(ActionEvent evt) {                                         
		String value = searchField.getText();
		List<Medecin> medecins = service.findMedecinsByCriteria(value);
		if(medecins != null && medecins.size() > 0){
			AbstractTableModel model = new MedecinTableModel(medecins);
			searchTable.setModel(model);
		}
		
    }
    
    public JTextField getSpeciality() {
		return speciality;
	}

	public void setSpeciality(JTextField speciality) {
		this.speciality = speciality;
	}

	public JTextField getEmail() {
		return email;
	}

	public void setEmail(JTextField email) {
		this.email = email;
	}

	public JTextField getNumNC() {
		return numNC;
	}

	public void setNumNC(JTextField numNC) {
		this.numNC = numNC;
	}

	public JTextField getFax() {
		return fax;
	}

	public void setFax(JTextField fax) {
		this.fax = fax;
	}

	public JTextField getFixe() {
		return fixe;
	}

	public void setFixe(JTextField fixe) {
		this.fixe = fixe;
	}

	public JTextField getFirstName() {
		return firstName;
	}

	public void setFirstName(JTextField firstName) {
		this.firstName = firstName;
	}

	public JTextField getLastName() {
		return lastName;
	}

	public void setLastName(JTextField lastName) {
		this.lastName = lastName;
	}

	public JTextField getNrcc() {
		return nrcc;
	}

	public void setNrcc(JTextField nrcc) {
		this.nrcc = nrcc;
	}

	public JTextField getReference() {
		return reference;
	}

	public void setReference(JTextField reference) {
		this.reference = reference;
	}
	
	public JTable getSearchTable() {
		return searchTable;
	}

	public JTextField getSearchField() {
		return searchField;
	}

	public JTextArea getAddress() {
		return address;
	}

	public void setAddress(JTextArea address) {
		this.address = address;
	}
	
	public boolean isEdit() {
		return isEdit;
	}

	public void setEdit(boolean isEdit) {
		this.isEdit = isEdit;
	}

	private void validateActionPerformed(ActionEvent evt){
		for (Frame frame : Frame.getFrames()) {
			if (frame.getTitle().equals("EasyPharma: Gestion Pharmacies ")) {
				SaleView saleView = (SaleView) frame;
				
				if(isNew || isEdit){
					if(Utilities.isEmptyString(firstName.getText()) || Utilities.isEmptyString(firstName.getText()) || Utilities.isEmptyString(firstName.getText())){
						JOptionPane.showMessageDialog(this, "Veuillez remplir les champs obligatoires (*)!");
						return;
					}
				}
				
				MedecinWidget medecinWidget = saleView.getMedecinWidget();
				if(!hiddenId.getText().equals("")){
					medecin = em.find(Medecin.class, Integer.valueOf(hiddenId.getText()));
				}else{
					medecin = new Medecin();
				}
				
				
//				if(isEdit){
				medecin.setNc(Utilities.isEmpty(numNC.getText()));
				medecin.setFax(Utilities.isEmpty(fax.getText()));
				medecin.setPhone(Utilities.isEmpty(fixe.getText()));
				medecin.setFirstName(Utilities.isEmpty(firstName.getText()));
				medecin.setLastName(Utilities.isEmpty(lastName.getText()));
				medecin.setNrcc(Utilities.isEmpty(nrcc.getText()));
				medecin.setReference(Utilities.isEmpty(reference.getText()));
				medecin.setSpeciality(Utilities.isEmpty(speciality.getText()));
				medecin.setAddress(Utilities.isEmpty(address.getText()));
				medecin.setEmail(Utilities.isEmpty(email.getText()));
//				}

				em.getTransaction().begin();
				vente = em.find(Vente.class, vente.getId());
				vente.setMedecin(medecin);
				em.getTransaction().commit();
				
				medecin = em.find(Vente.class, vente.getId()).getMedecin();
				
				if(isNew){
					medecinWidget.getData().put(medecin.getFirstName() + " " + medecin.getLastName(), String.valueOf(medecin.getId()));
					medecinWidget.getFirstName().setDataList(medecinWidget.getData());
				}	
			
				medecinWidget.getReference().setText(Utilities.isEmpty(medecin.getId()));
				medecinWidget.getFirstName().setSelectedItem(Utilities.isEmpty(medecin.getFirstName() + " " + medecin.getLastName()));
				medecinWidget.getSpeciality().setText(Utilities.isEmpty(medecin.getSpeciality()));
				medecinWidget.getNrcc().setText(Utilities.isEmpty(medecin.getNrcc()));
				medecinWidget.getPhone().setText(Utilities.isEmpty(medecin.getPhone()));
				
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
	
	public int getIdMedecin() {
		return idMedecin;
	}

	public void setIdMedecin(int idMedecin) {
		this.idMedecin = idMedecin;
	}

	public boolean isNew() {
		return isNew;
	}

	public void setNew(boolean isNew) {
		this.isNew = isNew;
	}



	private JButton validate;
    private JButton cancel;
    private JTextField speciality;
    private JLabel labelFirstName;
    private JLabel labelSpeciality;
    private JLabel labelAddress;
    private JLabel labelEmail;
    private JLabel labelNumNc;
    private JLabel labelFax;
    private JLabel labelFixe;
    private JLabel labelLastName;
    private JLabel labelNrcc;
    private JLabel labelReference;
    private MyJPanel jPanel1;
    private MyJPanel jPanel10;
    private MyJPanel jPanel12;
    private MyJPanel jPanel14;
    private MyJPanel jPanel16;
    private MyJPanel jPanel17;
    private MyJPanel jPanel18;
    private MyJPanel jPanel21;
    private MyJPanel jPanel22;
    private MyJPanel panelAddress;
    private MyJPanel jPanel3;
    private MyJPanel jPanel4;
    private MyJPanel jPanel5;
    private MyJPanel jPanel7;
    private MyJPanel jPanel9;
    private JScrollPane jScrollPane1;
    private JScrollPane scrollPaneAddress;
    private JTabbedPane addrPrincipale;
    private JTable searchTable;
    private JTextArea address;
    private JTextField searchField;
    private JTextField email;
    private JTextField numNC;
    private JTextField fax;
    private JTextField fixe;
    private JTextField firstName;
    private JTextField lastName;
    private JTextField nrcc;
    private JTextField reference;
    private JTextField hiddenId;
}
