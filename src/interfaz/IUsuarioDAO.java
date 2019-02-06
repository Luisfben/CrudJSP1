package interfaz;

import java.util.List;

import modelo.Usuario;

public interface IUsuarioDAO {
	public List listar();

	public Usuario list(String usuario);

	public boolean adiconar(Usuario usuario);

	public boolean editar(Usuario usuario);

	public boolean eliminar(Usuario usuario);
}
