package aplicacion.controlador.rest;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import aplicacion.modelo.ejb.AgentesEJB;
import aplicacion.modelo.ejb.SesionesEJB;
import aplicacion.modelo.pojo.Agente;

@Path("/Sesion")
public class RestSesion {

	@EJB
	SesionesEJB sesionesEJB;

	@EJB
	AgentesEJB agentesEJB;

	@Context
	private HttpServletRequest request;

	@POST
	@Path("/Login/{placa}/{clave}")
	public void login(@PathParam("placa") String placa, @PathParam("clave") String clave) {
		HttpSession session = request.getSession(false);
		Agente agente = sesionesEJB.agenteLogueado(session);
		if (agente == null) {
			agente = agentesEJB.loginAgente(placa, clave);
			if (agente != null) {
				HttpSession session2 = request.getSession(true);
				sesionesEJB.loginAgente(session2, agente);
			}
		}
	}

	@GET
	@Path("/Logueado")
	@Produces(MediaType.APPLICATION_JSON)
	public Agente logueado() {
		HttpSession session = request.getSession(false);
		Agente agente = sesionesEJB.agenteLogueado(session);
		return agente;
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
