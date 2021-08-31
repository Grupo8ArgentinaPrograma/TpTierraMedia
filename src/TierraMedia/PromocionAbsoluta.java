package TierraMedia;

public class PromocionAbsoluta extends Promocion {

	private double costo;

	public PromocionAbsoluta(String nombre,Atraccion[] atracciones, String tipo,double costo) {
		super(nombre,atracciones, tipo);
		this.costo = costo;
	}
		
	@Override
	public double getCosto() {
		return this.costo;
	}

	@Override
	public String toString() {
		return "PromocionAbsoluta "+super.toString() + "]";
	}

}
