package aplicacion.controlador.rest;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import aplicacion.modelo.ejb.AgentesEJB;
import aplicacion.modelo.ejb.SesionesEJB;
import aplicacion.modelo.pojo.Agente;

@Path("/Agentes")
public class RestAgentes {

	private static final String TOKEN = "patata23";

	@EJB
	SesionesEJB sesionesEJB;

	@EJB
	AgentesEJB agentesEJB;

	@Context
	private HttpServletRequest request;

	@GET
	@Path("/Validar/{token}/{placa}/{clave}")
	public Agente validar(@PathParam("token") String token, @PathParam("placa") String placa,
			@PathParam("clave") String clave) {
		if (token.equals(TOKEN)) {
			return agentesEJB.loginAgente(placa, clave);
		} else {
			return null;
		}
	}

	@GET
	@Path("/Logueado")
	@Produces(MediaType.APPLICATION_JSON)
	public Agente logueado() {
		HttpSession session = request.getSession(false);
		return sesionesEJB.agenteLogueado(session);
	}

	@GET
	@Path("/Logout")
	public void logout() {
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate();
		}
	}

}
