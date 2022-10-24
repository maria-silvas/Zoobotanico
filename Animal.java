import java.util.ArrayList;

public abstract class Animal {
    private int id;
    private String nome;
    private String especie;
    private ArrayList<Alimentacao> alimentacoes;

    public static ArrayList<Animal> animais = new ArrayList<Animal>();

    protected Animal(
            int id,
            String nome,
            String especie) {
        this.id = id;
        this.nome = nome;
        this.especie = especie;

        animais.add(this);
    }

    public int getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public String getEspecie() {
        return this.especie;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    @Override
    public String toString() {
        return "Id: " + this.id + " | Nome: " + this.nome + " | Especie: " + this.especie;
    }

    public static Animal getAnimalById(int id) {
        for (Animal animal : Animal.animais) {
            if (animal.id == id) {
                return animal;
            }
        }

        return null;
    }

    public static Animal deleteAnimalById(int id) {
        for (Animal animal : Animal.animais) {
            if (animal.id == id) {
                if (animal instanceof Mamiferos) {
                    Mamiferos.mamiferos.remove(animal);
                } else if (animal instanceof Aves) {
                    Aves.aves.remove(animal);
                } else if (animal instanceof Repteis) {
                    Repteis.repteis.remove(animal);
                }

                Animal.animais.remove(animal);
                return animal;
            }
        }
        return null;
    }
}