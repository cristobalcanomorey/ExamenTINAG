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

/***
 * Servicio rest para obtener datos de un agente de BBDD, de sesión o los quita
 * de la sesión
 * 
 * @author tofol
 *
 */
@Path("/Agentes")
public class RestAgentes {

	/***
	 * Token de autenticación
	 */
	private static final String TOKEN = "patata23";

	@EJB
	SesionesEJB sesionesEJB;

	@EJB
	AgentesEJB agentesEJB;

	@Context
	private HttpServletRequest request;

	/***
	 * Petición de tipo GET que obtiene un token, una placa y una clave y devuelve
	 * al agente que coincida con estos datos
	 * 
	 * @param token Token de identificación
	 * @param placa Placa del agente
	 * @param clave Contraseña del agente
	 * @return Json del Agente con esa placa y clave o null
	 */
	@GET
	@Path("/Validar/{token}/{placa}/{clave}")
	public Agente validar(@PathParam("token") String token, @PathParam("placa") String placa,
			@PathParam("clave") String clave) {
		if (token.equals(TOKEN)) {
			return agentesEJB.validarAgente(placa, clave);
		} else {
			return null;
		}
	}

	/***
	 * Petición de tipo GET que obtiene un token y devuelve el json del agente que
	 * esté logueado
	 * 
	 * @return Json del Agente logueado o null
	 */
	@GET
	@Path("/Logueado/{token}")
	@Produces(MediaType.APPLICATION_JSON)
	public Agente logueado(@PathParam("token") String token) {
		if (token.equals(TOKEN)) {
			return sesionesEJB.agenteLogueado(request.getSession(false));
		} else {
			return null;
		}
	}

	/***
	 * Petición de tipo GET que obtiene un token y cierra las sesiones
	 */
	@GET
	@Path("/Logout/{token}")
	public void logout(@PathParam("token") String token) {
		if (token.equals(TOKEN)) {
			HttpSession session = request.getSession(false);
			if (session != null) {
				session.invalidate();
			}
		}
	}

}
