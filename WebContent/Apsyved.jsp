<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="aplicacion.modelo.pojo.AccidentesPorSexoYVehiculoEnDistrito"%>
<%! ArrayList<AccidentesPorSexoYVehiculoEnDistrito> apsyveds; %>
<%! ArrayList<String> distritos; %>
<%! String fIni; %>
<%! String fFin; %>
<%! String distrito; %>
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
			<li><a href="Apsyved">Estadísticas A.P.S.Y.V.E.D.</a></li>
		</ul>
	</div>
	<h1>Estadísticas A.P.S.Y.V.E.D.</h1>
	<h3>Obtener las estadísticas del número de accidentes de cada vehículo por sexo en un distrito y en el rango de dos fechas</h3>
	<%
		fIni = (String)request.getAttribute("fIni");
		fFin = (String)request.getAttribute("fFin");
		distritos = (ArrayList<String>)request.getAttribute("distritos");
		distrito = (String)request.getAttribute("distrito");
		if(distrito == null){
			distrito = "";
		} 
	%>
	<form action="Apsyved" method="POST">
		<p>Distrito:</p>
		<select name="distrito">
			<%
			//Muestra las opciones de los distritos y el distrito seleccionado
				for(String dis: distritos){
					if(dis.equals(distrito)){
						out.print("<option selected='selected'>");
					} else{
						out.print("<option>");
					}
					out.print(dis);
					out.print("</option>");
				}
			%>
		</select>
		<p>Desde:</p>
		<input type="date" name="fIni" value="<%=fIni%>">
		<p>Hasta:</p>
		<input type="date" name="fFin" value="<%=fFin%>">
		<button type="submit">Buscar</button>
	</form>
	<%
	//Crea la tabla con los datos obtenidos o muestra un mensaje de error
		apsyveds = (ArrayList<AccidentesPorSexoYVehiculoEnDistrito>) request.getAttribute("APSYVEDS");
		if(apsyveds != null){
			if(!apsyveds.isEmpty()){
				out.print("<table><tbody><tr><th>Sexo</th><th>Vehículo</th><th>Cantidad</th></tr>");
				for(AccidentesPorSexoYVehiculoEnDistrito apsyved: apsyveds){
					out.print("<tr>");
					out.print("<td>"+apsyved.getSexo()+"</td>");
					out.print("<td>"+apsyved.getVehiculo()+"</td>");
					out.print("<td>"+apsyved.getCantidad()+"</td>");
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