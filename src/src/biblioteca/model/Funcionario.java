package biblioteca.model;

public class Funcionario extends Usuario {
    private String cargo;
    private String setor;

    public Funcionario(String nome, int id, String cargo, String setor) {
        super(nome, id);
        this.cargo = cargo;
        this.setor = setor;
    }

    public boolean registrarEmprestimo(Usuario usuario, Livro livro) {
        if (livro.isDisponivel()) {
            livro.emprestar();
            return true;
        }
        return false;
    }

    public boolean devolverLivro(Emprestimo emp) {
        emp.getLivro().devolver();
        return true;
    }

    public boolean cadastrarNovoLivro(Livro livro) {
        // Suponha que tem acesso à Biblioteca
        return true;
    }
}
