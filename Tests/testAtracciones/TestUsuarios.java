package testAtracciones;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import TierraMedia.Atraccion;
import TierraMedia.PromocionPorcentual;
import TierraMedia.Ofertable;
import TierraMedia.Promocion;
import TierraMedia.PromocionAbsoluta;
import TierraMedia.Usuario;

public class TestUsuarios {

	Usuario u1;

	@Before
	public void iniciar() {
		u1 = new Usuario("spider",1000, 100, "paisaje");
	}

	@Test
	public void queSeCreanUsuarios() {
		assertNotNull(u1);
	}

	@Test
	public void queGastaDinero() {
		double dinero = u1.getDineroDisponible();
		assertEquals(1000, dinero, 0.0);
		u1.gastarDinero(900);
		assertEquals(100, u1.getDineroDisponible(), 0.0);
	}

	@Test(expected = Error.class)
	public void queNoSePuedeGastarMasDineroDelQueSeTiene() {
		u1.gastarDinero(1001);

	}

	@Test
	public void queCompraAtracciones() {

		Atraccion atra = new Atraccion("Mordor uno",  25 , 10, 5, "Aventura");
		Atraccion atra2 = new Atraccion("Mordor dos", 25, 10, 5, "Aventura");
		Atraccion atra3 = new Atraccion("Mordor tres", 25, 10, 5, "Aventura");
		
		Atraccion itinerario[] = { atra, atra2, atra3 };
	
		Promocion oferta= new PromocionAbsoluta(itinerario, "aventura", 20);
		
		
	}

	@Test
	public void quePagaConDineroLasAtraccionse() {

		Atraccion atra = new Atraccion("Mordor uno", 25, 10, 5, "Aventura");
		u1.comprarSugerencia(atra);
		assertEquals(975, u1.getDineroDisponible(), 0);

	}

	@Test
	public void queCalculaElTiempo() {

		Atraccion atra = new Atraccion("Mordor uno", 25, 10, 5, "Aventura");
		u1.comprarSugerencia(atra);
		assertEquals(90, u1.getTiempoDisponible(), 0);

	}

	@Test
	public void quecUsuarioCompraPromo() {

		
		Usuario u3 = new Usuario("peter",1000, 100, "paisaje");

		Atraccion a1 = new Atraccion("Mordor uno", 25, 10, 5, "Aventura");
		Atraccion a2 = new Atraccion("Mordor dos", 25, 10, 5, "Aventura");
		Atraccion a3 = new Atraccion("Mordor tres", 25, 10, 5, "Aventura");
		Atraccion a4 = new Atraccion("Mordor cuatro", 25, 10, 5, "Aventura");
		Atraccion atracciones[] = { a1, a2, a3, a4 };
		Ofertable promo1 = new PromocionPorcentual(atracciones, "aventra",20);
		 
		
		u1.comprarSugerencia(promo1);
		u1.comprarSugerencia(a1);
		u3.comprarSugerencia(a1);
	
		

		assertEquals(2, a1.getCupo());

	}

}
