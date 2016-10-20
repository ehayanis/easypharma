package com.mm.app.utilities;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

import javax.print.PrintService;
import javax.print.PrintServiceLookup;

public class PrintPosologie implements Printable, ActionListener {

	private String patientName;
	private String[] posologieLines;
	private String produit;
	private String pharmacienName;

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String[] getPosologieLines() {
		return posologieLines;
	}

	public void setPosologieLines(String[] posologieLines) {
		this.posologieLines = posologieLines;
	}

	public String getProduit() {
		return produit;
	}

	public void setProduit(String produit) {
		this.produit = produit;
	}

	public String getPharmacienName() {
		return pharmacienName;
	}

	public void setPharmacienName(String pharmacienName) {
		this.pharmacienName = pharmacienName;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		/**set the printerName from properties file*/
		String printerName = setPosologiePrinter();
		PrintService[] printServices = PrintServiceLookup.lookupPrintServices(null, null);
		for (PrintService printer : printServices) {
			System.out.println("Printer: " + printer.getName());
			if (printer.getName().equals(printerName)) {
				try {
					PrinterJob job = PrinterJob.getPrinterJob();
					job.setPrintService(printer);
					PageFormat pf = job.defaultPage();
				    Paper paper = pf.getPaper();
				    paper.setImageableArea(paper.getImageableX()+5, 10, paper.getWidth(), paper.getHeight());
				    pf.setPaper(paper);
					job.setPrintable(this,pf);
					job.print();
				} catch (PrinterException ex) {
					/** The job did not successfully complete */
				}
			}
		}
	}

	@Override
	public int print(Graphics g, PageFormat pf, int page) throws PrinterException {

		if (page > 0) { /* We have only one page, and 'page' is zero-based */
			return NO_SUCH_PAGE;
		}

		/*
		 * User (0,0) is typically outside the imageable area, so we must
		 * translate by the X and Y values in the PageFormat to avoid clipping
		 */
		Graphics2D g2d = (Graphics2D) g;
		g2d.translate(pf.getImageableX(), pf.getImageableY());

		int x = 10;
		int y = 10;

		Font boldfont = new Font("Arial Unicode MS", Font.BOLD, 8);
		Font plainfont = new Font("Arial Unicode MS", Font.PLAIN, 8);
		Font smallboldfont = new Font("Arial Unicode MS", Font.BOLD, 6);
		Font smallplainfont = new Font("Arial Unicode MS", Font.PLAIN, 6);
		g2d.setFont(boldfont);

		String text = null;

		/** Printing the posologie's header */
		text = this.patientName;
		g2d.drawString(text, x + 30, y);

		/** Printing the posologie's lines */
		int length = "1 comprimé par jour matin et soir ".length();
		StringBuilder sb = new StringBuilder("");
		g2d.setFont(plainfont);
		for (String string : posologieLines) {
		    if((sb.toString().length() +string.length())> length) { 
		        g2d.drawString(sb.toString(), x, (y += 10)); 
		        sb = new StringBuilder(""); 
		    }
		    sb.append(string+" ");
		}
		g2d.drawString(sb.toString(), x, (y += 10));
		/** Printing the drugs names */
		g2d.setFont(smallplainfont);
		int recWidth = "T. Shoul Pharmacien Resp. 022 700 47 89  Mohammed".length();
		String dateString = new SimpleDateFormat("dd.MM.yyyy").format(Calendar.getInstance().getTime());
		String product = (this.produit.length() > (recWidth - 20))? this.produit.substring(0, (recWidth - 20)) : this.produit;
		text = product + dateString;
		g2d.drawString(text, x + 2, y += 30);
		text = "T. Shoul Pharmacien Resp. 022 700 47 89  " + this.pharmacienName;
		g2d.drawRect(x, y - 7, g2d.getFontMetrics(smallplainfont).stringWidth(text) + 2, 10);

		/** Printing the posologie's footer */
		g2d.setFont(smallboldfont);
		text = "PHARMACIE de Villereuse";
		g2d.drawString(text, x, (y += 10));
		g2d.setFont(smallplainfont);
		text = "Rue de la Terrassiére 32 1207 Genéve ";
		g2d.drawString(text, x, (y += 8));
		text = "T. Shoul Pharmacien Resp. 022 700 47 89  " + this.pharmacienName;
		g2d.drawString(text, x, (y += 8));
		g2d.dispose();

		/** tell the caller that this page is part of the printed document */
		return PAGE_EXISTS;
	}
	
	public String setPosologiePrinter(){
		Properties prop = new Properties();
		InputStream input = null;
		String printerName = null;

		try {
			input = new FileInputStream("printer.properties");
			// load a properties file
			prop.load(input);
			// get the property value and print it out
			printerName = prop.getProperty("posologiePrinter");

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return printerName;
	}

}