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

/***
 * Muestra los registros del número de Accidentes Por Tipo En cada Distrito o
 * A.P.T.E.D.
 * 
 * @author tofol
 *
 */
@WebServlet("/Apted")
public class Apted extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	AccidentesEJB accidentesEJB;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LogSingleton log = LogSingleton.getInstance();
		RequestDispatcher rs = getServletContext().getRequestDispatcher("/Apted.jsp");

		try {
			rs.forward(request, response);
		} catch (Exception e) {
			log.getLoggerEstadisticas().debug("Error en GET APTED: ", e);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LogSingleton log = LogSingleton.getInstance();
		RequestDispatcher rs = getServletContext().getRequestDispatcher("/Apted.jsp");
		String fIni = request.getParameter("fIni");
		String fFin = request.getParameter("fFin");

		if (fIni == null || fFin == null) {
			response.sendRedirect(request.getContextPath() + "/Apted");
		} else {
			request.setAttribute("APTEDS", accidentesEJB.getAccidentesPorTipoEnDistrito(fIni, fFin));
			request.setAttribute("fIni", fIni);
			request.setAttribute("fFin", fFin);
		}

		try {
			rs.forward(request, response);
		} catch (Exception e) {
			log.getLoggerEstadisticas().debug("Error en POST APTED: ", e);
		}
	}

}