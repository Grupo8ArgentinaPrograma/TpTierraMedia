package TierraMedia;

import java.util.ArrayList;

public class SistemaNuevo {

	private ArrayList<Usuario> visitantes;
	private ArrayList<Atraccion> atracciones;
	private ArrayList<Promocion> promociones;
	private ArrayList<Ofertable> ofertasPrioritaras;
	private ArrayList<Ofertable> ofertasSecundarios;

	public SistemaNuevo() {
		this.visitantes  = new ArrayList<Usuario>();
		this.atracciones = new ArrayList<Atraccion>();
		this.promociones = new ArrayList<Promocion>();
		this.ofertasPrioritaras = new ArrayList<Ofertable>();
		this.ofertasSecundarios = new ArrayList<Ofertable>();
	}

	public void nuevoUsuario(String nombre, int dinero, double tiempo, String tipo) {
		visitantes.add(new Usuario(nombre, dinero, tiempo, tipo));
	}

	public void nuevaAtraccion(String nombre, double costo, int cupo, double tiempo, String tipo) {
		atracciones.add(new Atraccion(nombre, costo, tiempo, cupo, tipo));
	}

	public void nuevaPromoPorcentual(String nombre, Atraccion[] paquete, String tipo, int descuento) {
		promociones.add(new PromocionPorcentual(nombre, paquete, tipo, descuento));
	}

	public void nuevaPromoAbsoluta(String nombre, Atraccion[] paquete, String tipo, int costo) {
		promociones.add(new PromocionAbsoluta(nombre, paquete, tipo, costo));
	}

	public void nuevaPromoAxB(String nombre, Atraccion[] paquete, String tipo) {
		promociones.add(new PromocionAxB(nombre, paquete, tipo));
	}

	
	
	

	public void setOfertasPrioritaras(Usuario visitante) {

		for (Atraccion a : this.atracciones) {
			if (	visitante.getTipoPreferido() == a.getTipo()
					&&visitante.getDineroDisponible() >= a.getCosto()
					&& visitante.getTiempoDisponible() >= a.getTiempoRecorrido()
					&& !visitante.getItinerario().contains(a)) {
				ofertasPrioritaras.add(a);
			}
		}
	}

	public void setOfertasSecundarias(Usuario visitante) {

		for (Atraccion a : this.atracciones) {
			if (	!(visitante.getTipoPreferido() == a.getTipo())
					&&visitante.getDineroDisponible() >= a.getCosto()
					&& visitante.getTiempoDisponible() >= a.getTiempoRecorrido()
					&& !visitante.getItinerario().contains(a)) {
				ofertasSecundarios.add(a);
			}
		}
	}
	
	public ArrayList<Ofertable> getOfertasSecundarios() {
		return ofertasSecundarios;
	}
	
	public ArrayList<Ofertable> getOfertasPrioritaras() {
		return ofertasPrioritaras;
	}

	public ArrayList<Usuario> getVisitantes() {
		return visitantes;
	}

	public ArrayList<Atraccion> getAtracciones() {
		return   atracciones;
	}

	public ArrayList<Promocion> getPromociones() {
		return promociones;
	}
	
	
}
