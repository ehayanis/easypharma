package com.mm.app.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

import com.mm.app.model.Assurance;
import com.mm.app.model.Client;
import com.mm.app.model.Operator;
import com.mm.app.model.Vente;
import com.mm.app.service.OperatorService;
import com.mm.app.service.impl.OperatorServiceImpl;
import com.mm.app.utilities.Java2sAutoComboBox;

/**
 *
 * @author A574266
 */
public class LoginView extends JFrame {
	private EntityManagerFactory emf;
	private EntityManager em;
	private OperatorService service;
	
	private static final long serialVersionUID = 944984973485351368L;
	public LoginView() {
		emf = Persistence.createEntityManagerFactory("easypharma");
    	em = emf.createEntityManager();
		
    	service = new OperatorServiceImpl(em);
    	
		initComponents();
        getContentPane().setBackground(Color.WHITE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        ImageIcon img = new ImageIcon(getClass().getResource("/img/logo.png"));
        setIconImage(img.getImage());
    }

    private void initComponents() {

        jPanel1 = new AdaptedPanel("/img/background.jpg");
        idLabel = new JLabel();
        welcomeLabel = new JLabel();
        jMenuBar1 = new JMenuBar();
        jMenu1 = new JMenu();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("EasyPharma: Bienvenu");
        setBackground(new Color(255, 255, 255));
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        setFont(new Font("Agency FB", 0, 11)); // NOI18N

        jPanel1.setBorder(new SoftBevelBorder(BevelBorder.RAISED));

        idLabel.setFont(new Font("Tahoma", 0, 12)); // NOI18N
        idLabel.setText("Veuillez Entrer Votre Identifiant");

        welcomeLabel.setFont(new Font("Tahoma", 1, 12)); // NOI18N
        welcomeLabel.setText("BIENVENU");
        
        ArrayList<String> data = new ArrayList<String>();   
		data.add("");
		List<Operator> result = service.getOperators();
		if(result != null && result.size() > 0){
			for(Operator o : result){
				data.add(o.getFirstName() + " " + o.getLastname() + " (" + o.getId() + ")");
			}
		}
		
        operatorName = new Java2sAutoComboBox(data);
        operatorName.setDataList(data);
        operatorName.setMaximumRowCount(3);
        
        operatorName.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
        	@Override
        	public void keyPressed(KeyEvent e) {
        		if (e.getKeyChar() == KeyEvent.VK_ENTER) {
        			String selectedValue = (String) operatorName.getSelectedItem();
        			String identifer = selectedValue.substring(selectedValue.indexOf("(") + 1, selectedValue.indexOf(")"));
        			if(!"".equals(identifer)){
        				Operator operator = service.findOperator(Integer.valueOf(identifer));

        				JFrame saleView = new SaleView(em, operator);
        				saleView.setVisible(true);

        				setVisible(false);
        				dispose();
        			}
        		}

        	}
        });
        
        
        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(idLabel, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
                        .addComponent(operatorName, GroupLayout.PREFERRED_SIZE, 257, GroupLayout.PREFERRED_SIZE))
                    .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(welcomeLabel)
                        .addGap(92, 92, 92)))
                .addContainerGap(123, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(welcomeLabel)
                .addGap(37, 37, 37)
                .addComponent(idLabel)
                .addPreferredGap(ComponentPlacement.RELATED)
                .addComponent(operatorName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(62, Short.MAX_VALUE))
        );

        jMenu1.setIcon(new ImageIcon(getClass().getResource("/img/help.png"))); // NOI18N
        jMenu1.setText("A propos");

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(450, 450, 450)
                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(357, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(500, Short.MAX_VALUE))
        );

        pack();
    }                       
    
//    private void jTextField1ActionPerformed(ActionEvent evt) {                                            
//        String id = operatorName.getText();
//    	
//        if(id != null){
//        	Operator operator = service.findOperator(Integer.valueOf(id));
//        	if(operator == null){
//        		JOptionPane.showMessageDialog(this, "Veuillez saisir un identifiant valide!");
//        	}else{
//        		JFrame saleView = new SaleView(em, operator);
//        		saleView.setVisible(true);
//        		
//        		setVisible(false);
//        		dispose();
//        	}
//        }
//    	
//    }   

            
    public static void main(String args[]) {
        try {
        	UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
        } catch (Exception ex) {
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginView().setVisible(true);
            }
        });
    }

    private JLabel idLabel;
    private JLabel welcomeLabel;
    private JMenu jMenu1;
    private JMenuBar jMenuBar1;
    private JPanel jPanel1;
    private Java2sAutoComboBox operatorName;

}
