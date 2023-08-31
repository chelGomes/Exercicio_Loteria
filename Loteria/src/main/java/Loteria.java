import java.util.List;

public class Loteria {

    public static final int ACERTOS_SENA = 6;
    public static final int ACERTOS_QUINA = 5;
    public static final int ACERTOS_QUADRA = 4;
    public static final float PREMIO_SENA = 1.0f;
    public static final float PREMIO_QUINA = 0.2f;
    public static final float PREMIO_QUADRA = 0.05f;

    public double calcularPremio(Aposta aposta, SorteioLoteria sorteio, double premioTotal) {
        if (aposta == null) {
            throw new IllegalArgumentException("Aposta inválida");
        }
        if (sorteio == null) {
            throw new IllegalArgumentException("Sorteio inválido");
        }

        int acertos = contarAcertos(aposta.getNumerosApostados(), sorteio.getNumerosSorteados());

        if (acertos == ACERTOS_SENA) {
            return premioTotal * PREMIO_SENA;
        } else if (acertos == ACERTOS_QUINA) {
            return premioTotal * PREMIO_QUINA;
        } else if (acertos == ACERTOS_QUADRA) {
            return premioTotal * PREMIO_QUADRA;
        } else {
            return 0.0;
        }
    }

    private int contarAcertos(List<Integer> numerosApostados, List<Integer> numerosSorteados) {
        int totalAcertos = 0;
        for (Integer numeroApostado : numerosApostados) {
            if (numerosSorteados.contains(numeroApostado)) {
                totalAcertos++;
            }
        }
        return totalAcertos;
    }

}




