package aplicacion.modelo.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import aplicacion.modelo.dao.mappers.TiposVehiculosMapper;
import aplicacion.modelo.pojo.TiposVehiculo;

public class TiposVehiculosDAO {

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
