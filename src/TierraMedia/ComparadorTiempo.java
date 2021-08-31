package TierraMedia;

import java.util.Comparator;

public class ComparadorTiempo implements Comparator<Ofertable> {

	@Override
	public int compare(Ofertable uno, Ofertable dos) {
		Double primero = uno.getTiempoRecorrido();
		Double segundo = dos.getTiempoRecorrido();
		
		
		return primero.compareTo(segundo);
	}

}
