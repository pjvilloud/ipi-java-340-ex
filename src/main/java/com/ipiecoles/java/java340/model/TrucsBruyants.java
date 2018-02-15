package com.ipiecoles.java.java340.model;


public class TrucsBruyants {
	
	private Integer dB;
	
	public Bruit equivalenceDecibels(){
		if(dB == null){
			return null;
		}
		switch (dB) {
			case 5:
				return Bruit.Glandeur;
			case 10:
				return Bruit.VentDansLesArbres;
			case 30:
				return Bruit.Chuchotement;
			case 55:
				return Bruit.ConversationNormale;
			case 65:
				return Bruit.AspirateurDomestique;
			case 92:
				return Bruit.TondeuseGazonEssence;
			case 95:
				return Bruit.RotativeJournaux;
			case 115:
				return Bruit.MarteauPneumatique;
			case 120:
				return Bruit.SeuilDeDouleur;
			case 125:
				return Bruit.AvionAReactionAuDecollage;
			default:
				return null;
		}
	}
	
	public void setDB(Integer dB) {
		this.dB = dB;
	}
	
	public Integer getDB() {
		return dB;
	}
	
}
