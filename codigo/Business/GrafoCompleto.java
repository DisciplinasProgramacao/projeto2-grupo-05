public class GrafoCompleto extends Grafo {
	
	public GrafoCompleto(int ordem) {
    super("GrafoFoda");

    if (ordem <= 0) {
     
      System.out.println("A ordem não é valida");
    }

    for(int i = 0; i < ordem; i++){

      Vertice v = new Vertice(i+1);

      for(int j = 0; j < ordem; j++){
        if(j != i){
          v.addAresta(j+1);
        }
      }

      super.vertices.add(v.getId(), v);
    }

  }
}