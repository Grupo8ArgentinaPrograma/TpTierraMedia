package TierraMedia;

public class PromocionPorcentual extends Promocion {

	private int descuento;

	public PromocionPorcentual(String nombre,Atraccion[] atracciones, String tipo, int descuento) {
		super(nombre,atracciones, tipo);
		this.descuento = descuento;
	}

	private double getDescuento() {
		return  super.getCosto() * (descuento * 0.01);
	}
	
	@Override
	public double getCosto() {
		return super.getCosto() - getDescuento();
	}

	@Override
	public String toString() {
		return "PromocionPorcentual "+super.toString()+", Descuento:" + descuento +"]";
	}
	

}
