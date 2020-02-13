package aplicacion.modelo.pojo;

public class AccidentesPorSexoYVehiculoEnDistrito {
	private String vehiculo;
	private String sexo;
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
