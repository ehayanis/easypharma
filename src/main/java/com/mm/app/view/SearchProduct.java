package com.mm.app.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.persistence.EntityManager;
import javax.swing.AbstractAction;
import javax.swing.AbstractListModel;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.LayoutStyle;
import javax.swing.ListSelectionModel;
import javax.swing.WindowConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import com.mm.app.model.AssuranceClient;
import com.mm.app.model.Client;
import com.mm.app.model.Product;
import com.mm.app.model.Vente;
import com.mm.app.model.VenteProduit;
import com.mm.app.service.ProductService;
import com.mm.app.service.impl.ProductServiceImpl;
import com.mm.app.utilities.ProductTableModel;
import com.mm.app.utilities.SubAssuranceTableModel;
import com.mm.app.utilities.Utilities;

public class SearchProduct extends JFrame {
	
	private EntityManager em;
	private ProductService service;
	private Product product;
	private Vente vente;
	
    public SearchProduct(EntityManager em, Vente vente) {
    	this.em = em;
    	this.vente = vente;
    	service = new ProductServiceImpl(em);
    	product = new Product();
    	
        initComponents();
        setBackground(Color.WHITE);
        ImageIcon img = new ImageIcon(getClass().getResource("/img/logo.png"));
        setIconImage(img.getImage());
    }
    
    private void initComponents() {
        jPanel1 = new MyJPanel();
        searchField = new JTextField();
        jScrollPane1 = new JScrollPane();
        produitTable = new JTable();
        jPanel3 = new MyJPanel();
        jPanel2 = new MyJPanel();
        historiqueLabel = new JLabel();
        jScrollPane2 = new JScrollPane();
        historiqueList = new JList();
        designation = new JTextField();
        reference = new JTextField();
        listRemb = new JTextField();
        prix = new JTextField();
        rabais = new JTextField();
        reglement = new JTextField();
        prixUsine = new JTextField();
        datePermeption = new JTextField();
        designationLabel = new JLabel();
        referenceLabel = new JLabel();
        listRembLabel = new JLabel();
        prixLabel = new JLabel();
        rabaisLabel = new JLabel();
        reglementLabel = new JLabel();
        prixUsineLabel = new JLabel();
        datePermeptionLabel = new JLabel();
        

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Recherche Médicament");
        setResizable(false);
        
        searchLabel = new JLabel("Désignation:");
        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
            	.addGap(180, 180, 180)
            	.addComponent(searchLabel)
            	.addGap(16, 16, 16)
                .addComponent(searchField, GroupLayout.PREFERRED_SIZE, 350, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup()
                .addGap(16, 16, 16)
                .addComponent(searchLabel, GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
                .addComponent(searchField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                )
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        
        searchField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				searchActionPerformed(evt);
			}
		});

        produitTable.setModel(new DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Id", "Désignation", "Réglement", "Prix Usine", "Date Péremption"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        
        produitTable.getColumnModel().getColumn(1).setPreferredWidth(300);
        produitTable.getColumnModel().getColumn(0).setPreferredWidth(30);
        
        
        produitTable.setCellSelectionEnabled(true);
		ListSelectionModel cellSelectionModel = produitTable.getSelectionModel();
		cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		cellSelectionModel.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				Integer selectedData = 0;

				int[] selectedRow = produitTable.getSelectedRows();
				int[] selectedColumns = produitTable.getSelectedColumns();

				for (int i = 0; i < selectedRow.length; i++) {
					for (int j = 0; j < selectedColumns.length; j++) {
						selectedData = (Integer) produitTable.getValueAt(selectedRow[i], 0);
					}
				}

				product = service.findProduct(selectedData);

				if(product != null){
//					designation.setText(product.getDesignation());
//					reference.setText(product.getReference());
//					listRemb.setText("");
//					prix.setText(Utilities.isEmpty(product.getPu()));
//					rabais.setText("");
//					reglement.setText("");
//					prixUsine.setText("");
//					datePermeption.setText("");
					
					Client client = em.find(Vente.class, vente.getId()).getClient();
					
					if(client != null){
						List<VenteProduit> products = service.findHistoriqueProductForClient(selectedData, client.getId());
						if(products != null && products.size() > 0){
							String[] data = new String[products.size()];
							int i  = 0;
							for(VenteProduit p : products){
								DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
								data[i] = dateFormat.format(p.getDateCreation()) + " -- " + product.getDesignation();
								i++;
							}
							
							historiqueList.setListData(data);
						}
					}
					
				}
			}
		});
		
		
        jScrollPane1.setViewportView(produitTable);
        produitTable.setBackground(Color.WHITE);
        
//        designationLabel.setText("Désignation:");
//        listRembLabel.setText("Liste Remb.: ");
//        prixLabel.setText("Prix:");
//        rabaisLabel.setText("Rabais:");
//        reglementLabel.setText("Réglement:");
//        prixUsineLabel.setText("Prix Ex-fact: ");
//        datePermeptionLabel.setText("Date Péremption: ");
//        referenceLabel.setText("Réference:");
		
//        GridLayout gridLayout = new GridLayout(6, 2, 0, 0);
//		gridLayout.setHgap(0);
//		gridLayout.setVgap(0);
//		jPanel3.setLayout(gridLayout);
		
        GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 445, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        
//		designation.setEditable(false);
//		reference.setEditable(false);
//		listRemb.setEditable(false);
//		prix.setEditable(false);
//		rabais.setEditable(false);
//		reglement.setEditable(false);
//		prixUsine.setEditable(false);
//		datePermeption.setEditable(false);
		
//		jPanel3.add(Utilities.createFilledSimpleInnerPanel(designationLabel, designation));
//		jPanel3.add(Utilities.createFilledSimpleInnerPanel(referenceLabel, reference));
//		jPanel3.add(Utilities.createFilledSimpleInnerPanel(listRembLabel, listRemb));
//		jPanel3.add(Utilities.createFilledSimpleInnerPanel(prixLabel, prix));
//		jPanel3.add(Utilities.createFilledSimpleInnerPanel(rabaisLabel, rabais));
//		jPanel3.add(Utilities.createFilledSimpleInnerPanel(reglementLabel, reglement));
//		jPanel3.add(Utilities.createFilledSimpleInnerPanel(prixUsineLabel, prixUsine));
//		jPanel3.add(Utilities.createFilledSimpleInnerPanel(datePermeptionLabel, datePermeption));

        jPanel2.setBorder(BorderFactory.createEtchedBorder());

        historiqueLabel.setText("Historique Des Ventes");
//        historiqueLabel.setFont(new Font("Tahoma", 1, 12));
        
        jScrollPane2.setViewportView(historiqueList);
        
        jScrollPane1.setBackground(Color.WHITE);
        jScrollPane2.setBackground(Color.WHITE);
        
        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(historiqueLabel)
                .addContainerGap(187, Short.MAX_VALUE))
            .addComponent(jScrollPane2)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(historiqueLabel)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2)
                .addGap(0, 0, 0))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, GroupLayout.Alignment.TRAILING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)

                .addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))

        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)

                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)

                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))

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
    }                   
    
    private void searchActionPerformed(ActionEvent evt) {                                         
		String value = searchField.getText();
		List<Product> products = service.findProductByCriteria(value);
		if(products != null && products.size() > 0){
			AbstractTableModel model = new ProductTableModel(products);
			produitTable.setModel(model);
		}
	}
    
    
    private JLabel historiqueLabel;
    private JList<String> historiqueList;
    private MyJPanel jPanel1;
    private MyJPanel jPanel2;
    private MyJPanel jPanel3;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JTable produitTable;
    private JTextField searchField;
    private JTextField designation;
    private JTextField reference;
    private JTextField listRemb;
    private JTextField prix;
    private JTextField rabais;
    private JTextField reglement;
    private JTextField prixUsine;
    private JTextField datePermeption;
    private JLabel searchLabel;
    private JLabel designationLabel;
    private JLabel referenceLabel;
    private JLabel listRembLabel;
    private JLabel prixLabel;
    private JLabel rabaisLabel;
    private JLabel reglementLabel;
    private JLabel prixUsineLabel;
    private JLabel datePermeptionLabel;
}
