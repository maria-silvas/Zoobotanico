import java.util.ArrayList;

public class Aves extends Animal {
    private String plumagem;
    private ArrayList<Alimentacao> alimentacoes;

    public static ArrayList<Aves> aves = new ArrayList<Aves>();

    public Aves(
            int id,
            String nome,
            String especie,
            String plumagem) {
        super(id, nome, especie);
        this.plumagem = plumagem;
        this.alimentacoes = new ArrayList<Alimentacao>();

        aves.add(this);
        super.animais.add(this);
    }

    public String getPlumagem() {
        return this.plumagem;
    }

    public void setPlumagem(String plumagem) {
        this.plumagem = plumagem;
    }

    @Override
    public String toString() {
        return super.toString() + " | Plumagem: " + this.plumagem;
    }
}
