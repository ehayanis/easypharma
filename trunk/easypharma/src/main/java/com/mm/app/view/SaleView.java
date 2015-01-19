package com.mm.app.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.PropertyVetoException;
import java.text.DecimalFormat;

import java.util.ArrayList;
import java.util.Calendar;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.persistence.EntityManager;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.DefaultCellEditor;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.DefaultComboBoxModel;

import com.mm.app.model.Operator;
import com.mm.app.model.Product;
import com.mm.app.model.Vente;
import com.mm.app.model.VenteProduit;
import com.mm.app.service.ProductService;
import com.mm.app.service.VenteService;
import com.mm.app.service.impl.ProductServiceImpl;
import com.mm.app.service.impl.VenteServiceImpl;
import com.mm.app.utilities.MedicamentCellEditor;

/**
 *
 * @author A574266
 */
public class SaleView extends JFrame {

	private static final long serialVersionUID = 6431174577095592545L;
	
	private EntityManager em;
	private Operator operator;
	private ProductService productService;
	private VenteService venteService;
	private Vente vente;
	private Map<Integer, VenteProduit> products;
	private MyDesktopManager desktopManager;
	private JDesktopPane m_desktop;
	private SortedMap<String, String> data;
    
	public SaleView(EntityManager em, Operator operator) {
		desktopManager = new MyDesktopManager();
		m_desktop = new JDesktopPane();
	    m_desktop.setDesktopManager(desktopManager);
        this.em = em;
        this.operator = operator;
    	productService = new ProductServiceImpl(em);
    	venteService = new VenteServiceImpl(em);
    	
    	vente = new Vente();
    	vente.setOperator(operator);
    	vente.setStatus("INIT");
    	vente.setDateCreation(new Date());
    	vente = venteService.addVente(vente);
    	
    	products = new HashMap<Integer, VenteProduit>();
    	
    	initComponents();
        getContentPane().setBackground(Color.WHITE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        ImageIcon img = new ImageIcon(getClass().getResource("/img/logo.png"));
        setIconImage(img.getImage());
        
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPanel1 = new JPanel();
        medecinWidget = new MedecinWidget(em, vente);
        assuranceWidget = new AssuranceWidget(em, vente);
        clientWidget = new ClientWidget(em, vente);
        headerPanel = new HeaderPanel(operator);
        
        m_desktop.add(assuranceWidget);
        m_desktop.add(medecinWidget);
        m_desktop.add(clientWidget);
        
        try {
        	clientWidget.setSelected(true);
		} catch (PropertyVetoException e1) {
			e1.printStackTrace();
		}
        
        jTabbedPane1 = new JTabbedPane();
        jScrollPane1 = new JScrollPane();
        jTable1 = new JTable();
        footerPanel = new FooterPanel();
        jMenuBar1 = new JMenuBar();
        jMenu1 = new JMenu();
        jMenuItem1 = new JMenuItem();
        jSeparator1 = new JPopupMenu.Separator();
        jMenuItem2 = new JMenuItem();
        jSeparator2 = new JPopupMenu.Separator();
        jMenuItem3 = new JMenuItem();
        jMenu2 = new JMenu();
        jMenu3 = new JMenu();
        jMenu4 = new JMenu();
        jMenu5 = new JMenu();
//        jLabel2 = new JLabel();
//        jLabel3 = new JLabel();
        
        
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("EasyPharma: Gestion Pharmacies ");
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        setFont(new Font("Agency FB", 0, 11)); // NOI18N
        
        
        jPanel1.setLayout(new GridLayout(1, 3, 10, 0));

        jPanel1.add(assuranceWidget);
        jPanel1.add(clientWidget);
        jPanel1.add(medecinWidget);
        
        jPanel1.setBackground(Color.WHITE);
        
        jTable1.setModel(new DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
            		"Désignation", "Liste Remb.", "PU TTC", "Qté", "Remise", "Total"
            }
        ));
        
        jTable1.setRowHeight(22);
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(230);
      
        
    	data = new TreeMap<String, String>();
        data.put("", "");
        Product product = new Product();
        product.setDesignation("designattion");
        product.setId(1);
        product.setReference("1234");
//        List<Product> result = new ArrayList<Product>();
//        result.add(product);
        List<Product> result = productService.getProducts();
        
		if(result != null && result.size() > 0){
			for(Product p : result){
				data.put(p.getDesignation(), p.getReference());
				data.put(p.getReference(), p.getReference());
			}
		}
        

        final DecimalFormat decimalFormat = new DecimalFormat("0.00");
    

        TableColumn column = jTable1.getColumnModel().getColumn(0);
        column.setCellEditor(new MedicamentCellEditor(data.keySet(),this));
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setToolTipText("Séléctionner un produit");
        column.setCellRenderer(renderer);
        
//        TableColumn factureColumn = jTable1.getColumnModel().getColumn(1);
//        JComboBox<String> facture = new JComboBox<String>();
//        facture.addItem("Comptoire");
//        facture.addItem("Assurance");
//        factureColumn.setCellEditor(new DefaultCellEditor(facture));
        
        jTable1.getModel().addTableModelListener(new TableModelListener() {
        	public void tableChanged(TableModelEvent evt) {
        		if (evt.getType() == TableModelEvent.UPDATE){
        			int column = evt.getColumn();
        			int  row = 0;
        			if (column == 3){
        				row = jTable1.getSelectedRow();
        				String qte = (String) jTable1.getValueAt(row, column);
        				try{
        					Double q = Double.valueOf(qte);
        					String designation = (String) jTable1.getValueAt(row, 0);
        					if(designation != null && !designation.equals("")){
        						String total = (String) jTable1.getValueAt(row, 5);
        						if(total != null && !total.equals("")){
        							Double t = Double.parseDouble(((String) total).replace(",", "."));
        							jTable1.setValueAt(decimalFormat.format(t * q), row, 5);
        						}
        						
        						int rows = jTable1.getRowCount();
        						double sum = 0;
        						for(int i = 0; i < rows; i++){
        							Object d = jTable1.getValueAt(i, 5);
        							if(d != null && !d.toString().equals("")){
        								sum += Double.parseDouble(((String) d).replace(",", "."));
        							}
        						}
        						footerPanel.getTotalValue().setText(decimalFormat.format(sum));
        					}
        				}catch(NumberFormatException exception){
        					System.out.println(exception.getStackTrace());

        				}

        				System.out.println(jTable1.getValueAt(row, column));
        			}
        		}
			}
		});
        
        jTable1.addKeyListener(new KeyAdapter() {         
            public void keyPressed(KeyEvent e) {
                System.out.println("pressed");
                
                if (e.getKeyChar() == KeyEvent.VK_DELETE) {
                	int row = jTable1.getSelectedRow();
                	if(products.get(row) != null){

                		products.remove(row);
                		for (int i = 0; i <= 5; i++) {
                			jTable1.setValueAt("", row, i);
                		}

                		int rows = jTable1.getRowCount();
						double sum = 0;
						for(int i = 0; i < rows; i++){
							Object d = jTable1.getValueAt(i, 5);
							if(d != null && !d.toString().equals("")){
								sum += Double.parseDouble(((String) d).replace(",", "."));
							}
						}
						
						if(sum == 0d){ footerPanel.getTotalValue().setText(""); }
						else { footerPanel.getTotalValue().setText(decimalFormat.format(sum)); }
                	}
                }
            }
       });
   
        
        jScrollPane1.setViewportView(jTable1);
        jTabbedPane1.addTab("Produits", jScrollPane1);
        
        /////////////////////////////////////////
        // Insert Total JPanel 
        ////////////////////////////////////////
        
//        jLabel2.setFont(new Font("Tahoma", 0, 14)); // NOI18N
//        jLabel2.setText("TOTAL : ");
//
//        jLabel3.setFont(new Font("Tahoma", 1, 18)); // NOI18N
//        
//        footerPanel.setBackground(Color.WHITE);
//        GroupLayout jPanel4Layout = new GroupLayout(footerPanel);
//        footerPanel.setLayout(jPanel4Layout);
//        jPanel4Layout.setHorizontalGroup(
//            jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
//            .addGroup(GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
//                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//                .addComponent(jLabel2)
//                .addGap(18, 18, 18)
//                .addComponent(jLabel3)
//                .addGap(40, 40, 40))
//        );
//        jPanel4Layout.setVerticalGroup(
//            jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
//            .addGroup(jPanel4Layout.createSequentialGroup()
//                .addContainerGap()
//                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
//                    .addComponent(jLabel2)
//                    .addComponent(jLabel3))
//                .addContainerGap(24, Short.MAX_VALUE))
//        );

        jMenu1.setIcon(new ImageIcon(getClass().getResource("/img/AdminCatalog.gif"))); // NOI18N
        jMenu1.setText("Vente de Produits");

//        jMenuItem1.setAccelerator(KeyStroke.getKeyStroke(KeyVK_N, InputCTRL_MASK));
        jMenuItem1.setText("Vente Normal");
//        jMenuItem1.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent evt) {
//                jMenuItem1ActionPerformed(evt);
//            }
//        });
        jMenu1.add(jMenuItem1);
        jMenu1.add(jSeparator1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setActionCommand("ordonnance");
        jMenuItem2.setText("Vente sur Ordonnance");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        
        jMenu1.add(jMenuItem2);
        jMenu1.add(jSeparator2);

//        jMenuItem3.setAccelerator(KeyStroke.getKeyStroke(KeyVK_C, InputCTRL_MASK));
        jMenuItem3.setText("Vente à Crédit");
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        jMenu2.setIcon(new ImageIcon(getClass().getResource("/img/AdminPriceRule.gif"))); // NOI18N
        jMenu2.setText("Gestion des  Articles");
        jMenuBar1.add(jMenu2);

        jMenu3.setIcon(new ImageIcon(getClass().getResource("/img/AdminParentCustomer.gif"))); // NOI18N
        jMenu3.setText("Gestion des Clients");
        jMenuBar1.add(jMenu3);

        jMenu4.setIcon(new ImageIcon(getClass().getResource("/img/AdminParentOrders.gif"))); // NOI18N
        jMenu4.setText("Liste des Commandes");
        jMenuBar1.add(jMenu4);

        jMenu5.setIcon(new ImageIcon(getClass().getResource("/img/AdminParentStats.gif"))); // NOI18N
        jMenu5.setText("Statistique Pharmacie");
        jMenuBar1.add(jMenu5);

        
        setJMenuBar(jMenuBar1);
        footerPanel.setBackground(Color.WHITE);
        
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(headerPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTabbedPane1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(footerPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(headerPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jTabbedPane1, GroupLayout.PREFERRED_SIZE, 351, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(footerPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap())
            );
        
        
        KeyStroke escapeKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, false);
        Action escapeAction = new AbstractAction() {
        	public void actionPerformed(ActionEvent e) {
        		PaymentView paymentView = new PaymentView(em, vente);
        		
        		if("".equals(footerPanel.getTotalValue().getText())){
        			JOptionPane.showMessageDialog(jTabbedPane1, "Veuillez séléctionner au moins un produit!");
        		}else{
        			em.getTransaction().begin();
        			vente = em.find(Vente.class, vente.getId());
        			vente.setProduits(products.values());
        			em.getTransaction().commit();
        			
        			headerPanel.getPaiement().activateButton(true);
        			
        			paymentView.getTotal().setText(footerPanel.getTotalValue().getText());
        			paymentView.setVisible(true);
        		}
        	}
        };
        
        KeyStroke f9KeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_F9, 0, false);
        Action f9Action = new AbstractAction() {
        	public void actionPerformed(ActionEvent e) {
        		if("".equals(footerPanel.getTotalValue().getText())){
        			JOptionPane.showMessageDialog(jTabbedPane1, "Veuillez séléctionner au moins un produit!");
        		}else{
        			PosologieFrame posologieFrame = new PosologieFrame(em, vente);
        			
        			em.getTransaction().begin();
        			vente = em.find(Vente.class, vente.getId());
        			vente.setProduits(products.values());
        			em.getTransaction().commit();
        			
        			posologieFrame.setVisible(true);
        		}
        	}
        };
        
        KeyStroke f1KeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0, false);
        Action f1Action = new AbstractAction() {
        	public void actionPerformed(ActionEvent e) {
        		assuranceWidget.getAssurance1().requestFocus();
        	}
        };
        
        KeyStroke f2KeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_F2, 0, false);
        Action f2Action = new AbstractAction() {
        	public void actionPerformed(ActionEvent e) {
        		clientWidget.getFirstName().requestFocus();
        	}
        };
        
        KeyStroke f3KeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_F3, 0, false);
        Action f3Action = new AbstractAction() {
        	public void actionPerformed(ActionEvent e) {
        		clientWidget.getEditButton().requestFocus();
        	}
        };
        
        KeyStroke f4KeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_F4, 0, false);
        Action f4Action = new AbstractAction() {
        	public void actionPerformed(ActionEvent e) {
        		medecinWidget.getFirstName().requestFocus();
        	}
        };
        
        KeyStroke f5KeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_F5, 0, false);
        Action f5Action = new AbstractAction() {
        	public void actionPerformed(ActionEvent e) {
        		medecinWidget.getEditButton().requestFocus();
        	}
        };
        
        KeyStroke f6KeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_F6, 0, false);
        Action f6Action = new AbstractAction() {
        	public void actionPerformed(ActionEvent e) {
        		jTable1.requestFocus();
        		jTable1.editCellAt(0, 0);
//        		jTable1.changeSelection(0, 0, false, false);
        	}
        };
        
        KeyStroke f8KeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_F8, 0, false);
        Action f8Action = new AbstractAction() {
        	public void actionPerformed(ActionEvent e) {
        		SearchProduct searchProduct = new SearchProduct(em, vente);
        		searchProduct.setVisible(true);
        	}
        };
        
        
        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(escapeKeyStroke, "ESCAPE");
        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(f9KeyStroke, "F9");
        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(f1KeyStroke, "F1");
        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(f2KeyStroke, "F2");
        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(f3KeyStroke, "F3");
        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(f4KeyStroke, "F4");
        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(f5KeyStroke, "F5");
        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(f6KeyStroke, "F6");
        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(f8KeyStroke, "F8");
        getRootPane().getActionMap().put("ESCAPE", escapeAction);
        getRootPane().getActionMap().put("F9", f9Action);
        getRootPane().getActionMap().put("F1", f1Action);
        getRootPane().getActionMap().put("F2", f2Action);
        getRootPane().getActionMap().put("F3", f3Action);
        getRootPane().getActionMap().put("F4", f4Action);
        getRootPane().getActionMap().put("F5", f5Action);
        getRootPane().getActionMap().put("F6", f6Action);
        getRootPane().getActionMap().put("F8", f8Action);
        
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }                        

    private void jMenuItem2ActionPerformed(ActionEvent evt) {                                           
        Component[] list1 = clientWidget.getComponents();
        for(Component component : list1){
        	component.setEnabled(true);
        }
    }                                          

            
    public JPanel getjPanel1(){
    	return this.jPanel1;
    }
    
    public AssuranceWidget getAssuranceWidget(){
    	return this.assuranceWidget;
    }
    
    public ClientWidget getClientWidget(){
    	return this.clientWidget;
    }
    
    public MedecinWidget getMedecinWidget(){
    	return this.medecinWidget;
    }
    
    public HeaderPanel getHeaderPanel() {
		return headerPanel;
	}

	public void setHeaderPanel(HeaderPanel headerPanel) {
		this.headerPanel = headerPanel;
	}

	public Vente getVente() {
		return vente;
	}

	public void setVente(Vente vente) {
		this.vente = vente;
	}

	public FooterPanel getFooterPanel() {
		return footerPanel;
	}

	public JTable getjTable1() {
		return jTable1;
	}

	public Operator getOperator() {
		return operator;
	}
	

	public VenteService getVenteService() {
		return venteService;
	}

	public void setVenteService(VenteService venteService) {
		this.venteService = venteService;
	}

	public ProductService getProductService() {
		return productService;
	}

	public Map<Integer, VenteProduit> getProducts() {
		return products;
	}

	public void setProducts(Map<Integer, VenteProduit> products) {
		this.products = products;
	}

	public SortedMap<String, String> getData() {
		return data;
	}

	public void setData(SortedMap<String, String> data) {
		this.data = data;
	}
	
	public void updateProductLine(String selectedValue) {
		
		 final DecimalFormat decimalFormat = new DecimalFormat("0.00");
		 int row = jTable1.getSelectedRow();		 
		Product product = productService.findProductByReference(data.get(selectedValue));
        			 
                	 jTable1.setValueAt(product.getPu(), row, 2);
                	 jTable1.setValueAt(decimalFormat.format(product.getPu() + (product.getPu() * 0.2)), row, 5);
                	 // Mettre la désignation au cas ou c'est le code bare qui est saisi
                	 //comboBox.setSelectedItem(product.getDesignation());
                	 
                	 VenteProduit vp = null;
                	 if(products.get(row) != null){
                		 vp = products.get(row);
                		 vp.setProduct(product);
                		 vp.setDateCreation(new Date());
                	 }else{
                		 vp = new VenteProduit(product);
                		 vp.setVente(vente);
                		 vp.setDateCreation(new Date());
                		 products.put(row, vp);
                	 }
                	 
                	 headerPanel.getProduit().activateButton(true);
                	 
                	 
                	 int rows = jTable1.getRowCount();
                	 double total = 0;
                	 for(int i = 0; i < rows; i++){
                		 Object d = jTable1.getValueAt(i, 5);
                		 if(d != null && !d.toString().equals("")){
                			 total += Double.parseDouble(((String) d).replace(",", "."));
                		 }
                	 }
                	 footerPanel.getTotalValue().setText(decimalFormat.format(total));
	}


	private ClientWidget clientWidget;
    private AssuranceWidget assuranceWidget;
    private MedecinWidget medecinWidget;
    private JMenu jMenu1;
    private JMenu jMenu2;
    private JMenu jMenu3;
    private JMenu jMenu4;
    private JMenu jMenu5;
    private JMenuBar jMenuBar1;
    private JMenuItem jMenuItem1;
    private JMenuItem jMenuItem2;
    private JMenuItem jMenuItem3;
    private JPanel jPanel1;
    private HeaderPanel headerPanel;
    private FooterPanel footerPanel;
    private JScrollPane jScrollPane1;
    private JPopupMenu.Separator jSeparator1;
    private JPopupMenu.Separator jSeparator2;
    private JTabbedPane jTabbedPane1;
    private JTable jTable1;
//    private JLabel jLabel2;
//    private JLabel jLabel3;
    

}