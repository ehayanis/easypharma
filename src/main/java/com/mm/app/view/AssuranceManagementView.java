package com.mm.app.view;

import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.LayoutStyle;
import javax.swing.ListSelectionModel;
import javax.swing.WindowConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

import com.mm.app.model.Assurance;
import com.mm.app.model.AssuranceClient;
import com.mm.app.model.Client;
import com.mm.app.model.Vente;
import com.mm.app.service.AssuranceService;
import com.mm.app.service.VenteService;
import com.mm.app.service.impl.AssuranceServiceImpl;
import com.mm.app.service.impl.VenteServiceImpl;
import com.mm.app.utilities.AssuranceTableModel;
import com.mm.app.utilities.Utilities;

public class AssuranceManagementView extends javax.swing.JFrame {

	private static final long serialVersionUID = 2071451267119111319L;

	private EntityManager em;
	private AssuranceService service;
	private VenteService venteService;
	private Assurance assurance = null;
	private Vente vente;
	private TypeAssurance typeAssurance;
	private List<AssuranceClient> assuranceClients;
	private boolean isEdit = false;
	private int idAssurance = 0;
	
	public AssuranceManagementView(EntityManager em, Vente vente) {
		this.em = em;
		this.vente = vente;
		service = new AssuranceServiceImpl(em);
		venteService = new VenteServiceImpl(em);
		
		assuranceClients = new ArrayList<AssuranceClient>();
		
        initComponents();
        getContentPane().setBackground(Color.WHITE);
        ImageIcon img = new ImageIcon(getClass().getResource("/img/logo.png"));
        setIconImage(img.getImage());
    }

    @SuppressWarnings({ "serial" })
    private void initComponents() {

        jPanel1 = new MyJPanel();
        searchField = new JTextField();
        jScrollPane1 = new JScrollPane();
        tableSearch = new JTable();
        jPanel3 = new MyJPanel();
        jPanel2 = new MyJPanel();
        labelNom = new JLabel();
        nom = new JTextField();
        labelAgence = new JLabel();
        agence = new JTextField();
        labelEan = new JLabel();
        ean = new JTextField();
        labelOfas = new JLabel();
        ofas = new JTextField();
        labelCoverCard = new JLabel();
        coverCard = new JTextField();
        labelEmail = new JLabel();
        email = new JTextField();
        labelCardValidity = new JLabel();
        cardValidity = new UtilDateModel();
        labelValidationDate = new JLabel();
        validationDate = new UtilDateModel();
        labelMobile = new JLabel();
        mobile = new JTextField();
        labelPhone = new JLabel();
        phone = new JTextField();
        labelValidationNumber = new JLabel();
        validationNumber = new JTextField();
        labelRcc = new JLabel();
        rcc = new JTextField();
        labelNpa = new JLabel();
        npa = new JTextField();
        couvertureAos = new JLabel();
        jPanel21 = new MyJPanel();
        aos = new JLabel();
        aosYes = new JRadioButton();
        aosNo = new JRadioButton();
        jPanel22 = new MyJPanel();
        accident = new JLabel();
        accidentYes = new JRadioButton();
        accidentNo = new JRadioButton();
        labelAddress = new JLabel();
        address = new JTextArea();
        jScrollPane3 = new JScrollPane();
        validate = new JButton();
        cancel = new JButton();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gestion des Assurances");
        setResizable(false);

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(232, 232, 232)
                .addComponent(searchField, GroupLayout.PREFERRED_SIZE, 327, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(256, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        
        searchField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });
        
        tableSearch.setModel(new DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "R�f", "Agence", "N� OFAS", "N� EAN", "N� RCC", "Cover Card"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableSearch);
        
        tableSearch.setCellSelectionEnabled(true);
        ListSelectionModel cellSelectionModel = tableSearch.getSelectionModel();
        cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        cellSelectionModel.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
              Integer selectedData = 0;

              int[] selectedRow = tableSearch.getSelectedRows();
              int[] selectedColumns = tableSearch.getSelectedColumns();

              for (int i = 0; i < selectedRow.length; i++) {
                for (int j = 0; j < selectedColumns.length; j++) {
                  selectedData = (Integer) tableSearch.getValueAt(selectedRow[i], selectedColumns[j]);
                }
              }
              System.out.println("Selected: " + selectedData);
              
              assurance = service.findAssurance(selectedData);
              if(assurance != null){
            	  nom.setText(Utilities.isEmpty(assurance.getName()));
            	  agence.setText(Utilities.isEmpty(assurance.getAgence()));
            	  ofas.setText(Utilities.isEmpty(assurance.getOfas()));
            	  ean.setText(Utilities.isEmpty(assurance.getEan()));
            	  rcc.setText(Utilities.isEmpty(assurance.getRcc()));
//            	  coverCard.setText(assurance.getCoverCard());
            	  npa.setText(Utilities.isEmpty(assurance.getNpa()));
            	  phone.setText(Utilities.isEmpty(assurance.getPhone()));
            	  validationDate.setValue(assurance.getValidationDate());
            	  cardValidity.setValue(assurance.getCardValidity());
            	  validationNumber.setText(Utilities.isEmpty(assurance.getValidationNumber()));
            	  address.setText(Utilities.isEmpty(assurance.getAddress()));
              }
            }
        });
        labelNom.setText("Nom:");
        labelAgence.setText("Agence:");
        labelEan.setText("N� EAN:");
        labelOfas.setText("N� OFAS:");
        labelCoverCard.setText("Cover Card:");
        labelEmail.setText("Email: ");
        labelCardValidity.setText("Validiti� de la Carte:");
        labelValidationDate.setText("Date de Validation:");
        labelMobile.setText("Mobile:");
        labelPhone.setText("Fix: ");
        labelValidationNumber.setText("N� Validation:");
        labelRcc.setText("N� RCC:");
        labelNpa.setText("NPA/ Localit�:");

        
        GridLayout gridLayout = new GridLayout(5, 3, 0, 0);
        gridLayout.setHgap(10);
        gridLayout.setVgap(14);
        jPanel3.setLayout(gridLayout);
        
        jPanel3.add(Utilities.createFilledSimpleInnerPanel(labelNom, nom));
        jPanel3.add(Utilities.createFilledSimpleInnerPanel(labelAgence, agence));
        jPanel3.add(Utilities.createFilledSimpleInnerPanel(labelEan, ean));
        jPanel3.add(Utilities.createFilledSimpleInnerPanel(labelOfas, ofas));
//        jPanel3.add(Utilities.createFilledSimpleInnerPanel(labelCoverCard, coverCard));
//        jPanel3.add(Utilities.createFilledSimpleInnerPanel(labelEmail, email));
        JDatePanelImpl datePanel2 = new JDatePanelImpl(cardValidity);
        JDatePickerImpl au2 = new JDatePickerImpl(datePanel2);
        jPanel3.add(Utilities.createFilledSimpleInnerPanel(labelCardValidity, au2));
        JDatePanelImpl datePanel = new JDatePanelImpl(validationDate);
        JDatePickerImpl au = new JDatePickerImpl(datePanel);
        jPanel3.add(Utilities.createFilledSimpleInnerPanel(labelValidationDate, au));
        jPanel3.add(Utilities.createFilledSimpleInnerPanel(labelMobile, mobile));
        jPanel3.add(Utilities.createFilledSimpleInnerPanel(labelPhone, phone));
        jPanel3.add(Utilities.createFilledSimpleInnerPanel(labelValidationNumber, validationNumber));
        jPanel3.add(Utilities.createFilledSimpleInnerPanel(labelRcc, rcc));
        jPanel3.add(Utilities.createFilledSimpleInnerPanel(labelNpa, npa));
        
        labelAddress.setText("Addresse: ");
        labelAddress.setFont(new java.awt.Font("Tahoma", 1, 11));
        couvertureAos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        couvertureAos.setText("Couverture AOS");
        jScrollPane3.setViewportView(address);

        aos.setText("AOS:");
        aosYes.setText("Oui");
        aosNo.setText("Non");

        accident.setText("Accident:");
        accidentYes.setText("Oui");
        accidentNo.setText("Non");

        accidentYes.setBackground(Color.WHITE);
        accidentNo.setBackground(Color.WHITE);
        aosYes.setBackground(Color.WHITE);
        aosNo.setBackground(Color.WHITE);

        jPanel21.setLayout(new GridLayout(1, 2, 0, 0));
        jPanel21.add(aosYes);
        jPanel21.add(aosNo);
        
        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(couvertureAos)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(aos)
                                .addGap(18, 18, 18)
                                .addComponent(aosYes)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(aosNo))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(accident)
                        .addGap(18, 18, 18)
                        .addComponent(accidentYes)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(accidentNo)))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(labelAddress)
                        .addGap(361, 361, 361))
                    .addComponent(jScrollPane3, GroupLayout.PREFERRED_SIZE, 410, GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(labelAddress)
                    .addComponent(couvertureAos))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(aosNo)
                            .addComponent(aosYes)
                            .addComponent(aos, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(accident, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(accidentYes)
                                .addComponent(accidentNo)))))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        
        
        validate.setText("Valider");
        validate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				validateActionPerformed(evt);	
			}
		});
        
        cancel.setText("Annuler");
        cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				cancelActionPerformed(evt);	
			}
		});
        
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, GroupLayout.Alignment.TRAILING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(cancel, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(validate, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jPanel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(cancel)
                    .addComponent(validate))
                .addContainerGap())
        );

        KeyStroke escapeKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, false);
        Action escapeAction = new AbstractAction() {
        	public void actionPerformed(ActionEvent e) {
        		setVisible(false);
        		dispose();
        	}
        };
        
        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(escapeKeyStroke, "ESCAPE");
        getRootPane().getActionMap().put("ESCAPE", escapeAction);
        
        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>                        
    

    
	private void searchActionPerformed(ActionEvent evt) {                                         
		String value = searchField.getText();
		List<Assurance> assurances = service.getAssurancesByCriteria(value, typeAssurance);
		if(assurances != null && assurances.size() > 0){
			AbstractTableModel model = new AssuranceTableModel(assurances);
			tableSearch.setModel(model);
		}
		
    } 
	
	private void validateActionPerformed(ActionEvent evt){
		for (Frame frame : Frame.getFrames()) {
			if (frame.getTitle().equals("EasyPharma: Gestion Pharmacies ")) {
				SaleView saleView = (SaleView) frame;
				
				AssuranceWidget assuranceWidget = ((AssuranceWidget) saleView.getAssuranceWidget());
				JTextField assuranceField = null;
				JTextField hiddenField = null;
				
				switch (typeAssurance) {
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
					
				
				if(isEdit){
					em.getTransaction().begin();
					assurance = em.find(Assurance.class, idAssurance);
					
					assurance.setName(Utilities.isEmpty(nom.getText()));
					assurance.setAgence(Utilities.isEmpty(agence.getText()));
					assurance.setOfas(Utilities.isEmpty(ofas.getText()));
					assurance.setEan(Utilities.isEmpty(ean.getText()));
					assurance.setRcc(Utilities.isEmpty(rcc.getText()));
					assurance.setNpa(Utilities.isEmpty(npa.getText()));
					assurance.setPhone(Utilities.isEmpty(phone.getText()));
					assurance.setValidationDate(validationDate.getValue());
					assurance.setCardValidity(cardValidity.getValue());
					assurance.setValidationNumber(Integer.valueOf(Utilities.isEmpty(validationNumber.getText())));
					assurance.setAddress(Utilities.isEmpty(address.getText()));
					
					em.persist(assurance);
					em.getTransaction().commit();
					
				}else{
					
					em.getTransaction().begin();
					vente = em.find(Vente.class, vente.getId());
					Client client = vente.getClient();
					
					AssuranceClient assuranceClient = new AssuranceClient();
					assuranceClient.setAssurance(assurance);
					assuranceClient.setType(typeAssurance);
					assuranceClient.setClient(client);
					
					em.persist(assuranceClient);
					
					assuranceClients.add(assuranceClient);
					client.setAssuranceClients(assuranceClients);
					em.getTransaction().commit();
				}
				
				assuranceField.setText(Utilities.isEmpty(assurance.getName()));
				hiddenField.setText(Utilities.isEmpty(assurance.getId()));
				
				
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
	
    public Assurance getAssurance() {
		return assurance;
	}

	public JTextArea getAddress() {
		return address;
	}

	public JTextField getCoverCard() {
		return coverCard;
	}

	public JTextField getNpa() {
		return npa;
	}

	public UtilDateModel getCardValidity() {
		return cardValidity;
	}

	public UtilDateModel getValidationDate() {
		return validationDate;
	}

	public JTextField getPhone() {
		return phone;
	}

	public JTextField getValidationNumber() {
		return validationNumber;
	}

	public JTextField getNom() {
		return nom;
	}

	public JTextField getAgence() {
		return agence;
	}

	public JTextField getEan() {
		return ean;
	}

	public JTextField getOfas() {
		return ofas;
	}

	public JTextField getRcc() {
		return rcc;
	}

	public JLabel getAos() {
		return aos;
	}

	public JTextField getEmail() {
		return email;
	}

	public JTextField getMobile() {
		return mobile;
	}
	
	public JTable getTableSearch() {
		return tableSearch;
	}

	public JTextField getSearchField() {
		return searchField;
	}
	
	public boolean isEdit() {
		return isEdit;
	}

	public void setEdit(boolean isEdit) {
		this.isEdit = isEdit;
	}

	public void setTypeAssurance(TypeAssurance typeAssurance){
		this.typeAssurance = typeAssurance;
	}
	
	public int getIdAssurance() {
		return idAssurance;
	}

	public void setIdAssurance(int idAssurance) {
		this.idAssurance = idAssurance;
	}



	private JButton validate;
    private JButton cancel;
    private JLabel labelNom;
    private JLabel labelCoverCard;
    private JLabel labelRcc;
    private JLabel labelEmail;
    private JLabel labelCardValidity;
    private JLabel labelValidationDate;
    private JLabel labelMobile;
    private JLabel labelPhone;
    private JLabel labelValidationNumber;
    private JLabel labelNpa;
    private JLabel aos;
    private JLabel couvertureAos;
    private JLabel accident;
    private JLabel labelAddress;
    private JLabel labelAgence;
    private JLabel labelEan;
    private JLabel labelOfas;
    private MyJPanel jPanel1;
    private MyJPanel jPanel21;
    private MyJPanel jPanel22;
    private MyJPanel jPanel3;
    private MyJPanel jPanel2;
    private JRadioButton aosYes;
    private JRadioButton aosNo;
    private JRadioButton accidentYes;
    private JRadioButton accidentNo;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane3;
    private JTable tableSearch;
    private JTextArea address;
    private JTextField searchField;
    private JTextField coverCard;
    private JTextField npa;
    private JTextField email;
    private UtilDateModel cardValidity;
    private UtilDateModel validationDate;
    private JTextField mobile;
    private JTextField phone;
    private JTextField validationNumber;
    private JTextField nom;
    private JTextField agence;
    private JTextField ean;
    private JTextField ofas;
    private JTextField rcc;
    // End of variables declaration                   
}
