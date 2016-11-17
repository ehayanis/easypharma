package com.mm.app.view;

import static javax.swing.GroupLayout.Alignment.LEADING;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

import com.mm.app.model.Client;
import com.mm.app.model.Medecin;
import com.mm.app.model.Prescription;
import com.mm.app.model.PrescriptionProduct;
import com.mm.app.utilities.PrescriptionProductTableModel;

public class PrescriptionSynthesisView extends JFrame {


	private static final long serialVersionUID = 4602374836203434549L;
	private Prescription prescription;
	private MyDesktopManager desktopManager;
	private JDesktopPane m_desktop;

	/** SearchBlock elements */
	private JPanel synthesiBlock;
	
	private JLabel prescriptionRefLbl;
	private JTextField prescriptionRef;
	private JLabel clientNameLbl;
	private JTextField clientName;
	private JLabel doctorNameLbl;
	private JTextField doctorName;
	
	private JLabel startDateLbl;
	private JTextField startDate;
	private JLabel endDateLbl;
	private JTextField endDate;

	/** ResultBlock elements */
	private JPanel listDrugsBlock;
	private JScrollPane scrolllistDrugsBlock;
	private JTable listDrugsTable;

	public PrescriptionSynthesisView(EntityManager em, Prescription prescription) {
		desktopManager = new MyDesktopManager();
		m_desktop = new JDesktopPane();
		m_desktop.setDesktopManager(desktopManager);
		this.prescription = prescription;
		setTitle("Aperçu Ordonnance");
		initComponent();
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setResizable(false);
		pack();
		setLocationRelativeTo(null);
		getContentPane().setBackground(Color.WHITE);
		ImageIcon img = new ImageIcon(getClass().getResource("/img/logo.png"));
		setIconImage(img.getImage());

	}

	private void initComponent() {
		/** Synthesis block */
		synthesiBlock = new MyJPanel();
		prescriptionRefLbl = new JLabel("Référence");
		prescriptionRef = new JTextField();
		clientNameLbl = new JLabel("Client");
		clientName = new JTextField();
		doctorNameLbl = new JLabel("Médcin");
		doctorName = new JTextField();
		
		startDateLbl = new JLabel("Date de début de validité");
		startDate = new JTextField();
		endDateLbl = new JLabel("Date de fin de validité");
		endDate = new JTextField();

		GroupLayout searchBlockLayout = new GroupLayout(synthesiBlock);
		synthesiBlock.setLayout(searchBlockLayout);
		searchBlockLayout.setHorizontalGroup(searchBlockLayout.createParallelGroup(LEADING)
				
				.addGroup(searchBlockLayout.createSequentialGroup()
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(prescriptionRefLbl).addGap(20, 20, 20)
						.addComponent(prescriptionRef, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE).addGap(20, 20, 20)
						.addComponent(clientNameLbl).addGap(20, 20, 20)
						.addComponent(clientName, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE).addGap(20, 20, 20)
						.addComponent(doctorNameLbl).addGap(20, 20, 20)
						.addComponent(doctorName, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				
				.addGroup(searchBlockLayout.createSequentialGroup()
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(startDateLbl).addGap(20, 20, 20)
						.addComponent(startDate, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE).addGap(20, 20, 20)
						.addComponent(endDateLbl).addGap(20, 20, 20)
						.addComponent(endDate, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE).addGap(120, 120, 120)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				
				);

		searchBlockLayout .setVerticalGroup( searchBlockLayout.createSequentialGroup()
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								
								.addGroup(searchBlockLayout.createParallelGroup(LEADING).addGap(16, 16, 16)
										.addComponent(prescriptionRefLbl).addGap(20, 20, 20)
										.addComponent(prescriptionRef, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addGap(20, 20, 20)
										.addComponent(clientNameLbl).addGap(20, 20, 20)
										.addComponent(clientName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addGap(20, 20, 20)
										.addComponent(doctorNameLbl).addGap(20, 20, 20)
										.addComponent(doctorName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								
								.addGroup(searchBlockLayout.createParallelGroup(LEADING).addGap(16, 16, 16)
										.addComponent(startDateLbl).addGap(20, 20, 20)
										.addComponent(startDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addGap(20, 20, 20)
										.addComponent(endDateLbl).addGap(20, 20, 20)
										.addComponent(endDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addGap(20, 20, 20))
								
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				);

		/** list of drugs */
		listDrugsBlock = new MyJPanel();
		scrolllistDrugsBlock = new JScrollPane();
		listDrugsTable = new JTable();

		scrolllistDrugsBlock.setViewportView(listDrugsTable);
		listDrugsTable.setBackground(Color.WHITE);

		listDrugsTable.setModel(new PrescriptionProductTableModel(new ArrayList<PrescriptionProduct>()));

		GroupLayout resultBlockLayout = new GroupLayout(listDrugsBlock);
		listDrugsBlock.setLayout(resultBlockLayout);

		resultBlockLayout.setHorizontalGroup(resultBlockLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(scrolllistDrugsBlock));
		resultBlockLayout.setVerticalGroup(resultBlockLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(scrolllistDrugsBlock));

		/** Actions */
		KeyStroke escapeKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, false);
		Action escapeAction = new AbstractAction() {
			private static final long serialVersionUID = -5676849682497574192L;

			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		};

		getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(escapeKeyStroke, "ESCAPE");
		getRootPane().getActionMap().put("ESCAPE", escapeAction);

		initPrincipalLayout();
		initView();
	}

	private void initPrincipalLayout() {
		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);

		/** Horizontal Grouping */
		layout.setHorizontalGroup(layout.createParallelGroup(LEADING)
				.addComponent(synthesiBlock, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addComponent(listDrugsBlock));

		/** Vertical Grouping */
		layout.setVerticalGroup(layout.createSequentialGroup()
				.addComponent(synthesiBlock, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				.addComponent(listDrugsBlock, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE));

	}
	
	private void initView(){
		System.out.println(getTitle());
		setTitle(getTitle()+" : "+ (prescription.getRef() != null ? prescription.getRef() : ""));
		Client client = prescription.getClient();
		Medecin medecin = prescription.getMedecin();
		prescriptionRef.setText(prescription.getRef());
		doctorName.setText(medecin != null ? medecin.getFirstName() : null);
		clientName.setText(client != null ? client.getFirstName() : null);
		startDate.setText(prescription.getStartDate() != null ? prescription.getStartDate().toString() : null);
		endDate.setText(prescription.getEndDate() != null ? prescription.getEndDate().toString() : null);
		listDrugsTable.setModel(new PrescriptionProductTableModel((List<PrescriptionProduct>) prescription.getPrescriptionProducts()));

	}

	// TODO delete the main once the tests are done
	public static void main(String args[]) {
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
		} catch (Exception ex) {
		}

		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				Prescription prescription = new Prescription();
				prescription.setRef("GGG");
				List<PrescriptionProduct> prescriptionProducts = new ArrayList<PrescriptionProduct>();
				PrescriptionProduct prescriptionProduct = new PrescriptionProduct();
				prescriptionProduct.setQte(10);
				prescriptionProducts.add(prescriptionProduct);
				prescription.setPrescriptionProducts(prescriptionProducts);
				new PrescriptionSynthesisView(null,prescription).setVisible(true);
			}
		});
	}
}
