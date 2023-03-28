import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class GrafoDirecionadoTest {
  public static GrafoDirecionado g;

  @BeforeEach
  void setUp() throws Exception {
    g = new GrafoDirecionado(0, "Grafo direcionado");
  }

  @Test
  @DisplayName("Adicionando uma aresta grafo direcionado")
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