package aplicacion.modelo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import aplicacion.controlador.Estadisticas;
import aplicacion.modelo.dao.MyBatisUtil;

public class LogSingleton {
	private static final LogSingleton INSTANCE = new LogSingleton();
	private Logger loggerMyBatisUtil = LoggerFactory.getLogger(MyBatisUtil.class);
	private Logger loggerEstadisticas = LoggerFactory.getLogger(Estadisticas.class);

	private LogSingleton() {

	}

	public static LogSingleton getInstance() {
		return INSTANCE;
	}

	public Logger getLoggerMyBatisUtil() {
		return loggerMyBatisUtil;
	}

	public Logger getLoggerEstadisticas() {
		return loggerEstadisticas;
	}

}
