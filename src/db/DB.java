package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DB {
	
	// M�todo para conectar ao banco de dados
	private static Connection conn = null;
	
	public static Connection getConnection() {
		if(conn == null) {
			try {	
				Properties props = loadProperties();
				String url = props.getProperty("dburl");
				conn = DriverManager.getConnection(url, props);
				}
			catch (SQLException e) {
			throw new DbException(e.getMessage());	
			}
		}
		return conn;
	}
	
	//Metodo para fechar a conex�o com o banco de dados
	public static void closeConnection() {
		if(conn != null) {
			try {
				conn.close();
			}
			catch (SQLException e){
				throw new DbException(e.getMessage());
			}
		}
	}
			// tratamento das excecoes para close DB.
	private static Properties loadProperties(){
		try (FileInputStream fs = new FileInputStream("db.properties")){
			Properties props = new Properties();
			props.load(fs);
			return props;			
		}
		catch (IOException e) {
			throw new DbException(e.getMessage());
		}
	}
	// Startement tratamento  exce��es close DB
	public static void closeStatement(Statement st) {
		if(st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				throw new DbException (e.getMessage());
			}
		}		
	}
	// closeResultSet tratamento  exce��es close DB
	public static void closeResultSet(ResultSet rs) {
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				throw new DbException (e.getMessage());
			}
		}
	}
}