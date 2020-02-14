package aplicacion.modelo.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import aplicacion.modelo.dao.mappers.TiposSexosMapper;
import aplicacion.modelo.pojo.TiposSexo;

public class TiposSexosDAO {

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
