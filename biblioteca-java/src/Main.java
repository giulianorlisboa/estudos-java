import model.Livro;
import service.LivroService;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LivroService livroService = new LivroService();

        System.out.println("Bem vindo a biblioteca!");
        System.out.println("O que deseja fazer? ");
        System.out.println("1 - Cadastrar livro");
        System.out.println("2 - Mostrar livros cadastrados");
        System.out.println("3 - Buscar informações do livro por ID.");
        System.out.println("4 - Alterar dados do livro.");
        System.out.println("5 - Excluir livro.");
        System.out.println("6 - Alugar um livro.");
        System.out.println("7 - Sair.");
        System.out.print("Insira a opção desejada: ");
        int opcao = sc.nextInt();
        sc.nextLine();

        while (opcao != 0) {
            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do livro: ");
                    String nomeLivro = sc.nextLine();
                    System.out.print("Digite o autor do livro: ");
                    String autorLivro = sc.nextLine();
                    System.out.print("Digite uma descrição para o livro: ");
                    String descricaoLivro = sc.nextLine();
                    livroService.cadastrarLivro(nomeLivro, autorLivro, descricaoLivro);
                    System.out.println("Livro cadastrado com sucesso!");
                    break;
                case 2:
                    List<Livro> livros = livroService.listarLivros();
                    for (Livro livro : livros) {
                        System.out.println("Livros cadastrados: ");
                        System.out.println(livro);
                        System.out.println("------------------------------- \n");
                    }
                    break;
                case 3:
                    System.out.print("Insira o id do livro: ");
                    int numId = sc.nextInt();
                    sc.nextLine();
                    try {
                        Livro livroBuscado = livroService.buscarlivro(numId);
                        System.out.println("Livro encontrado com sucesso!");
                        System.out.println(livroBuscado);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Erro: " + e.getMessage());
                    }
                    break;
                case 4:
                    System.out.println("Qual livro deseja alterar? insira o ID do livro: ");
                    int idLivroParaEditar = sc.nextInt();
                    sc.nextLine();
                    try {
                        Livro livroParaEditar = livroService.buscarlivro(idLivroParaEditar);
                        System.out.print("O livro que você vai editar: ");
                        System.out.println(livroParaEditar);
                        System.out.print("Digite o novo titulo do livro: ");
                        String novoTituloLivro = sc.nextLine();
                        System.out.print("Digite o novo autor do livro: ");
                        String novoAutorLivro = sc.nextLine();
                        System.out.print("Digite a nova descricao do livro: ");
                        String novaDescricaoLivro = sc.nextLine();
                        livroService.editarLivro(idLivroParaEditar, novoTituloLivro, novoAutorLivro, novaDescricaoLivro);
                        System.out.println("Livro atualizado com sucesso!");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Erro: " + e.getMessage());
                    }
                    break;
                case 5:
                    System.out.println("Qual livro deseja excluir? Insira o ID do livro: ");
                    int idLivroParaExcluir = sc.nextInt();
                    sc.nextLine();
                    boolean removido = livroService.removerLivro(idLivroParaExcluir);
                    System.out.println(removido ? "Livro removido com sucesso!" : "Livro não encontrado.");
                    break;
                case 6:
                    System.out.print("Insira o ID do livro que deseja pegar emprestado: ");
                    int idLivroEmprestar = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Informe o nome de quem quer pegar emprestado: ");
                    String nomeEmprestado = sc.nextLine();
                    try {
                        livroService.emprestarLivro(idLivroEmprestar, nomeEmprestado);
                        System.out.println("Emprestado com sucesso!");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Erro: " + e.getMessage());
                    }
                    break;
                case 7:
                    System.out.println("Fechando sistema.");
                    opcao = 0;
                    break;

                default:
                    System.out.println("Você inseriu uma opção invalida.");
                    break;

            }
            System.out.println();
            System.out.println("O que deseja fazer agora? ");
            System.out.println("1 - Cadastrar livro");
            System.out.println("2 - Mostrar livros cadastrados");
            System.out.println("3 - Buscar informações do livro por ID.");
            System.out.println("4 - Alterar dados do livro.");
            System.out.println("5 - Excluir livro.");
            System.out.println("6 - Alugar um livro. Digite o ID do livro que deseja alugar: ");
            System.out.println("7 - Sair.");
            System.out.print("Insira a opção desejada: ");
            opcao = sc.nextInt();
            sc.nextLine();

        }


    }

}
