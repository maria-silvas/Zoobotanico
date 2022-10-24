import java.util.ArrayList;

public class Mamiferos extends Animal {
    private String tempoGestacao;
    private ArrayList<Alimentacao> alimentacoes;

    public static ArrayList<Mamiferos> mamiferos = new ArrayList<Mamiferos>();

    public Mamiferos(
            int id,
            String nome,
            String especie,
            String tempoGestacao) {
        super(id, nome, especie);
        this.tempoGestacao = tempoGestacao;
        this.alimentacoes = new ArrayList<Alimentacao>();

        mamiferos.add(this);
        super.animais.add(this);
    }

    public String getTempoGestacao() {
        return this.tempoGestacao;
    }

    public void setTempoGestacao(String tempoGestacao) {
        this.tempoGestacao = tempoGestacao;
    }

    @Override
    public String toString() {
        return super.toString() + " | Tempo de gestação: " + this.tempoGestacao;
    }

}
