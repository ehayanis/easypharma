package com.mm.app.view;

import java.awt.Cursor;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class HeaderButton extends JButton{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2493861803779140490L;
	
	private String title;
	private String imgPath;
	
	public HeaderButton() {
		super();
	}
	
	public HeaderButton(String title, String imgPath){
		super();
		this.title = title;
		this.imgPath = imgPath;
		
		setText(title);
		setFont(this.getFont().deriveFont(Font.BOLD));
		setIcon(new ImageIcon(getClass().getResource(imgPath)));
		setBorder(BorderFactory.createEmptyBorder());
		setContentAreaFilled(false);
		setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	
	public HeaderButton(String title, String imgPath, String tooltip){
		this(title, imgPath);
		
		setToolTipText(tooltip);
	}
	
	public void activateButton(boolean isActive){
		setEnabled(isActive);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	
}
