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
import javax.swing.JPanel;
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

import com.mm.app.model.AssuranceClient;
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

        jPanel1 = new JPanel();
        searchField = new JTextField();
        jScrollPane1 = new JScrollPane();
        searchTable = new JTable();
        jPanel3 = new JPanel();
        jPanel4 = new JPanel();
        labelFirstName = new JLabel();
        firstName = new JTextField();
        jPanel5 = new JPanel();
        labelLastName = new JLabel();
        lastName = new JTextField();
        jPanel9 = new JPanel();
        labelNrcc = new JLabel();
        nrcc = new JTextField();
        jPanel10 = new JPanel();
        labelReference = new JLabel();
        reference = new JTextField();
        jPanel12 = new JPanel();
        labelSpeciality = new JLabel();
        speciality = new JTextField();
        jPanel14 = new JPanel();
        labelEmail = new JLabel();
        email = new JTextField();
        jPanel16 = new JPanel();
        labelNumNc = new JLabel();
        numNC = new JTextField();
        jPanel17 = new JPanel();
        labelFax = new JLabel();
        fax = new JTextField();
        jPanel18 = new JPanel();
        labelFixe = new JLabel();
        fixe = new JTextField();
        validate = new JButton();
        cancel = new JButton();
        jTabbedPane1 = new JTabbedPane();
        jPanel7 = new JPanel();
        jPanel21 = new JPanel();
        labelCity = new JLabel();
        city = new JTextField();
        jPanel22 = new JPanel();
        labelPostalCode = new JLabel();
        postalCode = new JTextField();
        jPanel23 = new JPanel();
        labelAddress = new JLabel();
        jScrollPane4 = new JScrollPane();
        address = new JTextArea();

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
              
              if(medecin != null){
            	  numNC.setText(medecin.getNc());
            	  fax.setText(medecin.getFax());
            	  fixe.setText(medecin.getPhone());
            	  firstName.setText(medecin.getFirstName());
            	  lastName.setText(medecin.getLastName());
            	  nrcc.setText(medecin.getNrcc());
            	  reference.setText(medecin.getReference());
            	  speciality.setText(medecin.getSpeciality());
              }
            		  
            }
        });
        
        labelFirstName.setText("Nom:");
        labelLastName.setText("Prénom: ");
        labelNrcc.setText("N° NRCC:");
        labelReference.setText("Réference:");
        labelSpeciality.setText("Spécialité: ");
        labelEmail.setText("Email: ");
        labelNumNc.setText("N° NC:");
        labelFax.setText("Fax:");
        labelFixe.setText("Fix: ");
        
        validate.setText("Valider");
        cancel.setText("Annuler");
        labelCity.setText("Ville:");
        labelPostalCode.setText("Code Postale: ");
        labelAddress.setText("Addresse: ");
        
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


        GroupLayout jPanel21Layout = new GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelCity)
                .addGap(18, 18, 18)
                .addComponent(city)
                .addContainerGap())
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(labelCity, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                .addComponent(city, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );


        GroupLayout jPanel22Layout = new GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelPostalCode)
                .addGap(18, 18, 18)
                .addComponent(postalCode, GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(labelPostalCode, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                .addComponent(postalCode, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );

        
        address.setColumns(15);
        address.setRows(5);
        jScrollPane4.setViewportView(address);

        GroupLayout jPanel23Layout = new GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelAddress)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGroup(jPanel23Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(labelAddress, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        
        GroupLayout jPanel7Layout = new GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel23, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel22, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel21, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(0, 17, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel21, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(ComponentPlacement.UNRELATED)
                .addComponent(jPanel22, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jPanel23, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Addr. Principale", jPanel7);
        
        jPanel1.setBackground(Color.WHITE);
        jScrollPane1.setBackground(Color.WHITE);
        jPanel3.setBackground(Color.WHITE);
        jPanel7.setBackground(Color.WHITE);
        jPanel23.setBackground(Color.WHITE);
        jPanel22.setBackground(Color.WHITE);
        jPanel21.setBackground(Color.WHITE);
        jTabbedPane1.setBackground(Color.WHITE);
        
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
                    .addComponent(jTabbedPane1, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 338, GroupLayout.PREFERRED_SIZE)))
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
                    .addComponent(jTabbedPane1, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE))
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

	private void validateActionPerformed(ActionEvent evt){
		for (Frame frame : Frame.getFrames()) {
			if (frame.getTitle().equals("EasyPharma: Gestion Pharmacies ")) {
				SaleView saleView = (SaleView) frame;
				
				MedecinWidget medecinWidget = saleView.getMedecinWidget();
				
				em.getTransaction().begin();
				vente = em.find(Vente.class, vente.getId());
				vente.setMedecin(medecin);
				em.getTransaction().commit();
				
				
				medecinWidget.getReference().setText(String.valueOf(medecin.getId()));
				medecinWidget.getFirstName().setSelectedItem(medecin.getFirstName() + " " + medecin.getLastName());
				medecinWidget.getSpeciality().setText(medecin.getSpeciality());
				medecinWidget.getNrcc().setText(medecin.getNrcc());
				medecinWidget.getPhone().setText(medecin.getPhone());
				
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
    private JLabel labelCity;
    private JLabel labelLastName;
    private JLabel labelPostalCode;
    private JLabel labelNrcc;
    private JLabel labelReference;
    private JPanel jPanel1;
    private JPanel jPanel10;
    private JPanel jPanel12;
    private JPanel jPanel14;
    private JPanel jPanel16;
    private JPanel jPanel17;
    private JPanel jPanel18;
    private JPanel jPanel21;
    private JPanel jPanel22;
    private JPanel jPanel23;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JPanel jPanel5;
    private JPanel jPanel7;
    private JPanel jPanel9;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane4;
    private JTabbedPane jTabbedPane1;
    private JTable searchTable;
    private JTextArea address;
    private JTextField searchField;
    private JTextField email;
    private JTextField numNC;
    private JTextField fax;
    private JTextField fixe;
    private JTextField firstName;
    private JTextField lastName;
    private JTextField city;
    private JTextField postalCode;
    private JTextField nrcc;
    private JTextField reference;
}
