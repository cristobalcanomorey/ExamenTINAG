package aplicacion.modelo.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import aplicacion.modelo.dao.AgentesDAO;
import aplicacion.modelo.pojo.Agente;

@Stateless
@LocalBean
public class AgentesEJB {

	public Agente loginAgente(String placa, String clave) {
		return AgentesDAO.loginAgente(placa, clave);
	}

}
