<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page
	import="aplicacion.modelo.pojo.AccidentesPorSexoYVehiculoEnDistrito"%>
<%!ArrayList<AccidentesPorSexoYVehiculoEnDistrito> apsyveds;%>
<%!ArrayList<String> distritos;%>
<%!String fIni;%>
<%!String fFin;%>
<%!String distrito;%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>This is not a Gameland</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<nav
		class="navbar navbar-expand-sm bg-dark navbar-dark justify-content-center">
		<!-- Links -->
		<ul class="navbar-nav">
			<li class="nav-item"><a class="nav-link" href="Principal">This
					is not a Gameland</a></li>
			<li class="nav-item"><a class="nav-link" href="Apted">Estadísticas
					A.P.T.E.D.</a></li>
			<li class="nav-item"><a class="nav-link active" href="Apsyved">Estadísticas
					A.P.S.Y.V.E.D.</a></li>
		</ul>
	</nav>
	<div class="container text-center border mb-5 mt-5">
		<h1>Estadísticas A.P.S.Y.V.E.D.</h1>
		<h3>Obtener las estadísticas del número de accidentes de cada
			vehículo por sexo en un distrito y en el rango de dos fechas</h3>

		<%
			fIni = (String) request.getAttribute("fIni");
			fFin = (String) request.getAttribute("fFin");
			distritos = (ArrayList<String>) request.getAttribute("distritos");
			distrito = (String) request.getAttribute("distrito");
			if (distrito == null) {
				distrito = "";
			}
		%>
		<form action="Apsyved" method="POST">
			<div class="form-group">
				<label for="distrito">Distrito:</label> <br><select id="distrito"
					name="distrito">
					<%
						//Muestra las opciones de los distritos y el distrito seleccionado
						for (String dis : distritos) {
							if (dis.equals(distrito)) {
								out.print("<option selected='selected'>");
							} else {
								out.print("<option>");
							}
							out.print(dis);
							out.print("</option>");
						}
					%>
				</select>
			</div>
			<div class="form-group">
				<label for="fIni">Desde:</label> <br><input id="fIni" type="date" class="form-control text-center"
					name="fIni" value="<%=fIni%>">
			</div>
			<div class="form-group">
				<label for="fFin">Hasta:</label> <input id="fFin"
					class="form-control text-center" type="date" name="fFin" value="<%=fFin%>">
			</div>
			<button type="submit" class="btn btn-primary mb-2 mt-2 btn-block">Buscar</button>
		</form>
	</div>
	<%
		//Crea la tabla con los datos obtenidos o muestra un mensaje de error
		apsyveds = (ArrayList<AccidentesPorSexoYVehiculoEnDistrito>) request.getAttribute("APSYVEDS");
		if (apsyveds != null) {
			if (!apsyveds.isEmpty()) {
				out.print("<table class='table table-striped text-center'><thead><tr><th>Sexo</th><th>Vehículo</th><th>Cantidad</th></tr></thead><tbody>");
				for (AccidentesPorSexoYVehiculoEnDistrito apsyved : apsyveds) {
					out.print("<tr>");
					out.print("<td>" + apsyved.getSexo() + "</td>");
					out.print("<td>" + apsyved.getVehiculo() + "</td>");
					out.print("<td>" + apsyved.getCantidad() + "</td>");
					out.print("</tr>");
				}
				out.print("</tbody></table>");
			} else if (fIni != null || fFin != null) {
				out.print("<p class='text-danger'>No se han encontrado accidentes con esas características</p>");
			}
		} else if (fIni != null || fFin != null) {
			out.print("<p class='text-danger'>No se han encontrado accidentes con esas características</p>");
		}
	%>
	<footer class="page-footer font-small blue text-center">
            <p>Ayuntamiento de Madrid</p>
            <!-- Copyright -->
            <div class="footer-copyright text-center py-3">© 2020 Copyright:
                Dach SL</div>
            <!-- Copyright -->
        </footer>
</body>
</html>