public class Emprestimo {
    private Filme filme;
    private Cliente cliente;
    private Locador locador;

    public Emprestimo(Filme filme, Cliente cliente, Locador locador) {
        this.filme = filme;
        this.cliente = cliente;
        this.locador = locador;
    }

    public Filme getFilme() {
        return filme;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public boolean realizar() {
        if (filme.isDisponivel()) {
            filme.emprestar();
            System.out.println(
                cliente.getNome()
                + " fez um empréstimo do filme \"" + filme.getTitulo() + "\""
                + ". Responsável pela locação: " + locador.getNome());
            return true;
        } else {
            System.out.println("Filme indisponível no estoque.");
            return false;
        }
    }

    public void devolver(int diasAtraso) {
        filme.devolver();
        System.out.println("Filme \"" + filme.getTitulo() + "\" devolvido com sucesso!");
        
        if (diasAtraso > 0) {
            double multa = diasAtraso * 2.50;
            System.out.printf("Atraso de %d dia(s). Multa: R$%.2f\n", diasAtraso, multa);
        } else {
            System.out.println("Devolução realizada no prazo (Sem multa).");
        }
    }
}