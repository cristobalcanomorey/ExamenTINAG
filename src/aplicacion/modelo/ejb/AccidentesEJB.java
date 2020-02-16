package aplicacion.modelo.ejb;

import java.util.ArrayList;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import aplicacion.modelo.dao.AccidentesDAO;
import aplicacion.modelo.pojo.Accidente;
import aplicacion.modelo.pojo.AccidenteConDistrito;
import aplicacion.modelo.pojo.AccidentesPorSexoYVehiculoEnDistrito;
import aplicacion.modelo.pojo.AccidentesPorTipoEnDistrito;

@Stateless
@LocalBean
public class AccidentesEJB {

	public ArrayList<AccidentesPorTipoEnDistrito> getAccidentesPorTipoEnDistrito(String fIni, String fFin) {
		return AccidentesDAO.getAccidentesPorTipoEnDistrito(fIni, fFin);
	}

	public ArrayList<AccidentesPorSexoYVehiculoEnDistrito> getAccidentesPorSexoYVehiculoEnDistrito(String fIni,
			String fFin, String distrito) {
		return AccidentesDAO.getAccidentesPorSexoYVehiculoEnDistrito(fIni, fFin, distrito);
	}

	public ArrayList<AccidenteConDistrito> getAccidentesConDistritos(String idDistrito) {
		return AccidentesDAO.getAccidentesConDistritos(idDistrito);
	}

	public Accidente getAccidente(String id) {
		return AccidentesDAO.getAccidente(id);
	}

	public Accidente updateAccidente(Accidente accidente) {
		AccidentesDAO.updateAccidente(accidente);
		return AccidentesDAO.getAccidente(accidente.getId().toString());
	}

	public void borrarAccidente(String id) {
		AccidentesDAO.borrarAccidente(id);
	}

	public void insertAccidente(Accidente accidente) {
		AccidentesDAO.insertAccidente(accidente);
	}
}
