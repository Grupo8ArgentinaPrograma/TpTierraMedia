package TierraMedia;

public class Atraccion extends Ofertable{

	private double costo;
	private double tiempo;
	private int cupo;	

	public Atraccion(String nombre, double costo, double tiempo, int cupo, String tipo) {
		
		super(nombre,tipo);
		this.costo = costo;
		this.tiempo = tiempo;
		this.cupo = cupo;
		
	}

	public boolean tieneCupo() {
		return cupo > 0;
	}

	public int getCupo() {
		return this.cupo;
	}

	@Override
	public void ocuparLugar() {
		if (!tieneCupo())
			throw new Error("no quedan cupos");
		this.cupo--;
	}

	@Override
	public double getCosto() {
		return this.costo;
	}

	@Override
	public double getTiempoRecorrido() {
		return this.tiempo;
	}

	
	@Override
	public String toString() {
		return "Atraccion ("+super.toString() +", Costo:" + costo + ", Tiempo:" + tiempo +")";
	}


	
}
