package TierraMedia;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class SistemaNuevo {

	private ArrayList<Usuario> visitantes;
	private ArrayList<Atraccion> atracciones;
	private ArrayList<Promocion> promociones;
	private ArrayList<Ofertable> ofertasPrioritaras;
	private ArrayList<Ofertable> ofertasSecundarios;

	public SistemaNuevo() {
		this.visitantes  = new ArrayList<Usuario>();
		this.atracciones = new ArrayList<Atraccion>();
		this.promociones = new ArrayList<Promocion>();
		this.ofertasPrioritaras = new ArrayList<Ofertable>();
		this.ofertasSecundarios = new ArrayList<Ofertable>();
	}

	public void CrearUsuarios(String archivo) {

		Scanner sc = null;

		try {
			sc = new Scanner(new File(archivo));

			while (sc.hasNext()) {
				// leo cada linea del archivo
				String linea = sc.nextLine();
				String datos[] = linea.split(",");
				// creo visitante
				String nombre = datos[0];
				int dinero = Integer.parseInt(datos[1]);
				double tiempo = Double.parseDouble(datos[2]);
				String tipo = datos[3];
				visitantes.add(new Usuario(nombre, dinero, tiempo, tipo));
				

			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			sc.close();
		}

	}

	
	public void nuevaAtraccion(String archivo) {
		
		Scanner sc = null;

		try {
			sc = new Scanner(new File(archivo));

			while (sc.hasNext()) {
				// leo cada linea del archivo
				String linea = sc.nextLine();
				String datos[] = linea.split(",");
				// creo visitante
				String nombre = datos[0];
				double costo = Double.parseDouble(datos[1]);
				double tiempo = Double.parseDouble(datos[2]);
				int cupo = Integer.parseInt(datos[3]);
				String tipo = datos[4];
				atracciones.add(new Atraccion(nombre,costo, tiempo,cupo ,tipo));
				
			}
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} finally {
			sc.close();
		}	
	}
	
	public void nuevaPromocion(String archivo) {
		Scanner sc = null;

		
		

		
		try {
			sc = new Scanner(new File(archivo));

			while (sc.hasNext()) {
				
				String linea = sc.nextLine();
				String datos[] = linea.split(",");
			
				String promo = datos[0];
				String nombre = datos[1];
				int costo = Integer.parseInt(datos[2]);
				String tipo = datos[3];
				
				if(promo.equals("porcentual")){ nuevaPromoPorcentual(nombre, null,tipo,costo);}
				if(promo.equals("absoluta")) { nuevaPromoAbsoluta(nombre, null, tipo, costo);}
				if(promo.equals("axb")) {nuevaPromoAxB(nombre,null,tipo);}
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			sc.close();
		}	
		
	}

	private void nuevaPromoPorcentual(String nombre, Atraccion[] paquete, String tipo, int descuento) {
		promociones.add(new PromocionPorcentual(nombre, paquete, tipo, descuento));
	}

	private void nuevaPromoAbsoluta(String nombre, Atraccion[] paquete, String tipo, int costo) {
		promociones.add(new PromocionAbsoluta(nombre, paquete, tipo, costo));
	}

	private void nuevaPromoAxB(String nombre, Atraccion[] paquete, String tipo) {
		promociones.add(new PromocionAxB(nombre, paquete, tipo));
	}

	
	public void ofertasAtracciones(Usuario visitante) {
		
		for (Atraccion a : this.atracciones) {
			if (      !visitante.atraccionYaComprada(a)
					&& visitante.getTipoPreferido().equals(a.getTipo())
					&& visitante.getDineroDisponible() >= a.getCosto()
					&& visitante.getTiempoDisponible() >= a.getTiempoRecorrido()
					&& !visitante.getAtraccionComprada().contains(a)){
				
				ofertasPrioritaras.add(a);
				System.out.println(visitante.getTipoPreferido() == a.getTipo());
				
			} else if (	 
					   !visitante.atraccionYaComprada(a)
					&& !visitante.getTipoPreferido().equals(a.getTipo())
					&& visitante.getDineroDisponible() >= a.getCosto()
					&& visitante.getTiempoDisponible() >= a.getTiempoRecorrido()
					&& !visitante.getAtraccionComprada().contains(a)) {
				ofertasSecundarios.add(a);
				
				
				
			}
		}
	}
	
	public void OfertasPromociones(Usuario visitante) {

		for (Promocion a :this.promociones) {
			if (      
					visitante.getTipoPreferido().equals(a.getTipo())
					&& visitante.getDineroDisponible() >= a.getCosto()
					&& visitante.getTiempoDisponible() >= a.getTiempoRecorrido()
					&& !visitante.getPromocionComprada().contains(a)){
				ofertasPrioritaras.add(a);
				
			} else if (	 
					!visitante.getTipoPreferido().equals(a.getTipo()) 
					&& visitante.getDineroDisponible() >= a.getCosto()
					&& visitante.getTiempoDisponible() >= a.getTiempoRecorrido()
					&& !visitante.getPromocionComprada().contains(a)) {
				ofertasSecundarios.add(a);
			}
		}
	}
	
	
	public void ordenarOfertas() {
		this.ofertasPrioritaras.sort(new ComparadorCosotoYTiempo());
		this.ofertasSecundarios.sort(new ComparadorCosotoYTiempo());
	}

	
	public ArrayList<Ofertable> getOfertasSecundarios() {
		return ofertasSecundarios;
	}
	
	public ArrayList<Ofertable> getOfertasPrioritaras() {
		return ofertasPrioritaras;
	}

	public ArrayList<Usuario> getVisitantes() {
		return visitantes;
	}

	public ArrayList<Atraccion> getAtracciones() {
		return   atracciones;
	}

	public ArrayList<Promocion> getPromociones() {
		return promociones;
	}
	
	
	
}
