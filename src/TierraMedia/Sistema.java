package TierraMedia;



public class Sistema {

	public static void main(String[] args) {


		SistemaNuevo sistema = new SistemaNuevo();
			
		Atraccion []paquete1= {new Atraccion("Tres", 30, 33, 10,"Aventura"), new Atraccion("Cinco", 12, 10, 10, "Ave5ntura")};
		Atraccion []paquete2= {new Atraccion("Uno", 30, 33, 10,"Aventura"),new Atraccion("dos", 30, 33, 10, "Aventura")};
		Atraccion []paquete3= {new Atraccion("Cuatro", 30, 33, 10,"Aventura"),new Atraccion("Cinco", 30, 33, 10, "Aventura")};
		
		sistema.CrearUsuarios("visitantes.txt");
		
		//sistema.nuevaPromoAbsoluta("promo uno",paquete2 ,"Aventura", 10);
		//sistema.nuevaPromoAxB("promo dos",paquete1 ,"Aventura");
		//sistema.nuevaPromoPorcentual("Promo tres",paquete3 ,"Aventura", 10);
		sistema.nuevaPromocion("promociones.txt");
		
		sistema.nuevaAtraccion("atracciones.txt");
		System.out.println("todas las promociones"+sistema.getPromociones());
		//System.out.println("todas las atracciones"+sistema.getAtracciones());
		
		
		//sistema.getVisitantes().get(0).comprarPromocion(sistema.getPromociones().get(0));
	
	//	sistema.getVisitantes().get(0).comprarAtraccion(sistema.getAtracciones().get(0));
	//	sistema.getVisitantes().get(0).comprarAtraccion(sistema.getAtracciones().get(1));
    // 	sistema.getVisitantes().get(0).comprarAtraccion(sistema.getAtracciones().get(2));
		//sistema.getVisitantes().get(0).comprarPromocion(sistema.getPromociones().get(1));
	//	sistema.getVisitantes().get(0).comprarPromocion(sistema.getPromociones().get(0));
	//	sistema.getVisitantes().get(0).comprarPromocion(sistema.getPromociones().get(2));
	
		
		sistema.OfertasPromociones(sistema.getVisitantes().get(0));
		sistema.ofertasAtracciones(sistema.getVisitantes().get(0));
		
		System.out.println("visitante:"+sistema.getVisitantes().get(0));
		System.out.println("promociones compradas: "+sistema.getVisitantes().get(0).getPromocionComprada());
		System.out.println("Atraccion compradas: "+sistema.getVisitantes().get(0).getAtraccionComprada());
		System.out.println("////////////////////////////////////////////");
		sistema.ordenarOfertas();
		System.out.println("todas las promociones"+sistema.getPromociones());
		System.out.println("todas las atracciones"+sistema.getAtracciones());
		System.out.println("////////////////////////////////////////////");
		System.out.println("ofertas prioritarias"+sistema.getOfertasPrioritaras());
		System.out.println("ofertassecundarias"+sistema.getOfertasSecundarios());
		
//		System.out.println(sistema.getVisitantes().get(0).atraccionYaComprada(sistema.getAtracciones().get(0)));
//		System.out.println(sistema.getVisitantes().get(0).atraccionYaComprada(sistema.getAtracciones().get(1)));
//		System.out.println(sistema.getVisitantes().get(0).atraccionYaComprada(sistema.getAtracciones().get(2)));
//		System.out.println(sistema.getVisitantes().get(0).atraccionYaComprada(sistema.getAtracciones().get(3)));
//		System.out.println(sistema.getVisitantes().get(0).atraccionYaComprada(sistema.getAtracciones().get(4)));
//		
		
		
		
		
		//System.out.println(sistema.getVisitantes().get(0));
		//System.out.println(sistema.getAtracciones());
		//System.out.println(sistema.getPromociones());
	  //  sistema.setOfertasPrioritaras(sistema.getVisitantes().get(0));
	    
	   // System.out.println(sistema.getOfertasPrioritaras());
	  

		
	
		
	
	//	System.out.println(u1.atraccionYaComprada(at5));
		
		
	
		
	/*	
		System.out.println("///////////////////////////");
		System.out.println("atraccion compradas "+u1.getAtraccionComprada());
		System.out.println("promociones compradas "+u1.getPromocionComprada());
		System.out.println("///////////////////////////");
	
		for(Ofertable a :sug.getOfertasPrioritaras()) {
			System.out.println(a);
		}
		
		System.out.println("///////////////////////////////");
		
		for(Ofertable a :sug.getOfertasSecundarios()) {
			System.out.println(a);
		}
		
	/*	
			System.out.println(u1);

		//u1.comprarSugerencia(at5);
		//u1.comprarSugerencia(at4);
			
		//System.out.println(sug.atraccionEstaEnOfertaComprada(paquete2));
/*	
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
