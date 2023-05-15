package ar.edu.unlam.pb1.InterfazConcesionaria;

import java.util.Scanner;

import ar.edu.unlam.pb1.dominioConcesionaria.Concesionaria;
import ar.edu.unlam.pb1.dominioConcesionaria.Vehiculo;

public class TestConcesionaria {
	static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		Concesionaria concesionariaNueva = new Concesionaria();
		Integer opcion;
		do {

			menuConcesionaria();
			opcion = teclado.nextInt();
			switch (opcion) {
			case 1:
				registrarNuevoVehiculo(concesionariaNueva);
				break;
			case 2:
				mostrarTodosLosVehiculos(concesionariaNueva.getCoches());
				break;
			case 3:
				buscarVehiculoPorPatente(concesionariaNueva);
				break;
			case 4:
				mostrarMensaje("Saliendo...");
				break;

			default:
				mostrarMensaje("Opcion incorrecta\n");
				break;

			}
		} while (opcion != 4);
	}

// ---------------------------------------------------------------------------------------------------------------

	private static void buscarVehiculoPorPatente(Concesionaria concesionariaNueva) {
		String patente = "";
		Vehiculo vehiculoEncontrado = null;
		;

		mostrarMensaje("Ingrege la patente del vehiculo buscado");
		patente = teclado.next().toUpperCase();
		vehiculoEncontrado = concesionariaNueva.buscarVehiculo(patente);
		mostrarMensaje("El vehiculo es: " + vehiculoEncontrado.toString());
	}

	private static void mostrarTodosLosVehiculos(Vehiculo[] coches) {
		mostrarMensaje("Los Vehiculos registrados son: \n");
		for (int i = 0; i < coches.length; i++) {
			if (coches[i] != null) {
				mostrarMensaje(coches[i].toString());
			}
		}

	}

	private static void registrarNuevoVehiculo(Concesionaria concesionariaNueva) {
		String marca = "", modelo = "", patente = "";
		Integer kilometrosActuales = 0, anioDeFabricacion = 0;
		Double precio = 0.0;
		boolean sePudoAgregarVehiculo = false, esCeroKm = false;

		mostrarMensaje("Ingrese la Marca del vehiculo");
		marca = teclado.next().toLowerCase();
		mostrarMensaje("Ingrese el Modelo del vehiculo");
		modelo = teclado.next().toLowerCase();
		mostrarMensaje("Ingrese los Kilometros Actuales del vehiculo");
		kilometrosActuales = teclado.nextInt();
		mostrarMensaje("Ingrese el año de fabricacion del vehiculo");
		anioDeFabricacion = teclado.nextInt();
		mostrarMensaje("Ingrese precio deseado para el vehiculo");
		precio = teclado.nextDouble();
		mostrarMensaje("Ingrese la patente del vehiculo");
		patente = teclado.next().toUpperCase();

		Vehiculo nuevoVehiculo = new Vehiculo(marca, modelo, patente, kilometrosActuales, anioDeFabricacion, precio);
		sePudoAgregarVehiculo = concesionariaNueva.agregarVehiculo(nuevoVehiculo);
		notificarSiPudoAgregarVehiculo(sePudoAgregarVehiculo);
	}

	private static void notificarSiPudoAgregarVehiculo(boolean sePudoAgregarVehiculo) {
		if (sePudoAgregarVehiculo) {
			mostrarMensaje("Vehiculo registrado correctamente");
		} else {
			mostrarMensaje("No fue posible registrar el Vehiculo");
		}

	}

	private static void menuConcesionaria() {
		mostrarMensaje("----- BIENVENIDO -----");
		mostrarMensaje("Ingrese 1 para ingresar un nuevo vehiculo");
		mostrarMensaje("Ingrese 2 para mostrar el listado de Vehiculos");
		mostrarMensaje("Ingrese 3 para ver info. especifica de un vehiculo");
		mostrarMensaje("Ingrese 4 para salir");
	}

	public static void mostrarMensaje(String mensaje) {
		System.out.println(mensaje);
	}
}
