
/** Classe Vertice para um grafo */
public class Vertice {

  private ABB<Aresta> arestas;
  private final int id;
  private boolean visitado;
  /**
   * Construtor para criação de vértice identificado
   * 
   * @param id Número/id do vértice a ser criado (atributo final).
   */
  public Vertice(int id) {
    this.id = id;
    this.arestas = new ABB<Aresta>();
    this.visitado = false;
  }

  public ABB<Aresta> getArestas(){
    return this.arestas;
  }

  /**
   * Retorna o id do vértice, caso seja necessário para verificações próprias
   * 
   * @return Identificador do vértice (int)
   */
  public int getId() {
    return this.id;
  }

  public boolean addAresta(int destino) {
    return this.arestas.add(destino, new Aresta(destino));
  }

  /**
   * Adiciona uma aresta ponderada neste vértice para um destino
   * 
   * @param peso Peso da aresta
   * @param dest Vértice de destino
   * @return TRUE se foi inserida, FALSE caso já existisse e não foi inserida.
   */
  public boolean addAresta(int destino, int peso) {
    return this.arestas.add(destino, new Aresta(detino,peso));
  }

  public Aresta existeAresta(int destino) {
    return arestas.find(destino);
  }

  /**
   * Remove e retorna a aresta para o destino indicado. Retorna null caso não
   * exista a aresta.
   * 
   * @param destino Destino da aresta a ser removida.
   * @return A aresta removida, ou null se não existir.
   */
  public Aresta removeAresta(int destino) {
    return this.arestas.remove(destino);
  }

  public int grau() {
    return this.arestas.size();
  }

  /**
   * Marca o vértice como visitado
   */
  public void visitar() {
    this.visitado = true;
  }

  /**
   * Marca o vértice como não visitado
   */
  public void limparVisita() {
    this.visitado = false;
  }

  /**
   * Indica se o vértice foi visitado (TRUE) ou não (FALSE)
   * 
   * @return TRUE/FALSE conforme o vértice tenha sido ou não visitado.
   */
  public boolean visitado() {
    return this.visitado;
  }

  public Lista<Integer> vizinhos(){
    Lista vizinhos=new Lista();
    
    for(int i=0;i<this.arestas.size();i++){
      vizinhos.add(this.arestas.find(i).destino());
    }
    return vizinhos;
  }



}
