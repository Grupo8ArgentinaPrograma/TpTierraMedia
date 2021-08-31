package TierraMedia;

public abstract class Ofertable implements Comparable<Ofertable> {

	private String nombre;
	private String tipo;

	public Ofertable(String nombre, String tipo) {
		this.nombre = nombre;
		this.tipo = tipo;

	}

	abstract protected double getCosto();

	abstract protected double getTiempoRecorrido();

	abstract protected void ocuparLugar();

	protected String getTipo() {
		return tipo;
	}
	public String getNombre() {
		return nombre;
	}

	@Override
	public int compareTo(Ofertable o) {

		if (this.getCosto() - o.getCosto() == 0) {
			return (int) -(this.getTiempoRecorrido() - o.getTiempoRecorrido());
		}

		return (int) -(this.getCosto() - o.getCosto());
	}

	@Override
	public String toString() {
		return "Nombre:" + nombre + ", Tipo:" + tipo + "";
	}

}
