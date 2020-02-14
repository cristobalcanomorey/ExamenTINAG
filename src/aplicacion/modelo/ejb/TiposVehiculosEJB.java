package aplicacion.modelo.ejb;

import java.util.ArrayList;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import aplicacion.modelo.dao.TiposVehiculosDAO;
import aplicacion.modelo.pojo.TiposVehiculo;

@Stateless
@LocalBean
public class TiposVehiculosEJB {

	public ArrayList<TiposVehiculo> getTiposVehiculos() {
		return TiposVehiculosDAO.getTiposVehiculos();
	}

}
