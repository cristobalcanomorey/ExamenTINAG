package aplicacion.controlador.rest;

import java.util.ArrayList;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import aplicacion.modelo.LogSingleton;
import aplicacion.modelo.ejb.AccidentesEJB;
import aplicacion.modelo.ejb.DistritosEJB;
import aplicacion.modelo.ejb.SesionesEJB;
import aplicacion.modelo.ejb.TiposAccidentesEJB;
import aplicacion.modelo.ejb.TiposSexosEJB;
import aplicacion.modelo.ejb.TiposVehiculosEJB;
import aplicacion.modelo.pojo.Accidente;
import aplicacion.modelo.pojo.AccidenteConDistrito;
import aplicacion.modelo.pojo.Agente;
import aplicacion.modelo.pojo.Distrito;
import aplicacion.modelo.pojo.TiposAccidente;
import aplicacion.modelo.pojo.TiposSexo;
import aplicacion.modelo.pojo.TiposVehiculo;

@Path("/Accidente")
public class RestAccidentes {

	@EJB
	SesionesEJB sesionesEJB;

	@EJB
	AccidentesEJB accidentesEJB;

	@EJB
	DistritosEJB distritosEJB;

	@EJB
	TiposAccidentesEJB tiposAccidentesEJB;

	@EJB
	TiposSexosEJB tiposSexosEJB;

	@EJB
	TiposVehiculosEJB tiposVehiculosEJB;

	@Context
	private HttpServletRequest request;

	@GET
	@Path("/getAccidente")
	@Produces(MediaType.APPLICATION_JSON)
	public Accidente getAccidente(@QueryParam("id") String id) {
		LogSingleton log = LogSingleton.getInstance();
		try {
			Integer iden = Integer.valueOf(id);
			HttpSession session = request.getSession(false);
			Agente agente = sesionesEJB.agenteLogueado(session);
			if (agente != null) {
				return accidentesEJB.getAccidente(iden.toString());
			} else {
				return null;
			}
		} catch (NumberFormatException e) {
			log.getLoggerRestAccidentes().debug("Se ha producido un error en GET Accidente: ", e);
			return null;
		}
	}

	@PUT
	@Path("/updateAccidente")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Accidente updateAccidente(Accidente accidente) {
		HttpSession session = request.getSession(false);
		Agente agente = sesionesEJB.agenteLogueado(session);
		if (agente != null) {
			return accidentesEJB.updateAccidente(accidente);
		} else {
			return null;
		}
	}

	@DELETE
	@Path("/borraAccidente/{id}")
	public void borraAccidente(@PathParam("id") String id) {
		LogSingleton log = LogSingleton.getInstance();
		try {
			Integer iden = Integer.valueOf(id);
			HttpSession session = request.getSession(false);
			Agente agente = sesionesEJB.agenteLogueado(session);
			if (agente != null) {
				accidentesEJB.borrarAccidente(iden.toString());
			}
		} catch (NumberFormatException e) {
			log.getLoggerRestAccidentes().debug("Se ha producido un error en DELETE Accidente: ", e);
		}
	}

	@PUT
	@Path("/insertAccidente")
	@Consumes(MediaType.APPLICATION_JSON)
	public void insertAccidente(Accidente accidente) {
		HttpSession session = request.getSession(false);
		Agente agente = sesionesEJB.agenteLogueado(session);
		if (agente != null) {
			accidentesEJB.insertAccidente(accidente);
		}
	}

	@GET
	@Path("/getAccidentesConDistritos")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<AccidenteConDistrito> getAccidentesConDistritos() {
		HttpSession session = request.getSession(false);
		Agente agente = sesionesEJB.agenteLogueado(session);
		if (agente != null) {
			return accidentesEJB.getAccidentesConDistritos();
		} else {
			return null;
		}
	}

	@GET
	@Path("/getDistritos")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Distrito> getDistritos() {
		HttpSession session = request.getSession(false);
		Agente agente = sesionesEJB.agenteLogueado(session);
		if (agente != null) {
			return distritosEJB.getDistritos();
		} else {
			return null;
		}
	}

	@GET
	@Path("/getTiposAccidentes")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<TiposAccidente> getTiposAccidentes() {
		HttpSession session = request.getSession(false);
		Agente agente = sesionesEJB.agenteLogueado(session);
		if (agente != null) {
			return tiposAccidentesEJB.getTiposAccidentes();
		} else {
			return null;
		}
	}

	@GET
	@Path("/getTiposSexos")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<TiposSexo> getTiposSexos() {
		HttpSession session = request.getSession(false);
		Agente agente = sesionesEJB.agenteLogueado(session);
		if (agente != null) {
			return tiposSexosEJB.getTiposSexos();
		} else {
			return null;
		}
	}

	@GET
	@Path("/getTiposVehiculos")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<TiposVehiculo> getTiposVehiculos() {
		HttpSession session = request.getSession(false);
		Agente agente = sesionesEJB.agenteLogueado(session);
		if (agente != null) {
			return tiposVehiculosEJB.getTiposVehiculos();
		} else {
			return null;
		}
	}

}
