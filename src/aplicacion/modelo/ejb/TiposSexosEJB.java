package aplicacion.modelo.ejb;

import java.util.ArrayList;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import aplicacion.modelo.dao.TiposSexosDAO;
import aplicacion.modelo.pojo.TiposSexo;

/***
 * Lógica de negocio para los tipos de tipos de sexos
 * 
 * @author tofol
 *
 */
@Stateless
@LocalBean
public class TiposSexosEJB {

	/***
	 * Obtiene una lista con los tipos de sexos
	 * 
	 * @return ArrayList con los tipos de sexos
	 */
	public ArrayList<TiposSexo> getTiposSexos() {
		return TiposSexosDAO.getTiposSexos();
	}

}
