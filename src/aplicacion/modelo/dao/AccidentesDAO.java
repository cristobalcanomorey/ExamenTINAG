package aplicacion.modelo.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import aplicacion.modelo.dao.mappers.AccidentesMapper;
import aplicacion.modelo.pojo.AccidentesPorTipoEnDistrito;

public class AccidentesDAO {

	public static ArrayList<AccidentesPorTipoEnDistrito> getAccidentesPorTipoEnDistrito(String fIni, String fFin) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			AccidentesMapper accidentesMapper = sqlSession.getMapper(AccidentesMapper.class);
			return accidentesMapper.getAccidentesPorTipoEnDistrito(fIni, fFin);
		} finally {
			sqlSession.close();
		}
	}

}
