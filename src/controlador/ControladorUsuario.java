package controlador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsuarioDAO;
import modelo.Usuario;

/**
 * Servlet implementation class ControladorUsuario
 */
@WebServlet("/ControladorUsuario")
public class ControladorUsuario extends HttpServlet {
	String vistaListar = "vistas/listar.jsp";
	String vistaAdicionar = "vistas/adicionar.jsp";
	String vistaEditar = "vistas/editar.jsp";

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControladorUsuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		String acceso = "";
		String action = request.getParameter("accion");
		if (action != null) {
			if (action.equals("listar")) {
				acceso = vistaListar;
			}

			if (action.equals("editar")) {
				acceso = vistaEditar + "?usuario=" + request.getParameter("usuario");
			}
			if (action.equals("eliminar")) {
				// if (action.equals("guardar")) {
				UsuarioDAO dao = new UsuarioDAO();
				dao.eliminar(request.getParameter("usuario"));
				acceso = vistaListar;
			}

		}
		if (request.getParameter("guardar") != null) {
			// if (action.equals("guardar")) {
			UsuarioDAO dao = new UsuarioDAO();
			Usuario usuario = new Usuario();
			usuario.setPerfil(request.getParameter("perfil"));
			usuario.setUsuario(request.getParameter("usuario"));
			usuario.setNombre(request.getParameter("nombre"));
			usuario.setApellido(request.getParameter("apellido"));

			dao.editar(usuario);
			acceso = vistaListar;
		}

		RequestDispatcher vista = request.getRequestDispatcher(acceso);
		vista.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
