package main.java.com.wbc.core.classes;

import java.util.List;

public class FactureClasse {
	
	private String clientNom;
	private String clientAdresse1;
	private String clientAdresse2;
	private String clientAdresse3;
	private String clientCode_postal;
	private String clientVille;
	private String clientPays;
	private String clientSiret;

	private String factureDate;
	private String factureNumero;

	private String custom1;
	private String custom2;
	private String custom3;
	private String custom4;
	private String custom5;
	private String custom6;
	private String custom7;
	private String custom8;
	private String custom9;
	private String custom10;
	
	private List<FactureLigneClasse> lignes;

	private String totalHtBrut;
	private String remise;
	private String totalHt;
	private String totalTva;
	private String totalTtc;
	private String accompte;
	private String totalAPayer;
	
	private Integer nbLignesFacturation;
	private String pdfFile;
	
	
	public String getPdfFile() {
		return pdfFile;
	}
	public void setPdfFile(String pdfFile) {
		this.pdfFile = pdfFile;
	}
	public Integer getNbLignesFacturation() {
		return nbLignesFacturation;
	}
	public void setNbLignesFacturation(Integer nbLignesFacturation) {
		this.nbLignesFacturation = nbLignesFacturation;
	}
	public String getClientNom() {
		return clientNom;
	}
	public void setClientNom(String clientNom) {
		this.clientNom = clientNom;
	}
	public String getClientAdresse1() {
		return clientAdresse1;
	}
	public void setClientAdresse1(String clientAdresse1) {
		this.clientAdresse1 = clientAdresse1;
	}
	public String getClientAdresse2() {
		return clientAdresse2;
	}
	public void setClientAdresse2(String clientAdresse2) {
		this.clientAdresse2 = clientAdresse2;
	}
	public String getClientAdresse3() {
		return clientAdresse3;
	}
	public void setClientAdresse3(String clientAdresse3) {
		this.clientAdresse3 = clientAdresse3;
	}
	public String getClientCode_postal() {
		return clientCode_postal;
	}
	public void setClientCode_postal(String clientCode_postal) {
		this.clientCode_postal = clientCode_postal;
	}
	public String getClientVille() {
		return clientVille;
	}
	public void setClientVille(String clientVille) {
		this.clientVille = clientVille;
	}
	public String getClientPays() {
		return clientPays;
	}
	public void setClientPays(String clientPays) {
		this.clientPays = clientPays;
	}
	public String getClientSiret() {
		return clientSiret;
	}
	public void setClientSiret(String clientSiret) {
		this.clientSiret = clientSiret;
	}
	public String getFactureDate() {
		return factureDate;
	}
	public void setFactureDate(String factureDate) {
		this.factureDate = factureDate;
	}
	public String getFactureNumero() {
		return factureNumero;
	}
	public void setFactureNumero(String factureNumero) {
		this.factureNumero = factureNumero;
	}
	public String getCustom1() {
		return custom1;
	}
	public void setCustom1(String custom1) {
		this.custom1 = custom1;
	}
	public String getCustom2() {
		return custom2;
	}
	public void setCustom2(String custom2) {
		this.custom2 = custom2;
	}
	public String getCustom3() {
		return custom3;
	}
	public void setCustom3(String custom3) {
		this.custom3 = custom3;
	}
	public String getCustom4() {
		return custom4;
	}
	public void setCustom4(String custom4) {
		this.custom4 = custom4;
	}
	public String getCustom5() {
		return custom5;
	}
	public void setCustom5(String custom5) {
		this.custom5 = custom5;
	}
	public String getCustom6() {
		return custom6;
	}
	public void setCustom6(String custom6) {
		this.custom6 = custom6;
	}
	public String getCustom7() {
		return custom7;
	}
	public void setCustom7(String custom7) {
		this.custom7 = custom7;
	}
	public String getCustom8() {
		return custom8;
	}
	public void setCustom8(String custom8) {
		this.custom8 = custom8;
	}
	public String getCustom9() {
		return custom9;
	}
	public void setCustom9(String custom9) {
		this.custom9 = custom9;
	}
	public String getCustom10() {
		return custom10;
	}
	public void setCustom10(String custom10) {
		this.custom10 = custom10;
	}
	public List<FactureLigneClasse> getLignes() {
		return lignes;
	}
	public void setLignes(List<FactureLigneClasse> lignes) {
		this.lignes = lignes;
	}
	public String getTotalHtBrut() {
		return totalHtBrut;
	}
	public void setTotalHtBrut(String totalHtBrut) {
		this.totalHtBrut = totalHtBrut;
	}
	public String getRemise() {
		return remise;
	}
	public void setRemise(String remise) {
		this.remise = remise;
	}
	public String getTotalHt() {
		return totalHt;
	}
	public void setTotalHt(String totalHt) {
		this.totalHt = totalHt;
	}
	public String getTotalTva() {
		return totalTva;
	}
	public void setTotalTva(String totalTva) {
		this.totalTva = totalTva;
	}
	public String getTotalTtc() {
		return totalTtc;
	}
	public void setTotalTtc(String totalTtc) {
		this.totalTtc = totalTtc;
	}
	public String getAccompte() {
		return accompte;
	}
	public void setAccompte(String accompte) {
		this.accompte = accompte;
	}
	public String getTotalAPayer() {
		return totalAPayer;
	}
	public void setTotalAPayer(String totalAPayer) {
		this.totalAPayer = totalAPayer;
	}
	
	
	
	

}
