package aplicacion.modelo.pojo;

import javax.xml.bind.annotation.XmlRootElement;

/***
 * Pojo con el nombre de distrito, el tipo de accidente y la cantidad de
 * accidentes de ese tipo en el distrito
 * 
 * @author tofol
 *
 */
@XmlRootElement
public class AccidentesPorTipoEnDistrito {

	private String distrito;
	private String tipo;
	private Integer cantidad;

	public AccidentesPorTipoEnDistrito() {

	}

	public String getDistrito() {
		return distrito;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

}
