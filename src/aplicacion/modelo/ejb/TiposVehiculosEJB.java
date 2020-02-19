package aplicacion.modelo.ejb;

import java.util.ArrayList;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import aplicacion.modelo.dao.TiposVehiculosDAO;
import aplicacion.modelo.pojo.TiposVehiculo;

/***
 * Lógica de negocio para los tipos de tipos de vehiculos
 * 
 * @author tofol
 *
 */
@Stateless
@LocalBean
public class TiposVehiculosEJB {

	/***
	 * Obtiene una lista con los tipos de vehiculos
	 * 
	 * @return ArrayList con los tipos de vehiculos
	 */
	public ArrayList<TiposVehiculo> getTiposVehiculos() {
		return TiposVehiculosDAO.getTiposVehiculos();
	}

}
