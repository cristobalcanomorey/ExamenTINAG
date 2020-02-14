package aplicacion.controlador.rest;

import javax.ejb.EJB;
import javax.ws.rs.Path;

import aplicacion.modelo.ejb.AccidentesEJB;

@Path("/Accidente")
public class RestAccidentes {

	@EJB
	AccidentesEJB accidentesEJB;

}
