package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import connessione.Connessione;

public class Teatri{
	
	public static final int POSTI_CARIGNANO = 875;	//T001
	public static final int POSTI_REGIO = 1592;		//T002
	public static final int POSTI_ALFIERI = 1500;	//T003
	
	Connessione bd = new Connessione();
	
	private String cod_teatro = null;
	private String nome = null;
	private String indirizzo = null;
	private String citta = null;
	private String provincia = null;
	private String telefono = null;
	private int posti;
	

	public String getCodTeatro() {
		return cod_teatro;
	}

	public void setCodTeatro(String cod_teatro) {
		this.cod_teatro = cod_teatro;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public int getPosti() {
		return posti;
	}

	public void setPosti(int posti) {
		this.posti = posti;
	}
	
	public Teatri(){}
	
	public Teatri(String cod_teatro){
		
		Teatri u = this.trovaTeatro(cod_teatro);
		
		this.nome = u.getNome();
		this.indirizzo = u.getIndirizzo();
		this.citta = u.getCitta();
		this.provincia = u.getProvincia();
		this.telefono = u.getTelefono();
		this.posti = u.getPosti();
	}
	

	public Teatri(String cod_teatro, String nome, String indirizzo, String citta, String provincia, String telefono,
			int posti) {
		this.cod_teatro = cod_teatro;
		this.nome = nome;
		this.indirizzo = indirizzo;
		this.citta = citta;
		this.provincia = provincia;
		this.telefono = telefono;
		this.posti = posti;
	}

	public ArrayList<Teatri> elencoTeatri(){
		
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM teatri";
		ArrayList<Teatri> lista = new ArrayList<>();
		
		try {
			stmt=bd.getConnessione().createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				
				lista.add(new Teatri(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7)));
			}
		}
		
		catch(SQLException e){
			
			e.printStackTrace();
		} 
		
		return lista;
		
		
	}
	
	public ArrayList<ArrayList<Object>> visualizzaSpettacoliPerTeatro(){
		
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT t.nome, s.titolo, s.autore, s.regista, s.prezzo, r.data_replica, r.cod_replica" +
					 "FROM teatri t, spettacoli s, repliche r" +
					 "WHERE t.cod_teatro = s.cod_teatro and s.cod_spettacolo = r.cod_spettacolo";
		ArrayList<ArrayList<Object>> lista = new ArrayList<>();
		
		try{
			stmt=bd.getConnessione().createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				
				//p = new Teatri(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7));
				ArrayList<Object> dati = new ArrayList<>();
				
				dati.add(rs.getString(1));
				dati.add(rs.getString(2));
				dati.add(rs.getString(3));
				dati.add(rs.getString(4));
				dati.add(rs.getDouble(5));
				dati.add(rs.getDate(6));
				dati.add(rs.getString(7));
				
				lista.add(dati);
			}
			
		}
		
		catch(SQLException e){
			
			e.printStackTrace();
		}
		
		return lista;
		
	}
	
	
	
	
	
	
	
	public Teatri trovaTeatro(String i){
		
		
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM teatri  where cod_teatro =  " + i + "";
		System.out.println(sql);
		Teatri p = null;
		
		try{
			stmt=bd.getConnessione().createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				
				p = new Teatri(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7));
			}
		}
		
		catch(SQLException e){
			
			e.printStackTrace();
		}
		
		return p;
		
		
	}
	
	@Override
	public String toString() {
		return "Codice teatro: " + this.cod_teatro + "\t Nome:" + this.nome + "\t Indirizzo: " + this.indirizzo + 
				"\t citta: " + this.citta + "\t provincia: " + this.provincia + "\t Telefono: " + this.telefono + "\t posti: " + this.posti;
	}
	

	
}
