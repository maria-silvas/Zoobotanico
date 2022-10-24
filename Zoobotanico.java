import java.util.Scanner;

public class Zoobotanico {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int op = 0;

        
        System.out.println("========== ZOOBOTÂNICO ===========");


        do {
            System.out.println("\n\n01 - Cadastrar Jaulas");
            System.out.println("02 - Cadastrar Animais");
            System.out.println("03 - Alimentar Animal");
            System.out.println("04 - Listar Jaulas");
            System.out.println("05 - Listar Animais");
            System.out.println("06 - Listar Alimentação por Animal");
            System.out.println("07 - Excluir Jaula");
            System.out.println("08 - Excluir Animal");
            System.out.println("09 - Limpar Jaula");
            System.out.println("10 - Relação Limpeza x Jaula");
            System.out.println("11 - Alterar Animal");
            System.out.println("12 - Sair");
            op = sc.nextInt();

            switch (op) {
                case 1:
                    CadastrarJaula(sc);
                    break;

                case 2:
                    CadastrarAnimal(sc);
                    break;

                case 3:
                    CadastrarAlimentacao(sc);
                    break;

                case 4:
                    ListarJaulas();
                    break;

                case 5:
                    ListarAnimais();
                    break;

                case 6:
                    ListarAlimentacoes(sc);
                    break;

                case 7:
                    ExcluirJaula(sc);
                    break;

                case 8:
                    ExcluirAnimal(sc);
                    break;

                case 9:
                    LimparJaula(sc);
                    break;

                case 10:
                    RelacaoLimpezaJaula(sc);
                    break;

                case 11:
                    AlterarAnimal(sc);
                    break;

                case 12:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }

        } while (op != 10);
    }

    public static void CadastrarJaula(Scanner sc) {
        System.out.println("==== Cadastro de Jaulas ====");
        System.out.println("Informe o nome da jaula: ");
        String nomeJaula = sc.next();

        System.out.println("Informe o tipo da jaula: [M] Mamíferos | [R] Répteis | [A] Aves");
        String tipoJaula = sc.next();

        Jaula jaula = new Jaula(Jaula.jaulas.size() + 1, nomeJaula, tipoJaula);
        System.out.println("Jaula " + jaula.getNome() + " cadastrada!");
    }

    public static void CadastrarAnimal(Scanner sc) {
        System.out.println("==== Cadastro de Animais ====");
        System.out.println("Informe o nome do animal: ");
        String nomeAnimal = sc.next();
        System.out.println("Informe a espécie do animal: ");
        String especieAnimal = sc.next();
        int valida = 0;
        String tipoAnimal = "";
        System.out.println("Informe o tipo da Animal: [M] Mamíferos | [R] Répteis | [A] Aves");
        do {
            tipoAnimal = sc.next();
            switch (tipoAnimal) {
                case "M":
                    System.out.println("Informe o tempo de gestação: ");
                    String tempoGestacao = sc.next();
                    System.out.println("Informe o ID da Jaula que este animal vai habitar: ");
                    int idJaulaMam = sc.nextInt();

                    try {
                        Jaula jaulaMam = Jaula.getJaulaById(idJaulaMam);
                        Mamiferos mamifero = new Mamiferos(Mamiferos.mamiferos.size() + 1, nomeAnimal, especieAnimal,
                                tempoGestacao);

                        if (Jaula.VerificaJaulaAnimal(jaulaMam, mamifero)) {
                            jaulaMam.getAnimais().add(mamifero);
                            System.out.println("Animal " + mamifero.getNome() + " cadastrado!");
                        } else {
                            System.out.println("Jaula não encontrada ou não compatível com o tipo de animal!");
                        }

                        valida = 1;

                    } catch (Exception e) {
                        System.out.println("Entrada inválida!");
                    }
                    break;

                case "R":
                    System.out.println("Informe o tipo de Habitat: ");
                    String tipoHabitat = sc.next();
                    System.out.println("Informe o ID da Jaula que este animal vai habitar: ");
                    int idJaulaRep = sc.nextInt();

                    try {
                        Jaula jaulaRep = Jaula.getJaulaById(idJaulaRep);
                        Repteis repteis = new Repteis(Repteis.repteis.size() + 1, nomeAnimal, especieAnimal,
                                tipoHabitat);

                        if (Jaula.VerificaJaulaAnimal(jaulaRep, repteis) == true) {
                            jaulaRep.getAnimais().add(repteis);
                            System.out.println("Animal " + repteis.getNome() + " cadastrado!");
                        } else {
                            System.out.println("Jaula não encontrada ou não compatível com o tipo de animal!");
                        }

                        valida = 1;

                    } catch (Exception e) {
                        System.out.println("Entrada inválida!");
                    }

                    break;

                case "A":
                    System.out.println("Informe o tipo de Plumagem: ");
                    String tipoPlumagem = sc.next();
                    System.out.println("Informe o ID da Jaula que este animal vai habitar: ");
                    int idJaulaAve = sc.nextInt();

                    try {
                        Jaula jaulaAve = Jaula.getJaulaById(idJaulaAve);

                        Aves aves = new Aves(Aves.aves.size() + 1, nomeAnimal, especieAnimal, tipoPlumagem);

                        if (Jaula.VerificaJaulaAnimal(jaulaAve, aves) == true) {
                            jaulaAve.getAnimais().add(aves);
                            System.out.println("Animal " + aves.getNome() + " cadastrado!");
                        } else {
                            System.out.println("Jaula não encontrada ou não compatível com o tipo de animal!");
                        }

                        valida = 1;

                    } catch (Exception e) {
                        System.out.println("Entrada inválida!");
                    }

                    break;

                default:
                    System.out.println("Tipo de animal inválido! Tente novamente: ");
                    valida = 0;
                    break;
            }
        } while (valida == 0);
    }

    public static void CadastrarAlimentacao(Scanner sc) {
        System.out.println("==== Cadastro de Alimentação ====");
        System.out.println("Data da Alimentação: ");
        String dataAlimentacao = sc.next();
        System.out.println("Descrição da Alimentação: ");
        String descricaoAlimentacao = sc.next();
        System.out.println("Informe o ID do animal que será alimentado: ");
        int idAnimal = sc.nextInt();

        try {
            Animal animalAlimentado = Animal.getAnimalById(idAnimal);
            Alimentacao alimentacao = new Alimentacao(Alimentacao.alimentacoes.size() + 1, dataAlimentacao,
                    descricaoAlimentacao, animalAlimentado);
            System.out.println("Alimentação de " + alimentacao.data + " para o animal " + animalAlimentado.getEspecie()
                    + " cadastrada!");

        } catch (Exception e) {
            System.out.println("Animal não encontrado!");
        }
    }

    public static void ListarJaulas() {
        System.out.println("==== Lista de Jaulas ====");
        for (Jaula jaula : Jaula.jaulas) {
            System.out.println(jaula.toString());
        }
    }

    public static void ListarAnimais() {
        System.out.println("==== Lista de Animais ====");

        if (Mamiferos.mamiferos.size() > 0) {
            System.out.println("\nMAMÍFEROS");
            for (Mamiferos mamiferos : Mamiferos.mamiferos) {
                System.out.println(mamiferos.toString());
            }
        }

        if (Repteis.repteis.size() > 0) {
            System.out.println("\nRÉPTEIS");
            for (Repteis repteis : Repteis.repteis) {
                System.out.println(repteis.toString());
            }
        }

        if (Aves.aves.size() > 0) {
            System.out.println("\nAVES");
            for (Aves aves : Aves.aves) {
                System.out.println(aves.toString());
            }
        }
    }

    public static void ListarAlimentacoes(Scanner sc) {
        System.out.println("==== Lista de Alimentações ====");
        System.out.println("Informe o ID do animal para consultar alimentação: ");
        int idAnimal = sc.nextInt();

        try {
            Animal animalAlimentado = Animal.getAnimalById(idAnimal);
            for (Alimentacao alimentacao : Alimentacao.alimentacoes) {
                if (animalAlimentado.getId() == idAnimal) {
                    System.out.println(alimentacao.toString());
                }
            }
        } catch (Exception e) {
            System.out.println("Animal não encontrado!");
        }
    }

    public static void ExcluirJaula(Scanner sc) {
        System.out.println("==== Excluir Jaulas ====");
        System.out.println("Informe o ID da Jaula a ser excluída: ");
        int idJaula = sc.nextInt();
        Jaula jaula = Jaula.getJaulaById(idJaula);

        try {
            Jaula.deleteJaulaById(idJaula);
            System.out.println("Jaula " + jaula.getNome() + " excluída com sucesso!");
        } catch (Exception e) {
            System.out.println("Jaula não encontrada!");
        }
    }

    public static void ExcluirAnimal(Scanner sc) {
        System.out.println("==== Excluir Animais ====");
        System.out.println("Informe o ID do Animal a ser excluído: ");
        int idAnimal = sc.nextInt();
        Animal animal = Animal.getAnimalById(idAnimal);

        try {
            Animal.deleteAnimalById(idAnimal);
            System.out.println("Animal " + animal.getNome() + " excluído com sucesso!");
        } catch (Exception e) {
            System.out.println("Animal não encontrado!");
        }
    }

    public static void LimparJaula(Scanner sc) {
        System.out.println("==== Limpar Jaulas ====");
        System.out.println("Informe a data da limpeza: ");
        String dataLimpeza = sc.next();
        System.out.println("Informe a descrição da limpeza: ");
        String descricaoLimpeza = sc.next();
        System.out.println("Informe o ID da Jaula a ser limpa: ");
        int idJaula = sc.nextInt();

        try {
            Jaula jaula = Jaula.getJaulaById(idJaula);
            Limpeza limparJaula = new Limpeza(Limpeza.limpezas.size() + 1, dataLimpeza, descricaoLimpeza, jaula);

            System.out.println("Limpeza da jaula " + jaula.getNome() + " registrada com sucesso!");
        } catch (Exception e) {
            System.out.println("Jaula não encontrada!");
        }
    }

    public static void RelacaoLimpezaJaula(Scanner sc) {
        System.out.println("==== Relação de Limpeza de Jaulas ====");
        System.out.println("Informe o ID da Jaula: ");
        int idJaula = sc.nextInt();

        try {
            Jaula jaula = Jaula.getJaulaById(idJaula);
            System.out.println("Jaula: " + jaula.getNome());
            System.out.println("Limpezas: ");
            for (Limpeza limpeza : Limpeza.limpezas) {
                if (jaula.getId() == idJaula) {
                    System.out.println(limpeza.toString());
                }
            }
        } catch (Exception e) {
            System.out.println("Jaula não encontrada!");
        }
    }

    public static void AlterarAnimal(Scanner sc) {
        System.out.println("==== Alterar Animal ====");
        System.out.println("Informe o ID do Animal a ser alterado: ");
        int idAnimal = sc.nextInt();

        try {
            Animal animal = Animal.getAnimalById(idAnimal);

            if (animal instanceof Mamiferos) {
                System.out.println("Informe o elemento a ser alterado: ");
                System.out.println("1 - Nome");
                System.out.println("2 - Espécie");
                System.out.println("3 - Tempo de Gestação");
                int opcao = sc.nextInt();
                switch (opcao) {
                    case 1:
                        System.out.println("Informe o novo nome: ");
                        String nome = sc.next();
                        animal.setNome(nome);
                        break;
                    case 2:
                        System.out.println("Informe a nova espécie: ");
                        String especie = sc.next();
                        animal.setEspecie(especie);
                        break;
                    case 3:
                        System.out.println("Informe o novo tempo de gestação: ");
                        String tempoGestacao = sc.next();
                        ((Mamiferos) animal).setTempoGestacao(tempoGestacao);
                        break;
                    default:
                        System.out.println("Opção inválida!");
                        break;
                }
            } else if (animal instanceof Aves) {
                System.out.println("Informe o elemento a ser alterado: ");
                System.out.println("1 - Nome");
                System.out.println("2 - Espécie");
                System.out.println("3 - Plumagem");
                int opcao = sc.nextInt();
                switch (opcao) {
                    case 1:
                        System.out.println("Informe o novo nome: ");
                        String nome = sc.next();
                        animal.setNome(nome);
                        break;
                    case 2:
                        System.out.println("Informe a nova espécie: ");
                        String especie = sc.next();
                        animal.setEspecie(especie);
                        break;
                    case 3:
                        System.out.println("Informe a nova Plumagem: ");
                        String plumagem = sc.next();
                        ((Aves) animal).setPlumagem(plumagem);
                        break;
                    default:
                        System.out.println("Opção inválida!");
                        break;
                }
            } else {
                System.out.println("Informe o elemento a ser alterado: ");
                System.out.println("1 - Nome");
                System.out.println("2 - Espécie");
                System.out.println("3 - Habitat");
                int opcao = sc.nextInt();
                switch (opcao) {
                    case 1:
                        System.out.println("Informe o novo nome: ");
                        String nome = sc.next();
                        animal.setNome(nome);
                        break;
                    case 2:
                        System.out.println("Informe a nova espécie: ");
                        String especie = sc.next();
                        animal.setEspecie(especie);
                        break;
                    case 3:
                        System.out.println("Informe a nova Plumagem: ");
                        String habitat = sc.next();
                        ((Repteis) animal).setHabitat(habitat);
                        break;
                    default:
                        System.out.println("Opção inválida!");
                        break;
                }
            }

        } catch (Exception e) {
            System.out.println("Animal não encontrado!");
        }
    }
}
