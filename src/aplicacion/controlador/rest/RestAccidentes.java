package aplicacion.controlador.rest;

import java.util.ArrayList;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
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
import aplicacion.modelo.pojo.Distrito;
import aplicacion.modelo.pojo.TiposAccidente;
import aplicacion.modelo.pojo.TiposSexo;
import aplicacion.modelo.pojo.TiposVehiculo;

@Path("/Accidente")
public class RestAccidentes {

	private static final String TOKEN = "patata23";

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
	@Path("/getAccidente/{token}")
	@Produces(MediaType.APPLICATION_JSON)
	public Accidente getAccidente(@PathParam("token") String token, @QueryParam("id") String id) {
		LogSingleton log = LogSingleton.getInstance();
		try {
			Integer iden = Integer.valueOf(id);
			if (token.equals(TOKEN)) {
				return accidentesEJB.getAccidente(iden.toString());
			}
		} catch (NumberFormatException e) {
			log.getLoggerRestAccidentes().debug("Se ha producido un error en GET Accidente: ", e);
		}
		return null;
	}

	@PUT
	@Path("/updateAccidente/{token}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Accidente updateAccidente(@PathParam("token") String token, Accidente accidente) {
		if (token.equals(TOKEN)) {
			return accidentesEJB.updateAccidente(accidente);
		} else {
			return null;
		}
	}

	@DELETE
	@Path("/borraAccidente/{token}/{id}")
	public void borraAccidente(@PathParam("token") String token, @PathParam("id") String id) {
		LogSingleton log = LogSingleton.getInstance();
		try {
			Integer iden = Integer.valueOf(id);
			if (token.equals(TOKEN)) {
				accidentesEJB.borrarAccidente(iden.toString());
			}
		} catch (NumberFormatException e) {
			log.getLoggerRestAccidentes().debug("Se ha producido un error en DELETE Accidente: ", e);
		}
	}

	@PUT
	@Path("/insertAccidente/{token}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void insertAccidente(@PathParam("token") String token, Accidente accidente) {
		if (token.equals(TOKEN)) {
			accidentesEJB.insertAccidente(accidente);
		}
	}

	@GET
	@Path("/getAccidentesConDistritos/{token}")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<AccidenteConDistrito> getAccidentesConDistritos(@PathParam("token") String token,
			@QueryParam("idDistrito") String idDistrito) {
		if (token.equals(TOKEN)) {
			return accidentesEJB.getAccidentesConDistritos(idDistrito);
		} else {
			return null;
		}
	}

	@GET
	@Path("/getDistritos/{token}")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Distrito> getDistritos(@PathParam("token") String token) {
		if (token.equals(TOKEN)) {
			return distritosEJB.getDistritos();
		} else {
			return null;
		}
	}

	@GET
	@Path("/getTiposAccidentes/{token}")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<TiposAccidente> getTiposAccidentes(@PathParam("token") String token) {
		if (token.equals(TOKEN)) {
			return tiposAccidentesEJB.getTiposAccidentes();
		} else {
			return null;
		}
	}

	@GET
	@Path("/getTiposSexos/{token}")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<TiposSexo> getTiposSexos(@PathParam("token") String token) {
		if (token.equals(TOKEN)) {
			return tiposSexosEJB.getTiposSexos();
		} else {
			return null;
		}
	}

	@GET
	@Path("/getTiposVehiculos/{token}")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<TiposVehiculo> getTiposVehiculos(@PathParam("token") String token) {
		if (token.equals(TOKEN)) {
			return tiposVehiculosEJB.getTiposVehiculos();
		} else {
			return null;
		}
	}

}
