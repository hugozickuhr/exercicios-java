public class Filme {
    private String titulo;
    private Genero genero;
    private int quantidade;

    public Filme(String titulo, Genero genero, int quantidade) {
        this.titulo = titulo;
        this.genero = genero;
        this.quantidade = quantidade;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public Genero getGenero() {
        return genero;
    }

    public boolean isDisponivel() {
        return quantidade > 0;
    }

    public void emprestar() {
        if (quantidade > 0) {
            quantidade--;
        }
    }

    public void devolver() {
        quantidade++;
    }
}