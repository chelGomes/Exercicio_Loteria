import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Sorteio implements SorteioLoteria {

    private static final int MAXIMO_NUMERO_SORTEADO = 59;

    private List<Integer> numeros;

    public Sorteio(int qtdeNumeros) {
        this.numeros = sortear(qtdeNumeros);
    }

    public void setNumeros(List<Integer> numeros) {
        this.numeros = numeros;
    }

    public List<Integer> getNumerosSorteados() {
        return this.numeros;
    }

    private List<Integer> sortear(int qtdeNumeros) {
        List<Integer> sorteados = new ArrayList<>();
        int numeroSorteado;
        while (sorteados.size() < qtdeNumeros) {
            numeroSorteado = new Random().nextInt(MAXIMO_NUMERO_SORTEADO) + 1;
            if (!sorteados.contains(numeroSorteado)) {
                sorteados.add(numeroSorteado);
            }
        }
        return sorteados;
    }

    public void sortearNumeros(int i) {
    }
}