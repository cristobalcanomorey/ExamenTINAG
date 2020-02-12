package aplicacion.modelo.pojo;

public class AccidentesPorDistrito {

	private Integer idDistrito;
	private String nombreDistrito;
	private Integer numeroAccidentes;

	public AccidentesPorDistrito() {

	}

	public Integer getIdDistrito() {
		return idDistrito;
	}

	public void setIdDistrito(Integer idDistrito) {
		this.idDistrito = idDistrito;
	}

	public String getNombreDistrito() {
		return nombreDistrito;
	}

	public void setNombreDistrito(String nombreDistrito) {
		this.nombreDistrito = nombreDistrito;
	}

	public Integer getNumeroAccidentes() {
		return numeroAccidentes;
	}

	public void setNumeroAccidentes(Integer numeroAccidentes) {
		this.numeroAccidentes = numeroAccidentes;
	}

}
