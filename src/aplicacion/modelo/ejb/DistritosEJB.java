package aplicacion.modelo.ejb;

import java.util.ArrayList;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import aplicacion.modelo.dao.DistritosDAO;
import aplicacion.modelo.pojo.Distrito;

@Stateless
@LocalBean
public class DistritosEJB {

	public ArrayList<String> getNombresDistritos() {
		return DistritosDAO.getNombresDistritos();
	}

	public ArrayList<Distrito> getDistritos() {
		return DistritosDAO.getDistritos();
	}

}
