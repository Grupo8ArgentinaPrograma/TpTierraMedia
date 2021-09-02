package TierraMedia;

import java.util.ArrayList;
import java.util.Arrays;

public class Sugerencias {

	private Usuario visitante;
	
 
	
	private ArrayList<Ofertable> ofertasPrioritaras;
	private ArrayList<Ofertable> ofertasSecundarios;

	public Sugerencias(Usuario visitante, Atraccion[] atracciones, Promocion[] promocionDiarias) {
		this.visitante = visitante;
		
		ofertasPrioritaras = new ArrayList<Ofertable>();
		ofertasSecundarios = new ArrayList<Ofertable>();
		setOferta(atracciones, promocionDiarias);
	}

	private void setOferta(Atraccion[] atracciones, Promocion[] promocionDiarias) {
		ordenarAgregarElementoArray(promocionDiarias);
		ordenarAgregarElementoArray(atracciones);
	}

	private void ordenarAgregarElementoArray(Ofertable[] array) {
		Arrays.sort(array);
		for (Ofertable a : array) {
			if (tipoCoinciden(a) && puedoOfertar(a))
				this.ofertasPrioritaras.add(a);
			else if (!tipoCoinciden(a) && puedoOfertar(a))
				this.ofertasSecundarios.add(a);
		}
	}

	private boolean tipoCoinciden(Ofertable a) {
		return visitante.getTipoPreferido() == a.getTipo();
	}

	private boolean puedoOfertar(Ofertable a) {

		if (a instanceof Atraccion) {
				
				return  visitante.getDineroDisponible() >= a.getCosto()
						&& visitante.getTiempoDisponible() >= a.getTiempoRecorrido()
						&& !visitante.getAtraccionComprada().contains(a) && !(visitante.getPromocionComprada().contains(a))
						&& !(visitante.atraccionYaComprada((Atraccion) a));
			
		}
		
		return visitante.getDineroDisponible() >= a.getCosto()
				&& visitante.getTiempoDisponible() >= a.getTiempoRecorrido()
				&& !visitante.getAtraccionComprada().contains(a) && !(visitante.getPromocionComprada().contains(a));

	}

	

	public ArrayList<Ofertable> getOfertasPrioritaras() {
		return ofertasPrioritaras;
	}

	public ArrayList<Ofertable> getOfertasSecundarios() {
		return ofertasSecundarios;
	}

}
