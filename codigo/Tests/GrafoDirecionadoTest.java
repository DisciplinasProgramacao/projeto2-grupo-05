/*
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GrafoDirecionadoTest {
  public GrafoMutavel g;

    @BeforeEach
    void setUp() throws Exception {
      g = new GrafoDirecionado(0, "grafo direcionado");
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
      g.addVertice(0);
      assertSame(0, g.removeVertice(0).getId());
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
    
    
    g.addVertice(10);
    g.vertices.find(10).addAresta(0);

    assertSame(0, g.vertices.find(10).removeAresta(0).destino());
    assertEquals(null, g.vertices.find(10).removeAresta(0));
  }
}
*/