<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.UsuarioDAO" %>
<%@ page import="modelo.Usuario" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listar usuarios</title>
</head>
<body>
	<div>
		<table border="1">
			<thead>
				<tr>
					<th>perfil</th>
					<th>usuario</th>
					<th>nombre</th>
					<th>apellido</th>
					<th>acciones</th>
				</tr>
			</thead>
			<% 
				UsuarioDAO dao = new UsuarioDAO();
				List<Usuario> list = dao.listar();
				Iterator<Usuario> iter=list.iterator();
				Usuario usu=null;
				while(iter.hasNext()){
					usu=iter.next();
			%>
			<tbody>
				<tr>
					<td><%=usu.getPerfil() %></td>
					<td><%=usu.getUsuario() %></td>
					<td><%=usu.getNombre() %></td>
					<td><%=usu.getApellido() %></td>
					<td>
						<a href="ControladorUsuario?accion=editar&usuario=<%=usu.getUsuario() %>">editar</a>
						<a href="ControladorUsuario?accion=eliminar&usuario=<%=usu.getUsuario() %>">eliminar</a>
					</td>
				</tr>
				<%}%>
			</body>
		</table>
	</div>
</body>
</html>