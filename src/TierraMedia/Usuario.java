package TierraMedia;

import java.util.ArrayList;

public class Usuario {

	private String nombre;
	private double dineroDisponible;
	private double tiempoDisponible;
	private String tipoPreferido;
	private ArrayList<Ofertable> visitasCompradas;
	

	public Usuario(String nombre, int presupuesto, double tiempoDisponible, String tipoPreferido) {
		this.nombre = nombre;
		this.dineroDisponible = presupuesto;
		this.tiempoDisponible = tiempoDisponible;
		this.tipoPreferido = tipoPreferido;
		visitasCompradas = new ArrayList<Ofertable>();
	}

	public void gastarDinero(double gasto) {
		if (getDineroDisponible() < gasto)
			throw new Error("Dinero insuficiente");

		this.dineroDisponible -= gasto;

	}

	private void restarTiempo(double tiempoUsado) {
		if (getTiempoDisponible() < tiempoUsado)
			throw new Error("Dinero insuficiente");

		this.tiempoDisponible -= tiempoUsado;
	}

	public void comprarSugerencia(Ofertable visitaSugerida) {
		visitasCompradas.add(visitaSugerida);
		this.gastarDinero(visitaSugerida.getCosto());
		this.restarTiempo(visitaSugerida.getTiempoRecorrido());
		visitaSugerida.ocuparLugar();

	}
		

	public ArrayList<Ofertable> getItinerario() {
		return this.visitasCompradas;
	}

	public double getTiempoDisponible() {

		return this.tiempoDisponible;
	}

	public String getTipoPreferido() {
		return tipoPreferido;
	}

	public double getDineroDisponible() {
		return this.dineroDisponible;
	}

	public String getNombre() {
		return nombre;
	}

	@Override
	public String toString() {
		return "Usuario (Nombre:" + nombre + ", DineroDisponible:" + dineroDisponible + ", TiempoDisponible:"
				+ tiempoDisponible + ", TipoPreferido:" + tipoPreferido + ", VisitasCompradas:" + visitasCompradas
				+ ")";
	}

}
