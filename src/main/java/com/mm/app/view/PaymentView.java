package com.mm.app.view;

import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.Vector;

import javax.persistence.EntityManager;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.mm.app.model.Product;
import com.mm.app.model.Vente;
import com.mm.app.model.VenteProduit;
import com.mm.app.utilities.Java2sAutoComboBox;
import com.mm.app.utilities.MedicamentCellEditor;

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
		setBackground(Color.WHITE);
	}

	@SuppressWarnings("unchecked")
	private void initComponents() {

		jPanel8 = new MyJPanel();
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

		jComboBox1.setModel(new DefaultComboBoxModel(new String[] { "Comptant", "Carte de Cr�dit", "BVR", "Assurance Maladie-Accident" }));

		jScrollPane1.setViewportView(jList1);

		jButton1.setText("...");
		jButton1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent evt) {
				addPaiementTypeAction(evt);
			}
		});

		rendre.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
		rendre.setText("0");
		jLabel1.setText("A rendre:");

		annuler.setText("Annuler");
		annuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				cancelActionPerformed(evt);	
			}
		});

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

					if(selectedValue.contains("Comptant")){
						rendre.setText("0");
					}

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

	public JTextField getTotal() {
		return total;
	}

	private void addPaiementTypeAction(ActionEvent evt) {
		String montant = payed.getText();
		if(!"".equals(montant)){
			final DecimalFormat decimalFormat = new DecimalFormat("0.00");
			String selectedItem = (String) jComboBox1.getSelectedItem();
			Set<String> types = result.keySet();

			if(types.contains(selectedItem)){
				JOptionPane.showMessageDialog(this, "Le type " + selectedItem + " est d�j� s�l�ctionn�");
			}else{
				if("Comptant".equalsIgnoreCase(selectedItem)){
					Collection<Float> values = result.values();
					Float currentTotal = 0f;
					for(Float d : values){
						currentTotal = d + currentTotal;
					}

					Float sum = Float.valueOf(total.getText().replace(",", "."));
					currentTotal += Float.valueOf(montant.replace(",", "."));
					if(currentTotal > sum){
						float arendre = currentTotal - sum;
						rendre.setText(decimalFormat.format(arendre));
					}

				}
				listData.add(montant + " (" + selectedItem + ")");
				result.put(selectedItem, Float.valueOf(montant.replace(",", ".")));

				jList1.setListData(listData);
			}

		}
	}

	private void cancelActionPerformed(ActionEvent evt){
		setVisible(false);
		dispose();
	}

	private void validatePayementAction(ActionEvent evt) {
		Collection<Float> values = result.values();
		Float currentTotal = 0f;
		for(Float d : values){
			currentTotal = d + currentTotal;
		}

		if(currentTotal < Float.valueOf(total.getText().replace(",", "."))){
			JOptionPane.showMessageDialog(this, "Le total saisi est inf�rieure � ce qui doit �tre pay�");
		}else{
			em.getTransaction().begin();
			vente = em.find(Vente.class, vente.getId());
			for(String key : result.keySet()){
				Float value = result.get(key);
				if("Comptant".equals(key)){
					vente.setPaiementCheque(value);
				}else if("Carte de Cr�dit".equals(key)){
					vente.setPaiementCarte(value);
				}else if("BVR".equals(key)){
					vente.setPaiementBvr(value);
				}else{
					vente.setPaiementAssurance(value);
				}
			}
			vente.setStatus("COMPLETE");
			em.getTransaction().commit();
			for (Frame frame : Frame.getFrames()) {
				if (frame.getTitle().equals("EasyPharma: Gestion Pharmacies ")) {
					final SaleView saleView = (SaleView) frame;

					vente = new Vente();
					vente.setOperator(saleView.getOperator());
					vente.setStatus("INIT");
					vente.setDateCreation(new Date());
					vente = saleView.getVenteService().addVente(vente);
					saleView.setVente(vente);

					saleView.getAssuranceWidget().getAssurance1().setText("");
					saleView.getAssuranceWidget().getAssurance2().setText("");
					saleView.getAssuranceWidget().getAssurance3().setText("");
					saleView.getAssuranceWidget().getHiddenField1().setText("");
					saleView.getAssuranceWidget().getHiddenField2().setText("");
					saleView.getAssuranceWidget().getHiddenField3().setText("");
					saleView.getAssuranceWidget().getEditAssur1().setEnabled(false);
					saleView.getAssuranceWidget().getEditAssur2().setEnabled(false);
					saleView.getAssuranceWidget().getEditAssur3().setEnabled(false);
					saleView.getAssuranceWidget().setVente(vente);

					saleView.getClientWidget().getDateOfBirth().setText("");
					saleView.getClientWidget().getReference().setText("");
					saleView.getClientWidget().getFirstName().setSelectedItem("");
					saleView.getClientWidget().getAge().setText("");
					saleView.getClientWidget().getPhone().setText("");
					saleView.getClientWidget().setVente(vente);

					saleView.getMedecinWidget().getFirstName().setSelectedItem("");
					saleView.getMedecinWidget().getSpeciality().setText("");
					saleView.getMedecinWidget().getReference().setText("");
					saleView.getMedecinWidget().getPhone().setText("");
					saleView.getMedecinWidget().getNrcc().setText("");
					saleView.getMedecinWidget().setVente(vente);

					saleView.getHeaderPanel().getClient().activateButton(false);
					saleView.getHeaderPanel().getProduit().activateButton(false);
					saleView.getHeaderPanel().getPaiement().activateButton(false);
					saleView.getHeaderPanel().getImpression().activateButton(false);

					saleView.getFooterPanel().getTotalValue().setText("");

					saleView.getjTable1().setModel(new DefaultTableModel(
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
									"D�signation", "Liste Remb.", "PU TTC", "Qt�", "Remise", "Total"
							}
							));

					saleView.getjTable1().setRowHeight(22);
					saleView.getjTable1().getColumnModel().getColumn(0).setPreferredWidth(230);

					SortedMap<String, String> data = new TreeMap<String, String>();
					data.put("", "");
					Product product = new Product();
					product.setDesignation("designattion");
					product.setId(1);
					product.setReference("1234");
					//			        List<Product> result = new ArrayList<Product>();
					//			        result.add(product);
					List<Product> result = saleView.getProductService().getProducts();

					if(result != null && result.size() > 0){
						for(Product p : result){
							data.put(p.getDesignation(), p.getReference());
							data.put(p.getReference(), p.getReference());
						}
					}


					final DecimalFormat decimalFormat = new DecimalFormat("0.00");


					TableColumn column = saleView.getjTable1().getColumnModel().getColumn(0);
					column.setCellEditor(new MedicamentCellEditor(data.keySet(),saleView));
					DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
					renderer.setToolTipText("S�l�ctionner un produit");
					column.setCellRenderer(renderer);

					//			        TableColumn factureColumn = jTable1.getColumnModel().getColumn(1);
					//			        JComboBox<String> facture = new JComboBox<String>();
					//			        facture.addItem("Comptoire");
					//			        facture.addItem("Assurance");
					//			        factureColumn.setCellEditor(new DefaultCellEditor(facture));

					saleView.getjTable1().getModel().addTableModelListener(new TableModelListener() {
						public void tableChanged(TableModelEvent evt) {
							if (evt.getType() == TableModelEvent.UPDATE){
								int column = evt.getColumn();
								int  row = 0;
								if (column == 3){
									row = saleView.getjTable1().getSelectedRow();
									String qte = (String) saleView.getjTable1().getValueAt(row, column);
									try{
										Double q = Double.valueOf(qte);
										String designation = (String) saleView.getjTable1().getValueAt(row, 0);
										if(designation != null && !designation.equals("")){
											String total = (String) saleView.getjTable1().getValueAt(row, 5);
											if(total != null && !total.equals("")){
												Double t = Double.parseDouble(((String) total).replace(",", "."));
												saleView.getjTable1().setValueAt(decimalFormat.format(t * q), row, 5);
											}

											int rows = saleView.getjTable1().getRowCount();
											double sum = 0;
											for(int i = 0; i < rows; i++){
												Object d = saleView.getjTable1().getValueAt(i, 5);
												if(d != null && !d.toString().equals("")){
													sum += Double.parseDouble(((String) d).replace(",", "."));
												}
											}
											saleView.getFooterPanel().getTotalValue().setText(decimalFormat.format(sum));
										}
									}catch(NumberFormatException exception){
										System.out.println(exception.getStackTrace());

									}

									System.out.println(saleView.getjTable1().getValueAt(row, column));
								}
							}
						}
					});

					saleView.getjTable1().addKeyListener(new KeyAdapter() {         
						public void keyPressed(KeyEvent e) {
							System.out.println("pressed");

							if (e.getKeyChar() == KeyEvent.VK_DELETE) {
								int row = saleView.getjTable1().getSelectedRow();
								if(saleView.getProducts().get(row) != null){

									saleView.getProducts().remove(row);
									for (int i = 0; i <= 5; i++) {
										saleView.getjTable1().setValueAt("", row, i);
									}

									int rows = saleView.getjTable1().getRowCount();
									double sum = 0;
									for(int i = 0; i < rows; i++){
										Object d = saleView.getjTable1().getValueAt(i, 5);
										if(d != null && !d.toString().equals("")){
											sum += Double.parseDouble(((String) d).replace(",", "."));
										}
									}

									if(sum == 0d){ saleView.getFooterPanel().getTotalValue().setText(""); }
									else { saleView.getFooterPanel().getTotalValue().setText(decimalFormat.format(sum)); }
								}
							}
						}
					});

				}}}
		setVisible(false);
		dispose();

	}

	private JButton jButton1;
	private JButton annuler;
	private JButton valider;
	private JComboBox<String> jComboBox1;
	private JLabel jLabel1;
	private JLabel jLabel6;
	private JList<String> jList1;
	private MyJPanel jPanel8;
	private JScrollPane jScrollPane1;
	private JTextField payed;
	private JTextField rendre;
	private JTextField total;
}
