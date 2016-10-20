package com.mm.app.view;

import static javax.swing.GroupLayout.Alignment.LEADING;

import java.awt.Color;
import java.awt.Dimension;
import java.io.IOException;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class ResponseView extends JFrame{

	private static final long serialVersionUID = -8181707677458833048L;
	
	public ResponseView(){
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setTitle("Détail facture");
		setResizable(false);
		initComponents(loadInvoice());
		buildView();
		ImageIcon img = new ImageIcon(getClass().getResource("/img/logo.png"));
		setIconImage(img.getImage());
		setBackground(Color.WHITE);
		pack();
		setLocationRelativeTo(null);
	}
	public void setComponentValues(Document invoice){
		Element eElement = null;
		
		/*********************** Facture === initialisation === */
		eElement = (Element) invoice.getElementsByTagName("invoice:invoice").item(0);
		jTextFieldID.setText(eElement.getAttribute("request_id"));
		eElement = (Element) invoice.getElementsByTagName("invoice:explanation").item(0);
		jTextFieldExplan.setText(eElement.getTextContent());
		
		/*********************** Patient === initialisation === */
		eElement = (Element) invoice.getElementsByTagName("invoice:patient").item(0);
		jTextFieldPtNom.setText(eElement.getElementsByTagName("invoice:familyname").item(0).getTextContent());
		jTextFieldPtPrenom.setText(eElement.getElementsByTagName("invoice:givenname").item(0).getTextContent());
		jTextFieldPtDateNais.setText(eElement.getAttribute("birthdate").substring(0, 10));
		jTextFielPtAdresse.setText(
				eElement.getElementsByTagName("invoice:street").item(0).getTextContent()+ " " + 
		eElement.getElementsByTagName("invoice:zip").item(0).getTextContent()+ " " + 
				eElement.getElementsByTagName("invoice:city").item(0).getTextContent());
		
		
		/*********************** Assurance === initialisation === */
		eElement = (Element) invoice.getElementsByTagName("invoice:company").item(0);
		jTextFieldAsrNom.setText(eElement.getElementsByTagName("invoice:companyname").item(0).getTextContent());
		jTextFieldAsrDept.setText(eElement.getElementsByTagName("invoice:department").item(0).getTextContent());
		jTextFieldAsrPhone.setText(eElement.getElementsByTagName("invoice:phone").item(0).getTextContent());
		jTextFieldAsrFax.setText(eElement.getElementsByTagName("invoice:fax").item(0).getTextContent());
		jTextFielAsrAdresse.setText(eElement.getElementsByTagName("invoice:street").item(0).getTextContent()+ " " + 
		eElement.getElementsByTagName("invoice:zip").item(0).getTextContent()+ " " + 
				eElement.getElementsByTagName("invoice:city").item(0).getTextContent());
		
		/*********************** Employeur === initialisation === */
		eElement = (Element) invoice.getElementsByTagName("invoice:employee").item(0);
		jTextFieldEmpNom.setText(eElement.getElementsByTagName("invoice:familyname").item(0).getTextContent());
		jTextFieldEmpPrenom.setText(eElement.getElementsByTagName("invoice:givenname").item(0).getTextContent());
		jTextFieldEmpPhone.setText(eElement.getElementsByTagName("invoice:phone").item(0).getTextContent());
		jTextFieldEmpFax.setText(eElement.getElementsByTagName("invoice:fax").item(0).getTextContent());
		jTextFielEmpEmail.setText(eElement.getElementsByTagName("invoice:email").item(0).getTextContent());
		
	}
	
	private void initComponents(Document invoice) {
		/*********************** Facture === initialisation === */
		jTabbedPaneInvoice = new JTabbedPane();
		jPanelInvoice = new JPanel();
		jLabelID = new JLabel("Id Facture");
		jTextFieldID = new JTextField();
		jTextFieldID.setPreferredSize(new Dimension(150, jTextFieldID.getHeight()));
		jLabelStatus = new JLabel("Status");
		jTextFieldStatus = new JTextField();
		jTextFieldStatus.setText("Rejected");
		jTextFieldStatus.setPreferredSize(new Dimension(150, jTextFieldStatus.getHeight()));
		jLabelExplan = new JLabel("Explication");
		
		JScrollPane jScrollPaneExplan = new JScrollPane();
		jTextFieldExplan = new JTextArea();
		jTextFieldExplan.setColumns(20);
		jTextFieldExplan.setRows(3);
		jScrollPaneExplan.setViewportView(jTextFieldExplan);
		
		GroupLayout gpLayoutInvoive = new GroupLayout(jPanelInvoice);
		jPanelInvoice.setLayout(gpLayoutInvoive);
		gpLayoutInvoive.setHorizontalGroup(gpLayoutInvoive.createParallelGroup(LEADING)
				.addGroup(gpLayoutInvoive.createSequentialGroup()
						.addComponent(jLabelID)
						.addGap(20, 20, 20)
						.addComponent(jTextFieldID)
						.addGap(20, 20, 20)
						.addComponent(jLabelStatus)
						.addGap(20, 20, 20)
						.addComponent(jTextFieldStatus))
				.addGap(20, 20, 20)
				.addGroup(gpLayoutInvoive.createSequentialGroup()
						.addComponent(jLabelExplan)
						.addGap(20, 20, 20)
						.addComponent(jScrollPaneExplan, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))
				.addGap(20, 20, 20));
		gpLayoutInvoive.setVerticalGroup(gpLayoutInvoive.createSequentialGroup()
				.addGroup(gpLayoutInvoive.createParallelGroup()
						.addComponent(jLabelID)
						.addGap(20, 20, 20)
						.addComponent(jTextFieldID)
						.addGap(20, 20, 20)
						.addComponent(jLabelStatus)
						.addGap(20, 20, 20)
						.addComponent(jTextFieldStatus))
				.addGap(10, 10, 10)
				.addGroup(gpLayoutInvoive.createParallelGroup()
						.addComponent(jLabelExplan)
						.addGap(20, 20, 20)
						.addComponent(jScrollPaneExplan, GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE))
				.addGap(10, 10, 10));
		JPanel jPanelInvoiceContainer = new JPanel();
		jPanelInvoiceContainer.add(jPanelInvoice);
		jTabbedPaneInvoice.addTab("Facture", jPanelInvoiceContainer);
		
		
		
		
		
		
		/*********************** Patient === initialisation === */
		jTabbedPanePt = new JTabbedPane();
		jPanelPt = new JPanel();
		jLabelPtNom  = new JLabel("Nom");
		jTextFieldPtNom = new JTextField();
		jTextFieldPtNom.setPreferredSize(new Dimension(150, jTextFieldPtNom.getHeight()));
		jLabelPtPrenom = new JLabel("Prénom");
		jTextFieldPtPrenom = new JTextField();
		jTextFieldPtPrenom.setPreferredSize(new Dimension(150, jTextFieldPtPrenom.getHeight()));
		jLabelPtDateNais = new JLabel("Date de Naissaince");
		jTextFieldPtDateNais = new JTextField();
		jTextFieldPtDateNais.setPreferredSize(new Dimension(150, jTextFieldPtDateNais.getHeight()));
		jLabelPtAdresse = new JLabel("Adresse");
		jTextFielPtAdresse = new JTextField();
		
		GroupLayout gpLayoutPt = new GroupLayout(jPanelPt);
		jPanelPt.setLayout(gpLayoutPt);
		gpLayoutPt.setHorizontalGroup(gpLayoutPt.createParallelGroup(LEADING)
				.addGroup(gpLayoutPt.createSequentialGroup()
						.addComponent(jLabelPtNom)
						.addGap(20, 20, 20)
						.addComponent(jTextFieldPtNom)
						.addGap(20, 20, 20)
						.addComponent(jLabelPtPrenom)
						.addGap(20, 20, 20)
						.addComponent(jTextFieldPtPrenom))
				.addGap(20, 20, 20)
				.addGroup(gpLayoutPt.createSequentialGroup()
						.addComponent(jLabelPtDateNais)
						.addGap(20, 20, 20)
						.addComponent(jTextFieldPtDateNais))
				.addGap(20, 20, 20)
				.addGroup(gpLayoutPt.createSequentialGroup()
						.addComponent(jLabelPtAdresse)
						.addGap(20, 20, 20)
						.addComponent(jTextFielPtAdresse))
				.addGap(20, 20, 20));
		gpLayoutPt.setVerticalGroup(gpLayoutPt.createSequentialGroup()
				.addGroup(gpLayoutPt.createParallelGroup()
						.addComponent(jLabelPtNom)
						.addGap(20, 20, 20)
						.addComponent(jTextFieldPtNom)
						.addGap(20, 20, 20)
						.addComponent(jLabelPtPrenom)
						.addGap(20, 20, 20)
						.addComponent(jTextFieldPtPrenom))
				.addGap(10, 10, 10)
				.addGroup(gpLayoutPt.createParallelGroup()
						.addComponent(jLabelPtDateNais)
						.addGap(20, 20, 20)
						.addComponent(jTextFieldPtDateNais))
				.addGap(10, 10, 10)
				.addGroup(gpLayoutPt.createParallelGroup()
						.addComponent(jLabelPtAdresse)
						.addGap(20, 20, 20)
						.addComponent(jTextFielPtAdresse))
				.addGap(10, 10, 10));
		JPanel jPanelPtContainer = new JPanel();
		jPanelPtContainer.add(jPanelPt);
		jTabbedPanePt.addTab("Patient", jPanelPtContainer);
		
		
		/*********************** Assurance === initialisation === */
		jTabbedPaneAsr = new JTabbedPane();
		jPanelAsr = new JPanel();
		
		jLabelAsrNom  = new JLabel("Nom");
		jTextFieldAsrNom = new JTextField();
		jTextFieldAsrNom.setPreferredSize(new Dimension(150, jTextFieldAsrNom.getHeight()));
		
		jLabelAsrDept = new JLabel("Département");
		jTextFieldAsrDept = new JTextField();
		jTextFieldAsrDept.setPreferredSize(new Dimension(150, jTextFieldAsrDept.getHeight()));
		
		jLabelAsrPhone = new JLabel("Télephone");
		jTextFieldAsrPhone = new JTextField();
		jTextFieldAsrPhone.setPreferredSize(new Dimension(150, jTextFieldAsrPhone.getHeight()));
		
		jLabelAsrFax = new JLabel("Fax");
		jTextFieldAsrFax = new JTextField();
		jTextFieldAsrFax.setPreferredSize(new Dimension(150, jTextFieldAsrFax.getHeight()));
		
		jLabelAsrAdresse = new JLabel("Adresse");
		jTextFielAsrAdresse = new JTextField();
		
		
		GroupLayout gpLayoutAsr = new GroupLayout(jPanelAsr);
		jPanelAsr.setLayout(gpLayoutAsr);
		gpLayoutAsr.setHorizontalGroup(gpLayoutAsr.createParallelGroup(LEADING)
				.addGroup(gpLayoutAsr.createSequentialGroup()
						.addComponent(jLabelAsrNom)
						.addGap(20, 20, 20)
						.addComponent(jTextFieldAsrNom)
						.addGap(20, 20, 20)
						.addComponent(jLabelAsrDept)
						.addGap(20, 20, 20)
						.addComponent(jTextFieldAsrDept))
				.addGap(20, 20, 20)
				.addGroup(gpLayoutAsr.createSequentialGroup()
						.addComponent(jLabelAsrPhone)
						.addGap(20, 20, 20)
						.addComponent(jTextFieldAsrPhone)
						.addGap(20, 20, 20)
						.addComponent(jLabelAsrFax)
						.addGap(20, 20, 20)
						.addComponent(jTextFieldAsrFax))
				.addGap(20, 20, 20)
				.addGroup(gpLayoutAsr.createSequentialGroup()
						.addComponent(jLabelAsrAdresse)
						.addGap(20, 20, 20)
						.addComponent(jTextFielAsrAdresse))
				.addGap(20, 20, 20));
		gpLayoutAsr.setVerticalGroup(gpLayoutAsr.createSequentialGroup()
				.addGroup(gpLayoutAsr.createParallelGroup()
						.addComponent(jLabelAsrNom)
						.addGap(20, 20, 20)
						.addComponent(jTextFieldAsrNom)
						.addGap(20, 20, 20)
						.addComponent(jLabelAsrDept)
						.addGap(20, 20, 20)
						.addComponent(jTextFieldAsrDept))
				.addGap(10, 10, 10)
				.addGroup(gpLayoutAsr.createParallelGroup()
						.addComponent(jLabelAsrPhone)
						.addGap(20, 20, 20)
						.addComponent(jTextFieldAsrPhone)
						.addGap(20, 20, 20)
						.addComponent(jLabelAsrFax)
						.addGap(20, 20, 20)
						.addComponent(jTextFieldAsrFax))
				.addGap(10, 10, 10)
				.addGroup(gpLayoutAsr.createParallelGroup()
						.addComponent(jLabelAsrAdresse)
						.addGap(20, 20, 20)
						.addComponent(jTextFielAsrAdresse))
				.addGap(10, 10, 10));
		JPanel jPanelAsrContainer = new JPanel();
		jPanelAsrContainer.add(jPanelAsr);
		jTabbedPaneAsr.addTab("Assurance", jPanelAsrContainer);
		
		
		/*********************** Employeur === initialisation === */
		jTabbedPaneEmp = new JTabbedPane();
		jPanelEmp = new JPanel();
		
		jLabelEmpNom  = new JLabel("Nom");
		jTextFieldEmpNom = new JTextField();
		jTextFieldEmpNom.setPreferredSize(new Dimension(150, jTextFieldEmpNom.getHeight()));
		
		jLabelEmpPrenom = new JLabel("Prénom");
		jTextFieldEmpPrenom = new JTextField();
		jTextFieldEmpPrenom.setPreferredSize(new Dimension(150, jTextFieldEmpPrenom.getHeight()));
		
		jLabelEmpPhone = new JLabel("Télephone");
		jTextFieldEmpPhone = new JTextField();
		jTextFieldEmpPhone.setPreferredSize(new Dimension(150, jTextFieldEmpPhone.getHeight()));
		
		jLabelEmpFax = new JLabel("Fax");
		jTextFieldEmpFax = new JTextField();
		jTextFieldEmpFax.setPreferredSize(new Dimension(150, jTextFieldEmpFax.getHeight()));
		
		jLabelEmpEmail = new JLabel("Email");
		jTextFielEmpEmail = new JTextField();
		
		GroupLayout gpLayoutEmp = new GroupLayout(jPanelEmp);
		jPanelEmp.setLayout(gpLayoutEmp);
		gpLayoutEmp.setHorizontalGroup(gpLayoutEmp.createParallelGroup(LEADING)
				.addGroup(gpLayoutEmp.createSequentialGroup()
						.addComponent(jLabelEmpNom)
						.addGap(20, 20, 20)
						.addComponent(jTextFieldEmpNom)
						.addGap(20, 20, 20)
						.addComponent(jLabelEmpPrenom)
						.addGap(20, 20, 20)
						.addComponent(jTextFieldEmpPrenom))
				.addGap(20, 20, 20)
				.addGroup(gpLayoutEmp.createSequentialGroup()
						.addComponent(jLabelEmpPhone)
						.addGap(20, 20, 20)
						.addComponent(jTextFieldEmpPhone)
						.addGap(20, 20, 20)
						.addComponent(jLabelEmpFax)
						.addGap(20, 20, 20)
						.addComponent(jTextFieldEmpFax))
				.addGap(20, 20, 20)
				.addGroup(gpLayoutEmp.createSequentialGroup()
						.addComponent(jLabelEmpEmail)
						.addGap(20, 20, 20)
						.addComponent(jTextFielEmpEmail))
				.addGap(20, 20, 20));
		gpLayoutEmp.setVerticalGroup(gpLayoutEmp.createSequentialGroup()
				.addGroup(gpLayoutEmp.createParallelGroup()
						.addComponent(jLabelEmpNom)
						.addGap(20, 20, 20)
						.addComponent(jTextFieldEmpNom)
						.addGap(20, 20, 20)
						.addComponent(jLabelEmpPrenom)
						.addGap(20, 20, 20)
						.addComponent(jTextFieldEmpPrenom))
				.addGap(10, 10, 10)
				.addGroup(gpLayoutEmp.createParallelGroup()
						.addComponent(jLabelEmpPhone)
						.addGap(20, 20, 20)
						.addComponent(jTextFieldEmpPhone)
						.addGap(20, 20, 20)
						.addComponent(jLabelEmpFax)
						.addGap(20, 20, 20)
						.addComponent(jTextFieldEmpFax))
				.addGap(10, 10, 10)
				.addGroup(gpLayoutEmp.createParallelGroup()
						.addComponent(jLabelEmpEmail)
						.addGap(20, 20, 20)
						.addComponent(jTextFielEmpEmail))
				.addGap(10, 10, 10));
		JPanel jPanelEmpContainer = new JPanel();
		jPanelEmpContainer.add(jPanelEmp);
		jTabbedPaneEmp.addTab("Employeur", jPanelEmpContainer);
		
		setComponentValues(invoice);
		
	}
	
	private void buildView() {
		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);

		layout.setHorizontalGroup(layout.createParallelGroup(LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(jTabbedPaneInvoice)
						.addComponent(jTabbedPanePt))
				.addGroup(layout.createSequentialGroup()
						.addComponent(jTabbedPaneAsr)
						.addComponent(jTabbedPaneEmp)));

		layout.setVerticalGroup(layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup()
						.addComponent(jTabbedPaneInvoice)
						.addComponent(jTabbedPanePt))
				.addGroup(layout.createParallelGroup()
						.addComponent(jTabbedPaneAsr)
						.addComponent(jTabbedPaneEmp)));
	
	}
	
	public Document loadInvoice(){
		Document invoice = null;
		try {
			File fXmlFile = new File("D:/New_Beginning/EsyPharma/test/ISGEX04401452632905948TMP0.XML");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			invoice = dBuilder.parse(fXmlFile);
			Element eElement = (Element) invoice.getElementsByTagName("invoice:invoice").item(0);
			System.out.println("First Name : " + eElement.getAttribute("request_id"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return invoice;
	}

	public static void main(String[] args) {
//		new ResponseView().setVisible(true);
		
		try {
        	UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
        } catch (Exception ex) {
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ResponseView().setVisible(true);
            }
        });
	}
	
	
	/** Facture === variables === */
	private JTabbedPane jTabbedPaneInvoice;
	private JPanel jPanelInvoice;
	private JLabel jLabelID;
	private JTextField jTextFieldID;
	private JLabel jLabelStatus;
	private JTextField jTextFieldStatus;
	private JLabel jLabelExplan;
	private JTextArea jTextFieldExplan;
	
	/** Patient === variables === */
	private JTabbedPane jTabbedPanePt;
	private JPanel jPanelPt;
	private JLabel jLabelPtNom;
	private JTextField jTextFieldPtNom;
	private JLabel jLabelPtPrenom;
	private JTextField jTextFieldPtPrenom;
	private JLabel jLabelPtDateNais;
	private JTextField jTextFieldPtDateNais;
	private JLabel jLabelPtAdresse;
	private JTextField jTextFielPtAdresse;
	
	
	/** Assurance === variables === */
	private JTabbedPane jTabbedPaneAsr;
	private JPanel jPanelAsr;
	private JLabel jLabelAsrNom;
	private JTextField jTextFieldAsrNom;
	private JLabel jLabelAsrDept;
	private JTextField jTextFieldAsrDept;
	private JLabel jLabelAsrPhone;
	private JTextField jTextFieldAsrPhone;
	private JLabel jLabelAsrFax;
	private JTextField jTextFieldAsrFax;
	private JLabel jLabelAsrAdresse;
	private JTextField jTextFielAsrAdresse;
	
	/** Employeur === variables === */
	private JTabbedPane jTabbedPaneEmp;
	private JPanel jPanelEmp;
	private JLabel jLabelEmpNom;
	private JTextField jTextFieldEmpNom;
	private JLabel jLabelEmpPrenom;
	private JTextField jTextFieldEmpPrenom;
	private JLabel jLabelEmpPhone;
	private JTextField jTextFieldEmpPhone;
	private JLabel jLabelEmpFax;
	private JTextField jTextFieldEmpFax;
	private JLabel jLabelEmpEmail;
	private JTextField jTextFielEmpEmail;
	

}
