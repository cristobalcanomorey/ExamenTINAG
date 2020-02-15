package aplicacion.modelo.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import aplicacion.modelo.dao.mappers.AccidentesMapper;
import aplicacion.modelo.pojo.Accidente;
import aplicacion.modelo.pojo.AccidenteConDistrito;
import aplicacion.modelo.pojo.AccidentesPorSexoYVehiculoEnDistrito;
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

	public static ArrayList<AccidentesPorSexoYVehiculoEnDistrito> getAccidentesPorSexoYVehiculoEnDistrito(String fIni,
			String fFin, String distrito) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			AccidentesMapper accidentesMapper = sqlSession.getMapper(AccidentesMapper.class);
			return accidentesMapper.getAccidentesPorSexoYVehiculoEnDistrito(fIni, fFin, distrito);
		} finally {
			sqlSession.close();
		}
	}

	public static ArrayList<AccidenteConDistrito> getAccidentesConDistritos() {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			AccidentesMapper accidentesMapper = sqlSession.getMapper(AccidentesMapper.class);
			return accidentesMapper.getAccidentesConDistritos();
		} finally {
			sqlSession.close();
		}
	}

	public static Accidente getAccidente(String id) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			AccidentesMapper accidentesMapper = sqlSession.getMapper(AccidentesMapper.class);
			return accidentesMapper.getAccidente(id);
		} finally {
			sqlSession.close();
		}
	}

	public static void updateAccidente(Accidente accidente) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			AccidentesMapper accidentesMapper = sqlSession.getMapper(AccidentesMapper.class);
			accidentesMapper.updateAccidente(accidente);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}

	public static void borrarAccidente(String id) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			AccidentesMapper accidentesMapper = sqlSession.getMapper(AccidentesMapper.class);
			accidentesMapper.borrarAccidente(id);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}

	public static void insertAccidente(Accidente accidente) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			AccidentesMapper accidentesMapper = sqlSession.getMapper(AccidentesMapper.class);
			accidentesMapper.insertAccidente(accidente);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}

}
