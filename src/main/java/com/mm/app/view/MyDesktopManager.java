package com.mm.app.view;

import javax.swing.DefaultDesktopManager;
import javax.swing.JComponent;
import javax.swing.JInternalFrame;

public class MyDesktopManager extends DefaultDesktopManager
{

	public void activateFrame(JInternalFrame f) {
		super.activateFrame(f);
	}
	public void beginDraggingFrame(JComponent f) { 
	}
	public void beginResizingFrame(JComponent f, int direction) { 
	}
	public void closeFrame(JInternalFrame f) {
		super.closeFrame(f);
	}
	public void deactivateFrame(JInternalFrame f) {
		super.deactivateFrame(f);
	}
	public void deiconifyFrame(JInternalFrame f) {
		super.deiconifyFrame(f);
	}
	public void dragFrame(JComponent f, int newX, int newY) {
		f.setLocation(newX, newY);
	}
	public void endDraggingFrame(JComponent f) {
	}
	public void endResizingFrame(JComponent f) {
	}
	public void iconifyFrame(JInternalFrame f) {
		super.iconifyFrame(f);
	}
	public void maximizeFrame(JInternalFrame f) {
		super.maximizeFrame(f);
	}
	public void minimizeFrame(JInternalFrame f) {
		super.minimizeFrame(f);
	}
	public void openFrame(JInternalFrame f) {
	}
	public void resizeFrame(JComponent f, int newX, int newY, int newWidth, int newHeight) {
		f.setBounds(newX, newY, newWidth, newHeight);
	}
	public void setBoundsForFrame(JComponent f, int newX, int newY, int newWidth, int newHeight) {
		f.setBounds(newX, newY, newWidth, newHeight);
	}
}