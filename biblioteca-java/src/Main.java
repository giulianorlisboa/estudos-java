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
        int opcao = sc.nextInt();
        sc.nextLine();

        while (opcao != 0) {
            switch (opcao) {
                case 1:
                    System.out.println("Digite o nome do livro: ");
                    String nomeLivro = sc.nextLine();
                    System.out.println("Digite o autor do livro: ");
                    String autorLivro = sc.nextLine();
                    System.out.println("Digite uma descrição para o livro: ");
                    String descricaoLivro = sc.nextLine();
                    Livro novoLivro = livroService.cadastrarLivro(nomeLivro, autorLivro, descricaoLivro);
                    System.out.println("Livro cadastrado com sucesso!");
                    System.out.println(novoLivro);
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
                    System.out.println("Insira o id do livro: ");
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

                default:
                    break;

            }
            System.out.println("O que deseja fazer? ");
            opcao = sc.nextInt();
            sc.nextLine();

        }


    }

}
