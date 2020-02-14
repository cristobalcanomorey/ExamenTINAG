package aplicacion.modelo.ejb;

import java.util.ArrayList;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import aplicacion.modelo.dao.TiposSexosDAO;
import aplicacion.modelo.pojo.TiposSexo;

@Stateless
@LocalBean
public class TiposSexosEJB {

	public ArrayList<TiposSexo> getTiposSexos() {
		return TiposSexosDAO.getTiposSexos();
	}

}
