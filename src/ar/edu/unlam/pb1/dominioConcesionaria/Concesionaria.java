package ar.edu.unlam.pb1.dominioConcesionaria;

public class Concesionaria {
	// contiene los vehiculos
	private  Vehiculo coches[];

	public Concesionaria() {
		this.coches = new Vehiculo[Vehiculo.getContidadCoches()];
	}

	public Vehiculo[] getCoches() {
		return coches;
	}

	public void setCoches(Vehiculo[] coches) {
		this.coches = coches;
	}

	public boolean agregarVehiculo(Vehiculo nuevoVehiculo) {
		boolean sePudoAgregarVehiculo = false;
		int indice = 0;
		for (indice = 0; indice < coches.length; indice++) {
			if (!sePudoAgregarVehiculo && coches[indice] == null) {
				this.coches[indice] = nuevoVehiculo;
				sePudoAgregarVehiculo = true;
			}
		}
		return sePudoAgregarVehiculo;
	}

	public Vehiculo buscarVehiculo(String patente) {
		boolean sePudoEncontrarVehiculo = false;
		Vehiculo vehiculoEncontrado = null;
		int indice = 0;

		for (indice = 0; indice < coches.length; indice++) {
			if (coches[indice] != null && !sePudoEncontrarVehiculo && coches[indice].getPatente().equals(patente)) {
				vehiculoEncontrado = this.coches[indice];
				sePudoEncontrarVehiculo = true;
			}
		}
		return vehiculoEncontrado;
	}
}
