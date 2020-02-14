package aplicacion.controlador.rest;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
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
	@Path("/Login")
	@Produces(MediaType.APPLICATION_JSON)
	public Agente login(@FormParam("placa") String placa, @FormParam("clave") String clave) {
		HttpSession session = request.getSession(false);
		Agente agente = sesionesEJB.agenteLogeado(session);
		if (agente == null) {
			agente = agentesEJB.loginAgente(placa, clave);
			if (agente != null) {
				session = request.getSession(true);
				sesionesEJB.loginAgente(session, agente);
				return agente;
			}
		}
		return null;
	}

}
