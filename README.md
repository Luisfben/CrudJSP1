# CrudJSP1

Laboratorio en tecnología JSP(Java Server Pages)

Estructura 

1. Paquetes
- src/onfig: Conexión base de datos

```java
String connectionUrl = "jdbc:sqlserver://192.168.99.100:32772;databaseName=test;user=sa;password=XXXXX";
Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
con = DriverManager.getConnection(connectionUrl);`
```
- src/controlador: uso metodo doGet

```java
protected void doGet(HttpServletRequest request, HttpServletResponse response)
	...
    	/* atraves de texto en la url. Ej. ...?accion=listar */
		String action = request.getParameter("accion");
		if (action.equals("listar")) {
		  acceso = vistaListar; /* "vistas/listar.jsp" */
		}
    	...
     	/* atraves de form */
		if (request.getParameter("guardar") != null) {
    	...
    RequestDispatcher vista = request.getRequestDispatcher(acceso);
    vista.forward(request, response);
```

- src/dao: interacción con bd

```java
public class UsuarioDAO implements IUsuarioDAO {
	...
	@Override
	public List listar() {
		ArrayList<Usuario> list = new ArrayList<>();
		String sql = "select * from dbo.usuario";
		try {
			con = cn.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setPerfil(rs.getString("perfil"));
				list.add(usuario);

```
- src/intefaz: interfaces dao

```java
public interface IUsuarioDAO {
	public List listar();
```

- src/modelo: mapeo de tabla (bo: business object)

```java
public class Usuario {
	String perfil;
	public String getPerfil() {
		return perfil;
	}
```

2. Contenido Web
- index.jsp: archivo inicial

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Pagina Principal</title>
</head>
<body>
	<div>
		<a href="ControladorUsuario?accion=listar">Listar Usuarios</a>
	</div>
...
```
- vistas/listar.jsp: ejemplo listar elementos tabla

```jsp
<!-- importación clases-->
<%@ page import="dao.UsuarioDAO" %>
...
		<table border="1">
...
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
...
						<a href="ControladorUsuario?accion=editar&usuario=<%=usu.getUsuario() %>">editar</a>
...
				</tr>
				<%}%>
```
