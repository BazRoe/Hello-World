package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connessione.Connessione;

public class Clienti{

	Connessione bd = new Connessione();
	
	private String cod_cliente = null;
	private String cognome = null;
	private String nome = null;
	private String telefono = null;
	private String email = null;
	
	
	public String getCodCliente() {
		return cod_cliente;
	}

	public void setCodCliente(String cod_cliente) {
		this.cod_cliente = cod_cliente;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public Clienti(){}
	
	public Clienti(String cod_utente){
		
		Clienti u = this.trovaCliente(cod_utente);
		
		this.cognome = u.getCognome();
		this.nome = u.getNome();
		this.telefono = u.getTelefono();
		this.email = u.getEmail();
	}
	
	
	public Clienti(String cod_cliente, String cognome, String nome, String telefono, String email) {
		
		this.cod_cliente = cod_cliente;
		this.cognome = cognome;
		this.nome = nome;
		this.telefono = telefono;
		this.email = email;
	}
	
	

	public ArrayList<Clienti> elencoClienti(){
		
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM clienti";
		ArrayList<Clienti> lista = new ArrayList<>();
		
		try {
			stmt=bd.getConnessione().createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				lista.add(new Clienti(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
			}
		}
		
		catch(SQLException e){
			
			e.printStackTrace();
		} 
		
		return lista;
		
		
	}
	
	public Clienti trovaCliente(String i){
		
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM clienti where cod_cliente = " + i + "";
		Clienti p = null;
		
		try{
			stmt = bd.getConnessione().createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				p = new Clienti(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
			}
			
			
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		return p;
		
		
	}
	
	@Override
	public String toString() {
		return "Codice utente: " + this.cod_cliente + "\t Nome:" + this.nome + "\t Cognome: " + this.cognome + "\t Telefono: " + this.telefono + "\t email: " + this.email;
	}
	

	
}
