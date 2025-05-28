package biblioteca.model;

public class Categoria {
    private String nome;
    private String codigo;

    public Categoria(String nome, String codigo) {
        this.nome = nome;
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }
}
