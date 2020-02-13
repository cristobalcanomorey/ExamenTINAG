package aplicacion.modelo.dao.mappers;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import aplicacion.modelo.pojo.AccidentesPorTipoEnDistrito;

public interface AccidentesMapper {

	ArrayList<AccidentesPorTipoEnDistrito> getAccidentesPorTipoEnDistrito(@Param("fIni") String fIni,
			@Param("fFin") String fFin);

}
