package aplicacion.controlador.rest;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;

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
				session = request.getSession(true);
				sesionesEJB.loginAgente(session, agente);
			}
		}
	}

	@GET
	@Path("/Logueado")
	public Agente logueado() {
		HttpSession session = request.getSession(false);
		return sesionesEJB.agenteLogueado(session);
	}

}
