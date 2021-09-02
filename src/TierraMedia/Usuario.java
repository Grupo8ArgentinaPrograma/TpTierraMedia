package TierraMedia;

import java.util.ArrayList;


public class Usuario {

	private String nombre;
	private double dineroDisponible;
	private double tiempoDisponible;
	private String tipoPreferido;
	private ArrayList<Atraccion> atraccionComprada;
	private ArrayList<Promocion> promocionComprada;
	
	public Usuario(String nombre, int presupuesto, double tiempoDisponible, String tipoPreferido) {
		this.nombre = nombre;
		this.dineroDisponible = presupuesto;
		this.tiempoDisponible = tiempoDisponible;
		this.tipoPreferido = tipoPreferido;
		this.atraccionComprada = new  ArrayList<Atraccion>();
		this.promocionComprada = new ArrayList<Promocion>();
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

	public void comprarAtraccion(Atraccion atraccion) {
		
			atraccionComprada.add(atraccion);
			this.gastarDinero(atraccion.getCosto());
			this.restarTiempo(atraccion.getTiempoRecorrido());
			atraccion.ocuparLugar();

	}

	public boolean atraccionYaComprada(Atraccion atraccion) {
		boolean valor = false;
		for (Promocion promo : promocionComprada) {
			for (Atraccion atra : promo.getAtracciones()) {
				if (atra.getNombre().equals(atraccion.getNombre())) {
					valor = true;
					break;
				}
			}
		}
		
		return valor;
	}
	
	public void comprarPromocion(Promocion oferta) {
		
			promocionComprada.add(oferta);
			this.gastarDinero(oferta.getCosto());
			this.restarTiempo(oferta.getTiempoRecorrido());
			oferta.ocuparLugar();
		
	}
	

	public ArrayList<Atraccion> getAtraccionComprada() {
		return this.atraccionComprada;
	}

	public ArrayList<Promocion> getPromocionComprada() {
		return this.promocionComprada;
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
				+ tiempoDisponible + ", TipoPreferido:" + tipoPreferido + ", Atraccion Compradas:"+ this.atraccionComprada+this.promocionComprada+")";
	}

}
