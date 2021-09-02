package TierraMedia;

public class PromocionAxB extends Promocion {

	Atraccion atracciongratis = super.getAtracciones()[super.getAtracciones().length - 1];

	public PromocionAxB(String nombre, Atraccion[] atracciones, String tipo) {
		super(nombre, atracciones, tipo);

	}
	
	
	@Override
	public double getCosto() {

		return super.getCosto() - atracciongratis.getCosto();
	}

	@Override
	public String toString() {
		return "PromocionAxB " + super.toString() + ", Atraccion Gratis: " + atracciongratis.getNombre() + "]";
	}
	
	
	

}
