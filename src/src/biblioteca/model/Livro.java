package biblioteca.model;

public class Livro {
    private String titulo;
    private Autor autor;
    private String isbn;
    private boolean disponivel = true;
    private Categoria categoria;

    public Livro(String titulo, Autor autor, String isbn, Categoria categoria) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.categoria = categoria;
    }

    public void emprestar() {
        disponivel = false;
    }

    public void devolver() {
        disponivel = true;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Autor getAutor() {
        return autor;
    }

    @Override
    public String toString() {
        return titulo + " - " + autor.getNome();
    }
}
