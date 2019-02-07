package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import config.Conexion;
import config.ConexionBD;
import interfaz.IUsuarioDAO;
import modelo.Usuario;

public class UsuarioDAO implements IUsuarioDAO {
	Conexion cn = new Conexion();
	Connection con;
	PreparedStatement ps;
	Statement s;
	ResultSet rs;
	Usuario usuario = new Usuario();

	/*
	 * @Override public List listar() { ArrayList<Usuario> list = new ArrayList<>();
	 * Usuario usuario = new Usuario(); usuario.setPerfil("Administrador");
	 * list.add(usuario); return list; }
	 */

	@Override
	public List listar() {
		ArrayList<Usuario> list = new ArrayList<>();
		String sql = "select * from dbo.usuario";
		try {
			con = cn.getConnection();
			ps = con.prepareStatement(sql);
			// s = cn.createStatement();
			rs = ps.executeQuery();
			while (rs.next()) {
				Usuario usuario = new Usuario();

				usuario.setPerfil(rs.getString("perfil"));
				usuario.setUsuario(rs.getString("usuario"));
				usuario.setNombre(rs.getString("nombre"));
				usuario.setApellido(rs.getString("apellido"));

				list.add(usuario);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Usuario list(String usuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean adiconar(Usuario usuario) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void editar(Usuario usuario) {
		String sql = "update dbo.usuario " 
				+ "set perfil = '" + usuario.getPerfil() +"'" 
				+ ", nombre = '" + usuario.getNombre() +"'" 
				+ ", apellido = '" + usuario.getApellido() +"'" 
				+ " where usuario = '" + usuario.getUsuario() +"'";
		try {
			con = cn.getConnection();
			ps = con.prepareStatement(sql);
			ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void eliminar(String usuario) {
		String sql = "delete from dbo.usuario " 
				+ " where usuario = '" + usuario +"'";
		try {
			con = cn.getConnection();
			ps = con.prepareStatement(sql);
			ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List consultarUsuario(String usu) {
		ArrayList<Usuario> list = new ArrayList<>();
		String sql = "select * from dbo.usuario where usuario='" + usu + "'";
		try {
			con = cn.getConnection();
			ps = con.prepareStatement(sql);
			// s = cn.createStatement();
			rs = ps.executeQuery();
			while (rs.next()) {
				Usuario usuario = new Usuario();

				usuario.setPerfil(rs.getString("perfil"));
				usuario.setUsuario(rs.getString("usuario"));
				usuario.setNombre(rs.getString("nombre"));
				usuario.setApellido(rs.getString("apellido"));

				list.add(usuario);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
