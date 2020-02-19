package aplicacion.modelo.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import aplicacion.modelo.dao.mappers.TiposAccidentesMapper;
import aplicacion.modelo.pojo.TiposAccidente;

/***
 * Se encarga del acceso y manipulación de los datos de los tipos de accidentes
 * 
 * @author tofol
 *
 */
public class TiposAccidentesDAO {

	/***
	 * Obtiene una lista con los tipos de accidentes
	 * 
	 * @return ArrayList con los tipos de accidentes
	 */
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
