package aplicacion.modelo.ejb;

import java.util.ArrayList;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import aplicacion.modelo.dao.AccidentesDAO;
import aplicacion.modelo.pojo.Accidente;
import aplicacion.modelo.pojo.AccidenteConDistrito;
import aplicacion.modelo.pojo.AccidentesPorSexoYVehiculoEnDistrito;
import aplicacion.modelo.pojo.AccidentesPorTipoEnDistrito;

/***
 * Lógica de negocio para los accidentes
 * 
 * @author tofol
 *
 */
@Stateless
@LocalBean
public class AccidentesEJB {

	/***
	 * Obtiene una lista de 'AccidentesPorTipoEnDistrito' a partir de dos fechas
	 * limitantes
	 * 
	 * @param fIni Fecha mínima
	 * @param fFin Fecha máxima
	 * @return ArrayList de 'AccidentesPorTipoEnDistrito'
	 */
	public ArrayList<AccidentesPorTipoEnDistrito> getAccidentesPorTipoEnDistrito(String fIni, String fFin) {
		return AccidentesDAO.getAccidentesPorTipoEnDistrito(fIni, fFin);
	}

	/***
	 * Obtiene una lista de 'AccidentesPorSexoYVehiculoEnDistrito' de un distrito a
	 * partir de dos fechas limitantes
	 * 
	 * @param fIni     Fecha mínima
	 * @param fFin     Fecha máxima
	 * @param distrito Distrito del cual se obtienen los
	 *                 'AccidentesPorSexoYVehiculoEnDistrito'
	 * @return ArrayList de 'AccidentesPorSexoYVehiculoEnDistrito'
	 */
	public ArrayList<AccidentesPorSexoYVehiculoEnDistrito> getAccidentesPorSexoYVehiculoEnDistrito(String fIni,
			String fFin, String distrito) {
		return AccidentesDAO.getAccidentesPorSexoYVehiculoEnDistrito(fIni, fFin, distrito);
	}

	/***
	 * Obtiene una lista de 'AccidenteConDistrito' de un distrito
	 * 
	 * @param idDistrito Id del distrito
	 * @return ArrayList de 'AccidenteConDistrito'
	 */
	public ArrayList<AccidenteConDistrito> getAccidentesConDistritos(String idDistrito) {
		return AccidentesDAO.getAccidentesConDistritos(idDistrito);
	}

	/***
	 * Obtiene un accidente a partir de su id
	 * 
	 * @param id Id del accidente
	 * @return Accidente con esa id
	 */
	public Accidente getAccidente(String id) {
		return AccidentesDAO.getAccidente(id);
	}

	/***
	 * Modifica los datos del accidente que tenga la misma id que el accidente
	 * pasado por parametro
	 * 
	 * @param accidente Accidente con los datos modificados
	 */
	public void updateAccidente(Accidente accidente) {
		AccidentesDAO.updateAccidente(accidente);
	}

	/***
	 * Borra el accidente que tenga esa id
	 * 
	 * @param id Id del accidente a borrar
	 */
	public void borrarAccidente(String id) {
		AccidentesDAO.borrarAccidente(id);
	}

	/***
	 * Inserta un nuevo accidente
	 * 
	 * @param accidente El nuevo accidente
	 */
	public void insertAccidente(Accidente accidente) {
		AccidentesDAO.insertAccidente(accidente);
	}
}
