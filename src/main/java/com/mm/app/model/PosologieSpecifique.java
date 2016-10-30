package com.mm.app.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="posologie_specifique")
public class PosologieSpecifique implements Serializable {

	@Id
	@GeneratedValue
	private int id;
	
	private int quantity;
	private int heures;
	private boolean matin;
	private boolean midi;
	private boolean soir;
	private boolean nuit;
	private String repas;
	private String condition;
	private int rythme;
	@Column(name="nombre_jours")
	private int njours;
	private int dureeTotal;
	
	private  String etiquette;
	private String avertissement;
	
	private static final long serialVersionUID = 1L;

	public PosologieSpecifique() {
		super();
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getHeures() {
		return heures;
	}

	public void setHeures(int heures) {
		this.heures = heures;
	}

	public boolean isMatin() {
		return matin;
	}

	public void setMatin(boolean matin) {
		this.matin = matin;
	}

	public boolean isMidi() {
		return midi;
	}

	public void setMidi(boolean midi) {
		this.midi = midi;
	}

	public boolean isSoir() {
		return soir;
	}

	public void setSoir(boolean soir) {
		this.soir = soir;
	}

	public boolean isNuit() {
		return nuit;
	}

	public void setNuit(boolean nuit) {
		this.nuit = nuit;
	}

	public String getRepas() {
		return repas;
	}

	public void setRepas(String repas) {
		this.repas = repas;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public int getRythme() {
		return rythme;
	}

	public void setRythme(int rythme) {
		this.rythme = rythme;
	}

	public int getNjours() {
		return njours;
	}

	public void setNjours(int njours) {
		this.njours = njours;
	}

	public int getDureeTotal() {
		return dureeTotal;
	}

	public void setDureeTotal(int dureeTotal) {
		this.dureeTotal = dureeTotal;
	}

	public String getEtiquette() {
		return etiquette;
	}

	public void setEtiquette(String etiquette) {
		this.etiquette = etiquette;
	}

	public String getAvertissement() {
		return avertissement;
	}

	public void setAvertissement(String avertissement) {
		this.avertissement = avertissement;
	}
   
}
