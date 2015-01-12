package com.mm.app.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;

import com.mm.app.model.Posologie;
import com.mm.app.model.PosologieSpecifique;
import com.mm.app.model.Product;
import com.mm.app.model.Vente;
import com.mm.app.model.VenteProduit;
import com.mm.app.utilities.SubProductTableModel;
import com.mm.app.utilities.Utilities;

/**
 *
 * @author A574266
 */
public class PosologieFrame extends JFrame {
	
	private EntityManager em;
	private Vente vente;
	private Collection<VenteProduit> venteProduits;
	private List<Product> products;
	String productIdentifier = "";
	
    public PosologieFrame(EntityManager em, Vente vente) {
    	this.em = em;
    	this.vente = vente;
    	products = new ArrayList<Product>();
    	
    	vente = em.find(Vente.class, vente.getId());
    	venteProduits = vente.getProduits();
    	
    	for(VenteProduit venteProduit : venteProduits){
    		products.add(venteProduit.getProduct());
    	}
    	
        initComponents();
        ImageIcon img = new ImageIcon(getClass().getResource("/img/logo.png"));
        setIconImage(img.getImage());
        setBackground(Color.WHITE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new MyJPanel();
        jTabbedPane1 = new JTabbedPane();
        jPanel4 = new MyJPanel();
        jScrollPane3 = new JScrollPane();
        codexPosoologie = new JTextArea();
        jTabbedPane2 = new JTabbedPane();
        jScrollPane5 = new JScrollPane();
        tableProduit = new JTable();
        jPanel2 = new MyJPanel();
        jPanel6 = new MyJPanel();
        jLabel3 = new JLabel();
        qteJour = new JSpinner();
        jLabel4 = new JLabel();
        qteHeur = new JSpinner();
        jLabel5 = new JLabel();
        matin = new JCheckBox();
        matinLabel = new JLabel();
        midi = new JCheckBox();
        nuitLabel = new JLabel();
        soir = new JCheckBox();
        soirLabel = new JLabel();
        midiLabel = new JLabel();
        nuit = new JCheckBox();
        jLabel10 = new JLabel();
        jLabel11 = new JLabel();
        jLabel12 = new JLabel();
        jLabel13 = new JLabel();
        repos = new JTextField();
        condition = new JTextField();
        rithme = new JSpinner();
        jLabel14 = new JLabel();
        jourSur = new JSpinner();
        duree = new JSpinner();
        jLabel15 = new JLabel();
        jScrollPane4 = new JScrollPane();
        etiquette = new JTextArea();
        jLabel24 = new JLabel();
        jPanel7 = new MyJPanel();
        jLabel16 = new JLabel();
        dosage = new JTextField();
        jLabel17 = new JLabel();
        forme = new JTextField();
        jLabel18 = new JLabel();
        unite = new JTextField();
        jLabel19 = new JLabel();
        preparation = new JTextField();
        recommand = new JTextField();
        jLabel20 = new JLabel();
        jLabel21 = new JLabel();
        avertissementField = new JTextField();
        application = new JTextField();
        jLabel22 = new JLabel();
        jLabel23 = new JLabel();
        action = new JTextField();
        jTabbedPane3 = new JTabbedPane();
        jPanel3 = new MyJPanel();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jScrollPane1 = new JScrollPane();
        avertissement = new JTextArea();
        jTabbedPane4 = new JTabbedPane();
        jPanel8 = new MyJPanel();
        jScrollPane2 = new JScrollPane();
        contreIndication = new JTextArea();
        print = new JButton();
        validate = new JButton();
        jLabel25 = new JLabel();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Posologie");
        setResizable(false);

        codexPosoologie.setColumns(20);
        codexPosoologie.setRows(3);
//        codexPosoologie.setText("Pour toutes les formes qaléniques, \nRespecter un interval");
        jScrollPane3.setViewportView(codexPosoologie);

        GroupLayout jPanel4Layout = new GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, GroupLayout.DEFAULT_SIZE, 392, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Codex-Posologie", jPanel4);
        
        AbstractTableModel model = new SubProductTableModel(products);
        tableProduit.setModel(model);
        
        tableProduit.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent event) {
                productIdentifier = tableProduit.getValueAt(tableProduit.getSelectedRow(), 0).toString();
                
                Product product = em.find(Product.class, Integer.valueOf(productIdentifier));
                if(product != null){
                	Posologie posologie = product.getPosologie();
                	initFields();
                	if(posologie != null){
                		action.setText(Utilities.isEmpty(posologie.getAction()));
                		codexPosoologie.setText(Utilities.isEmpty(posologie.getCodex()));
                		contreIndication.setText(Utilities.isEmpty(posologie.getContreIndication()));
                		forme.setText(Utilities.isEmpty(posologie.getForme()));
                	}
                }
                
            }
        });
        
        jScrollPane5.setViewportView(tableProduit);
        jTabbedPane2.addTab("Liste Produits", jScrollPane5);
        jLabel3.setText("Qté (/jour):");
        jLabel4.setText("Toutes les:");
        jLabel5.setText("Heures");

        matin.setText("Matin");
        matin.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent evt) {
                jCheckBoxStateChanged(evt);
            }
        });
        matin.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent evt) {
                jCheckBoxItemStateChanged(evt, matinLabel, "Matin");
            }
        });

        matinLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        matinLabel.setText("-----------");

        midi.setText("Midi");
        midi.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent evt) {
                jCheckBoxStateChanged(evt);
            }
        });
        midi.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent evt) {
                jCheckBoxItemStateChanged(evt, midiLabel, "Midi");
            }
        });

        nuitLabel.setFont(new Font("Tahoma", 0, 14)); // NOI18N
        nuitLabel.setText("-----------");

        soir.setText("Soir");
        soir.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent evt) {
                jCheckBoxStateChanged(evt);
            }
        });
        soir.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent evt) {
                jCheckBoxItemStateChanged(evt, soirLabel, "Soir");
            }
        });

        soirLabel.setFont(new Font("Tahoma", 0, 14)); // NOI18N
        soirLabel.setText("-----------");

        midiLabel.setFont(new Font("Tahoma", 0, 14)); // NOI18N
        midiLabel.setText("-----------");

        nuit.setText("Nuit");
        nuit.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent evt) {
                jCheckBoxStateChanged(evt);
            }
        });
        nuit.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent evt) {
                jCheckBoxItemStateChanged(evt, nuitLabel, "Nuit");
            }
        });
        
        nuit.setBackground(Color.WHITE);
        soir.setBackground(Color.WHITE);
        matin.setBackground(Color.WHITE);
        midi.setBackground(Color.WHITE);
        
        jLabel10.setText("Repas:");
        jLabel11.setText("Conditions:");
        jLabel12.setText("Rythme:");
        jLabel13.setText("Durée:");
        jLabel14.setText("Jours sur: ");
        jLabel15.setText("Jours");
        
        etiquette.setColumns(20);
        etiquette.setRows(5);
        jScrollPane4.setViewportView(etiquette);
        jLabel24.setText("Etiquette:");
        
        GroupLayout jPanel6Layout = new GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                .addComponent(matinLabel, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE))
                            .addComponent(matin)
                            .addComponent(jLabel10))
                        .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                            .addGap(56, 56, 56)
                                            .addComponent(jLabel14)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jourSur, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(jLabel13)
                                            .addGap(18, 18, 18)
//                                        .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
//                                            .addComponent(rithme, GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
//                                            .addComponent(duree))
//                                        .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
//                                            .addGroup(jPanel6Layout.createSequentialGroup()
//                                                .addGap(12, 12, 12)
//                                                .addComponent(jLabel14)
//                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(duree, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
//                                            .addGroup(jPanel6Layout.createSequentialGroup()
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel15)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel6Layout.createSequentialGroup()
                                                .addComponent(qteJour, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel4))
                                            .addGroup(jPanel6Layout.createSequentialGroup()
                                                .addGap(20, 20, 20)
                                                .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                    .addComponent(nuit)
                                                    .addComponent(nuitLabel, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE))))
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel6Layout.createSequentialGroup()
                                                .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                    .addComponent(midiLabel, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(midi))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                    .addComponent(soir)
                                                    .addComponent(soirLabel, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(jPanel6Layout.createSequentialGroup()
                                                .addComponent(qteHeur, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel5)))))
                                .addContainerGap())
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(135, 135, 135)
                                .addComponent(jLabel11)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                    		.addComponent(jLabel12)
                            .addGap(18, 18, 18)
                            .addComponent(rithme, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addGroup(GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(repos, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(condition, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                        .addComponent(jLabel24)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jScrollPane4, GroupLayout.PREFERRED_SIZE, 311, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())))
                );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(qteJour, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(qteHeur, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(nuit)
                            .addComponent(midi))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nuitLabel))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(midiLabel))
                            .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                                .addGroup(GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                    .addComponent(soir)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(soirLabel))
                                .addGroup(jPanel6Layout.createSequentialGroup()
                                    .addComponent(matin)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(matinLabel))))))
                .addGap(0, 0, 0)
                .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(condition, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(repos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(rithme, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(jourSur, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(duree, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                    .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel24)
                    .addComponent(jScrollPane4, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel16.setText("Dosage: ");
        jLabel17.setText("Forme: ");
        jLabel18.setText("Unité: ");
        jLabel19.setText("Préparation: ");
        jLabel20.setText("Recommand.: ");
        jLabel21.setText("Avertissement:");
        jLabel22.setText("Applications: ");
        jLabel23.setText("Action: ");

        GroupLayout jPanel7Layout = new GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19)
                    .addComponent(jLabel23)
                    .addComponent(jLabel22)
                    .addComponent(jLabel21)
                    .addComponent(jLabel20))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING, jPanel7Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                        .addComponent(avertissementField)
                        .addComponent(application, GroupLayout.Alignment.LEADING)
                        .addComponent(action, GroupLayout.Alignment.LEADING)
                        .addComponent(preparation, GroupLayout.Alignment.LEADING)
                        .addComponent(unite, GroupLayout.Alignment.LEADING)
                        .addComponent(forme, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
                        .addComponent(dosage, GroupLayout.Alignment.LEADING))
                    .addComponent(recommand, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 243, GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(dosage, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(forme, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(unite, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(preparation, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(action, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23))
                .addGap(9, 9, 9)
                .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(application, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(avertissementField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(recommand, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                    .addGap(0, 0, Short.MAX_VALUE))
        );

        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jPanel7, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel1.setText("Date Naiss.:");

//        jLabel2.setText("13/06/1987");

        avertissement.setColumns(20);
        avertissement.setRows(2);
        jScrollPane1.setViewportView(avertissement);

        GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addContainerGap(247, Short.MAX_VALUE))
            .addComponent(jScrollPane1, GroupLayout.Alignment.TRAILING)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Avertissement Client", jPanel3);

        contreIndication.setColumns(20);
        contreIndication.setLineWrap(true);
        contreIndication.setRows(4);
        jScrollPane2.setViewportView(contreIndication);

        GroupLayout jPanel8Layout = new GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(0, 13, Short.MAX_VALUE)
                .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane4.addTab("Codex-Contreindications", jPanel8);

        print.setText("Imprimer");

        validate.setText("Valider");
        validate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				validatePosologieView(evt);
			}
		});
        
        jLabel25.setText("F1 pour sauvegarder une etiquette");
        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 13));
        jLabel25.setForeground(Color.RED);
        
        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
            		.addContainerGap()
                    .addComponent(jLabel25)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(print, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(validate, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(jTabbedPane1, GroupLayout.PREFERRED_SIZE, 397, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTabbedPane4, GroupLayout.PREFERRED_SIZE, 395, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane3)
                    .addComponent(jTabbedPane2, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTabbedPane2, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jTabbedPane1))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane3, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTabbedPane4, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(print, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel25))
                            .addComponent(validate, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        
        KeyStroke f1KeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0, false);
        Action f1Action = new AbstractAction() {
        	public void actionPerformed(ActionEvent e) {
        		if(Utilities.isEmptyString(productIdentifier)){
        			JOptionPane.showMessageDialog(getContentPane(), "Veuillez séléctionner un produit!");
        		}
        		
        		if(!em.getTransaction().isActive()){
        			em.getTransaction().begin();
        		}
        		PosologieSpecifique ps = new PosologieSpecifique();
        		ps.setEtiquette(Utilities.isEmpty(etiquette.getText()));
        		System.out.println("productIdentifier" + productIdentifier);
        		VenteProduit vp = null;
        		
        		vente = em.find(Vente.class, vente.getId());
            	venteProduits = vente.getProduits();
            	
        		for(VenteProduit venteProduit : venteProduits){
            		if(Integer.valueOf(productIdentifier) == venteProduit.getProduct().getId()){
            			vp = venteProduit;
            			break;
            		}
            	}
        		
        		vp.setSpecifique(ps);
        		em.persist(ps);
        		em.getTransaction().commit();
        		
        		JOptionPane.showMessageDialog(getContentPane(), "Etiquette enregistrée!");
        		
        	}
        };
        
        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(f1KeyStroke, "F1");
        getRootPane().getActionMap().put("F1", f1Action);
        
        
        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>                        
    
    private void initFields(){
    	matin.setSelected(false);
    	matinLabel.setText("-----------");
    	midi.setSelected(false);
    	midiLabel.setText("-----------");
    	nuit.setSelected(false);
    	nuitLabel.setText("-----------");
    	soir.setSelected(false);
    	soirLabel.setText("-----------");
    	
    	
    	etiquette.setText("");
    }
    
    private void jCheckBoxItemStateChanged(ItemEvent evt, JLabel label, String type) {                                            
        if (evt.getStateChange() == ItemEvent.SELECTED) {
        	label.setText(qteJour.getValue().toString() + ".00");
        	if(Utilities.isEmptyString(etiquette.getText())){
        		etiquette.setText("Avaler " + qteJour.getValue().toString() + "  Comprimé ");
        	}
        	etiquette.setText(etiquette.getText() + " " + type);
        } else {
        	label.setText("-----------");
        }
    }       
    
    private void jCheckBoxStateChanged(ChangeEvent evt) {                                        
        
    }                                       
    
    private void validatePosologieView(ActionEvent evt) {
    	setVisible(false);
		dispose();
	}
    
    // Variables declaration - do not modify                     
    private JButton validate;
    private JButton print;
    private JCheckBox matin;
    private JCheckBox midi;
    private JCheckBox soir;
    private JCheckBox nuit;
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
    private JLabel matinLabel;
    private JLabel nuitLabel;
    private JLabel soirLabel;
    private JLabel midiLabel;
    private JLabel jLabel24;
    private JLabel jLabel25;
    private MyJPanel jPanel1;
    private MyJPanel jPanel2;
    private MyJPanel jPanel3;
    private MyJPanel jPanel4;
    private MyJPanel jPanel6;
    private MyJPanel jPanel7;
    private MyJPanel jPanel8;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JScrollPane jScrollPane3;
    private JScrollPane jScrollPane4;
    private JScrollPane jScrollPane5;
    private JSpinner qteJour;
    private JSpinner qteHeur;
    private JSpinner rithme;
    private JSpinner jourSur;
    private JSpinner duree;
    private JTabbedPane jTabbedPane1;
    private JTabbedPane jTabbedPane2;
    private JTabbedPane jTabbedPane3;
    private JTabbedPane jTabbedPane4;
    private JTable tableProduit;
    private JTextArea avertissement;
    private JTextArea contreIndication;
    private JTextArea codexPosoologie;
    private JTextArea etiquette;
    private JTextField avertissementField;
    private JTextField application;
    private JTextField action;
    private JTextField repos;
    private JTextField condition;
    private JTextField dosage;
    private JTextField forme;
    private JTextField unite;
    private JTextField preparation;
    private JTextField recommand;
}
