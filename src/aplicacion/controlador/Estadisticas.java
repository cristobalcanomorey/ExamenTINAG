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

@WebServlet("/Estadisticas")
public class Estadisticas extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	AccidentesEJB accidentesEJB;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LogSingleton log = LogSingleton.getInstance();
		RequestDispatcher rs = getServletContext().getRequestDispatcher("/Estadisticas.jsp");

		try {
			rs.forward(request, response);
		} catch (Exception e) {
			log.getLoggerEstadisticas().debug("Error en GET Estadisticas: ", e);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LogSingleton log = LogSingleton.getInstance();
		RequestDispatcher rs = getServletContext().getRequestDispatcher("/Estadisticas.jsp");
		String fIni = request.getParameter("fIni");
		String fFin = request.getParameter("fFin");

		if (fIni == null || fFin == null) {
			response.sendRedirect(request.getContextPath() + "/Estadisticas");
		} else {
			request.setAttribute("APTEDS", accidentesEJB.getAccidentesPorTipoEnDistrito(fIni, fFin));
		}

		try {
			rs.forward(request, response);
		} catch (Exception e) {
			log.getLoggerEstadisticas().debug("Error en POST Estadisticas: ", e);
		}
	}

}
