package TierraMedia;



public class Sistema {

	public static void main(String[] args) {


		SistemaNuevo sistema = new SistemaNuevo();
		
		sistema.nuevoUsuario("mauro", 1000, 100, "Aventura");
		sistema.nuevoUsuario("Frodo", 200, 300, "Dessgustacion");
		
		sistema.nuevaAtraccion("Bree", 30, 33, 10, "Aventura");
		sistema.nuevaAtraccion("Rohan", 210, 23, 30, "Aventura");
		
		
		Atraccion []paquete1= {new Atraccion("Uno", 30, 33, 10, "Aventura"), new Atraccion("dos", 12, 10, 10, "Ave5ntura"),new Atraccion("Tres", 30, 30, 30, "Aventura")};
		sistema.nuevaPromoAbsoluta("El camino de thombombadil",paquete1 , "Aventura", 10);
		
		sistema.nuevaPromoAbsoluta("El camino de thombombadil",paquete1 , "aventura", 10);
		
		
		//System.out.println(sistema.getVisitantes().get(0));
		//System.out.println(sistema.getAtracciones());
		//System.out.println(sistema.getPromociones());
	    sistema.setOfertasPrioritaras(sistema.getVisitantes().get(0));
	    
	    System.out.println(sistema.getOfertasPrioritaras());
	  
		
		
		
		/*		Usuario u1 = new Usuario("camilon",1000, 100,"Aventura");
		
		Atraccion at1 = new Atraccion("Uno", 30, 33, 10, "Aventura");
		Atraccion at2 = new Atraccion("dos", 12, 10, 10, "Ave5ntura");
		Atraccion at3 = new Atraccion("Tres", 30, 30, 30, "Aventura");
		Atraccion at4 = new Atraccion("Cuatro", 40, 40, 40, "Aventura");
		Atraccion at5 = new Atraccion("Cinco", 3,101, 50, "Aventural");
		
		Atraccion paquete1[]= {at1,at2};
		Atraccion paquete2[]= {at3,at4};
		Atraccion paquete3[]= {at4,at5};
		
		
		Promocion promoPOrcentual1 = new PromocionPorcentual("primera",paquete1, "Aventura",50);
		Promocion promoPOrcentual2 = new PromocionAbsoluta("segunda",paquete2, "Aventu2ra",100);
		Promocion promoPOrcentual3 = new PromocionAxB("tercera",paquete3, "Aventura");
	
		Atraccion todasLasAtracciones[]= {at1,at2,at3,at4,at5};
		Promocion todasLasPromociones[]= {promoPOrcentual1,promoPOrcentual2,promoPOrcentual3};
		u1.comprarSugerencia(promoPOrcentual1);
		Sugerencias sug = new Sugerencias(u1 ,todasLasAtracciones, todasLasPromociones);
		
		
	
		for(Ofertable a :sug.getOfertasPrioritaras()) {
			System.out.println(a);
		}
		
		System.out.println("///////////////////////////////");
		
		for(Ofertable a :sug.getOfertasSecundarios()) {
			System.out.println(a);
		}
		
		
			System.out.println(u1);

		u1.comprarSugerencia(promoPOrcentual);
		//u1.comprarSugerencia(at5);
		//u1.comprarSugerencia(at4);
			
		//System.out.println(sug.atraccionEstaEnOfertaComprada(paquete2));
	
		public boolean atraccionEstaEnOfertaComprada(Promocion[] promocionDiarias) {
		boolean valor = false;
		for (int i = 0; i < promocionDiarias.length; i++) {
			for (Ofertable atraccion : visitante.getItinerario()) {
				if (!(atraccion instanceof Promocion)) {
					promocionDiarias[i].tieneAtraccion(atraccion);
					//System.out.println(promocionDiarias[i].tieneAtraccion(atraccion));
				}
			}
		}
		return valor;
	}
	
	
	
*/	
	}

}
