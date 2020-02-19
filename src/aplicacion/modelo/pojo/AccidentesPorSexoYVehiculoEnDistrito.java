package aplicacion.modelo.pojo;

import javax.xml.bind.annotation.XmlRootElement;

/***
 * Pojo con el sexo, vehiculo y cantidad de accidentes de ese sexo y con ese
 * vehículo
 * 
 * @author tofol
 *
 */
@XmlRootElement
public class AccidentesPorSexoYVehiculoEnDistrito {
	private String sexo;
	private String vehiculo;
	private Integer cantidad;

	public AccidentesPorSexoYVehiculoEnDistrito() {

	}

	public String getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(String vehiculo) {
		this.vehiculo = vehiculo;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

}
