package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connessione.Connessione;

public class Repliche{

	Connessione bd = new Connessione();
	
	private String cod_replica = null;
	private String cod_spettacolo = null;
	private String data_replica = null;
	
//	private ArrayList<Repliche> elenco;
	
	public String getCodReplica() {
		return cod_replica;
	}

	public void setCodReplica(String cod_replica) {
		this.cod_replica = cod_replica;
	}

	public String getCodSpettacolo() {
		return cod_spettacolo;
	}

	public void setCodSpettacolo(String cod_spettacolo) {
		this.cod_spettacolo = cod_spettacolo;
	}

	public String getDataReplica() {
		return data_replica;
	}

	public void setDataReplica(String data_replica) {
		this.data_replica = data_replica;
	}


	public Repliche(){
//		elenco = this.elencoRepliche();
	}
	
//	public ArrayList<Repliche> getElenco() {
//		return elenco;
//	}

	public Repliche(String cod_replica, String cod_spettacolo, String data_replica) {
		this.cod_replica = cod_replica;
		this.cod_spettacolo = cod_spettacolo;
		this.data_replica = data_replica;
	}

	public ArrayList<Repliche> elencoRepliche(){
		
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT c.nome, b.titolo, a.data, a.cod_replica " +asd
				"FROM `repliche` as a "+
				"join spettacoli as b on a.cod_spettacolo=b.cod_spettacolo "+
				"JOIN teatri as c ON b.cod_teatro=c.cod_teatro";
		ArrayList<Repliche> lista = new ArrayList<>();
		
		try{
			stmt=bd.getConnessione().createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				
				lista.add(new Repliche(rs.getString(1),rs.getString(2),rs.getString(3)));
			}
		}
		
		catch(SQLException e){
			
			e.printStackTrace();
		}
		
		return lista;
		
		
	}
	

//@Override
//	public String toString() {
//		return this.teatro + 
//		this.titolo+
//		this.data  +
//		this.id_rappresentazione ;
//	}
//	
}
