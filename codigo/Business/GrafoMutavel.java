import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public abstract class GrafoMutavel extends Grafo {
  private int idVerticeInicio;

  public GrafoMutavel(int idVerticeInicio, String nome) {
    super(nome);
    this.idVerticeInicio = idVerticeInicio;
    // TODO Auto-generated constructor stub
  }
 //método adiciona um vertice ao grafo ultilizando id, retorna se foi possível registrar vertice
  public boolean addVertice(int id) {
    return this.vertices.add(id, new Vertice(id));
  }
//método remove um vertice do grafo ultilizando id, retorna vertice removido
  public Vertice removeVertice(int id) {
    return this.vertices.remove(id);
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
//Metodo que carregar um arquivo de grafo dentro de um objeto a partir de seu nome
  public void carregar(String nomeArquivo) throws FileNotFoundException {
	  Scanner scGrafo; // Scanner para ler do arquivo
	  	
	    File arqGrafo = new File(nomeArquivo);
	    scGrafo = new Scanner(arqGrafo);
	    
	    Vertice v, d;
	    int origem, destino, peso = 0;
	    int qtdVertices = scGrafo.nextInt();
	    int qtdArestas = scGrafo.nextInt();
	    scGrafo.nextLine();

	    int cont = 1;
	    while(scGrafo.hasNext()){
	      origem = scGrafo.nextInt();
	      destino = scGrafo.nextInt();
	      peso = 0;
	      if(scGrafo.hasNextInt()){
	        peso = scGrafo.nextInt();
	      }
	      scGrafo.nextLine();

	      if (this.vertices.find(origem) == null) {
	    	  v = new Vertice(origem);
	      } else {
	    	  v = this.vertices.find(origem);
	      }

        if (this.vertices.find(destino) == null) {
	    	  d = new Vertice(destino);
          this.vertices.add(d.getId(),d);
	      }
        
	      if(peso != 0){
	        if(!v.addAresta(destino, peso)) {
	          System.out.println("Aresta " + cont + " já existente.");
	        }
	      } else {
	        if(!v.addAresta(destino)) {
	          System.out.println("Aresta " + cont + " já existente.");
	        }
	      }

	      this.vertices.add(v.getId(),v);

	      cont++;
	    }
	    
  }
//Metodo que salvar um arquivo de grafo com seu nome especifico
  public void salvar(String nomeArquivo) {

	    Vertice[] vet = new Vertice[this.vertices.size()];
	    vet = this.vertices.allElements(vet);
	    
	   
	    
	    for (int i = 0; i < vet.length; i++) {
	      Aresta[] vetA = new Aresta[vet[i].grau()];
	      vetA = vet[i].getArestas().allElements(vetA);
	      for (int j = 0; j < vetA.length; j++) {
	        System.out.println(vet[i].getId() + "--" + vetA[j].destino() + "---" + vetA[j].peso());
	      }
	    }
	    
	    
	    
	    
	    nomeArquivo = "grafo.txt"; // Nome do arquivo a ser criado
	    
	            try {
	                
	                File arquivo = new File(nomeArquivo); // Criação do objeto File com o nome do arquivo  
	                FileWriter fw = new FileWriter(arquivo); // Criação do objeto FileWriter para escrever no arquivo
	                BufferedWriter bw = new BufferedWriter(fw); // Criação do objeto BufferedWriter para escrever de forma mais eficiente
	    
	                
	                String vertQtd =String.valueOf(this.ordem());

	                bw.write("       ");
	                bw.write(vertQtd);
	                bw.newLine();
	                for (int i = 0; i < vet.length; i++) {
	                    Aresta[] vetA = new Aresta[vet[i].grau()];
	                    vetA = vet[i].getArestas().allElements(vetA);
	                    for (int j = 0; j < vetA.length; j++) {
	                    	
	                    	String id =String.valueOf(vet[i].getId());
	                    	String dest =String.valueOf(vetA[j].destino());
	                    	String pes =String.valueOf(vetA[j].peso());
	                    	
	                    	bw.write("       ");
	                    	bw.write(id);
	                    	bw.write("       ");
	                    	bw.write(dest); 
	                    	bw.write("        ");
	                    	bw.write(pes);
	                    	bw.newLine();
	                    }
	                  }
	               
	                bw.write("Olá, mundo!"); // Escrevendo no arquivo
	                bw.newLine(); // Adiciona uma nova linha
	                bw.write("Este é um exemplo de escrita de arquivo em Java.");
	                bw.close();// Fechando os objetos de escrita
	                fw.close();
	    
	                System.out.println("Arquivo criado com sucesso!");
	    
	            } catch (IOException e) {
	                System.err.println("Erro ao criar o arquivo: " + e.getMessage());
	                e.printStackTrace();
	            }
	    
  }
}
