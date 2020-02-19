package aplicacion.modelo.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import aplicacion.modelo.dao.mappers.TiposSexosMapper;
import aplicacion.modelo.pojo.TiposSexo;

/***
 * Se encarga del acceso y manipulación de los datos de los tipos de sexos
 * 
 * @author tofol
 *
 */
public class TiposSexosDAO {

	/***
	 * Obtiene una lista con los tipos de sexos
	 * 
	 * @return ArrayList con los tipos de sexos
	 */
	public static ArrayList<TiposSexo> getTiposSexos() {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			TiposSexosMapper tiposSexosMapper = sqlSession.getMapper(TiposSexosMapper.class);
			return tiposSexosMapper.getTiposSexos();
		} finally {
			sqlSession.close();
		}
	}

}
