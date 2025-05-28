package biblioteca.model;

public class Professor extends Usuario {
    private String disciplina;
    private String titulo;

    public Professor(String nome, int id, String disciplina, String titulo) {
        super(nome, id);
        this.disciplina = disciplina;
        this.titulo = titulo;
    }

    public boolean solicitarEmprestimo(Livro livro, int dias) {
        if (livro.isDisponivel()) {
            livro.emprestar();
            return true;
        }
        return false;
    }

    public boolean renovarEmprestimo(Emprestimo emp) {
        // Lógica de renovação fictícia
        return true;
    }
}
