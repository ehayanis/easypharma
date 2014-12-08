package com.mm.app.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.NumberFormat;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import javax.persistence.EntityManager;
import javax.swing.AbstractAction;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;

import com.mm.app.model.Vente;

public class PaymentView extends JFrame {

	private Vente vente;
	private EntityManager em;
	private Map<String, Float> result;
	private Vector<String> listData;
	
    public PaymentView(EntityManager em, Vente vente) {
        this.vente = vente;
        this.em = em;
        result = new HashMap<String, Float>();
        listData = new Vector<String>();
        
    	initComponents();
        ImageIcon img = new ImageIcon(getClass().getResource("/img/logo.png"));
        setIconImage(img.getImage());
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPanel8 = new JPanel();
        jLabel6 = new JLabel();
        total = new JTextField();
        payed = new JTextField();
        jComboBox1 = new JComboBox<String>();
        jScrollPane1 = new JScrollPane();
        jList1 = new JList<String>();
        jButton1 = new JButton();
        rendre = new JTextField();
        jLabel1 = new JLabel();
        annuler = new JButton();
        valider = new JButton();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Paiement");
        setResizable(false);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("TOTAL A PAYER: ");

        total.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N

        jComboBox1.setModel(new DefaultComboBoxModel(new String[] { "Comptant", "Carte de Crédit", "BVR", "Assurance Maladie-Accident" }));

        jScrollPane1.setViewportView(jList1);

        jButton1.setText("...");
        jButton1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent evt) {
				addPaiementTypeAction(evt);
			}
		});

        rendre.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel1.setText("A rendre:");

        annuler.setText("Annuler");

        valider.setText("Valider");
        valider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				validatePayementAction(evt);
			}
		});

        jList1.addKeyListener(new KeyAdapter() {
        	public void keyPressed(KeyEvent ke){
        		if(ke.getKeyCode()==KeyEvent.VK_DELETE){
        			String selectedValue = jList1.getSelectedValue(); 
        			String key = selectedValue.substring(selectedValue.indexOf("(") + 1, selectedValue.indexOf(")"));

        			listData.remove(selectedValue);
        			result.remove(key);
        			
        			jList1.setListData(listData);
        		}
        	}
        });
        
		
        GroupLayout jPanel8Layout = new GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(rendre, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addComponent(payed, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(18, 18, 18)
                                        .addComponent(total))
                                    .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 363, GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(70, 70, 70)
                                .addComponent(annuler, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(valider, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(total))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(payed, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(rendre, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(annuler)
                    .addComponent(valider))
                .addGap(0, 8, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }                      

    public JTextField getTotal() {
		return total;
	}
    
    private void addPaiementTypeAction(ActionEvent evt) {
    	String montant = payed.getText();
    	if(!"".equals(montant)){
    		String selectedItem = (String) jComboBox1.getSelectedItem();
    		Set<String> types = result.keySet();
    		
    		if(types.contains(selectedItem)){
    			JOptionPane.showMessageDialog(this, "Le type " + selectedItem + " est déjà séléctionné");
    		}else{
    			listData.add(montant + " (" + selectedItem + ")");
    			result.put(selectedItem, Float.valueOf(montant));
    			
    			jList1.setListData(listData);
    		}

    	}
	}
     
    private void validatePayementAction(ActionEvent evt) {
    	Collection<Float> values = result.values();
    	Float currentTotal = 0f;
    	for(Float d : values){
    		currentTotal = d + currentTotal;
    		System.out.println("currentTotal " + currentTotal);
    		System.out.println("TOTAL "  + Float.valueOf(total.getText()));
    	}
    	
    	if(currentTotal > Float.valueOf(total.getText())){
    		JOptionPane.showMessageDialog(this, "Le total saisi est suppérieure à ce qui doit être payé");
    	}else if(currentTotal < Float.valueOf(total.getText())){
    		JOptionPane.showMessageDialog(this, "Le total saisi est inférieure à ce qui doit être payé");
    	}else{
    		em.getTransaction().begin();
			vente = em.find(Vente.class, vente.getId());
			for(String key : result.keySet()){
				Float value = result.get(key);
				if("Comptant".equals(key)){
					vente.setPaiementCheque(value);
				}else if("Carte de Crédit".equals(key)){
					vente.setPaiementCarte(value);
				}else if("BVR".equals(key)){
					vente.setPaiementBvr(value);
				}else{
					vente.setPaiementAssurance(value);
				}
			}
			vente.setStatus("COMPLETE");
			em.getTransaction().commit();
			
			setVisible(false);
			dispose();
    	}
    }
    
	private JButton jButton1;
    private JButton annuler;
    private JButton valider;
    private JComboBox<String> jComboBox1;
    private JLabel jLabel1;
    private JLabel jLabel6;
    private JList<String> jList1;
    private JPanel jPanel8;
    private JScrollPane jScrollPane1;
    private JTextField payed;
    private JTextField rendre;
    private JTextField total;
}
 