package com.mm.app.view;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.util.List;

import javax.persistence.EntityManager;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
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

import com.mm.app.model.Assurance;
import com.mm.app.service.AssuranceService;
import com.mm.app.service.impl.AssuranceServiceImpl;
import com.mm.app.utilities.AssuranceTableModel;

public class AssuranceManagementView extends javax.swing.JFrame {

	private static final long serialVersionUID = 2071451267119111319L;

	private EntityManager em;
	private AssuranceService service;
	private Assurance assurance = null;
	
	public AssuranceManagementView(EntityManager em) {
		this.em = em;
		service = new AssuranceServiceImpl(em);
		
        initComponents();
        ImageIcon img = new ImageIcon(getClass().getResource("/img/logo.png"));
        setIconImage(img.getImage());
    }

    @SuppressWarnings({ "serial" })
    private void initComponents() {

        jPanel1 = new JPanel();
        jTextField1 = new JTextField();
        jScrollPane1 = new JScrollPane();
        jTable1 = new JTable();
        jPanel3 = new JPanel();
        jPanel4 = new JPanel();
        jLabel1 = new JLabel();
        nom = new JTextField();
        jPanel5 = new JPanel();
        jLabel4 = new JLabel();
        agence = new JTextField();
        jPanel9 = new JPanel();
        jLabel7 = new JLabel();
        ean = new JTextField();
        jPanel10 = new JPanel();
        jLabel8 = new JLabel();
        ofas = new JTextField();
        jPanel12 = new JPanel();
        jLabel10 = new JLabel();
        coverCard = new JTextField();
        jPanel14 = new JPanel();
        jLabel12 = new JLabel();
        jTextField12 = new JTextField();
        jPanel15 = new JPanel();
        jLabel13 = new JLabel();
        cardValidity = new JTextField();
        jPanel16 = new JPanel();
        jLabel14 = new JLabel();
        validationDate = new JTextField();
        jPanel17 = new JPanel();
        jLabel15 = new JLabel();
        jTextField15 = new JTextField();
        jPanel18 = new JPanel();
        jLabel16 = new JLabel();
        phone = new JTextField();
        jPanel19 = new JPanel();
        jLabel17 = new JLabel();
        validationNumber = new JTextField();
        jPanel13 = new JPanel();
        jLabel11 = new JLabel();
        rcc = new JTextField();
        jPanel20 = new JPanel();
        jLabel18 = new JLabel();
        npa = new JTextField();
        jLabel2 = new JLabel();
        jPanel21 = new JPanel();
        jLabel19 = new JLabel();
        jRadioButton3 = new JRadioButton();
        jRadioButton4 = new JRadioButton();
        jPanel22 = new JPanel();
        jLabel20 = new JLabel();
        jRadioButton5 = new JRadioButton();
        jRadioButton6 = new JRadioButton();
        jLabel3 = new JLabel();
        jScrollPane2 = new JScrollPane();
        address = new JTextArea();
        jButton1 = new JButton();
        jButton2 = new JButton();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gestion des Assurances");
        setResizable(false);


        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(232, 232, 232)
                .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 327, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(256, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        
        jTextField1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });
        
        jTable1.setModel(new DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "Réf", "Agence", "N° OFAS", "N° EAN", "N° RCC", "Cover Card"
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
              System.out.println("Selected: " + selectedData);
              
              assurance = service.findAssurance(selectedData);
              if(assurance != null){
            	  nom.setText(assurance.getName());
            	  agence.setText(assurance.getAgence());
            	  ofas.setText(assurance.getOfas());
            	  ean.setText(assurance.getEan());
            	  rcc.setText(assurance.getRcc());
            	  coverCard.setText(assurance.getCoverCard());
            	  npa.setText(assurance.getNpa());
            	  phone.setText(assurance.getPhone());
            	  validationDate.setText(DateFormat.getDateInstance().format(assurance.getValidationDate()));
            	  cardValidity.setText(DateFormat.getDateInstance().format(assurance.getCardValidity()));
            	  validationNumber.setText(String.valueOf(assurance.getValidationNumber()));
            	  address.setText(assurance.getAddress());
              }
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
                .addComponent(nom)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel1, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                .addComponent(nom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );

        jLabel4.setText("Agence:");

        GroupLayout jPanel5Layout = new GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(agence, GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel4, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                .addComponent(agence, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );

        jLabel7.setText("N° EAN:");

        GroupLayout jPanel9Layout = new GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(ean, GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel7, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                .addComponent(ean, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );

        jLabel8.setText("N° OFAS:");

        GroupLayout jPanel10Layout = new GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(ofas)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel8, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                .addComponent(ofas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );

        jLabel10.setText("Cover Card:");

        GroupLayout jPanel12Layout = new GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addComponent(coverCard, GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel10, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                .addComponent(coverCard, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
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
                .addComponent(jTextField12, GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel12, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                .addComponent(jTextField12, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );

        jLabel13.setText("Validitié de la Carte:");

        GroupLayout jPanel15Layout = new GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addGap(18, 18, 18)
                .addComponent(cardValidity, GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel13, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                .addComponent(cardValidity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );

        jLabel14.setText("Date de Validation:");

        GroupLayout jPanel16Layout = new GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addGap(18, 18, 18)
                .addComponent(validationDate, GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel14, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                .addComponent(validationDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
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
                .addComponent(jTextField15, GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel15, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                .addComponent(jTextField15, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
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
                .addComponent(phone, GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel16, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                .addComponent(phone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );

        jLabel17.setText("N° Validation:");

        GroupLayout jPanel19Layout = new GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17)
                .addGap(18, 18, 18)
                .addComponent(validationNumber, GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel17, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                .addComponent(validationNumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );

        jLabel11.setText("N° RCC:");

        GroupLayout jPanel13Layout = new GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addComponent(rcc)
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel11, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                .addComponent(rcc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );

        jLabel18.setText("NPA/ Localité:");

        GroupLayout jPanel20Layout = new GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18)
                .addGap(18, 18, 18)
                .addComponent(npa, GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel18, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                .addComponent(npa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Couverture AOS");

        jLabel19.setText("AOS:");

        jRadioButton3.setText("Oui");

        jRadioButton4.setText("Non");

        GroupLayout jPanel21Layout = new GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19)
                .addPreferredGap(ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(jRadioButton3)
                .addPreferredGap(ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton4)
                .addGap(24, 24, 24))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel19, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                .addComponent(jRadioButton3)
                .addComponent(jRadioButton4))
        );

        jLabel20.setText("Accident:");

        jRadioButton5.setText("Oui");

        jRadioButton6.setText("Non");

        GroupLayout jPanel22Layout = new GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20)
                .addGap(18, 18, 18)
                .addComponent(jRadioButton5)
                .addPreferredGap(ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton6)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel20, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                .addComponent(jRadioButton5)
                .addComponent(jRadioButton6))
        );

        jLabel3.setText("Addresse:");

        address.setColumns(20);
        address.setRows(3);
        jScrollPane2.setViewportView(address);

        GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel14, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(jPanel18, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(jPanel17, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel16, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(jPanel15, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(jPanel19, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel12, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(jPanel20, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel10, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jPanel9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(jPanel13, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jPanel5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2)
                                .addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel22, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel21, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(140, 140, 140)))
                        .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(361, 361, 361))
                            .addComponent(jScrollPane2))))
                .addContainerGap())
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
                    .addComponent(jPanel9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel13, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel12, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel20, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel14, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel18, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel17, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel16, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel15, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel19, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(jPanel21, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(jPanel22, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        jButton1.setText("Valider");
        jButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				validateActionPerformed(evt);	
			}
		});
        
        jButton2.setText("Annuler");
        jButton2.addActionListener(new ActionListener() {
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
                .addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jPanel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>                        
    

    
	private void searchActionPerformed(ActionEvent evt) {                                         
		String value = jTextField1.getText();
		List<Assurance> assurances = service.getAssurancesByCriteria(value);
		if(assurances != null && assurances.size() > 0){
			AbstractTableModel model = new AssuranceTableModel(assurances);
			jTable1.setModel(model);
		}
		
    } 
	
	private void validateActionPerformed(ActionEvent evt){
		for (Frame frame : Frame.getFrames()) {
			if (frame.getTitle().equals("EasyPharma: Gestion Pharmacies ")) {
				SaleView saleView = (SaleView) frame;
				((AssuranceWidget) saleView.getjInternalFrame3()).getAssurance1().setText(assurance.getName());
				((AssuranceWidget) saleView.getjInternalFrame3()).getHiddenField1().setText(String.valueOf(assurance.getId()));
				
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

	public JTextField getCardValidity() {
		return cardValidity;
	}

	public JTextField getValidationDate() {
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
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JPanel jPanel1;
    private JPanel jPanel10;
    private JPanel jPanel12;
    private JPanel jPanel13;
    private JPanel jPanel14;
    private JPanel jPanel15;
    private JPanel jPanel16;
    private JPanel jPanel17;
    private JPanel jPanel18;
    private JPanel jPanel19;
    private JPanel jPanel20;
    private JPanel jPanel21;
    private JPanel jPanel22;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JPanel jPanel5;
    private JPanel jPanel9;
    private JRadioButton jRadioButton3;
    private JRadioButton jRadioButton4;
    private JRadioButton jRadioButton5;
    private JRadioButton jRadioButton6;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JTable jTable1;
    private JTextArea address;
    private JTextField jTextField1;
    private JTextField coverCard;
    private JTextField npa;
    private JTextField jTextField12;
    private JTextField cardValidity;
    private JTextField validationDate;
    private JTextField jTextField15;
    private JTextField phone;
    private JTextField validationNumber;
    private JTextField nom;
    private JTextField agence;
    private JTextField ean;
    private JTextField ofas;
    private JTextField rcc;
    // End of variables declaration                   
}
