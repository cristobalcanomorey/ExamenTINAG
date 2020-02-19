package aplicacion.modelo.ejb;

import java.util.ArrayList;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import aplicacion.modelo.dao.TiposAccidentesDAO;
import aplicacion.modelo.pojo.TiposAccidente;

/***
 * Lógica de negocio para los tipos de accidentes
 * 
 * @author tofol
 *
 */
@Stateless
@LocalBean
public class TiposAccidentesEJB {

	/***
	 * Obtiene una lista con los tipos de accidentes
	 * 
	 * @return ArrayList con los tipos de accidentes
	 */
	public ArrayList<TiposAccidente> getTiposAccidentes() {
		return TiposAccidentesDAO.getTiposAccidentes();
	}

}
