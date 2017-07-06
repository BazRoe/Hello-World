package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connessione.Connessione;

public class Repliche{

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


//@Override
//	public String toString() {
//		return this.teatro + 
//		this.titolo+
//		this.data  +
//		this.id_rappresentazione ;
//	}
//	
}
