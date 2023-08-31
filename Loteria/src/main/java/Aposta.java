import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class Aposta {
    private static final int MIN_APOSTA_NUM = 1;
    private static final int MAX_APOSTA_NUM = 60;
    private static final int MIN_APOSTA_COUNT = 6;
    private static final int MAX_APOSTA_COUNT = 15;

    private final List<Integer> numerosApostados;

    public Aposta(List<Integer> numerosApostados) {
        this.numerosApostados = Collections.unmodifiableList(numerosApostados);
        validarAposta(numerosApostados);
    }

    public List<Integer> getNumerosApostados() {
        return numerosApostados;
    }

    private void validarAposta(List<Integer> numerosApostados) {
        if (numerosApostados.size() < MIN_APOSTA_COUNT) {
            throw new IllegalArgumentException("Aposta abaixo da mínima");
        }
        if (numerosApostados.size() > MAX_APOSTA_COUNT) {
            throw new IllegalArgumentException("Aposta acima da máxima");
        }

        List<Integer> numerosValidos = new ArrayList<>();
        for (Integer numeroApostado : numerosApostados) {
            if (numeroApostado < MIN_APOSTA_NUM || numeroApostado > MAX_APOSTA_NUM) {
                throw new IllegalArgumentException("Número fora do limite da aposta");
            }
            if (numerosValidos.contains(numeroApostado)) {
                throw new IllegalArgumentException("Número duplicado na aposta");
            }
            numerosValidos.add(numeroApostado);
        }
    }
}
