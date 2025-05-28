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

    @Override
    public String toString() {
        return super.toString() + " - Aluno do curso: " + curso;
    }
}
