import java.util.ArrayList;

public class Alimentacao {
    public int id;
    public String data;
    public String descricao;
    public Animal animal;

    public static ArrayList<Alimentacao> alimentacoes = new ArrayList<Alimentacao>();

    public Alimentacao(
            int id,
            String data,
            String descricao,
            Animal animal) {
        this.id = id;
        this.data = data;
        this.descricao = descricao;
        this.animal = animal;

        alimentacoes.add(this);
    }

    public static Alimentacao deleteAlimentacaoById(int id) {
        for (Alimentacao alimentacao : alimentacoes) {
            if (alimentacao.id == id) {
                Alimentacao.alimentacoes.remove(alimentacao);
                return alimentacao;
            }
        }

        return null;
    }

    @Override
    public String toString() {
        return "Id: " + id + " | Data: " + data + " | Descricao: " + descricao + " \n Animal: " + animal + " \n";
    }
}
