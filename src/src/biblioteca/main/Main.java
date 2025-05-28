package biblioteca.main;

import biblioteca.model.*;
import biblioteca.service.BibliotecaService;

import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();
        BibliotecaService service = new BibliotecaService(biblioteca);

        System.out.println("Sistema de Biblioteca iniciado!");

        int opcao;
        do {
            System.out.println("\n------ MENU ------");
            System.out.println("1 - Cadastrar Livro");
            System.out.println("2 - Cadastrar Usuário");
            System.out.println("3 - Listar Livros");
            System.out.println("4 - Listar Usuários");
            System.out.println("5 - Pesquisar Livro por Autor");
            System.out.println("6 - Pesquisar Livro por Categoria");
            System.out.println("7 - Registrar Empréstimo");
            System.out.println("8 - Devolver Livro");
            System.out.println("9 - Listar Empréstimos");
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
                    System.out.print("ISBN do livro: ");
                    String isbn = sc.nextLine();
                    System.out.print("Categoria do livro: ");
                    String nomeCategoria = sc.nextLine();
                    System.out.print("Código da categoria: ");
                    String codCategoria = sc.nextLine();

                    Autor autor = new Autor(nomeAutor, nacionalidade);
                    Categoria categoria = new Categoria(nomeCategoria, codCategoria);
                    Livro livro = new Livro(titulo, autor, isbn, categoria);

                    if (service.cadastrarLivro(livro)) {
                        System.out.println("Livro cadastrado!");
                    } else {
                        System.out.println("Livro já cadastrado.");
                    }
                    break;

                case 2:
                    System.out.print("Nome do usuário: ");
                    String nome = sc.nextLine();
                    System.out.print("ID do usuário (número): ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    Usuario usuario = new Usuario(nome, id);

                    if (service.cadastrarUsuario(usuario)) {
                        System.out.println("Usuário cadastrado!");
                    } else {
                        System.out.println("Usuário já cadastrado.");
                    }
                    break;

                case 3:
                    service.listarLivros();
                    break;

                case 4:
                    service.listarUsuarios();
                    break;

                case 5:
                    System.out.print("Nome do autor: ");
                    String nomeAutorBusca = sc.nextLine();
                    service.pesquisarAutor(nomeAutorBusca);
                    break;

                case 6:
                    System.out.print("Nome da categoria: ");
                    String categoriaBusca = sc.nextLine();
                    service.pesquisarCategoria(categoriaBusca);
                    break;

                case 7:
                    System.out.print("ID do Usuário: ");
                    int idUsuario = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Título do Livro: ");
                    String tituloLivro = sc.nextLine();

                    Usuario u = service.buscarUsuarioPorId(idUsuario);
                    Livro l = service.buscarLivroPorTitulo(tituloLivro);

                    if (u != null && l != null) {
                        if (service.registrarEmprestimo(u, l)) {
                            System.out.println("Empréstimo realizado.");
                        } else {
                            System.out.println("Livro indisponível.");
                        }
                    } else {
                        System.out.println("Usuário ou livro não encontrado.");
                    }
                    break;

                case 8:
                    System.out.print("Título do Livro para devolução: ");
                    String tituloDev = sc.nextLine();

                    Emprestimo emprestimo = service.buscarEmprestimoPorLivro(tituloDev);
                    if (emprestimo != null) {
                        service.devolverLivro(emprestimo);
                        System.out.println("Livro devolvido.");
                    } else {
                        System.out.println("Empréstimo não encontrado.");
                    }
                    break;

                case 9:
                    service.listarEmprestimos();
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);

        sc.close();
    }
}
