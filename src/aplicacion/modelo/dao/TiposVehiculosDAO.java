package aplicacion.modelo.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import aplicacion.modelo.dao.mappers.TiposVehiculosMapper;
import aplicacion.modelo.pojo.TiposVehiculo;

/***
 * Se encarga del acceso y manipulación de los datos de los tipos de vehiculos
 * 
 * @author tofol
 *
 */
public class TiposVehiculosDAO {

	/***
	 * Obtiene una lista con los tipos de vehiculos
	 * 
	 * @return ArrayList con los tipos de vehiculos
	 */
	public static ArrayList<TiposVehiculo> getTiposVehiculos() {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			TiposVehiculosMapper tiposVehiculosMapper = sqlSession.getMapper(TiposVehiculosMapper.class);
			return tiposVehiculosMapper.getTiposVehiculos();
		} finally {
			sqlSession.close();
		}
	}

}
