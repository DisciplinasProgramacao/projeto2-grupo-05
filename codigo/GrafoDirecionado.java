
public class GrafoDirecionado extends GrafoMutavel {

  GrafoDirecionado(int idVerticeInicio, String nome) {
    super(idVerticeInicio, nome);
  }

  public boolean addAresta(int origem, int destino, int peso) {
    Vertice v = this.vertices.find(origem);
    return v.addAresta(destino, peso);
  }

  public Aresta removeAresta(int origem, int destino) {
    Vertice v = this.vertices.find(origem);
    return v.removeAresta(destino);
  }
}
