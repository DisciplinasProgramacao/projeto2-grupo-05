// NÃO EXISTE
/*
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class GrafoMutavelTest {
    public static GrafoMutavel g;

    @BeforeEach
    void setUp() throws Exception {
      g = new GrafoMutavel(0, "grafo mutavel");
    }

    @Test
    @DisplayName("Adicionando um vertice ao grafo")
    void addVertice() {
      assertTrue(g.addVertice(1));
      assertFalse(g.addVertice(1));
    }

   @Test
    @DisplayName("Removendo um vertice do grafo")
    void removeVertice() {
      Vertice v = new Vertice(0);
      g.addVertice(0);
      assertEquals(v, g.removeVertice(0));
      assertEquals(null, g.removeVertice(0));
    }

  @Test
    @DisplayName("Adicionando uma aresta a um vertice")
    void addAresta() {

      g.addVertice(0);
      
      assertTrue(g.addAresta(0, 1, 0));
      assertFalse(g.addAresta(0, 1, 0));
    }

  @Test
  @DisplayName("Removendo uma aresta do vertice")
  void removeAresta() {
    Aresta a = new Aresta(0, 1);
    
    g.addVertice(10);
    g.addAresta(1);

    assertEquals(a, g.removeAresta(10, 1));
    assertEquals(null, g.removeAresta(10, 1));
  }



}
*/