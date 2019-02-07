<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="dao.UsuarioDAO" %>
<%@ page import="modelo.Usuario" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Editar</title>
</head>
<body>
<form action="ControladorUsuario" method="post">
<div>
	<% 
	UsuarioDAO dao = new UsuarioDAO();
	List<Usuario> list = dao.consultarUsuario(request.getParameter("usuario"));
	Iterator<Usuario> iter = list.iterator();
	Usuario usu = null;
	while(iter.hasNext()){
		usu=iter.next();
	%>
	<p>Perfil</p>
	<input type="text" name="perfil" value="<%=usu.getPerfil() %>">
	<p>Usuario</p>
	<input type="text" name="usuario" value="<%=usu.getUsuario() %>">
	<p>Nombre</p>
	<input type="text" name="nombre" value="<%=usu.getNombre() %>">
	<p>Apellido</p>
	<input type="text" name="apellido" value="<%=usu.getApellido() %>">
	<%} %>
	<input type="submit" name="guardar" value="guardar">
</div>
</form>
</body>
</html>