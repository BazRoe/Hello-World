package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import connessione.Connessione;

public class Biglietti{

	Connessione bd = new Connessione();
	
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
	
//	INSERT into Biglietti (cod_cliente, cod_replica, data_ora, tipo_pagamento, quantita) values ('', '', '', '', '');
//	
//	SELECT * FROM biglietti where cod_cliente = '';
//	
//	
//	
//	SELECT count(*) FROM biglietti where cod_replica = R001;


	public boolean inserisciBiglietto(){
		
		boolean b = true;
		
		Statement stmt = null;
		String sql = "INSERT INTO biglietti (cod_cliente, cod_replica, data_ora, tipo_pagamento, quantita) "
				+ " values('" +this.cod_cliente+"','"+this.cod_replica+"','NOW()','"+ this.tipoPagamento +"','" +this.quantita+"')";
		try{
			stmt=bd.getConnessione().createStatement();
			stmt.executeUpdate(sql);
		}
		
		catch(SQLException e){
			b = false;
			e.printStackTrace();
		}
		
		return b;
		
		
	}

	public ArrayList<Biglietti> elencoBiglietti(){
		
		
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM viaggi";
		ArrayList<Biglietti> lista = new ArrayList<>();
		
		try{
			stmt=bd.getConnessione().createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				
				lista.add(
						new Biglietti(rs.getInt(2),rs.getInt(3),rs.getString(4),rs.getInt(5)));
			}
		}
		
		catch(SQLException e){
			
			e.printStackTrace();
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
