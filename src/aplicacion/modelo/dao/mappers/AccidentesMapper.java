package aplicacion.modelo.dao.mappers;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import aplicacion.modelo.pojo.AccidentesPorSexoYVehiculoEnDistrito;
import aplicacion.modelo.pojo.AccidentesPorTipoEnDistrito;

public interface AccidentesMapper {

	public ArrayList<AccidentesPorTipoEnDistrito> getAccidentesPorTipoEnDistrito(@Param("fIni") String fIni,
			@Param("fFin") String fFin);

	public ArrayList<AccidentesPorSexoYVehiculoEnDistrito> getAccidentesPorSexoYVehiculoEnDistrito(
			@Param("fIni") String fIni, @Param("fFin") String fFin, @Param("distrito") String distrito);

}
