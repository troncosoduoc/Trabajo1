package cl.duoc.trabajo1.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDAO {
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/trabajo1","root", "root");
		} catch (ClassNotFoundException classException) {
			classException.printStackTrace();
			conn = null;
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
			conn = null;
		}

		return conn;
	}
	
	public static void closeConnection(Connection conn){
		try{
			conn.close();
		}catch(SQLException sqlEX){
			sqlEX.printStackTrace();
		}
	}
}
