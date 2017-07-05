package connessione;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connessione{
	
	
	private final String DRIVER = "com.mysql.jdbc.Driver";
	private final String URL       = "jdbc:mysql://localhost:3306/biglietteria_online";
	private final String USER     = "root";
	private final String PASS    = "";
	
	
	public Connection getConnessione(){
		
		Connection conn = null;
		
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		

		try{
			conn= DriverManager.getConnection(URL,USER,PASS);
		}catch(SQLException e){
				e.printStackTrace();
			}
		return conn;
		
	}
	
	public static void main(String[] args) {
		Connessione c = new Connessione();
		System.out.println(c.getConnessione());
	}
	
	

}
