package aplicacion.controlador;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aplicacion.modelo.LogSingleton;
import aplicacion.modelo.ejb.AccidentesEJB;
import aplicacion.modelo.ejb.DistritosEJB;

/***
 * Muestra los registros del número de Accidentes Por Sexo Y Vehiculo En cada
 * Distrito A.P.S.Y.V.E.D.
 * 
 * @author horabaixa
 *
 */
@WebServlet("/Apsyved")
public class Apsyved extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	AccidentesEJB accidentesEJB;

	@EJB
	DistritosEJB distritosEJB;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		LogSingleton log = LogSingleton.getInstance();
		RequestDispatcher rs = getServletContext().getRequestDispatcher("/Apsyved.jsp");
		request.setCharacterEncoding("UTF-8");

		request.setAttribute("distritos", distritosEJB.getNombresDistritos());

		try {
			rs.forward(request, response);
		} catch (Exception e) {
			log.getLoggerApsyved().debug("Error en GET APSYVED: ", e);
		}

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		LogSingleton log = LogSingleton.getInstance();
		RequestDispatcher rs = getServletContext().getRequestDispatcher("/Apsyved.jsp");
		request.setCharacterEncoding("UTF-8");
		String fIni = request.getParameter("fIni");
		String fFin = request.getParameter("fFin");
		String distrito = request.getParameter("distrito");
		request.setAttribute("distritos", distritosEJB.getNombresDistritos());

		if (fIni == null || fFin == null || distrito == null) {
			response.sendRedirect(request.getContextPath() + "/Apsyved");
		} else {
			request.setAttribute("APSYVEDS",
					accidentesEJB.getAccidentesPorSexoYVehiculoEnDistrito(fIni, fFin, distrito));
			request.setAttribute("fIni", fIni);
			request.setAttribute("fFin", fFin);
			request.setAttribute("distrito", distrito);
		}

		try {
			rs.forward(request, response);
		} catch (Exception e) {
			log.getLoggerApsyved().debug("Error en POST APSYVED: ", e);
		}

	}

}
