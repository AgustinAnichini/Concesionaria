package ar.edu.unlam.pb1.dominioConcesionaria;

public class Vehiculo {
	private boolean CERO_KM;
	private static final Integer ANO_ACTUAL = 2022;
	private static Integer contidadCoches = 10;
	private String marca;
	private String modelo;
	private Integer kilometrosActuales;
	private Integer anioDeFabricacion;
	private Double precio;
	private String patente;
//	private  static int antiguedadDeVehiculo = 0;

	@Override
	public String toString() {
		return "Vehiculo [Es cero Km =" + CERO_KM + ", Marca=" + marca + ", Modelo=" + modelo + ", Kilometros Actuales="
				+ kilometrosActuales + ", Anio De Fabricacion=" + anioDeFabricacion + ", Precio=" + precio
				+ ", Patente=" + patente + "]";
	}

	public Vehiculo(String marca, String modelo, Double precio) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.precio = precio;
		this.contidadCoches = 10;
		this.CERO_KM = false;
	}

	public Vehiculo(String marca, String modelo, String patente, Integer kilometrosActuales, Integer anioDeFabricacion,
			Double precio) {
		this.marca = marca;
		this.modelo = modelo;
		this.kilometrosActuales = kilometrosActuales;
		this.anioDeFabricacion = anioDeFabricacion;
		this.precio = precio;
		this.contidadCoches = 10;
		this.CERO_KM = esCeroKm(anioDeFabricacion);
		this.patente = patente;
	}

	public String getPatente() {
		return patente;
	}

	public static boolean esCeroKm(Integer anioDeFabricacion2) {
		boolean esCeroKm = false;
		if (anioDeFabricacion2.equals(ANO_ACTUAL)) {
			esCeroKm = true;
		} else {
//			antiguedadDeVehiculo = ANO_ACTUAL - anioDeFabricacion2;
			esCeroKm = false;
		}
		// si el año de fabricacion es el actual ---> es CERO KM
		// sino calculo la antiguedad ---> año actual - año de fabricacion
		return esCeroKm;
	}

	public static Integer getContidadCoches() {
		return contidadCoches;
	}

	public void setKilometrosActuales(Integer kilometrosActuales) {
		this.kilometrosActuales = kilometrosActuales;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

}
