import java.util.ArrayList;

public class Limpeza {
    private int id;
    private String data;
    private String descricao;
    private int idJaula;
    private Jaula jaula;

    public static ArrayList<Limpeza> limpezas = new ArrayList<Limpeza>();

    public Limpeza(
            int id,
            String data,
            String descricao,
            Jaula jaula) {
        this.id = id;
        this.data = data;
        this.descricao = descricao;
        this.jaula = jaula;

        limpezas.add(this);
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData() {
        return this.data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getIdJaula() {
        return this.idJaula;
    }

    public void setIdJaula(int idJaula) {
        this.idJaula = idJaula;
    }

    @Override
    public String toString() {
        return "Id: " + this.id + " | Data: " + this.data + " | Descrição: " + this.descricao + " | Id Jaula: "
                + this.idJaula;
    }
}
