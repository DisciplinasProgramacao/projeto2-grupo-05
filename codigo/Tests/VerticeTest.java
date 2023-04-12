/*
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.assertTrue;

class VerticeTest {
  public static Vertice v;

  @BeforeEach
  void setUp() throws Exception {
    v = new Vertice(1);
  }

  @Test
  @DisplayName("Adicionando uma aresta ao vertice")
  void addAresta() {
    assertTrue(v.addAresta(2));
    assertFalse(v.addAresta(1));
  }

  @Test
  @DisplayName("Adicionando uma aresta com peso ao vertice")
  void addArestaPeso() {
    assertTrue(v.addAresta(2, 1));
    assertFalse(v.addAresta(2, 1));
  }

  @Test
  @DisplayName("Verificando se a aresta existe")
  void existeAresta() {
    Aresta a = new Aresta(0);
    v.addAresta(0);

    assertEquals(a, v.existeAresta(0));
    assertEquals(null, v.existeAresta(2));
  }

  @Test
  @DisplayName("Removendo uma aresta")
  void removeAresta() {
    Aresta a = new Aresta(0);
    v.addAresta(0);

    assertEquals(a, v.removeAresta(0));
    assertEquals(null, v.removeAresta(2));
  }

  @Test
  @DisplayName("Calculando o grau do vertice")
  void grau() {
    v.addAresta(0);
    v.addAresta(1);    

    assertEquals(2, v.grau());
  }

  @Test
  @DisplayName("Verificando se o vertice foi ou nao visitado")
  void visitar() {
	    v.visitar();
	    assertTrue(v.visitado());
	    v.limparVisita();
	    assertFalse(v.visitado());
  }



}*/