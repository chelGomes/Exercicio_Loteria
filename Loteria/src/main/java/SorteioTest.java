import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SorteioTest {

    private Sorteio sorteio;

    @BeforeEach
    public void setUp() {
        // Configuração inicial para cada teste
        sorteio = new Sorteio(6); // Exemplo de sorteio com 6 números
    }

    @Test
    public void testGetNumerosSorteados() {
        List<Integer> numerosSorteados = sorteio.getNumerosSorteados();
        assertNotNull(numerosSorteados);
        assertEquals(6, numerosSorteados.size());
    }

    @Test
    public void testSortearNumerosDiferentes() {
        List<Integer> numerosSorteados1 = sorteio.getNumerosSorteados();
        sorteio.sortearNumeros(6); // Tentar sortear novamente
        List<Integer> numerosSorteados2 = sorteio.getNumerosSorteados();
        assertNotEquals(numerosSorteados1, numerosSorteados2); // Os números sorteados devem ser diferentes
    }
}