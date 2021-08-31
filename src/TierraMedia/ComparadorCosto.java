package TierraMedia;

import java.util.Comparator;

public class ComparadorCosto implements Comparator<Ofertable> {

	@Override
	public int compare(Ofertable uno, Ofertable dos) {
		Double primero = uno.getCosto();
		Double segundo = dos.getCosto();
		
		return primero.compareTo(segundo);
	}

}
