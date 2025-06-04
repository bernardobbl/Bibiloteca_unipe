package biblioteca.model;

public class Professor extends Usuario {
    private String disciplina;
    private String titulo;

    public Professor(String nome, int id, String disciplina, String titulo) {
        super(nome, id);
        this.disciplina = disciplina;
        this.titulo = titulo;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public String getTitulo() {
        return titulo;
    }

    @Override
    public String toString() {
        return super.toString()
                + " | Disciplina: " + disciplina
                + " | Título: " + titulo;
    }
}
