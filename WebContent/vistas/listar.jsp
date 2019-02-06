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
		<table>
			<thead>
				<tr>
					<th>perfil</th>
				</tr>
			</thead>
			<% 
				UsuarioDAO dao = new UsuarioDAO();
				List<Usuario> list=dao.listar();
				Iterator<Usuario> iter=list.iterator();
				Usuario usu=null;
				while(iter.hasNext())
					usu=iter.next();
			%>
			<tbody>
				<tr>
					<td><%=usu.getPerfil() %></td>
				</tr>
			</body>
		</table>
	</div>
</body>
</html>