package com.mm.app.view;

import static javax.swing.GroupLayout.Alignment.LEADING;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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
import javax.swing.table.AbstractTableModel;

import com.mm.app.model.Prescription;
import com.mm.app.service.PrescriptionService;
import com.mm.app.service.impl.PrescriptionServiceImpl;
import com.mm.app.utilities.PrescriptionTableModel;

public class PrescriptionSearchView extends JFrame {

	private static final long serialVersionUID = 879461986204093549L;
	private EntityManager em;

	private PrescriptionService prescriptionService;
	private List<Prescription> prescriptions;
	private MyDesktopManager desktopManager;
	private JDesktopPane m_desktop;

	/** SearchBlock elements */
	private JPanel searchBlock;
	private JLabel prescriptionRefLbl;
	private JTextField prescriptionRef;
	private JLabel clientNameLbl;
	private JTextField clientName;
	private JLabel doctorNameLbl;
	private JTextField doctorName;

	/** ResultBlock elements */
	private JPanel resultBlock;
	private JScrollPane scrollResultBlock;
	private JTable prescriptionsTable;

	/** ActionsBlock elements */
	private JPanel actionsBlock;
	private JButton viewBtn;
	private JButton loadBtn;

	public PrescriptionSearchView(EntityManager entityManager) {
		this.em = entityManager;
		desktopManager = new MyDesktopManager();
		m_desktop = new JDesktopPane();
		m_desktop.setDesktopManager(desktopManager);
		prescriptionService = new PrescriptionServiceImpl(em);
		initComponent();
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setTitle("Gestion des ordonnances");
		setResizable(false);
		pack();
		setLocationRelativeTo(null);
		getContentPane().setBackground(Color.WHITE);
		ImageIcon img = new ImageIcon(getClass().getResource("/img/logo.png"));
		setIconImage(img.getImage());

	}

	private void initComponent() {
		/** search criteria */
		searchBlock = new MyJPanel();
		prescriptionRefLbl = new JLabel("Référence");
		prescriptionRef = new JTextField();
		clientNameLbl = new JLabel("Client");
		clientName = new JTextField();
		doctorNameLbl = new JLabel("Médcin");
		doctorName = new JTextField();

		prescriptionRef.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("prescriptionRef clicked");
				searchPrescriptions();

			}
		});

		clientName.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("clientName clicked");
				searchPrescriptions();

			}
		});

		doctorName.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("doctorName clicked");
				searchPrescriptions();

			}
		});

		GroupLayout searchBlockLayout = new GroupLayout(searchBlock);
		searchBlock.setLayout(searchBlockLayout);
		searchBlockLayout.setHorizontalGroup(searchBlockLayout.createParallelGroup(LEADING).addGroup(searchBlockLayout.createSequentialGroup()
				.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addGap(50, 50, 50).addComponent(prescriptionRefLbl).addGap(20, 20, 20)
				.addComponent(prescriptionRef, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE).addGap(20, 20, 20).addComponent(clientNameLbl)
				.addGap(20, 20, 20).addComponent(clientName, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE).addGap(20, 20, 20)
				.addComponent(doctorNameLbl).addGap(20, 20, 20).addComponent(doctorName, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
				.addGap(50, 50, 50).addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		searchBlockLayout
				.setVerticalGroup(
						searchBlockLayout.createSequentialGroup()
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addGroup(searchBlockLayout.createParallelGroup().addGap(16, 16, 16).addComponent(prescriptionRefLbl).addGap(20, 20, 20)
										.addComponent(prescriptionRef, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGap(20, 20, 20).addComponent(clientNameLbl).addGap(20, 20, 20)
										.addComponent(clientName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGap(20, 20, 20).addComponent(doctorNameLbl).addGap(20, 20, 20)
										.addComponent(doctorName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

		/** list of prescriptions */
		resultBlock = new MyJPanel();
		scrollResultBlock = new JScrollPane();
		prescriptionsTable = new JTable();

		scrollResultBlock.setViewportView(prescriptionsTable);
		prescriptionsTable.setBackground(Color.WHITE);

		prescriptionsTable.setModel(new PrescriptionTableModel(new ArrayList<Prescription>()));
		
		prescriptionsTable.addKeyListener(new KeyListener() {
			
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyChar() == KeyEvent.VK_ENTER) {
					new PrescriptionSynthesisView(em,prescriptions.get(prescriptionsTable.getSelectedRow())).setVisible(true);
				}
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		GroupLayout resultBlockLayout = new GroupLayout(resultBlock);
		resultBlock.setLayout(resultBlockLayout);

		resultBlockLayout.setHorizontalGroup(resultBlockLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(scrollResultBlock));
		resultBlockLayout.setVerticalGroup(resultBlockLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(scrollResultBlock));

		/** screen buttons */
		actionsBlock = new MyJPanel();
		viewBtn = new JButton("Aperçu");
		loadBtn = new JButton("Nouvelle vente ");
		
		loadBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		GroupLayout actionsBlockLayout = new GroupLayout(actionsBlock);
		actionsBlock.setLayout(actionsBlockLayout);
		actionsBlockLayout.setHorizontalGroup(
				actionsBlockLayout.createSequentialGroup().addGap(400, 400, 400).addComponent(viewBtn).addGap(20, 20, 20).addComponent(loadBtn));
		actionsBlockLayout.setVerticalGroup(actionsBlockLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(viewBtn).addComponent(loadBtn));

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
	}

	private void initPrincipalLayout() {
		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);

		/** Horizontal Grouping */
		layout.setHorizontalGroup(layout.createParallelGroup(LEADING)
				.addComponent(searchBlock, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addComponent(resultBlock)
				.addComponent(actionsBlock, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE));

		/** Vertical Grouping */
		layout.setVerticalGroup(
				layout.createSequentialGroup().addComponent(searchBlock, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(resultBlock, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
						.addComponent(actionsBlock, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE));

	}

	private void searchPrescriptions() {
		String prescriptionRefCrt = prescriptionRef.getText();
		String doctorNameCrt = doctorName.getText();
		String clientNameCrt = clientName.getText();
		prescriptions = prescriptionService.findPrescriptionByCriteria(prescriptionRefCrt, doctorNameCrt, clientNameCrt, null, null);
		if (prescriptions != null && prescriptions.size() > 0) {
			AbstractTableModel model = new PrescriptionTableModel(prescriptions);
			prescriptionsTable.setModel(model);
		}
	}
	

	public List<Prescription> getPrescriptions() {
		return prescriptions;
	}

	public void setPrescriptions(List<Prescription> prescriptions) {
		this.prescriptions = prescriptions;
	}

	public static void main(String args[]) {
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
		} catch (Exception ex) {
		}

		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new PrescriptionSearchView(null).setVisible(true);
			}
		});
	}
}
