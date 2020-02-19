package aplicacion.modelo.dao;

import org.apache.ibatis.session.SqlSession;

import aplicacion.modelo.dao.mappers.AgentesMapper;
import aplicacion.modelo.pojo.Agente;

/***
 * Se encarga del acceso y manipulación de los datos de los agentes
 * 
 * @author tofol
 *
 */
public class AgentesDAO {

	/***
	 * Obtiene el agente que coincide con esta placa y clave
	 * 
	 * @param placa Placa del agente
	 * @param clave Contraseña del agente
	 * @return Agente con esa placa y clave o null
	 */
	public static Agente validarAgente(String placa, String clave) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			AgentesMapper agentesMapper = sqlSession.getMapper(AgentesMapper.class);
			return agentesMapper.getAgente(placa, clave);
		} finally {
			sqlSession.close();
		}
	}

}
