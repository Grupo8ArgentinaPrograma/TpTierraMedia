package testAtracciones;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import TierraMedia.Atraccion;
import TierraMedia.PromocionPorcentual;

public class TestPromoPorcentual {
	PromocionPorcentual pp;
	Atraccion a1;
	Atraccion a2;
	Atraccion a3;
	Atraccion a4;
	
	@Before
	public void test() {
		 a1 = new Atraccion("Mordor uno", 25, 10, 5, "Aventura");
	     a2 = new Atraccion("Mordor dos", 25, 10, 5, "Aventura");
		 a3 = new Atraccion("Mordor tres", 25, 10, 5, "Aventura");
		 a4 = new Atraccion("Mordor cuatro", 25, 10, 5, "Aventura");
		 Atraccion atracciones[] = { a1, a2, a3, a4 };
	     pp = new PromocionPorcentual(atracciones,"Paisaje",25);
	}

	@Test
	public void queSeCreaPromoPorcentual() {
		assertNotNull(a1);
	}

	@Test
	public void queHaceDescuentoPorcentual() {
		double costo = pp.getCosto();
		assertEquals(75, costo,0.0);
		
	}
}
