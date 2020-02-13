<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="aplicacion.modelo.pojo.AccidentesPorTipoEnDistrito"%>
<%! ArrayList<AccidentesPorTipoEnDistrito> apteds; %>
<%! String fIni; %>
<%! String fFin; %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>This is not a Gameland</title>
</head>
<body>
	<div id="cabecera">
		<ul>
			<li><a href="Principal">This is not a Gameland</a></li>
			<li><a href="Apted">Estadísticas A.P.T.E.D.</a></li>
		</ul>
	</div>
	<h1>Estadísticas A.P.T.E.D.</h1>
	<h3>Obtener las estadísticas del número de accidentes de cada tipo por distrito en el rango de dos fechas</h3>
	<%
		fIni = (String)request.getAttribute("fIni");
		fFin = (String)request.getAttribute("fFin");
	%>
	<form action="Estadisticas" method="POST">
		<p>Desde:</p>
		<input type="date" name="fIni" value="<%=fIni%>">
		<p>Hasta:</p>
		<input type="date" name="fFin" value="<%=fFin%>">
		<button type="submit">Buscar</button>
	</form>
	<%
		apteds = (ArrayList<AccidentesPorTipoEnDistrito>) request.getAttribute("APTEDS");
		if(apteds != null){
			if(!apteds.isEmpty()){
				out.print("<table><tbody><tr><th>Distrito</th><th>Tipo</th><th>Cantidad</th></tr>");
				for(AccidentesPorTipoEnDistrito apted: apteds){
					out.print("<tr>");
					out.print("<td>"+apted.getDistrito()+"</td>");
					out.print("<td>"+apted.getTipo()+"</td>");
					out.print("<td>"+apted.getCantidad()+"</td>");
					out.print("</tr>");
				}
				out.print("</tbody></table>");	
			} else if(fIni != null || fFin != null){
				out.print("<p class='error'>No se han encontrado accidentes con esas características</p>");
			}
		} else if(fIni != null || fFin != null){
			out.print("<p class='error'>No se han encontrado accidentes con esas características</p>");
		}
	%>
	<div id="pie">
		<p>Ayuntamiento de Madrid</p>
	</div>
</body>
</html>