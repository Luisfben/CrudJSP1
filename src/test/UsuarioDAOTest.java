package test;

import java.util.Iterator;
import java.util.List;

import dao.UsuarioDAO;
import modelo.Usuario;

public class UsuarioDAOTest {

	public static void main(String[] args) {
		UsuarioDAO dao = new UsuarioDAO();
		List<Usuario> list = dao.listar();
		Iterator<Usuario> iter = list.iterator();
		Usuario usu = null;
		while (iter.hasNext())
			usu = iter.next();
		
		System.out.println(usu.getPerfil());

	}

}
