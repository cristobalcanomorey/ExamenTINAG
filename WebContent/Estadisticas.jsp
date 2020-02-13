<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="aplicacion.modelo.pojo.AccidentesPorTipoEnDistrito"%>
<%! ArrayList<AccidentesPorTipoEnDistrito> apteds; %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>This is not a Gameland</title>
</head>
<body>
	<div id="cabecera">
		<h1>This is not a Gameland</h1>
	</div>
	<h3>Obtener estadísticas del número de accidentes de cada tipo por distrito en el rango de dos fechas</h3>
	<form action="Estadisticas" method="POST">
		<p>Desde:</p>
		<input type="date" name="fIni">
		<p>Hasta:</p>
		<input type="date" name="fFin">
		<button type="submit">Buscar</button>
	</form>
	<%
		apteds = (ArrayList<AccidentesPorTipoEnDistrito>) request.getAttribute("APTEDS");
		if(apteds != null){
			out.print("<table><tbody><tr><th>Distrito</th><th>Tipo</th><th>Cantidad</th></tr>");
			for(AccidentesPorTipoEnDistrito apted: apteds){
				out.print("<tr>");
				out.print("<td>"+apted.getDistrito()+"</td>");
				out.print("<td>"+apted.getTipo()+"</td>");
				out.print("<td>"+apted.getCantidad()+"</td>");
				out.print("</tr>");
			}
			out.print("</tbody></table>");
		}
	%>
	<table>
		<tbody>
			
		</tbody>
	</table>
	<div id="pie">
		<p>Ayuntamiento de Madrid</p>
	</div>
</body>
</html>