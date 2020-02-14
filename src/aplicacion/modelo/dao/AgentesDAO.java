package aplicacion.modelo.dao;

import org.apache.ibatis.session.SqlSession;

import aplicacion.modelo.dao.mappers.AgentesMapper;
import aplicacion.modelo.pojo.Agente;

public class AgentesDAO {

	public static Agente loginAgente(String placa, String clave) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			AgentesMapper agentesMapper = sqlSession.getMapper(AgentesMapper.class);
			return agentesMapper.getAgente(placa, clave);
		} finally {
			sqlSession.close();
		}
	}

}
