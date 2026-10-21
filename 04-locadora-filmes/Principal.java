import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

    static ArrayList<Filme> filmes = new ArrayList<>();
    static ArrayList<Cliente> clientes = new ArrayList<>();
    static ArrayList<Emprestimo> emprestimos = new ArrayList<>();

    static Scanner sc = new Scanner(System.in);

    static Locador locador = new Locador("Carlos");

    public static void main(String[] args) {

        int opcao;

        do {
            System.out.println("\n========= LOCADORA =========");
            System.out.println("1 - Cadastrar Filme");
            System.out.println("2 - Cadastrar Clientes");
            System.out.println("3 - Realizar Empréstimo");
            System.out.println("4 - Devolver Filme");
            System.out.println("5 - Listar Filmes");
            System.out.println("6 - Listar Clientes");
            System.out.println("7 - Sair");
            System.out.print("Opção: ");

            opcao = lerInteiro();

            switch (opcao) {
                case 1:
                    cadastrarFilme();
                    break;
                case 2:
                    cadastrarCliente();
                    break;
                case 3:
                    realizarEmprestimo();
                    break;
                case 4:
                    devolverFilme();
                    break;
                case 5:
                    listarFilmes();
                    break;
                case 6:
                    listarClientes();
                    break;
                case 7:
                    System.out.println("Encerrando...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 7);

        sc.close();
    }

    static void cadastrarFilme() {
        sc.nextLine();
        System.out.print("Título do filme: ");
        String titulo = sc.nextLine();

        System.out.print("Nome do gênero: ");
        String nomeGenero = sc.nextLine();

        System.out.print("Quantidade de exemplares: ");
        int quantidade = lerInteiro();

        Genero genero = new Genero(nomeGenero);
        Filme filme = new Filme(titulo, genero, quantidade);
        filmes.add(filme);

        System.out.println("Filme cadastrado com sucesso!");
    }

    static void cadastrarCliente() {
        sc.nextLine();
        System.out.print("Nome do usuário: ");
        String nome = sc.nextLine();

        System.out.print("Matrícula: ");
        int matricula = lerInteiro();

        Cliente cliente = new Cliente(nome, matricula);
        clientes.add(cliente);

        System.out.println("Usuário cadastrado com sucesso!");
    }

    static void realizarEmprestimo() {
        if (filmes.isEmpty()) {
            System.out.println("Nenhum filme cadastrado.");
            return;
        }
        if (clientes.isEmpty()) {
            System.out.println("Nenhum usuário cadastrado.");
            return;
        }

        listarFilmes();
        System.out.print("Escolha o número do filme: ");
        int indiceFilme = lerInteiro() - 1;

        if (!indiceValido(indiceFilme, filmes.size())) {
            System.out.println("Filme inválido.");
            return;
        }

        listarClientes();
        System.out.print("Escolha o número do usuário: ");
        int indiceCliente = lerInteiro() - 1;

        if (!indiceValido(indiceCliente, clientes.size())) {
            System.out.println("Usuário inválido.");
            return;
        }

        Filme filme = filmes.get(indiceFilme);
        Cliente cliente = clientes.get(indiceCliente);

        Emprestimo emprestimo = new Emprestimo(filme, cliente, locador);

        if (emprestimo.realizar()) {
            emprestimos.add(emprestimo);
        }
    }

    static void devolverFilme() {

        if (emprestimos.isEmpty()) {
            System.out.println("Nenhum empréstimo ativo para devolução.");
            return;
        }

        System.out.println("\n--- Empréstimos Ativos ---");
        for (int i = 0; i < emprestimos.size(); i++) {
            Emprestimo emp = emprestimos.get(i);
            System.out.println((i + 1) + " - Filme: " + emp.getFilme().getTitulo()
                    + " | Usuário: " + emp.getCliente().getNome());
        }

        System.out.print("Escolha o número do empréstimo a ser devolvido: ");
        int indiceEmp = lerInteiro() - 1;

        if (!indiceValido(indiceEmp, emprestimos.size())) {
            System.out.println("Empréstimo inválido.");
            return;
        }

        System.out.print("Digite a quantidade de dias de atraso (0 se foi no prazo): ");
        int diasAtraso = lerInteiro();

        Emprestimo emprestimo = emprestimos.get(indiceEmp);

        emprestimo.devolver(diasAtraso);
        emprestimos.remove(indiceEmp);
    }

    static void listarFilmes() {
        System.out.println("\n--- Lista de Filmes ---");
        if (filmes.isEmpty()) {
            System.out.println("Nenhum filme cadastrado.");
            return;
        }
        for (int i = 0; i < filmes.size(); i++) {
            Filme f = filmes.get(i);
            String status = f.isDisponivel() ? "Disponível" : "Indisponível";
            System.out.println((i + 1) + " - " + f.getTitulo()
                    + " | Genero: " + f.getGenero().getNome()
                    + " | Status: " + status);
        }
    }

    static void listarClientes() {
        System.out.println("\n--- Lista de Clientes ---");
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
            return;
        }
        for (int i = 0; i < clientes.size(); i++) {
            Cliente c = clientes.get(i);
            System.out.print((i + 1) + " - ");
            c.apresentar();
        }
    }

    static int lerInteiro() {
        while (!sc.hasNextInt()) {
            System.out.print("Digite um número válido: ");
            sc.next();
        }
        return sc.nextInt();
    }

    static boolean indiceValido(int indice, int tamanho) {
        return indice >= 0 && indice < tamanho;
    }
}