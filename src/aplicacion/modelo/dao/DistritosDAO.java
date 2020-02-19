package aplicacion.modelo.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import aplicacion.modelo.dao.mappers.DistritosMapper;
import aplicacion.modelo.pojo.Distrito;

/***
 * Se encarga del acceso y manipulación de los datos de los distritos
 * 
 * @author tofol
 *
 */
public class DistritosDAO {

	/***
	 * Obtiene una lista de los nombres de los distritos
	 * 
	 * @return ArrayList con los nombres de los distritos
	 */
	public static ArrayList<String> getNombresDistritos() {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		ArrayList<String> distritos = null;
		try {
			distritos = (ArrayList<String>) sqlSession.selectList("getNombresDistritos");
		} finally {
			sqlSession.close();
		}
		return distritos;
	}

	/***
	 * Obtiene una lista con todos los distritos
	 * 
	 * @return ArrayList con los distritos
	 */
	public static ArrayList<Distrito> getDistritos() {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			DistritosMapper distritosMapper = sqlSession.getMapper(DistritosMapper.class);
			return distritosMapper.getDistritos();
		} finally {
			sqlSession.close();
		}
	}

}
