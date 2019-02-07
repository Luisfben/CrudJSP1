package config;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
	Connection con;

	public Conexion() {
		String connectionUrl = "jdbc:sqlserver://192.168.99.100:32772;databaseName=test;user=sa;password=Gordis2019";
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(connectionUrl);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Connection getConnection() {
		return con;
	}
}
