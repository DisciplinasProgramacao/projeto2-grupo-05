import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class ArrestaTest {
  public static Arresta a;

  @BeforeEach
  void setUp() throws Exception {
    a = new Arresta(1, 3);
  }

    @Test
  @DisplayName("Verificando o peso da arresta")
  void peso() {    
    assertEquals(1, a.peso());
  }

  
  @Test
  @DisplayName("Verificando o destino da arresta")
  void destino() {    
    assertEquals(3, a.destino());
  }


  @Test
  @DisplayName("Verificando se a aresta foi ou nao visitada")
  void visitar() {    
    assertTrue(a.visitar());
    assertTrue(a.visitado());
    assertFalse(a.limparVisita());
  }

}