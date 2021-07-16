package main.java.com.wbc.core.classes;

import java.util.UUID;

public class FactureLigneClasse {
	
	/**
	 * Identifiant unique de la facture
	 */
	private UUID uuid;
	
	private String designation;
	private String quantite;
	private String pu_ht;
	private String montant_ht;
	private String total_ttc;
	
	
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getQuantite() {
		return quantite;
	}
	public void setQuantite(String quantite) {
		this.quantite = quantite;
	}
	public String getPu_ht() {
		return pu_ht;
	}
	public void setPu_ht(String pu_ht) {
		this.pu_ht = pu_ht;
	}
	public String getMontant_ht() {
		return montant_ht;
	}
	public void setMontant_ht(String montant_ht) {
		this.montant_ht = montant_ht;
	}
	public String getTotal_ttc() {
		return total_ttc;
	}
	public void setTotal_ttc(String total_ttc) {
		this.total_ttc = total_ttc;
	}
	public FactureLigneClasse(String designation, String quantite, String pu_ht, String montant_ht, String total_ttc) {
		super();
		this.designation = designation;
		this.quantite = quantite;
		this.pu_ht = pu_ht;
		this.montant_ht = montant_ht;
		this.total_ttc = total_ttc;
	}
	public FactureLigneClasse() {
		super();
	}
	
	
	

}
