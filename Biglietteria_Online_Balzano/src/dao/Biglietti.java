package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import connessione.Connessione;

public class Biglietti{

	private String cod_cliente = null;
	private String cod_replica = null;
	private String data_ora = null;
	private String tipoPagamento = null;
	private int quantita;
	
	public String getCod_cliente() {
		return cod_cliente;
	}

	public void setCod_cliente(String cod_cliente) {
		this.cod_cliente = cod_cliente;
	}

	public String getCod_replica() {
		return cod_replica;
	}

	public void setCod_replica(String cod_replica) {
		this.cod_replica = cod_replica;
	}

	public String getData_ora() {
		return data_ora;
	}

	public void setData_ora(String data_ora) {
		this.data_ora = data_ora;
	}

	public String getTipoPagamento() {
		return tipoPagamento;
	}

	public void setTipoPagamento(String tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}

	public int getQuantita() {
		return quantita;
	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}


	public Biglietti(){}
	
	public Biglietti(String cod_cliente, String cod_replica, String data_ora, String tipoPagamento, int quantita) {
		this.cod_cliente = cod_cliente;
		this.cod_replica = cod_replica;
		this.data_ora = data_ora;
		this.tipoPagamento = tipoPagamento;
		this.quantita = quantita;
	}
	
	public Biglietti(String cod_cliente, String cod_replica, String tipoPagamento, int quantita) {
		this.cod_cliente = cod_cliente;
		this.cod_replica = cod_replica;
		this.tipoPagamento = tipoPagamento;
		this.quantita = quantita;
	}
	
	public boolean controllaPosti(String cod, int num) throws SQLException{
		
		Connessione bd = new Connessione();
		
		boolean b = true;
		
		Statement stmt = null;
		ResultSet rs = null;
		//String sql = "SELECT SUM(quantita) FROM biglietti where cod_replica = '" + cod + "'";
		String sql = "SELECT SUM(quantita), posti "+
					 "FROM biglietti JOIN repliche JOIN spettacoli JOIN teatri "+
					 "where biglietti.cod_replica = '" + cod + "' AND repliche.cod_replica = '" + cod + "' AND spettacoli.cod_spettacolo = repliche.cod_spettacolo "+
				 	"AND spettacoli.cod_teatro = teatri.cod_teatro";
		
		try{
			stmt=bd.getConnessione().createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				int count = rs.getInt(1);
				int postiTotali = rs.getInt(2);
				if ((count + num) >= postiTotali){
					b = false;
				}
			}
			
		}
		
		catch(SQLException e){
			e.printStackTrace();
		}finally{
			bd.getConnessione().close();
		}
		
		
		return b;
	}


	public boolean inserisciBiglietto() throws SQLException{
		
		Connessione bd = new Connessione();
		
		boolean b = true;
		
		Statement stmt = null;
		String sql = "INSERT INTO biglietti (cod_cliente, cod_replica, data_ora, tipo_pagamento, quantita) "
				+ " values('" +this.cod_cliente+"','"+this.cod_replica+"',NOW(),'"+ this.tipoPagamento +"','" +this.quantita+"')";
		try{
			stmt=bd.getConnessione().createStatement();
			stmt.executeUpdate(sql);
		}
		
		catch(SQLException e){
			b = false;
			e.printStackTrace();
		}finally{
			bd.getConnessione().close();
		}
		
		return b;
		
		
	}
	
//	SELECT * FROM biglietti where cod_cliente = '';

	public ArrayList<ArrayList<Object>> elencoBiglietti(String cod) throws SQLException{
		
		Connessione bd = new Connessione();
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT clienti.cognome, clienti.nome, biglietti.tipo_pagamento, biglietti.quantita, repliche.data_replica, spettacoli.titolo, " +
					 "spettacoli.autore, spettacoli.regista, teatri.nome " +
					 "FROM biglietti JOIN repliche JOIN spettacoli JOIN teatri JOIN clienti " +
					 "where biglietti.cod_cliente = '" + cod + "' AND clienti.cod_cliente = biglietti.cod_cliente AND " + 
				 	 "repliche.cod_replica = biglietti.cod_replica AND spettacoli.cod_spettacolo = repliche.cod_spettacolo AND " +
					 "teatri.cod_teatro = spettacoli.cod_teatro";
		
		ArrayList<ArrayList<Object>> lista = new ArrayList<>();
		
		try{
			stmt=bd.getConnessione().createStatement();
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				
				ArrayList<Object> dati = new ArrayList<>();
				
				dati.add(rs.getString(1));
				dati.add(rs.getString(2));
				dati.add(rs.getString(3));
				dati.add(rs.getInt(4));
				dati.add(rs.getDate(5));
				dati.add(rs.getString(6));
				dati.add(rs.getString(7));
				dati.add(rs.getString(8));
				dati.add(rs.getString(9));
				
				lista.add(dati);
			}
			
		}
		
		catch(SQLException e){
			
			e.printStackTrace();
		}finally{
			bd.getConnessione().close();
		}
		
		return lista;
		
	}



//	@Override
//	public String toString() {
//		// TODO Auto-generated method stub
//		//UtentiDAO u = new UtentiDAO(this.id_utenti);
//		return this.data_viaggio + this.id_tratte + this.id_utenti;
//	}
	
	

	
}
