package aplicacion.modelo.dao.mappers;

import org.apache.ibatis.annotations.Param;

import aplicacion.modelo.pojo.Agente;

public interface AgentesMapper {

	public Agente getAgente(@Param("placa") String placa, @Param("clave") String clave);

}
