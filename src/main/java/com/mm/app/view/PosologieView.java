package com.mm.app.view;

import static javax.swing.GroupLayout.Alignment.LEADING;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;

import com.mm.app.model.Product;
import com.mm.app.model.Vente;
import com.mm.app.model.VenteProduit;
import com.mm.app.service.ProductService;
import com.mm.app.service.impl.ProductServiceImpl;
import com.mm.app.utilities.PrintPosologie;
import com.mm.app.utilities.SubProductTableModel;

public class PosologieView extends JFrame {

	private static final long serialVersionUID = -3526624075858283471L;
	
	private EntityManager em;
	private Vente vente;
	private Collection<VenteProduit> venteProduits;
	private List<Product> products;
	private ProductService service;
	private String productIdentifier = "";
	private PrintPosologie printPosologie;
	
	public PosologieView(EntityManager em, Vente vente) {
		this.em = em;
    	this.vente = vente;
    	this.printPosologie = new PrintPosologie();
    	products = new ArrayList<Product>();
    	
    	venteProduits = vente.getProduits();
    	
    	for(VenteProduit venteProduit : venteProduits){
    		products.add(venteProduit.getProduct());
    	}
		
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setTitle("Posologie");
		setResizable(false);
		initComponents();
		buildView();
		ImageIcon img = new ImageIcon(getClass().getResource("/img/logo.png"));
		setIconImage(img.getImage());
		setBackground(Color.WHITE);
		pack();
		setLocationRelativeTo(null);
	}

	private void initComponents() {
		
		int jTabbedPaneW = 790;

		/*********************** Codex-Posologie === initialisation === */
		jTabbedPane1 = new JTabbedPane();
		jPanel1 = new JPanel();
		jScrollPane1 = new JScrollPane();
		jTextArea1 = new JTextArea();

		jTextArea1.setColumns(20);
		jTextArea1.setRows(3);

		jScrollPane1.setViewportView(jTextArea1);
		GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, jTabbedPaneW, Short.MAX_VALUE));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)));

		jTabbedPane1.addTab("Codex-Posologie", jPanel1);

		/*********************** Codex-Contreindications === initialisation === */
		jTabbedPane2 = new JTabbedPane();
		jPanel2 = new JPanel();
		jScrollPane2 = new JScrollPane();
		jTextArea2 = new JTextArea();

		jTextArea2.setColumns(20);
		jTextArea2.setRows(3);

		jScrollPane2.setViewportView(jTextArea2);
		GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(jScrollPane2, GroupLayout.DEFAULT_SIZE, jTabbedPaneW/2, Short.MAX_VALUE));
		jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel2Layout.createSequentialGroup()
						.addComponent(jScrollPane2, GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)));

		jTabbedPane2.addTab("Codex-Contreindications", jPanel2);
		
		/*********************** Avertissement Client === initialisation === */
		jTabbedPane3 = new JTabbedPane();
		jPanel3 = new JPanel();
		jScrollPane3 = new JScrollPane();
		jTextArea3 = new JTextArea();

		jTextArea3.setColumns(20);
		jTextArea3.setRows(3);

		jScrollPane3.setViewportView(jTextArea3);
		GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
		jPanel3.setLayout(jPanel3Layout);
		jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(jScrollPane3, GroupLayout.DEFAULT_SIZE, jTabbedPaneW/2, Short.MAX_VALUE));
		jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel3Layout.createSequentialGroup()
						.addComponent(jScrollPane3, GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)));

		jTabbedPane3.addTab("Avertissement Client", jPanel3);
		
		/*********************** Liste Produits === initialisation === */
		jTabbedPane4 = new JTabbedPane();
		jPanel4 = new JPanel();
		jTable4 = new JTable();
		AbstractTableModel model = new SubProductTableModel(products);
		jTable4.setModel(model);
		jTable4.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				jTextFieldProduit.setText( jTable4.getValueAt(jTable4.getSelectedRow(), 1).toString());
				jLabelDate.setText(new SimpleDateFormat( "dd.MM.yyyy").format(Calendar.getInstance().getTime()));
				printPosologie.setProduit(jTextFieldProduit.getText());
				
			}
		});
		jScrollPane4 = new JScrollPane();
		
		jTable4.setPreferredScrollableViewportSize(new java.awt.Dimension(jTabbedPaneW, 82));
		jScrollPane4.setViewportView(jTable4);
		GroupLayout jPanel4Layout = new GroupLayout(jPanel4);
		jPanel4.setLayout(jPanel4Layout);
		jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(jScrollPane4, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE));
		jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel4Layout.createSequentialGroup()
						.addComponent(jScrollPane4, GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)));
		jTabbedPane4.addTab("Liste Produits", jScrollPane4);
		
		/*********************** Construction posologie === initialisation === */
		jTabbedPane5 = new JTabbedPane();
		jPanel5 = new JPanel();
		jTextArea5 = new JTextArea();
		
		jPanel51 = new JPanel();
		jLabelQte = new JLabel("Quantité");
		SpinnerNumberModel spinnerModelQte =  new SpinnerNumberModel(1, 1, 100, 1);
		jSpinnerQte = new JSpinner(spinnerModelQte);
		jSpinnerQte.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				setPosologieText();
			}
		});
		jLabelFome = new JLabel("Forme: ");
		String[] vFormes = {"ampoule","application","bain","capsule","comprimé","cuillère"};
		jComboForme = new JComboBox<String>(vFormes) ;
		jComboForme.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setPosologieText();
			}
		});
		jLabelDosage = new JLabel("Dosage");
		SpinnerNumberModel spinnerModelDose =  new SpinnerNumberModel(0, 0, 100, 1);
		jSpinnerDose = new JSpinner(spinnerModelDose);
		jSpinnerDose.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				setPosologieText();
			}
		});
		String[] vPeriodes = {"","par jour","5 jours sur 7","à midi","le soir","le matin","fois par jour"};
		jComboPeriod = new JComboBox<String>(vPeriodes);
		jComboPeriod.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setPosologieText();
			}
		});
		String[] vRepas = {"","15min avant les repas","1h avant les repas","20min avant les repas","2h avant les repas","à jeun"};
		jComboRepas = new JComboBox<String>(vRepas);
		jComboRepas.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setPosologieText();
			}
		});
		jCheckBoxMatin = new JCheckBox("Matin");
		jCheckBoxMatin.setHorizontalTextPosition(SwingConstants.LEFT);
		jCheckBoxMidi = new JCheckBox("Midi");
		jCheckBoxMidi.setHorizontalTextPosition(SwingConstants.LEFT);
		jCheckBoxSoir = new JCheckBox("Soir");
		jCheckBoxSoir.setHorizontalTextPosition(SwingConstants.LEFT);
		jCheckBoxNuit = new JCheckBox("Nuit");
		jCheckBoxNuit.setHorizontalTextPosition(SwingConstants.LEFT);
		jLabelDuree = new JLabel("Durée");
		SpinnerNumberModel spinnerModelDuree =  new SpinnerNumberModel(1, 1, 100, 1);
		jSpinnerDuree = new JSpinner(spinnerModelDuree);
		jSpinnerDuree.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				setPosologieText();
			}
		});
		jLabelJours = new JLabel("jour(s)");
		jLabelNom = new JLabel("Prénom et Nom");
		String[] vGenres = {"M. ","Mme. ","Mlle. "};
		jComboGenre = new JComboBox<String>(vGenres);
		jTextFieldNom = new JTextField();
		jTextFieldNom.setPreferredSize(new Dimension(150, jTextFieldNom.getHeight()));
		jTextFieldNom.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				jLabelClientNom.setText(jComboGenre.getSelectedItem().toString()+" "+ jTextFieldNom.getText());
				printPosologie.setPatientName(jLabelClientNom.getText());
				
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		jLabelServi = new JLabel("Servi par ");
		jTextFieldServi = new JTextField();
		jTextFieldServi.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				jLabelPharmacienNom.setText(jTextFieldServi.getText());
				printPosologie.setPharmacienName(jLabelPharmacienNom.getText());
				
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		

		jTextArea5.setColumns(20);
		jTextArea5.setRows(3);

		GroupLayout jPanel5Layout = new GroupLayout(jPanel51);
		jPanel51.setLayout(jPanel5Layout);
		jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(LEADING)
				.addGroup(jPanel5Layout.createSequentialGroup()
						.addComponent(jLabelQte)
						.addGap(20, 20, 20)
						.addComponent(jSpinnerQte)
						.addGap(20, 20, 20)
						.addComponent(jLabelFome)
						.addGap(20, 20, 20)
						.addComponent(jComboForme))
				.addGap(20, 20, 20)
				
				.addGroup(jPanel5Layout.createSequentialGroup()
						.addComponent(jLabelDosage)
						.addGap(20, 20, 20)
						.addComponent(jSpinnerDose)
						.addGap(20, 20, 20)
						.addComponent(jComboPeriod))
				.addGap(20, 20, 20)
				
				.addGroup(jPanel5Layout.createSequentialGroup()
						.addGap(50, 50, 50)
						.addComponent(jComboRepas)
						.addGap(100, 100, 100))
				.addGap(20, 20, 20)
				
				.addGroup(jPanel5Layout.createSequentialGroup()
						.addComponent(jCheckBoxMatin)
						.addGap(20, 20, 20)
						.addComponent(jCheckBoxMidi)
						.addGap(20, 20, 20)
						.addComponent(jCheckBoxSoir)
						.addGap(20, 20, 20)
						.addComponent(jCheckBoxNuit))
				.addGap(20, 20, 20)
				
				.addGroup(jPanel5Layout.createSequentialGroup()
						.addComponent(jLabelDuree)
						.addGap(20, 20, 20)
						.addComponent(jSpinnerDuree)
						.addGap(20, 20, 20)
						.addComponent(jLabelJours)
						.addGap(100, 100, 100))
				.addGap(20, 20, 20)
				
				.addGroup(jPanel5Layout.createSequentialGroup()
						.addComponent(jLabelNom)
						.addGap(20, 20, 20)
						.addComponent(jComboGenre)
						.addGap(20, 20, 20)
						.addComponent(jTextFieldNom))
				.addGap(20, 20, 20)
				
				.addGroup(jPanel5Layout.createSequentialGroup()
						.addComponent(jLabelServi)
						.addGap(20, 20, 20)
						.addComponent(jTextFieldServi)));
		jPanel5Layout.setVerticalGroup(jPanel5Layout.createSequentialGroup()
				.addGroup(jPanel5Layout.createParallelGroup()
						.addComponent(jLabelQte)
						.addGap(20, 20, 20)
						.addComponent(jSpinnerQte)
						.addGap(20, 20, 20)
						.addComponent(jLabelFome)
						.addGap(20, 20, 20)
						.addComponent(jComboForme))
				.addGap(10, 10, 10)
				
				.addGroup(jPanel5Layout.createParallelGroup()
						.addComponent(jLabelDosage)
						.addGap(20, 20, 20)
						.addComponent(jSpinnerDose)
						.addGap(20, 20, 20)
						.addComponent(jComboPeriod))
				.addGap(10, 10, 10)
				
				.addGroup(jPanel5Layout.createParallelGroup()
						.addGap(20, 20, 20)
						.addComponent(jComboRepas))
				.addGap(10, 10, 10)
				
				.addGroup(jPanel5Layout.createParallelGroup()
						.addComponent(jCheckBoxMatin)
						.addGap(20, 20, 20)
						.addComponent(jCheckBoxMidi)
						.addGap(20, 20, 20)
						.addComponent(jCheckBoxSoir)
						.addGap(20, 20, 20)
						.addComponent(jCheckBoxNuit))
				.addGap(10, 10, 10)
				
				.addGroup(jPanel5Layout.createParallelGroup()
						.addComponent(jLabelDuree)
						.addGap(20, 20, 20)
						.addComponent(jSpinnerDuree)
						.addGap(20, 20, 20)
						.addComponent(jLabelJours))
				.addGap(10, 10, 10)
				
				.addGroup(jPanel5Layout.createParallelGroup()
						.addComponent(jLabelNom)
						.addGap(20, 20, 20)
						.addComponent(jComboGenre)
						.addGap(20, 20, 20)
						.addComponent(jTextFieldNom))
				.addGap(10, 10, 10)
				
				.addGroup(jPanel5Layout.createParallelGroup()
						.addComponent(jLabelServi)
						.addGap(20, 20, 20)
						.addComponent(jTextFieldServi)));
		jPanel5.add(jPanel51);
		
		jTabbedPane5.addTab("Posologie", jPanel5);
		
		/*********************** Apérçu posologie === initialisation === */
		jTabbedPane6 = new JTabbedPane();
		jPanel6 = new JPanel();
		jPanel61 = new JPanel();
		jLabelClientNom = new JLabel();
		Font boldFont = new Font(jLabelClientNom.getFont().getFontName(),Font.BOLD,jLabelClientNom.getFont().getSize());
		Font smallFont = new Font(jLabelClientNom.getFont().getFontName(),Font.PLAIN,jLabelClientNom.getFont().getSize()-3);
		Font smallBoldFont = new Font(jLabelClientNom.getFont().getFontName(),Font.BOLD,jLabelClientNom.getFont().getSize()-3);
		jLabelClientNom.setFont(boldFont);
		jScrollPane6 = new JScrollPane();
		jTextArea6 = new JTextArea(5,20);
		jTextArea6.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		jTextArea6.setLineWrap(true);
		jTextArea6.setWrapStyleWord(true);
		jScrollPane6.setViewportView(jTextArea6);
		jTextFieldProduit = new JTextField(15);
		jTextFieldProduit.setFont(smallFont);
		jTextFieldProduit.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		jLabelDate = new JLabel();
		jLabelDate.setFont(smallFont);
		jLabelPosFooterL1 = new JLabel("PHARMACIE de Villereuse");
		jLabelPosFooterL1.setFont(smallBoldFont);
		jLabelPosFooterL2 = new JLabel("Rue de la Terrassiére 32 1207 Genéve ");
		jLabelPosFooterL2.setFont(smallFont);
		jLabelPosFooterL3 = new JLabel("T. Shoul Pharmacien Resp. 022 700 47 89  ");
		jLabelPosFooterL3.setFont(smallFont);
		jLabelPharmacienNom = new JLabel();
		jLabelPharmacienNom.setFont(smallFont);
		GroupLayout jPanel6Layout = new GroupLayout(jPanel61);
		jPanel61.setLayout(jPanel6Layout);
		jPanel6Layout.setHorizontalGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel6Layout.createSequentialGroup()
						.addGap(50, 50, 50)
						.addComponent(jLabelClientNom))
				
				.addGroup(jPanel6Layout.createSequentialGroup()
						.addComponent(jScrollPane6))
				
				.addGroup(jPanel6Layout.createSequentialGroup()
						.addComponent(jTextFieldProduit)
						.addComponent(jLabelDate))
				
				.addGroup(jPanel6Layout.createSequentialGroup()
						.addComponent(jLabelPosFooterL1))
				
				.addGroup(jPanel6Layout.createSequentialGroup()
						.addComponent(jLabelPosFooterL2))
				
				.addGroup(jPanel6Layout.createSequentialGroup()
						.addComponent(jLabelPosFooterL3)
						.addComponent(jLabelPharmacienNom)));
		jPanel6Layout.setVerticalGroup(jPanel6Layout.createSequentialGroup()
				.addGap(10, 10, 10)
				.addGroup(jPanel6Layout.createParallelGroup()
						.addComponent(jLabelClientNom))
				
				.addGap(10, 10, 10)
				.addGroup(jPanel6Layout.createParallelGroup()
						.addComponent(jScrollPane6))
				
				.addGap(10, 10, 10)
				.addGroup(jPanel6Layout.createParallelGroup()
						.addComponent(jTextFieldProduit)
						.addComponent(jLabelDate))
				
				.addGroup(jPanel6Layout.createParallelGroup()
						.addComponent(jLabelPosFooterL1))
				
				.addGroup(jPanel6Layout.createParallelGroup()
						.addComponent(jLabelPosFooterL2))
				
				.addGroup(jPanel6Layout.createParallelGroup()
						.addComponent(jLabelPosFooterL3)
						.addComponent(jLabelPharmacienNom)));

		jPanel61.setBackground(Color.WHITE);
		jPanel6.add(jPanel61);
		jPanel6.setBackground(Color.WHITE);
		jTabbedPane6.addTab("Aperçu posologie", jPanel6);
		
		/*********************** Boutons === initialisation === */
		jPanel7 = new JPanel();
		jLabel7 = new JLabel();
		printBtn = new JButton();
		saveBtn = new JButton();
		
		saveBtn.setText("Enregistrer");
		printBtn.setText("Imprimer");
		printBtn.addActionListener(printPosologie);
		jLabel7.setText("F1 pour sauvegarder une etiquette");
		jLabel7.setFont(new java.awt.Font("Tahoma", 1, 13));
		jLabel7.setForeground(Color.RED);
		
		GroupLayout jPanel7Layout = new GroupLayout(jPanel7);
		jPanel7.setLayout(jPanel7Layout);
		jPanel7Layout.setHorizontalGroup(jPanel7Layout.createSequentialGroup()
				.addComponent(jLabel7)
				.addGap(400, 400, 400)
				.addComponent(printBtn)
				.addGap(20, 20, 20)
				.addComponent(saveBtn));
		jPanel7Layout.setVerticalGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(jLabel7)
				.addComponent(printBtn)
				.addComponent(saveBtn));

	}

	private void buildView() {
		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);

		layout.setHorizontalGroup(layout.createParallelGroup(LEADING)
				.addComponent(jTabbedPane4)
				.addComponent(jTabbedPane1)
				.addGroup(layout.createSequentialGroup()
						.addComponent(jTabbedPane2)
						.addComponent(jTabbedPane3))
				.addGroup(layout.createSequentialGroup()
						.addComponent(jTabbedPane5)
						.addComponent(jTabbedPane6))
				.addComponent(jPanel7));

		layout.setVerticalGroup(layout.createSequentialGroup()
				.addComponent(jTabbedPane4)
				.addComponent(jTabbedPane1)
				.addGroup(layout.createParallelGroup()
						.addComponent(jTabbedPane2)
						.addComponent(jTabbedPane3))
				.addGroup(layout.createParallelGroup()
						.addComponent(jTabbedPane5)
						.addComponent(jTabbedPane6))
				.addComponent(jPanel7));
	}
	
	public void setPosologieText(){
		String vQte = jSpinnerQte.getValue().toString()+" ";
		String vForme = jComboForme.getSelectedItem().toString()+(new Long(jSpinnerQte.getValue().toString()) > 1 ? "s ":" ");
		String vDose = new Long(jSpinnerDose.getValue().toString()) > 0 ? jSpinnerDose.getValue().toString()+" " : "";
		String vPeriod = jComboPeriod.getSelectedItem().toString().length() > 0 ? jComboPeriod.getSelectedItem().toString()+" " : "";
		String vRepas = jComboRepas.getSelectedItem().toString().length() > 0 ? jComboRepas.getSelectedItem().toString()+" " : "";
		String vPendant = "pendant ";
		String vDuree = jSpinnerDuree.getValue().toString();
		String vJours = new Long(jSpinnerDuree.getValue().toString()) > 1 ? " jours" : " jour";
		jTextArea6.setText(vQte+vForme+vDose+vPeriod+vRepas+vPendant+vDuree+vJours);
		printPosologie.setPosologieLines(jTextArea6.getText().split(" "));
	}

	/** Codex-Contreindications === variables === */
	private JTabbedPane jTabbedPane1;
	private JPanel jPanel1;
	private JScrollPane jScrollPane1;
	private JTextArea jTextArea1;

	/** Codex-Contreindications === variables === */
	private JTabbedPane jTabbedPane2;
	private JPanel jPanel2;
	private JScrollPane jScrollPane2;
	private JTextArea jTextArea2;
	
	/** Avertissement Client === variables === */
	private JTabbedPane jTabbedPane3;
	private JPanel jPanel3;
	private JScrollPane jScrollPane3;
	private JTextArea jTextArea3;
	
	/** Liste Produits === variables === */
	private JTabbedPane jTabbedPane4;
	private JPanel jPanel4;
	private JTable jTable4;
	private JScrollPane jScrollPane4;
	
	/** Constructio posologie === variables === */
	private JTabbedPane jTabbedPane5;
	private JPanel jPanel5;
	private JTextArea jTextArea5;
	private JPanel jPanel51;
	private JLabel jLabelQte;
	private JSpinner jSpinnerQte;
	private JLabel jLabelFome;
	private JComboBox<String> jComboForme;
	private JLabel jLabelDosage;
	private JSpinner jSpinnerDose;
	private JComboBox<String> jComboPeriod;
	private JComboBox<String> jComboRepas;
	private JCheckBox jCheckBoxMatin;
	private JCheckBox jCheckBoxMidi;
	private JCheckBox jCheckBoxSoir;
	private JCheckBox jCheckBoxNuit;
	private JLabel jLabelDuree;
	private JSpinner jSpinnerDuree;
	private JLabel jLabelJours;
	private JLabel jLabelNom;
	private JComboBox<String> jComboGenre;
	private JTextField jTextFieldNom;
	private JLabel jLabelServi;
	private JTextField jTextFieldServi;
	
	
	
	/** Aperçu posologie === variables === */
	private JTabbedPane jTabbedPane6;
	private JPanel jPanel6;
	private JPanel jPanel61;
	private JScrollPane jScrollPane6;
	private JLabel jLabelClientNom;
	private JTextArea jTextArea6;
	private JTextField jTextFieldProduit;
	private JLabel jLabelDate;
	private JLabel jLabelPosFooterL1;
	private JLabel jLabelPosFooterL2;
	private JLabel jLabelPosFooterL3;
	private JLabel jLabelPharmacienNom;
	
	/** Boutons === variables === */
	private JPanel jPanel7;
	private JLabel jLabel7;
	private JButton printBtn;
	private JButton saveBtn;
	
	

}
