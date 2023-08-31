import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ApostaTest {

    private Aposta aposta;

    @BeforeEach
    public void setUp() {
        // Configuração inicial para cada teste
        List<Integer> numerosApostados = Arrays.asList(5, 10, 15, 20, 25, 30); // Exemplo de números apostados
        aposta = new Aposta(numerosApostados);
    }

    @Test
    public void testGetNumerosApostados() {
        List<Integer> numerosApostados = aposta.getNumerosApostados();
        assertNotNull(numerosApostados);
        assertEquals(6, numerosApostados.size());
        assertTrue(numerosApostados.contains(5));
        assertTrue(numerosApostados.contains(15));
        assertFalse(numerosApostados.contains(40));
    }

    @Test
    public void testApostaAbaixoDaMinima() {
        List<Integer> numerosApostados = Arrays.asList(5, 10, 15, 20, 25); // Aposta com menos números que o mínimo
        assertThrows(IllegalArgumentException.class, () -> new Aposta(numerosApostados));
    }

    @Test
    public void testApostaAcimaDaMaxima() {
        List<Integer> numerosApostados = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16); // Aposta com mais números que o máximo
        assertThrows(IllegalArgumentException.class, () -> new Aposta(numerosApostados));
    }

    @Test
    public void testApostaComNumerosForaDoLimite() {
        List<Integer> numerosApostados = Arrays.asList(5, 10, 70, 20, 25, 30); // Aposta com número fora do limite
        assertThrows(IllegalArgumentException.class, () -> new Aposta(numerosApostados));
    }

    @Test
    public void testApostaComNumerosDuplicados() {
        List<Integer> numerosApostados = Arrays.asList(5, 10, 15, 10, 25, 30); // Aposta com números duplicados
        assertThrows(IllegalArgumentException.class, () -> new Aposta(numerosApostados));
    }
}