public abstract class GrafoMutavel extends Grafo{
	private int idVerticeInicio;

  
	public GrafoMutavel(int idVerticeInicio,String nome) {
		super(nome);
		this.idVerticeInicio=idVerticeInicio;
		// TODO Auto-generated constructor stub
	}
  
	public boolean addVertice(int id){
    return this.vertices.add(id, new Vertice(id));
  }
	
	public Vertice removeVertice(int id){    
    return this.vertices.remove(id);
  }
	
	public boolean addAresta(int origem, int destino, int peso){

    Vertice v = this.vertices.find(origem);
    return v.addAresta(destino, peso);
  }
	
	public Aresta removeAresta(int origem, int destino){
		
    Vertice v = this.vertices.find(origem);

    return v.removeAresta(destino);
  }
	
	public void carregar(String nomeArquivo){
    // TODO
    Scanner scGrafo; // Scanner para ler do arquivo
    
    File arqGrafo = new File(nomeArquivo);
    scGrafo = new Scanner(arqGrafo);
        
    Vertice v;
    int origem, destino, peso;
    int qtdArestas = scGrafo.nextInt();
    scGrafo.nextLine();
  
    int cont = 1;
    while(scGrafo.hasNext()){
      origem = scGrafo.nextInt();
      destino = scGrafo.nextInt();
      peso = scGrafo.nextInt();
      scGrafo.nextLine();
      
      v = new Vertice(origem);
      if(!v.addAresta(destino, peso)) {
        System.out.println("Aresta " + cont + " já existente.");
      }
       
      cont++;
    }
    
  }
  
	public void salvar(String nomeArquivo){
    // TODO
  }
	}

