package biblioteca.service;

import biblioteca.model.*;

public class BibliotecaService {
    private Biblioteca biblioteca;

    public BibliotecaService(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    public boolean cadastrarLivro(Livro livro) {
        if (!biblioteca.getLivros().contains(livro)) {
            biblioteca.adicionarLivro(livro);
            return true;
        }
        return false;
    }

    public boolean cadastrarUsuario(Usuario usuario) {
        if (!biblioteca.getUsuarios().contains(usuario)) {
            biblioteca.adicionarUsuario(usuario);
            return true;
        }
        return false;
    }

    public void listarLivros() {
        System.out.println("Lista de Livros:");
        for (Livro l : biblioteca.getLivros()) {
            System.out.println(l);
        }
    }

    public void listarUsuarios() {
        System.out.println("Lista de Usuários:");
        for (Usuario u : biblioteca.getUsuarios()) {
            System.out.println(u);
        }
    }

    public void listarEmprestimos() {
        System.out.println("Lista de Empréstimos:");
        for (Emprestimo e : biblioteca.getEmprestimos()) {
            System.out.println(e);
        }
    }

    public void pesquisarAutor(String nome) {
        System.out.println("Livros do autor: " + nome);
        for (Livro l : biblioteca.getLivros()) {
            if (l.getAutor().getNome().equalsIgnoreCase(nome)) {
                System.out.println(l);
            }
        }
    }

    public void pesquisarCategoria(String categoria) {
        System.out.println("Livros da categoria: " + categoria);
        for (Livro l : biblioteca.getLivros()) {
            if (l.getCategoria().getNome().equalsIgnoreCase(categoria)) {
                System.out.println(l);
            }
        }
    }
}
