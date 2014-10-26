package com.mm.app.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.AbstractAction;
import javax.swing.DefaultCellEditor;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JPopupMenu.Separator;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.LayoutStyle;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.mm.app.model.Product;
import com.mm.app.service.ProductService;
import com.mm.app.service.impl.ProductServiceImpl;
import com.mm.app.utilities.Java2sAutoComboBox;

/**
 *
 * @author A574266
 */
public class SaleView extends JFrame {

	private static final long serialVersionUID = 6431174577095592545L;
	
	private EntityManagerFactory emf;
	private EntityManager em;
	private ProductService productService; 
    
	public SaleView() {
    	emf = Persistence.createEntityManagerFactory("easypharma");
    	em = emf.createEntityManager();
        
    	productService = new ProductServiceImpl(em);
    	
    	initComponents();
        getContentPane().setBackground(Color.WHITE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        ImageIcon img = new ImageIcon(getClass().getResource("/img/logo.png"));
        setIconImage(img.getImage());
        
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPanel1 = new JPanel();
        jInternalFrame4 = new MedecinWidget(em);
        jInternalFrame3 = new AssuranceWidget(em);
        clientWidget = new ClientWidget(em);
        jPanel2 = new HeaderPanel();
        jTabbedPane1 = new JTabbedPane();
        jScrollPane1 = new JScrollPane();
        jTable1 = new JTable();
        jPanel4 = new JPanel();
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
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        
        
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("EasyPharma: Gestion Pharmacies ");
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        setFont(new Font("Agency FB", 0, 11)); // NOI18N
        
        
        jPanel1.setLayout(new GridLayout(1, 3, 10, 0));

        jPanel1.add(jInternalFrame3);
        jPanel1.add(clientWidget);
        jPanel1.add(jInternalFrame4);
        
        jPanel1.setBackground(Color.WHITE);
        
        jTable1.setModel(new DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
            		"Libellé", "Facture", "Référence", "Taux", "Base", "PU TTC", "Qté", "Remise", "Part Client", "Total"
            }
        ));
        jTable1.setRowHeight(22);
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(230);
      
        
//        ArrayList<String> data = new ArrayList<String>();
        final Map<String, String> data = new HashMap<String, String>();
        data.put("", "");
        List<Product> result = productService.getProducts();
		if(result != null && result.size() > 0){
			for(Product p : result){
				data.put(p.getDesignation(), p.getReference());
			}
		}
        
        final Java2sAutoComboBox comboBox = new Java2sAutoComboBox(data);
        comboBox.setDataList(data);
        comboBox.setMaximumRowCount(3);
        
        comboBox.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
        	@Override
        	public void keyPressed(KeyEvent e) {
        		 if (e.getKeyChar() == KeyEvent.VK_ENTER) {
        			 int row = jTable1.getSelectedRow();
        			 String selectedValue = (String) comboBox.getSelectedItem();
        			 Product product = productService.findProductByReference(data.get(selectedValue));
                	 jTable1.setValueAt(product.getReference(), row, 2);
                	 jTable1.setValueAt(product.getPu(), row, 5);
                	 jTable1.setValueAt(product.getQuantity(), row, 6);
                	 jTable1.setValueAt(product.getPu() + (product.getPu() * 0.2), row, 9);
                	 
                	 int rows = jTable1.getRowCount();
                	 double total = 0;
                	 for(int i = 0; i < rows; i++){
                		 Object d = jTable1.getValueAt(i, 9);
                		 if(d != null){
                			 total += (Double)d; 
                		 }
                		 
                	 }
                	 
                	 jLabel3.setText(String.valueOf(total));
             }
        	}
		});
        
        TableColumn column = jTable1.getColumnModel().getColumn(0);
        column.setCellEditor(new DefaultCellEditor(comboBox));
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setToolTipText("Séléctionner un produit");
        column.setCellRenderer(renderer);
        
        
        TableColumn factureColumn = jTable1.getColumnModel().getColumn(1);
        JComboBox<String> facture = new JComboBox<String>();
        facture.addItem("Comptoire");
        facture.addItem("Assurance");
        factureColumn.setCellEditor(new DefaultCellEditor(facture));

		JPopupMenu popupMenu = new JPopupMenu();
//		JMenuItem posologieItem = new JMenuItem("Posologie");
//		posologieItem.setIcon(new ImageIcon(getClass().getResource("/img/view.gif")));
		JMenuItem deleteItem = new JMenuItem("Supprimer");
		deleteItem.setIcon(new ImageIcon(getClass().getResource("/img/delete.gif")));
		
		Separator jSeparator12 = new Separator();
		
//		popupMenu.add(posologieItem);
		popupMenu.add(jSeparator12);
		popupMenu.add(deleteItem);
		
//		posologieItem.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent event) {
//				JFrame posologieFrame = new PosologieFrame();
//		        posologieFrame.setVisible(true);	
//			}
//		});

		jTable1.setComponentPopupMenu(popupMenu);

        
        jScrollPane1.setViewportView(jTable1);
        jTabbedPane1.addTab("Produits", jScrollPane1);
        
        /////////////////////////////////////////
        // Insert Total JPanel 
        ////////////////////////////////////////
        
        jLabel2.setFont(new Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("TOTAL : ");

        jLabel3.setFont(new Font("Tahoma", 1, 18)); // NOI18N
        
        jPanel4.setBackground(Color.WHITE);
        GroupLayout jPanel4Layout = new GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(40, 40, 40))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addContainerGap(24, Short.MAX_VALUE))
        );

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

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTabbedPane1)
            .addComponent(jPanel4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jTabbedPane1, GroupLayout.PREFERRED_SIZE, 351, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap())
            );
        
        
        KeyStroke escapeKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, false);
        javax.swing.Action escapeAction = new AbstractAction() {
        	public void actionPerformed(ActionEvent e) {
        		PaymentView paymentView = new PaymentView();
        		
        		if("".equals(jLabel3.getText())){
        			JOptionPane.showMessageDialog(jTabbedPane1, "Veuillez séléctionner au moins un produit!");
        		}else{
        			paymentView.getTotal().setText(jLabel3.getText());
        			paymentView.setVisible(true);
        		}
        	}
        };
        
        KeyStroke f9KeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_F9, 0, false);
        javax.swing.Action f9Action = new AbstractAction() {
        	public void actionPerformed(ActionEvent e) {
        		PosologieFrame posologieFrame = new PosologieFrame();
        		posologieFrame.setVisible(true);
        		
//        		if("".equals(jLabel3.getText())){
//        			JOptionPane.showMessageDialog(jTabbedPane1, "Veuillez séléctionner au moins un produit!");
//        		}else{
//        		}
        	}
        };
        
        
        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(escapeKeyStroke, "ESCAPE");
        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(f9KeyStroke, "F9");
        getRootPane().getActionMap().put("ESCAPE", escapeAction);
        getRootPane().getActionMap().put("F9", f9Action);
        
    
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }                        

    private void jMenuItem2ActionPerformed(ActionEvent evt) {                                           
        Component[] list1 = clientWidget.getComponents();
        for(Component component : list1){
        	component.setEnabled(true);
        }
    }                                          

            
    public static void main(String args[]) {
        try {
//            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        	 UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
        	 UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
        } catch (Exception ex) {
            
        } 
       
        new SaleView().setVisible(true);
         
    }
    
    public JPanel getjPanel1(){
    	return this.jPanel1;
    }
    
    public JInternalFrame getjInternalFrame3(){
    	return this.jInternalFrame3;
    }
    
    public JInternalFrame getClientWidget(){
    	return this.clientWidget;
    }

    private JInternalFrame clientWidget;
    private JInternalFrame jInternalFrame3;
    private JInternalFrame jInternalFrame4;
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
    private JPanel jPanel2;
    private JPanel jPanel4;
    private JScrollPane jScrollPane1;
    private JPopupMenu.Separator jSeparator1;
    private JPopupMenu.Separator jSeparator2;
    private JTabbedPane jTabbedPane1;
    private JTable jTable1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    

}
