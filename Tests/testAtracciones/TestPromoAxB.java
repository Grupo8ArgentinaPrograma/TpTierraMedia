package testAtracciones;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import TierraMedia.Atraccion;
import TierraMedia.Promocion;
import TierraMedia.PromocionAxB;

public class TestPromoAxB {


	Promocion pp;
	Atraccion a1;
	Atraccion a2;
	Atraccion a3;
	Atraccion a4;

	@Before
	public void test() {
		a1 = new Atraccion("Mordor uno", 10, 10, 5, "Aventura");
		a2 = new Atraccion("Mordor dos", 20, 10, 5, "Aventura");
		a3 = new Atraccion("Mordor tres", 30, 10, 5, "Aventura");
		a4 = new Atraccion("Mordor cuatro", 50000, 10, 5, "Aventura");
		Atraccion atracciones[] = { a1, a2, a3, a4 };
		pp = new PromocionAxB(atracciones, "Paisaje");
	}

	@Test
	public void queSeCreaPromoAxB() {
		assertNotNull(a1);
	}
	@Test
	public void queHaceDescuentaUltimaAtraccion() {
		double costo = pp.getCosto();
		assertEquals(60, costo, 0.0);

	}
	

}
