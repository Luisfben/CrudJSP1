package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import config.ConexionBD;

public class ConexionBDTest {

	public static void main(String[] args) {
		Connection cn = ConexionBD.getConnection();
		PreparedStatement ps;
		ResultSet rs;
		try {
			ps = cn.prepareStatement("select * from dbo.usuario");
			rs = ps.executeQuery();
			while(rs.next())
				System.out.println(rs.getString("Perfil"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
