package aplicacion.modelo.ejb;

import java.util.ArrayList;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import aplicacion.modelo.dao.DistritosDAO;
import aplicacion.modelo.pojo.Distrito;

/***
 * Lógica de negocio para los agentes
 * 
 * @author tofol
 *
 */
@Stateless
@LocalBean
public class DistritosEJB {

	/***
	 * Obtiene una lista de los nombres de los distritos
	 * 
	 * @return ArrayList con los nombres de los distritos
	 */
	public ArrayList<String> getNombresDistritos() {
		return DistritosDAO.getNombresDistritos();
	}

	/***
	 * Obtiene una lista con todos los distritos
	 * 
	 * @return ArrayList con los distritos
	 */
	public ArrayList<Distrito> getDistritos() {
		return DistritosDAO.getDistritos();
	}

}
