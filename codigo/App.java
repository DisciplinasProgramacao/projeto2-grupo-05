
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {

      
  public static void main(String[] args) throws Exception {

    Scanner input = new Scanner(System.in); // Scanner padrão
  
    System.out.print("Qual a ordem do grafo?(n de vértices):");

    int qtdVertices = input.nextInt();

    GrafoCompleto gCompleto = new GrafoCompleto(qtdVertices,"GrafoFoda");
    gCompleto.create();

    System.out.print("1. Grafo completo \n2. Sub grafo \n3. Grafo direcionado \n4. Grafo não direcionado \nDigite a opção desejada: ");
    int qtdVertices = input.nextInt();
    switch(qtdVertices) {
      case 1: 
          System.out.print("");
        break;
      case 2: 

        break;
      case 3: 

        break;
      case 4: 

        break;
    }
  }

  public void addGrafo() {
	Scanner input; 
    Scanner scGrafo; // Scanner para ler do arquivo
    
    while(true) { // Sai do loop quando o try da certo
      System.out.print("Nome do arquivo(Ex.: grafo-5.txt): ");
      File arqGrafo = new File(scGrafo.nextLine());
      try { // Caso o arquivo seja encontrado, ele cria o scanner para ler
        scGrafo = new Scanner(arqGrafo); // Setta o arquivo como entrada para o scanner do grafo
        break;
      } catch (FileNotFoundException e) {
        System.out.println("Arquivo não encontrado.\n");
      }
    }

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
  
}
