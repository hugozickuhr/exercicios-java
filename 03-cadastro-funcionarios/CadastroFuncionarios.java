import java.util.ArrayList;
import java.util.Scanner;

class Funcionario {

    String nome;
    int codigo;
    double salario;

    Funcionario(String nome, int codigo, double salario) {

        this.nome = nome;
        this.codigo = codigo;
        this.salario = salario;
    }

    void mostrarInfo() {
        System.out.println("Nome: " + nome + ", Código: " + codigo + ", Salário: " + salario);
        if (salario >= 5000) {
            System.out.println("Status: Funcionário com salário alto!");
        } else {
            System.out.println("Status: Funcionário com salário baixo!");
        }
    }
}

public class CadastroFuncionarios {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        ArrayList<Funcionario> listaFuncionarios = new ArrayList<>();
        int opcao;
        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1 - Incluir funcionário");
            System.out.println("2 - Listar todos os funcionários");
            System.out.println("3 - Buscar funcionário por nome");
            System.out.println("4 - Remover funcionário por nome");
            System.out.println("5 - Salários");
            System.out.println("6 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = entrada.nextInt();
            entrada.nextLine(); // limpar buffer
            switch (opcao) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = entrada.nextLine();
                    System.out.print(
                            "Código (O código do funcionário é composto pela data de aniversário + ano de contratação do mesmo (Ex.: 10092026): ");
                    int codigo = entrada.nextInt();
                    System.out.print("Salário: ");
                    double salario = entrada.nextDouble();
                    entrada.nextLine();
                    listaFuncionarios.add(new Funcionario(nome, codigo, salario));
                    if (salario >= 5000) {
                        System.out.println("ATENÇÃO: Funcionário com salário alto");
                    } else {
                        System.out.println("ATENÇÃO: Funcionário com salário baixo");
                    }
                    System.out.println("Funcionário cadastrado com sucesso!");
                    break;

                case 2:
                    if (listaFuncionarios.isEmpty()) {
                        System.out.println("Nenhum funcionário cadastrado.");
                    } else {
                        System.out.println("\n--- Lista de Funcionarios ---");
                        for (Funcionario a : listaFuncionarios) {
                            a.mostrarInfo();
                            System.out.println("-------------------");
                        }
                    }
                    break;

                case 3:
                    if (listaFuncionarios.isEmpty()) {
                        System.out.println("Nenhum funcionário cadastrado.");
                    } else {

                    System.out.print("Busque o funcionário: ");
                    String nomebuscar = entrada.nextLine();
                    boolean encontrado = false;
                    for (Funcionario b : listaFuncionarios) {
                        if (b.nome.equalsIgnoreCase(nomebuscar)) {
                            b.mostrarInfo();
                            encontrado = true;
                            break;
                        }
                    }
                    if (encontrado) {
                        System.out.println("Funcionário encontrado com sucesso!");
                    } else {
                        System.out.println("Funcionário não encontrado.");
                    }
                }
                    break;

                case 4:

                    if (listaFuncionarios.isEmpty()) {
                        System.out.println("Nenhum funcionário cadastrado.");
                    } else {

                        System.out.print("Digite o nome do funcionário que você deseja remover (DEMISSÃO ou CADASTRO INCORRETO): ");
                        String nomeremover = entrada.nextLine();
                        boolean removido = false;
                        for (Funcionario c : listaFuncionarios) {
                            if (c.nome.equalsIgnoreCase(nomeremover)) {
                                listaFuncionarios.remove(c);
                                removido = true;
                                break;
                            }
                        }

                        if (removido) {
                            System.out.println(
                                    "Funcionário removido com sucesso. Caso o funcionário tenha sido removido por CADASTRO INCORRETO, lembre-se de cadastrá-lo novamente.");
                        } else {
                            System.out.println("Funcionário não encontrado.");
                        }
                    }
                    break;

                case 5:

                    if (listaFuncionarios.isEmpty()) {
                        System.out.println("Nenhum funcionário cadastrado.");
                    } else {

                        double somasalarios = 0;
                        int salariosaltos = 0;
                        int salariosbaixos = 0;
                        double mediasalarios = 0;

                        for (Funcionario d : listaFuncionarios) {
                            somasalarios += d.salario;

                            if (d.salario < 5000) {
                                salariosbaixos++;
                            } else if (d.salario >= 5000) {
                                salariosaltos++;
                            }
                        }

                        mediasalarios = somasalarios / listaFuncionarios.size();

                        System.out.println("--- ESTATÍSTICAS SOBRE SALÁRIOS ---");
                        System.out.println();
                        System.out.println("Total de funcionários: " + listaFuncionarios.size());
                        System.out.println("Média de salários: " + mediasalarios);
                        System.out.println("Gasto mensal com salários: " + somasalarios);
                        System.out.println("------------------------------------------");
                        System.out.println("Classificação por faixa salarial:");
                        System.out.println();
                        System.out.println("Salários baixos (Menor que R$5000,00)): " + salariosbaixos);
                        System.out.println("Salários altos (Maior ou igual a R$5000,00): " + salariosaltos);

                    }
                    break;

                case 6:
                    System.out.println("Encerrando o sistema...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 6);
        entrada.close();
    }
}