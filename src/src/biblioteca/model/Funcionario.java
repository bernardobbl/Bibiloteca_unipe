package biblioteca.model;

public class Funcionario extends Usuario {
    private String cargo;

    public Funcionario(String nome, int id, String cargo) {
        super(nome, id);
        this.cargo = cargo;
    }

    public String getCargo() {
        return cargo;
    }

    @Override
    public String toString() {
        return super.toString()
                + " | Cargo: " + cargo;
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
        // Se tiver acesso à instância de Biblioteca, implemente corretamente aqui
        return true;
    }
}
