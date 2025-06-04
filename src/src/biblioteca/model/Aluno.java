package biblioteca.model;

public class Aluno extends Usuario {
    private String matricula;
    private String curso;

    public Aluno(String nome, int id, String matricula, String curso) {
        super(nome, id);
        this.matricula = matricula;
        this.curso = curso;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getCurso() {
        return curso;
    }

    @Override
    public String toString() {
        // super.toString() imprime ID e Nome
        return super.toString()
                + " | Matrícula: " + matricula
                + " | Curso: " + curso;
    }
}
