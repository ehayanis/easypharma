package com.mm.app.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;

import javax.persistence.EntityManager;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JTextField;

import com.mm.app.utilities.Utilities;

public class AssuranceWidget extends JInternalFrame implements InternalFrameWidget{

	private static final long serialVersionUID = -1528594567776851222L;
	
	private JTextField assurance1;
	private JTextField assurance2;
	private JTextField assurance3;
	
	private JButton editAssur1;
	private JButton editAssur2; 
	private JButton editAssur3;
	private JButton newAssur1;
	private JButton newAssur2;
	private JButton newAssur3;
	
	private EntityManager em;
	
	public AssuranceWidget(EntityManager em) {
		this.em = em;
		
		initComponent();
		
		getContentPane().setBackground(Color.WHITE);
		
		setFrameIcon(new ImageIcon(getClass().getResource("/img/graphite.png")));
		setTitle("Assurance");
		setBorder(javax.swing.BorderFactory.createEtchedBorder());
        setVisible(true);
        setFont(new Font("Agency FB", 0, 9));
	}
	
	private void initComponent() {
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		
		assurance1 = new JTextField();
		assurance2 = new JTextField();
		assurance3 = new JTextField();
		
		editAssur1 = new HeaderButton("/img/edit.gif");
		editAssur2 = new HeaderButton("/img/edit.gif");
		editAssur3 = new HeaderButton("/img/edit.gif");
		newAssur1 = new HeaderButton("/img/add.gif");
		newAssur2 = new HeaderButton("/img/add.gif");
		newAssur3 = new HeaderButton("/img/add.gif");
		
		editAssur1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                editActionPerformed(evt);
            }
        });
		editAssur2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                editActionPerformed(evt);
            }
        });
		editAssur3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                editActionPerformed(evt);
            }
        });
		
		newAssur1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                newActionPerformed(evt);
            }
        });
		newAssur2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                newActionPerformed(evt);
            }
        });
		newAssur3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                newActionPerformed(evt);
            }
        });
		
		add(Utilities.createFilledAdvancedPanel("Assurance Obligatoire", assurance1, editAssur1, newAssur1));
		add(Utilities.createFilledAdvancedPanel("Assurance Accident", assurance2, editAssur2, newAssur2));
		add(Utilities.createFilledAdvancedPanel("Assurance Complémentaire", assurance3, editAssur3, newAssur3));
		
	}

	public JTextField getAssurance1() {
		return assurance1;
	}

	public void setAssurance1(JTextField assurance) {
		this.assurance1 = assurance;
	}

	public JTextField getAssurance2() {
		return assurance2;
	}

	public void setAssurance2(JTextField assurance) {
		this.assurance2 = assurance;
	}

	public JTextField getAssurance3() {
		return assurance3;
	}

	public void setAssurance3(JTextField assurance) {
		this.assurance3 = assurance;
	}

	@Override
	public void activateComponents(){
		assurance1.setEnabled(true);
		assurance1.setEditable(true);
		assurance2.setEnabled(true);
		assurance2.setEditable(true);
		assurance3.setEnabled(true);
		assurance3.setEditable(true);
	}
	
	private void editActionPerformed(ActionEvent evt) {                                         
        JFrame assuranceManagementView = new AssuranceManagementView(em);
        assuranceManagementView.setVisible(true);
    } 
	
	private void newActionPerformed(ActionEvent evt) {                                         
        JFrame assuranceManagementView = new AssuranceManagementView(em);
        assuranceManagementView.setVisible(true);
    } 

}
