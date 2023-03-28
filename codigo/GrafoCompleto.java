public class GrafoCompleto extends Grafo {

  public GrafoCompleto(int ordem) {

    if (ordem <= 0) {
      System.out.println("A ordem não é valida");
    }

    // TODO: Criar a arvore
    ABB arvoreCompleta = new ABB();

    for (int i = 0; i < ordem; i++) {

      Vertice v = new Vertice(i);

      for (int j = 0; j < ordem; j++) {

        if (j == i) { // Condição anti loop
          break;
        }
        
        int destino = j;
        int peso = 1;
        
        if(!v.addAresta(destino, peso)) {
  		    System.out.println("Aresta " + v.getId() + " -> " + destino + " já existente.");
        }

      }

      // TODO: adicionar o vertice a arvore
      arvoreCompleta.add(v.getId(), v);
    }

  }
  
}
