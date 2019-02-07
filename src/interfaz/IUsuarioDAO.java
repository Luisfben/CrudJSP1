package interfaz;

import java.util.List;

import modelo.Usuario;

public interface IUsuarioDAO {
	public List listar();

	public Usuario list(String usuario);

	public boolean adiconar(Usuario usuario);

	public void editar(Usuario usuario);

	public void eliminar(String usuario);
	
	public List consultarUsuario(String usuario);
	
}
