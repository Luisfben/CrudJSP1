package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
	private static ConexionBD conexionBd = null;
	private Connection con = null;

	public static Connection getConnection() {
		if (conexionBd == null) {
			conexionBd = new ConexionBD();
		}
		// return conexionBd;
		return conexionBd.getCon();
	}

	private ConexionBD() {
		String connectionUrl = "jdbc:sqlserver://192.168.99.100:32771;databaseName=test;user=sa;password=Gordis2019";
		Connection con = null;
		try {
			con = DriverManager.getConnection(connectionUrl);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.setCon(con);
	}

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}

}
