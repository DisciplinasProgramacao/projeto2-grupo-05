package trab2;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Aplicacao {
  //Switch com as opções do programa ultizando os metedos do UML
  public static void main(String[] args) throws Exception {
  
    Scanner input = new Scanner(System.in); // Scanner padrão
    System.out.print(
        "1. Cria sub grafo \n2. Cria grafo completo \n3. Cria grafo direcionado \n4. Cria grafo não direcionado\n5. Pesquisa Profundidade \n6. Pesquisa Largura  \nDigite a opção desejada: ");
    int opc = (Integer)input.nextInt();
    input.nextLine();
    
    switch (opc) {
      case 2:
    	  completo();
        break;
      case 1:
    	  subgrafo();
        break;
      case 3:
    	  criaDirecionado();
        break;
      case 4:
    	  criaNaoDirecionado();
        break;
      case 5:
    	  //pesquisaProfundidade();
    	  break;
      case 6:
    	  pesquisaLargura();
    	  break;
      default:
    	  System.out.println("Numero invalido");
    	  break;
    }

    
  }


//Cria um grafo não direcionado a partir de novos vértices e arestas passadas pelo usuário,podendo salvar um grafo no final
private static void criaNaoDirecionado() {
	// TODO Auto-generated method stub
	Scanner input = new Scanner(System.in);
	System.out.println("Qual o nome do grafo?(grafo.txt)");
	String nome=input.nextLine();
	
	System.out.println("Qual o numero do primeiro vertice?");
	int prim= input.nextInt();	
	GrafoNaoDirecionado nd= new GrafoNaoDirecionado(prim,nome);
	
	 System.out.println("Digite os vertices a serem adicionados ou 0 para terminar:");
		 //String fim="";
		 int fim=9;
		 int i=0;
		 int j;
		 //fim=input.nextLine();
		 System.out.print("[1]:");
		 fim=input.nextInt();
		 //while(!fim.equals("FIM")){
		 while(fim!=0) {
			 i++;
			 j=i+1;
 			 System.out.print("["+j+"]:");
			 //int vertice=Integer.parseInt(fim);
			 //d.addVertice(vertice);
 			 nd.addVertice(fim);
			 //fim=input.nextLine();
 			fim=input.nextInt();
		 }
	System.out.println("Para adicionar aresta digite Origem, Destino e Peso da aresta ou 0 para terminar");

	int origem=9;
	int destino=9;
	int peso=9;
	int i2=0;
	int j2;
	System.out.print("[1] Origem:");

	origem=input.nextInt();
	
	System.out.print("[1] Destino:");
	
	destino=input.nextInt();
	
	System.out.print("[1] Peso:");
	peso=input.nextInt();

	while((origem!=0) || (destino!=0) || (peso!=0)){
		 i2++;
		 j2=i2+1;
		 System.out.print("["+j2+"] Origem:");
		 nd.addAresta(origem,destino,peso);
		 origem=input.nextInt();
		 if(origem==0) {
			 break;
		 }
		 System.out.print("["+j2+"] Destino:");
		 destino=input.nextInt();
		 System.out.print("["+j2+"] Peso:");
		 peso=input.nextInt();
	
	 }
	 
	  
 	Vertice[] vet = new Vertice[nd.vertices.size()];
 	vet = nd.vertices.allElements(vet);

 	for(int k=0;k<vet.length;k++){
 		Aresta[] vetA = new  Aresta[vet[k].grau()];
 	    vetA = vet[k].getArestas().allElements(vetA);
 	    for(int z=0;z<vetA.length;z++){
 	       System.out.println(vet[k].getId()+"--"+vetA[z].destino()+"---"+vetA[z].peso());
 	      }
 	   }
 	
 	System.out.println("Deseja salvar o grafo? (S/N)");
	String resp = input.nextLine();
	input.nextLine();
	if(resp=="S") {
		nd.salvar(nome);
	}
}
//Cria um grafo  direcionado a partir de novos vértices e arestas passadas pelo usuário, podendo salvar um grafo no final
  private static void criaDirecionado() {
	// TODO Auto-generated method stub
	Scanner input = new Scanner(System.in);
	System.out.println("Qual o nome do grafo?(grafo.txt)");
	String nome=input.nextLine();
	
	System.out.println("Qual o numero do primeiro vertice?");
	int prim= input.nextInt();	
	GrafoDirecionado d= new GrafoDirecionado(prim,nome);
	
	 System.out.println("Digite os vertices a serem adicionados ou 0 para terminar:");
		 //String fim="";
		 int fim=9;
		 int i=0;
		 int j;
		 //fim=input.nextLine();
		 System.out.print("[1]:");
		 fim=input.nextInt();
		 //while(!fim.equals("FIM")){
		 while(fim!=0) {
			 i++;
			 j=i+1;
 			 System.out.print("["+j+"]:");
			 //int vertice=Integer.parseInt(fim);
			 //d.addVertice(vertice);
 			 d.addVertice(fim);
			 //fim=input.nextLine();
 			fim=input.nextInt();
		 }
	System.out.println("Para adicionar aresta digite Origem, Destino e Peso da aresta ou 0 para terminar");

	int origem=9;
	int destino=9;
	int peso=9;
	int i2=0;
	int j2;
	System.out.print("[1] Origem:");

	origem=input.nextInt();
	
	System.out.print("[1] Destino:");
	
	destino=input.nextInt();
	
	System.out.print("[1] Peso:");
	peso=input.nextInt();

	while((origem!=0) || (destino!=0) || (peso!=0)){
		 i2++;
		 j2=i2+1;
		 System.out.print("["+j2+"] Origem:");
		 d.addAresta(origem,destino,peso);
		 origem=input.nextInt();
		 if(origem==0) {
			 break;
		 }
		 System.out.print("["+j2+"] Destino:");
		 destino=input.nextInt();
		 System.out.print("["+j2+"] Peso:");
		 peso=input.nextInt();
	
	 }
	 
	  
 	Vertice[] vet = new Vertice[d.vertices.size()];
 	vet = d.vertices.allElements(vet);

 	for(int k=0;k<vet.length;k++){
 		Aresta[] vetA = new  Aresta[vet[k].grau()];
 	    vetA = vet[k].getArestas().allElements(vetA);
 	    for(int z=0;z<vetA.length;z++){
 	       System.out.println(vet[k].getId()+"--"+vetA[z].destino()+"---"+vetA[z].peso());
 	      }
 	   }
 	
 	System.out.println("Deseja salvar o grafo? (S/N)");
	String resp = input.nextLine();
	input.nextLine();
	if(resp=="S") {
		d.salvar(nome);
	}
}
//gera um grafo completo a partir da ordem passada pelo usuario
public static void completo() {
	    Scanner input = new Scanner(System.in);
	    System.out.print("Qual a ordem do grafo? (nº de vértices):");
	    

	    int qtdVertices = input.nextInt();
	  
	    if (qtdVertices <= 0) {
	        System.out.println("A ordem não é valida");
	      }else {
	    	 System.out.println("(origem/destino/peso)");
	    	GrafoCompleto gCompleto = new GrafoCompleto(qtdVertices);
	    	  
	    	Vertice[] vet = new Vertice[gCompleto.vertices.size()];
	    	vet = gCompleto.vertices.allElements(vet);

	    	   for(int i=0;i<vet.length;i++){
	    	      Aresta[] vetA = new  Aresta[vet[i].grau()];
	    	      vetA = vet[i].getArestas().allElements(vetA);
	    	      for(int j=0;j<vetA.length;j++){
	    	        System.out.println(vet[i].getId()+"--"+vetA[j].destino()+"---"+vetA[j].peso());
	    	      }
	    	   }

	    	     
	      }
  }
  //Cria um grafo não direcionado a partir de novos vértices e arestas passadas pelo usuario
  public static void subgrafo() throws FileNotFoundException {
	Scanner input = new Scanner(System.in); 

		 System.out.print("Nome do arquivo(grafo.txt): ");
		 String arqNome = input.nextLine();
		 
		 System.out.print("É direcionado?(S/N): ");
		 char direcionado = input.nextLine().charAt(0);
       
		 GrafoMutavel retorno;
		
		 if(direcionado == 'S') {
			 GrafoDirecionado g = new GrafoDirecionado(1,"Nome do grafo");
			 g.carregar(arqNome);
			 Lista<Integer> subgrafo=new Lista<Integer>();
	 		 System.out.println("Digite os vertices escolhidos ou FIM para terminar:");
	 		 String fim="";
	 		 int i=0;
	 		 int j;
	 		 System.out.print("[1]:");
	 		 fim=input.nextLine();
	 		 while(!fim.equals("FIM")){
	 			 i++;
	 			 j=i+1;
	 			 System.out.print("["+j+"]:");
	 			 int vertice=Integer.parseInt(fim);
	 			 subgrafo.add(vertice);
	 			 fim=input.nextLine();
	 			 
	 		 }
	 		 retorno=(GrafoDirecionado) g.subGrafo(subgrafo,'d');
		 } else {
			 GrafoNaoDirecionado g = new GrafoNaoDirecionado(1,"Nome do grafo");
			 g.carregar(arqNome);
			 Lista<Integer> subgrafo=new Lista<Integer>();
	 		 System.out.println("Digite os vertices escolhidos ou FIM para terminar:");
	 		 String fim="";
	 		 int i=0;
	 		 int j;
	 		 System.out.print("[1]:");
	 		 fim=input.nextLine();
	 		 while(!fim.equals("FIM")){
	 			 i++;
	 			 j=i+1;
	 			 System.out.print("["+j+"]:");
	 			 int vertice=Integer.parseInt(fim);
	 			 subgrafo.add(vertice);
	 			 fim=input.nextLine();
	 		 }
	 		 retorno=(GrafoNaoDirecionado) g.subGrafo(subgrafo,'n');
		 }
		 
		System.out.println("(origem/destino/peso)");
       	Vertice[] vet = new Vertice[retorno.vertices.size()];
	    vet = retorno.vertices.allElements(vet);
	    int cont=0;
	    for(int i=0;i<vet.length;i++){
	    	Aresta[] vetA = new  Aresta[vet[i].grau()];
	    	vetA = vet[i].getArestas().allElements(vetA);
	    	if(vet[i].grau()==0) {
				cont++;
	    	}
	    	if(cont==vet.length) {
	    		System.out.println("Não existem arestas entre esses vertices");
	    	}
	    	for(int j=0;j<vetA.length;j++){
	    	    System.out.println(vet[i].getId()+"--"+vetA[j].destino()+"---"+vetA[j].peso());}}
	    
	    	System.out.println("Deseja salvar o grafo? (S/N)");
	    	char resp = input.nextLine().charAt(0);
	    	
	    	
	    	if(resp=='S') {
	    		System.out.print("Qual o nome do arquivo?");
	    		String nome=input.nextLine();
	    		retorno.salvar(nome);
	    		System.out.println("Arquivo"+nome+"criado");
	    	}
		
 	  
  }
  
  
  //Metodo usa scanner para ler o arquivo e salvar
  public void addGrafo() {
	Scanner input = new Scanner(System.in);
    Scanner scGrafo; // Scanner para ler do arquivo

    while (true) { // Sai do loop quando o try da certo
      System.out.print("Nome do arquivo(Ex.: grafo-5.txt): ");
      File arqGrafo = new File(input.nextLine());
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
    while (scGrafo.hasNext()) {
      origem = scGrafo.nextInt();
      destino = scGrafo.nextInt();
      peso = scGrafo.nextInt();
      scGrafo.nextLine();

      v = new Vertice(origem);
      if (!v.addAresta(destino, peso)) {
        System.out.println("Aresta " + cont + " já existente.");
      }

      cont++;
    }

  }
// realiza a pesquisa de profundidade com grafos direcionados ou não direcionados
private static void pesquisaProfundidade() throws FileNotFoundException {
	Scanner input = new Scanner(System.in);
	
	System.out.println("Grafo é direcionado?(S/N)");
	char op=input.nextLine().charAt(0);
	
	GrafoMutavel g;
	
	if(op=='S') {
	System.out.println("Qual o nome do grafo?(grafo.txt)");
	String nome=input.nextLine();
	g=new GrafoDirecionado(1,nome);
	g.carregar(nome);
	
	System.out.println("Qual o id do vertice de inicio?");
	int vert=input.nextInt();
	
	g.dfs(vert);}
	else{
	System.out.println("Qual o nome do grafo?(grafo.txt)");
	String nome=input.nextLine();
	g=new GrafoNaoDirecionado(1,nome);
	g.carregar(nome);
	
	System.out.println("Qual o id do vertice de inicio?");
	int vert=input.nextInt();
	
	g.dfs(vert);}
	
	
	
}
// realiza a pesquisa de largura com grafos direcionados ou não direcionados
private static void pesquisaLargura() throws FileNotFoundException {
	// TODO Auto-generated method stub
	Scanner input = new Scanner(System.in);
	
	System.out.println("Grafo é direcionado?(S/N)");
	char op=input.nextLine().charAt(0);
	
	GrafoMutavel g;
	
	if(op=='S') {
	System.out.println("Qual o nome do grafo?(grafo.txt)");
	String nome=input.nextLine();
	g=new GrafoDirecionado(1,nome);
	g.carregar(nome);
	
	System.out.println("Qual o id do vertice de inicio?");
	int vert=input.nextInt();
	
	g.bfs(vert);}
	else{
	System.out.println("Qual o nome do grafo?(grafo.txt)");
	String nome=input.nextLine();
	g=new GrafoNaoDirecionado(1,nome);
	g.carregar(nome);
	
	System.out.println("Qual o id do vertice de inicio?");
	int vert=input.nextInt();
	
	g.bfs(vert);}
	
	
}


}



