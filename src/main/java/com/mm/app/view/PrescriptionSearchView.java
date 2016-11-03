package com.mm.app.view;

import static javax.swing.GroupLayout.Alignment.LEADING;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.SortedMap;

import javax.persistence.EntityManager;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.WindowConstants;

import com.mm.app.utilities.MyJTable;

import net.sourceforge.jdatepicker.JDatePicker;

public class PrescriptionSearchView extends JFrame {

	private static final long serialVersionUID = 879461986204093549L;

	private EntityManager em;
	private MyDesktopManager desktopManager;
	private JDesktopPane m_desktop;
	private SortedMap<String, String> data;

	public PrescriptionSearchView(EntityManager em) {
		desktopManager = new MyDesktopManager();
		m_desktop = new JDesktopPane();
		m_desktop.setDesktopManager(desktopManager);
		this.em = em;
		initComponent();
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setTitle("Gestion des Clients");
		setResizable(false);
		pack();
		setLocationRelativeTo(null);
		getContentPane().setBackground(Color.WHITE);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		ImageIcon img = new ImageIcon(getClass().getResource("/img/logo.png"));
		setIconImage(img.getImage());

	}
	
	private void initComponent() {
		searchBlock = new MyJPanel();
		resultBlock = new MyJPanel();
		actionsBlock = new MyJPanel();
		
		/** Actions */
		KeyStroke escapeKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, false);
        Action escapeAction = new AbstractAction() {
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
        
        /** Horizontal Grouping*/
        layout.setHorizontalGroup(layout.createParallelGroup(LEADING)
        		.addComponent(searchBlock)
        		.addComponent(resultBlock)
        		.addComponent(actionsBlock)
        		);
        
        /** Vertical Grouping*/
        layout.setVerticalGroup(layout.createSequentialGroup()
        		.addComponent(searchBlock)
        		.addComponent(resultBlock)
        		.addComponent(actionsBlock)
        		);


	}
	
	
	/** SearchBlock elements */
	private JPanel searchBlock;
	private JTextField doctorName;
	private JTextField clientName;
	private JDatePicker startValDate;
	private JDatePicker endValDate;
	private JComboBox<String> valDuration;
	private JComboBox<String> addedValDuration;
	
	/** ResultBlock elements */
	private JPanel resultBlock;
	private JScrollPane scrollSearchBlock;
	private JTable prescriptionsTable;
	
	/** ActionsBlock elements */
	private JPanel actionsBlock;
	private JButton cancel;
	private JButton validate;
}
