package trab2;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Classe básica para um Grafo simples não direcionado.
 */
public abstract class Grafo {
  public final String nome;
  protected ABB<Vertice> vertices;

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
//verifica se existe aresta no grafo especifico
  public Aresta existeAresta(int verticeA, int verticeB) {
    return this.vertices.find(verticeA).existeAresta(verticeB);
  }
//Verifica se um grafo chamado é completo, retorna true ou false
  public boolean completo() {
    Vertice[] vet = new Vertice[vertices.size()];
    vet = vertices.allElements(vet);
    for (int i = 0; i < vet.length; i++) {
      if (vet[i].grau() != vet.length - 1) {
        return false;
      }
    }
    return true;
  }
 //a partir da lista de vértices passada e do grafo que chamou a função se monta um subGrafo 
  public Grafo subGrafo(Lista<Integer> vertices, char tipo) {
    Grafo g;
    switch(tipo) {
      case 'c':
        g = new GrafoCompleto(this.ordem());
        break;
      case 'n':
        g= new GrafoNaoDirecionado(1, "Grafo do bão");
        break;
      default:
        g = new GrafoDirecionado(1, "Grafo mais do bão");
        break;
	  }

    
    Vertice[] vetV = new Vertice[this.vertices.size()];
    vetV = this.vertices.allElements(vetV);

    for (int i = 0; i < vetV.length; i++) {
      if (vertices.getData().contains(vetV[i].getId())) {
        Aresta[] vetA = new Aresta[vetV[i].grau()];
        vetA = vetV[i].getArestas().allElements(vetA);

        g.vertices.add(vetV[i].getId(), vetV[i]);

        for (int j = 0; j < vetA.length; j++) {
          if (!vertices.getData().contains(vetA[j].destino())) {
            g.vertices.find(vetV[i].getId()).removeAresta(vetA[j].destino());
          }
        }

      }

    }

    return g;
  }
//retorna a soma dos graus de todos os vértices 
  public int tamanho() {
    int tam = vertices.size();
    Vertice[] vet = new Vertice[vertices.size()];
    vet = vertices.allElements(vet);
    for (int i = 0; i < vet.length; i++) {
      tam += vet[i].grau();
    }
    return tam;
  }

  public int ordem() {
    return this.vertices.size();
  }

//realiza a busca de profundidade no grado direcioado e não direcioado
  public void dfs(int idVerticeInicio) {
    int[] visited = new int[vertices.size()];
    dfsUtil(idVerticeInicio, visited, 0);
    for(int i = 0; i < visited.length; i++){
      if(visited[i] == 0) {
        Vertice[] vet = new Vertice[this.vertices.size()];
	      vet = this.vertices.allElements(vet);
        int vetI=i;
        for(int j = 0; j < this.vertices.size(); j++){
          if(!vet[j].visitado()){
            System.out.println("Proxima raiz:");
            dfsUtil(vet[j].getId(), visited, vetI);
            vetI++;
          }
        }
      }
      System.out.print("["+visited[i]+"] --->");
    }
    System.out.println("");
  }

  // helper function for dfs traversal
  private void dfsUtil(int idVerticeInicio, int[] visited, int cont) {
    visited[cont] = idVerticeInicio;
    System.out.println("Armazenou o " + visited[cont] + " no vetor");
    Vertice atual=vertices.find(idVerticeInicio);
    atual.visitar();

    Aresta[] arestasV=new Aresta[atual.grau()];
    arestasV = atual.getArestas().allElements(arestasV);
    
    for (Aresta a : arestasV) {
      if(!vertices.find(a.destino()).visitado())
        dfsUtil(a.destino(), visited, ++cont);
    }  
  }
//realiza a busca de largura no grado direcioado e não direcioado
  public void bfs(int idVerticeInicio) {
    Vertice first = vertices.find(idVerticeInicio);
    int[] visited = new int[vertices.size()];
    int visitedQtd = 0;
    Queue<Vertice> queue = new LinkedList<Vertice>();
    queue.add(first);
    first.visitar();
    visited[visitedQtd] = first.getId();
    visitedQtd++;

    while (!queue.isEmpty()) {
      Vertice atual = queue.poll();
      System.out.print(atual.getId() + " ");

      Aresta[] filhos=new Aresta[atual.grau()];
      filhos = atual.getArestas().allElements(filhos);
      for(Aresta a : filhos){
        if(!vertices.find(a.destino()).visitado()){
          this.vertices.find(a.destino()).visitar();
          visited[visitedQtd] = a.destino();
          visitedQtd++;
          queue.add(vertices.find(a.destino()));
        }
      }
    }
    for(int i = 0; i < visited.length; i++){
      System.out.print("["+visited[i]+"] --->");
    }
    System.out.println("");
  }
  
  /*
	  public Grafo bfs(int idVerticeInicio) { // busca em largura
		  int contTrue=1;
		  Vertice vet[] = new Vertice[this.vertices.size()];
		  vet = this.vertices.allElements(vet);
		  Grafo g = new GrafoNaoDirecionado(1, "grafo do bts");
		  boolean allTrue = false;
		  int i=1;
		  Aresta[] vetA = new  Aresta[vet[i].grau()];
		  
		  while(allTrue==false) {
			  contTrue=1;
			  vetA = new  Aresta[vet[i].grau()];
			  vetA = vet[i].getArestas().allElements(vetA);
			  g.vertices.add(vet[i].getId(), vet[i]);
		  //System.out.println("Origem="+vet[0].getId()); //0
		  System.out.println("Origem="+vet[i].getId());
		  vet[i].visitar();
		  for(int j=0; j!=vetA.length; j++) {
			  System.out.println("Destino="+vetA[j].destino());
		  }
		  
		  i++;
		  
		  for(int x=1; x!=vet.length; x++) {
			  
			  if(vet[x].visitado()==true) {
				  contTrue++;
				  System.out.println(contTrue);
			  }
		  }
		  if(contTrue==vet.length) {
			  allTrue=true;
		  }
		  
		  }
		  for(int y=1; y!=this.vertices.size(); y++) {
			  System.out.println(vet[y].visitado());
		  }	  
		  return g;
	  }

*/

// }
