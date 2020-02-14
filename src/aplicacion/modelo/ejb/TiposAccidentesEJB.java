package aplicacion.modelo.ejb;

import java.util.ArrayList;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import aplicacion.modelo.dao.TiposAccidentesDAO;
import aplicacion.modelo.pojo.TiposAccidente;

@Stateless
@LocalBean
public class TiposAccidentesEJB {

	public ArrayList<TiposAccidente> getTiposAccidentes() {
		return TiposAccidentesDAO.getTiposAccidentes();
	}

}
