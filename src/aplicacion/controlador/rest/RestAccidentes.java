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

/***
 * Servicio rest para obtener y manipular datos de los accidentes
 * 
 * @author tofol
 *
 */
@Path("/Accidente")
public class RestAccidentes {

	/***
	 * Token de autenticación
	 */
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

	/***
	 * Petición de tipo GET que obtiene un token y un accidente por su id y devuelve
	 * su json
	 * 
	 * @param token Token identificador
	 * @param id    Id del accidente
	 * @return Json con los datos del accidente o null
	 */
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

	/***
	 * Petición de tipo PUT que obtiene un token y un accidente en formato json y
	 * sustituye los datos del accidente en BBDD con la misma id por los nuevos
	 * datos obtenidos
	 * 
	 * @param token     Token identificador
	 * @param accidente Accidente con los nuevos datos para actualizar
	 */
	@PUT
	@Path("/updateAccidente/{token}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateAccidente(@PathParam("token") String token, Accidente accidente) {
		if (token.equals(TOKEN)) {
			accidentesEJB.updateAccidente(accidente);
		}
	}

	/***
	 * Petición de tipo DELETE que obtiene un token y la id de un accidente y borra
	 * este accidente de la BBDD
	 * 
	 * @param token Token identificador
	 * @param id    Id del accidente a borrar
	 */
	@DELETE
	@Path("/borraAccidente/{token}/{id}")
	public void borraAccidente(@PathParam("token") String token, @PathParam("id") String id) {
		LogSingleton log = LogSingleton.getInstance();
		try {
			/***
			 * Si consigue parsearlo a Integer lo borra, si no salta excepción
			 */
			Integer iden = Integer.valueOf(id);
			if (token.equals(TOKEN)) {
				accidentesEJB.borrarAccidente(iden.toString());
			}
		} catch (NumberFormatException e) {
			log.getLoggerRestAccidentes().debug("Se ha producido un error en DELETE Accidente: ", e);
		}
	}

	/***
	 * Petición de tipo PUT que obtiene un token y un accidente en formato json y lo
	 * inserta en la BBDD
	 * 
	 * @param token     Token identificador
	 * @param accidente Accidente a introducir en la BBDD
	 */
	@PUT
	@Path("/insertAccidente/{token}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void insertAccidente(@PathParam("token") String token, Accidente accidente) {
		if (token.equals(TOKEN)) {
			accidentesEJB.insertAccidente(accidente);
		}
	}

	/***
	 * Petición de tipo GET que obtiene un token y la id del distrito y devuelve los
	 * datos de todos los accidentes de este distrito y el nombre del distrito
	 * 
	 * @param token      Token identificador
	 * @param idDistrito Id del distrito del que obtener todos sus accidentes
	 * @return Json del ArrayList con todos los accidentes de ese distrito o null
	 */
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

	/***
	 * Petición de tipo GET que obtiene un token y devuelve todos los distritos
	 * 
	 * @param token Token identificador
	 * @return Json del ArrayList con todos los distritos o null
	 */
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

	/***
	 * Petición de tipo GET que obtiene un token y devuelve todos los tipos de
	 * accidentes
	 * 
	 * @param token Token identificador
	 * @return Json del ArrayList con todos los tipos de accidentes o null
	 */
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

	/***
	 * Petición de tipo GET que obtiene un token y devuelve todos los tipos de sexos
	 * 
	 * @param token Token identificador
	 * @return Json del ArrayList con todos los tipos de sexos o null
	 */
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

	/***
	 * Petición de tipo GET que obtiene un token y devuelve todos los tipos de
	 * vehiculos
	 * 
	 * @param token Token identificador
	 * @return Json del ArrayList con todos los tipos de vehiculos o null
	 */
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
