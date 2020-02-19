package aplicacion.modelo.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import aplicacion.modelo.dao.AgentesDAO;
import aplicacion.modelo.pojo.Agente;

/***
 * Lógica de negocio para los agentes
 * 
 * @author tofol
 *
 */
@Stateless
@LocalBean
public class AgentesEJB {

	/***
	 * Obtiene el agente que coincide con esta placa y clave
	 * 
	 * @param placa Placa del agente
	 * @param clave Contraseña del agente
	 * @return Agente con esa placa y clave o null
	 */
	public Agente validarAgente(String placa, String clave) {
		return AgentesDAO.validarAgente(placa, clave);
	}

}
