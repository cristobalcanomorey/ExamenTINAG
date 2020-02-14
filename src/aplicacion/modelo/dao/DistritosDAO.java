package aplicacion.modelo.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import aplicacion.modelo.dao.mappers.DistritosMapper;
import aplicacion.modelo.pojo.Distrito;

public class DistritosDAO {

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
