package aplicacion.modelo.ejb;

import java.util.ArrayList;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import aplicacion.modelo.dao.AccidentesDAO;
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

	public ArrayList<AccidenteConDistrito> getAccidentesConDistritos() {
		return AccidentesDAO.getAccidentesConDistritos();
	}

}
