/**
* Classe básica para um Grafo simples não direcionado.
*/
public abstract class Grafo {
  public final String nome;
  private ABB<Vertice> vertices;
  
  
  public static Grafo grafoCompleto(int ordem) {
    GrafoCompleto gCompleto = new GrafoCompleto(ordem);
    return gCompleto;
  }
  
  /**
   * Construtor. Cria um grafo vazio com um nome escolhido pelo usuário. Em caso
   * de nome não informado
   * (string vazia), recebe o nome genérico "Grafo"
   */
  public Grafo(String idVerticeInicio) {
    if (idVerticeInicio.length() == 0)
      this.nome = "Grafo";
    else
      this.nome = idVerticeInicio;
    this.vertices = new ABB<>();
  }
  
  /**
   * Retorna o nome do grafo (string), caso seja necessário em outras
   * classes/sistemas
   * 
   * @return O nome do grafo (uma string)
   */
  public String nome() {
    return this.nome;
  }
  
  /**
   * Adiciona um vértice com o id especificado. Ignora a ação e retorna false se
   * já existir
   * um vértice com este id
   * 
   * @param id O identificador do vértice a ser criado/adicionado
   * @return TRUE se houve a inclusão do vértice, FALSE se já existia vértice com
   *         este id
   */
  
  public Vertice existeVertice(int idVertice) {
    return this.vertices.find(idVertice);
  }
  
  /**
   * Adiciona uma aresta entre dois vértices do grafo, caso os dois vértices
   * existam no grafo.
   * Caso a aresta já exista, ou algum dos vértices não existir, o comando é
   * ignorado e retorna FALSE.
   * 
   * @param origem  Vértice de origem
   * @param destino Vértice de destino
   * @param peso    Peso da aresta
   * @return TRUE se foi inserida, FALSE caso contrário
   */
  
  
  public Aresta existeAresta(int verticeA, int verticeB) {
    return this.vertices.find(verticeA).existeAresta(verticeB);
  }
  
  public boolean completo() {
    Vertice[] vet = new Vertice[vertices.size()];
    vet = vertices.allElements(vet);
    for(int i = 0; i < vet.length; i++) {
      if(vet[i].grau() != vet.length - 1) {
        return false;
      }
    }
    return true;
  }
  
  public Grafo subGrafo(Lista<Integer> vertices) {
    /*
    if(this.completo()) {
      GrafoCompleto g = new GrafoCompleto(this.ordem());
    } else {
      
    }
    */
    
    Vertice[] vetV = new Vertice[this.vertices.size()];
    vetV = this.vertices.allElements(vetV);
    
    for(int i = 0; i < vetV.length; i++) {
      if(!vertices.getData.contains(vetV[i].getId())) {
        this.vertices.remove(vetV[i].getId());
      } else {
        Aresta[] vetA = new Aresta[vetV[i].grau()];
        vetA = vetV[i].getArestas().allElements(vetA);
        
        for(int j = 0; j < vetA.length; j++) {
          if(!vertices.getData.contains(vetA[j].destino())) {
            this.vertices.find(vetV[i].getId()).removeAresta(vetA[j].destino());
          }
        }
        
      }
      
    }
    
    return this;
  }
  
  public int tamanho() {
    int tam = vertices.size();
    Vertice[] vet = new Vertice[vertices.size()];
    vet = vertices.allElements(vet);
    for(int i = 0; i < vet.length; i++) {
      tam += vet[i].grau();
    }
    return tam;
  }
  
  public int ordem() {
    return this.vertices.size();
  }
  
  public Grafo bfs(int idVerticeInicio) {
    return null;
  }
  
  public Grafo dfs(int idVerticeInicio) {
    return null;
  }

}
