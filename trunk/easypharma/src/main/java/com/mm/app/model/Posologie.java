package com.mm.app.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Posologie
 *
 */
@Entity

public class Posologie implements Serializable {

	@Id
	@GeneratedValue
	private int id;
	private String codex;
	private String dosage;
	private String forme;
	private String unite;
	private String preparation;
	private String action;
	private String applications;
	private String avertissement;
	private String recommendation;
	
	private static final long serialVersionUID = 1L;

	public Posologie() {
		super();
	}

	public String getCodex() {
		return codex;
	}

	public void setCodex(String codex) {
		this.codex = codex;
	}

	public String getDosage() {
		return dosage;
	}

	public void setDosage(String dosage) {
		this.dosage = dosage;
	}

	public String getForme() {
		return forme;
	}

	public void setForme(String forme) {
		this.forme = forme;
	}

	public String getUnite() {
		return unite;
	}

	public void setUnite(String unite) {
		this.unite = unite;
	}

	public String getPreparation() {
		return preparation;
	}

	public void setPreparation(String preparation) {
		this.preparation = preparation;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getApplications() {
		return applications;
	}

	public void setApplications(String applications) {
		this.applications = applications;
	}

	public String getAvertissement() {
		return avertissement;
	}

	public void setAvertissement(String avertissement) {
		this.avertissement = avertissement;
	}

	public String getRecommendation() {
		return recommendation;
	}

	public void setRecommendation(String recommendation) {
		this.recommendation = recommendation;
	}
   
}
