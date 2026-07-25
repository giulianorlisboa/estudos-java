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
        System.out.println("0 - Sair.");
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
                    Livro novoLivro = livroService.cadastrarLivro(nomeLivro, autorLivro, descricaoLivro);
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
                case 4:
                    System.out.println("Qual livro deseja alterar? insira o ID do livro: ");
                    int idLivroParaEditar = sc.nextInt();
                    sc.nextLine();
                    try {
                        Livro livroParaEditar = livroService.buscarlivro(idLivroParaEditar);
                        System.out.println("O livro que você vai editar: ");
                        System.out.println(livroParaEditar);
                        System.out.println("Digite o novo titulo do livro: ");
                        String novoTituloLivro = sc.nextLine();
                        System.out.println("Digite o novo autor do livro: ");
                        String novoAutorLivro = sc.nextLine();
                        System.out.println("Digite a nova descricao do livro: ");
                        String novaDescricaoLivro = sc.nextLine();
                        livroService.editarLivro(idLivroParaEditar, novoTituloLivro, novoAutorLivro, novaDescricaoLivro);
                        System.out.println("Livro atualizado com sucesso!");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Erro: " + e.getMessage());
                    }
                    break;
                default:
                    break;

            }
            System.out.println();
            System.out.println("O que deseja fazer agora? ");
            opcao = sc.nextInt();
            sc.nextLine();

        }


    }

}
