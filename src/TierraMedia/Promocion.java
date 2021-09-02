package TierraMedia;

import java.util.Arrays;

abstract public class Promocion extends Ofertable {

	private Atraccion[] itinerario;

	public Promocion( String nombre,Atraccion[] atracciones, String tipo) {
		super(nombre,tipo);
		this.itinerario = atracciones;
	}

	@Override
	public double getCosto() {
		double total = 0;

		for (Atraccion a : itinerario) {
			total += a.getCosto();
		}
		return total;
	}

	@Override
	public double getTiempoRecorrido() {
		double total = 0;

		for (Atraccion a : itinerario) {
			total += a.getTiempoRecorrido();
		}
		return total;
	}

	public Atraccion[] getAtracciones() {
		return this.itinerario;
	}

	@Override
	public void ocuparLugar() {

		for (Atraccion a : itinerario) {
			a.ocuparLugar();
		}
	}

	
	public boolean tieneAtraccion(Atraccion a) {
		boolean valor = false;
		for (Atraccion elemento : this.itinerario) {
			if (elemento.equals(a)) {
				valor = true;
				break;
			}
		}
		return valor;
	}

	@Override
	public String toString() {
		return "("+super.toString()+", Costo:"+this.getCosto() +", Itinerario:" + Arrays.toString(itinerario) + ")";
	}

	

	

}
