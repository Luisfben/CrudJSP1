# CrudJSP1

Laboratorio en tecnología JSP(Java Server Pages)

Estructura 

1. Paquetes
- Config: Conexión base de datos

```java
String connectionUrl = "jdbc:sqlserver://192.168.99.100:32772;databaseName=test;user=sa;password=Gordis2019";
Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
con = DriverManager.getConnection(connectionUrl);`
```
- Controlador: uso metodo doGet

```java
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
    ...
    /*atraves de texto en la url. Ej. ...?accion=listar*/
		String action = request.getParameter("accion");
		if (action.equals("listar")) {
		  acceso = vistaListar; /* "vistas/listar.jsp" */
		}
    ...
     // atraves de form
		if (request.getParameter("guardar") != null) {
    RequestDispatcher vista = request.getRequestDispatcher(acceso);
    vista.forward(request, response);
```
