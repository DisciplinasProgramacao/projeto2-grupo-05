
public class GrafoDirecionado extends GrafoMutavel {

  GrafoDirecionado(int idVerticeInicio, String nome) {
    super(idVerticeInicio, nome);
  }
 //método adiciona uma aresta ao grafo ultilizando origem destino e peso, retorna se foi possível registrar aresta
  public boolean addAresta(int origem, int destino, int peso) {
    Vertice v = this.vertices.find(origem);
    return v.addAresta(destino, peso);
  }
//método remove uma aresta do grafo ultilizando origem destino, retorna aresta removida
  public Aresta removeAresta(int origem, int destino) {
    Vertice v = this.vertices.find(origem);
    return v.removeAresta(destino);
  }
}
