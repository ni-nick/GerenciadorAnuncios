package Entidades;

import java.util.Date;

public class Anuncio {
	
	private String nomeAnuncio;
	private int diaI;
	private int mesI;
	private int anoI;
	private int diaF;
	private int mesF;
	private int anoF;
	private String Investimento;
	private int IdAnuncios;
	
	
	public String getInvestimento() {
		return Investimento;
	}
	public void setInvestimento(String investimento) {
		Investimento = investimento;
	}
	
	public int getDiaI() {
		return diaI;
	}
	public void setDiaI(int diaI) {
		this.diaI = diaI;
	}
	public int getMesI() {
		return mesI;
	}
	public void setMesI(int mesI) {
		this.mesI = mesI;
	}
	public int getAnoI() {
		return anoI;
	}
	public void setAnoI(int anoI) {
		this.anoI = anoI;
	}
	public int getDiaF() {
		return diaF;
	}
	public void setDiaF(int diaF) {
		this.diaF = diaF;
	}
	public int getMesF() {
		return mesF;
	}
	public void setMesF(int mesF) {
		this.mesF = mesF;
	}
	public int getAnoF() {
		return anoF;
	}
	public void setAnoF(int anoF) {
		this.anoF = anoF;
	}
	
	public int getIdAnuncio() {
		return IdAnuncios;
	}
	public void setIdAnuncio(int idAnuncio) {
		IdAnuncios = idAnuncio;
	}
	public String getNomeAnuncio() {
		return nomeAnuncio;
	}
	public void setNomeAnuncio(String nomeAnuncio) {
		this.nomeAnuncio = nomeAnuncio;
	}

}
