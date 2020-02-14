package aplicacion.modelo.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import aplicacion.modelo.dao.mappers.TiposAccidentesMapper;
import aplicacion.modelo.pojo.TiposAccidente;

public class TiposAccidentesDAO {

	public static ArrayList<TiposAccidente> getTiposAccidentes() {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			TiposAccidentesMapper tiposAccidentesMapper = sqlSession.getMapper(TiposAccidentesMapper.class);
			return tiposAccidentesMapper.getTiposAccidentes();
		} finally {
			sqlSession.close();
		}
	}

}
