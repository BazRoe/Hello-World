package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connessione.Connessione;

public class Spettacoli{
	
	Connessione bd = new Connessione();
	
	private String cod_spettacolo = null;
	private String titolo = null;
	private String autore = null;
	private String regista = null;
	private double prezzo;
	private String cod_teatro = null;

	public String getCodSpettacolo() {
		return cod_spettacolo;
	}

	public void setCodSpettacolo(String cod_spettacolo) {
		this.cod_spettacolo = cod_spettacolo;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getAutore() {
		return autore;
	}

	public void setAutore(String autore) {
		this.autore = autore;
	}

	public String getRegista() {
		return regista;
	}

	public void setRegista(String regista) {
		this.regista = regista;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public String getCodTeatro() {
		return cod_teatro;
	}

	public void setCodTeatro(String cod_teatro) {
		this.cod_teatro = cod_teatro;
	}

	public Spettacoli(){}
	
	public Spettacoli(String cod_spettacolo, String titolo, String autore, String regista, double prezzo,
			String cod_teatro) {
		this.cod_spettacolo = cod_spettacolo;
		this.titolo = titolo;
		this.autore = autore;
		this.regista = regista;
		this.prezzo = prezzo;
		this.cod_teatro = cod_teatro;
	}

	public ArrayList<Spettacoli> elencoSpettacoli(){
		
		
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM spettacoli";
		ArrayList<Spettacoli> lista = new ArrayList<>();
		
		try{
			stmt=bd.getConnessione().createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				
				lista.add(new Spettacoli(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5), rs.getString(6)));
			}
		}
		
		catch(SQLException e){
			
			e.printStackTrace();
		}
		
		return lista;
		
		
	}
	
	public Spettacoli trovaSpettacoli(String i){
		
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM spettacoli  where cod_spettacolo =  " + i + "";
		Spettacoli p = null;
		
		try{
			stmt=bd.getConnessione().createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				
				p = new Spettacoli(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5), rs.getString(6));
			}
		}
		
		catch(SQLException e){
			
			e.printStackTrace();
		}
		
		return p;
		
		
	}

//@Override
//	public String toString() {
//		return this.descrizione;
//	}
//	
}
