
public class GrafoNaoDirecionado extends GrafoMutavel {

  public GrafoNaoDirecionado(int idVerticeInicio, String nome) {
    super(idVerticeInicio, nome);
    // TODO Auto-generated constructor stub
  }

  public boolean addAresta(int origem, int destino, int peso) {
    Vertice v = this.vertices.find(origem);
    return v.addAresta(destino, peso);
  }

  public Aresta removeAresta(int origem, int destino) {
    Vertice v = this.vertices.find(origem);
    return v.removeAresta(destino);
  }

  public boolean addVertice(int id) {
    return this.vertices.add(id, new Vertice(id));
  }

  public Vertice removeVertice(int id) {
    return this.vertices.remove(id);
  }

  public void carregar(String nomeArquivo) {
  }

  public void salvar(String nomeArquivo) {
  }
}
