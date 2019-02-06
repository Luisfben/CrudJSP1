package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import config.ConexionBD;
import interfaz.IUsuarioDAO;
import modelo.Usuario;

public class UsuarioDAO implements IUsuarioDAO {
	Connection cn = ConexionBD.getConnection();
	PreparedStatement ps;
	ResultSet rs;
	Usuario usuario = new Usuario();

	@Override
	public List listar() {
		ArrayList<Usuario> list = new ArrayList<>();
		String sql = "select * from dbo.usuario";
		try {
			ps = cn.prepareStatement(sql);
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
	public boolean editar(Usuario usuario) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(Usuario usuario) {
		// TODO Auto-generated method stub
		return false;
	}

}
