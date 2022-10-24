import java.util.ArrayList;

public class Jaula {
    private int id;
    private String nome;
    private String tipo;
    private ArrayList<Animal> animais;

    public static ArrayList<Jaula> jaulas = new ArrayList<Jaula>();

    public Jaula(
            int id,
            String nome,
            String tipo) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.animais = new ArrayList<Animal>();

        jaulas.add(this);
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public ArrayList<Animal> getAnimais() {
        return this.animais;
    }

    @Override
    public String toString() {
        return "Id: " + this.id + " | Nome: " + this.nome + " | Tipo: " + this.tipo + " | Animais: " + this.animais;
    }

    public static Jaula getJaulaById(int id) {
        for (Jaula jaula : Jaula.jaulas) {
            if (jaula.id == id) {
                return jaula;
            }
        }

        return null;
    }

    public static Jaula deleteJaulaById(int id) {
        for (Jaula jaula : Jaula.jaulas) {
            if (jaula.id == id) {
                Jaula.jaulas.remove(jaula);
                return jaula;
            }
        }

        return null;
    }

    public static boolean VerificaJaulaAnimal(Jaula jaula, Animal animal) {
        boolean valida = true;

        if (jaula.tipo == "M") {
            if (!(animal instanceof Mamiferos)) {
                valida = false;
            }
        } else if (jaula.tipo == "A") {
            if (!(animal instanceof Aves)) {
                valida = false;
            }
        } else if (jaula.tipo == "R") {
            if (!(animal instanceof Repteis)) {
                valida = false;
            }
        }

        return valida;
    }
}
