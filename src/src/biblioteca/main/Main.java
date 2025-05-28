package biblioteca.main;

import biblioteca.model.*;
import biblioteca.service.BibliotecaService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Biblioteca biblioteca = new Biblioteca();
        BibliotecaService service = new BibliotecaService(biblioteca);

        System.out.println("===== SISTEMA DE BIBLIOTECA =====");

        int opcao;
        do {
            System.out.println("\n------ MENU ------");
            System.out.println("1 - Cadastrar Livro");
            System.out.println("2 - Cadastrar Usuário");
            System.out.println("3 - Listar Livros");
            System.out.println("4 - Listar Usuários");
            System.out.println("5 - Pesquisar Livro por Autor");
            System.out.println("6 - Pesquisar Livro por Categoria");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine(); // limpar buffer

            switch (opcao) {
                case 1:
                    System.out.print("Título do livro: ");
                    String titulo = sc.nextLine();

                    System.out.print("Nome do autor: ");
                    String nomeAutor = sc.nextLine();

                    System.out.print("Nacionalidade do autor: ");
                    String nacionalidade = sc.nextLine();
                    Autor autor = new Autor(nomeAutor, nacionalidade);

                    System.out.print("ISBN: ");
                    String isbn = sc.nextLine();

                    System.out.print("Nome da categoria: ");
                    String nomeCategoria = sc.nextLine();

                    System.out.print("Código da categoria: ");
                    String codigoCategoria = sc.nextLine();
                    Categoria categoria = new Categoria(nomeCategoria, codigoCategoria);

                    Livro livro = new Livro(titulo, autor, isbn, categoria);
                    if (service.cadastrarLivro(livro)) {
                        System.out.println("Livro cadastrado com sucesso!");
                    } else {
                        System.out.println("Livro já cadastrado!");
                    }
                    break;

                case 2:
                    System.out.print("Nome do usuário: ");
                    String nomeUsuario = sc.nextLine();

                    System.out.print("ID do usuário (número): ");
                    int idUsuario = sc.nextInt();
                    sc.nextLine();

                    Usuario usuario = new Usuario(nomeUsuario, idUsuario);
                    if (service.cadastrarUsuario(usuario)) {
                        System.out.println("Usuário cadastrado com sucesso!");
                    } else {
                        System.out.println("Usuário já cadastrado!");
                    }
                    break;

                case 3:
                    service.listarLivros();
                    break;

                case 4:
                    service.listarUsuarios();
                    break;

                case 5:
                    System.out.print("Digite o nome do autor: ");
                    String buscaAutor = sc.nextLine();
                    service.pesquisarAutor(buscaAutor);
                    break;

                case 6:
                    System.out.print("Digite o nome da categoria: ");
                    String buscaCategoria = sc.nextLine();
                    service.pesquisarCategoria(buscaCategoria);
                    break;

                case 0:
                    System.out.println("Saindo do sistema...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        sc.close();
    }
}
