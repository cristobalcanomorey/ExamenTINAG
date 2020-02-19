package aplicacion.modelo.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import aplicacion.modelo.dao.mappers.AccidentesMapper;
import aplicacion.modelo.pojo.Accidente;
import aplicacion.modelo.pojo.AccidenteConDistrito;
import aplicacion.modelo.pojo.AccidentesPorSexoYVehiculoEnDistrito;
import aplicacion.modelo.pojo.AccidentesPorTipoEnDistrito;

/***
 * Se encarga del acceso y manipulación de los datos de los accidentes
 * 
 * @author tofol
 *
 */
public class AccidentesDAO {

	/***
	 * Obtiene una lista de 'AccidentesPorTipoEnDistrito' a partir de dos fechas
	 * limitantes
	 * 
	 * @param fIni Fecha mínima
	 * @param fFin Fecha máxima
	 * @return ArrayList de 'AccidentesPorTipoEnDistrito'
	 */
	public static ArrayList<AccidentesPorTipoEnDistrito> getAccidentesPorTipoEnDistrito(String fIni, String fFin) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			AccidentesMapper accidentesMapper = sqlSession.getMapper(AccidentesMapper.class);
			return accidentesMapper.getAccidentesPorTipoEnDistrito(fIni, fFin);
		} finally {
			sqlSession.close();
		}
	}

	/***
	 * Obtiene una lista de 'AccidentesPorSexoYVehiculoEnDistrito' de un distrito a
	 * partir de dos fechas limitantes
	 * 
	 * @param fIni     Fecha mínima
	 * @param fFin     Fecha máxima
	 * @param distrito Distrito del cual se obtienen los
	 *                 'AccidentesPorSexoYVehiculoEnDistrito'
	 * @return ArrayList de 'AccidentesPorSexoYVehiculoEnDistrito'
	 */
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

	/***
	 * Obtiene una lista de 'AccidenteConDistrito' de un distrito
	 * 
	 * @param idDistrito Id del distrito
	 * @return ArrayList de 'AccidenteConDistrito'
	 */
	public static ArrayList<AccidenteConDistrito> getAccidentesConDistritos(String idDistrito) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			AccidentesMapper accidentesMapper = sqlSession.getMapper(AccidentesMapper.class);
			return accidentesMapper.getAccidentesConDistritos(idDistrito);
		} finally {
			sqlSession.close();
		}
	}

	/***
	 * Obtiene un accidente a partir de su id
	 * 
	 * @param id Id del accidente
	 * @return Accidente con esa id
	 */
	public static Accidente getAccidente(String id) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			AccidentesMapper accidentesMapper = sqlSession.getMapper(AccidentesMapper.class);
			return accidentesMapper.getAccidente(id);
		} finally {
			sqlSession.close();
		}
	}

	/***
	 * Modifica los datos del accidente que tenga la misma id que el accidente
	 * pasado por parametro
	 * 
	 * @param accidente Accidente con los datos modificados
	 */
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

	/***
	 * Borra el accidente que tenga esa id
	 * 
	 * @param id Id del accidente a borrar
	 */
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

	/***
	 * Inserta un nuevo accidente
	 * 
	 * @param accidente El nuevo accidente
	 */
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
