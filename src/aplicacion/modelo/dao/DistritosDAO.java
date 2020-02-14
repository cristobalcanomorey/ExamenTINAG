package aplicacion.modelo.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

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

}
