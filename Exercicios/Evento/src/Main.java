import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy H:mm");
        GerenciadorDeEventos gerencia = new GerenciadorDeEventos();

        boolean sistema = true;
        System.out.println("Sistema de eventos");

        while (sistema) {
            System.out.println("Bem-vindo ao gerenciador de eventos");
            System.out.println("1 - Listar eventos cadastrados.");
            System.out.println("2 - Adicionar evento.");
            System.out.println("3 - Remover evento.");
            System.out.println("4 - Mostrar eventos futuros.");
            System.out.println("5 - Sair");
            System.out.print("O que deseja fazer? ");
            int opcao = sc.nextInt();
            sc.nextLine();
            System.out.println();

            switch (opcao) {
                case 1:
                    gerencia.listarEventos();
                    break;
                case 2:
                    System.out.print("Insira o nome do evento: ");
                    String nomeEvento = sc.nextLine();
                    System.out.print("Digite a data do evento (Ex. 01/01/2026): ");
                    String dataTexto = sc.nextLine();
                    System.out.print("Digite a hora do evento (Ex. 18:30): ");
                    String horaTexto = sc.nextLine();
                    LocalDateTime dataEvento = LocalDateTime.parse(dataTexto + " " + horaTexto, dtf);
                    System.out.println("Insira uma breve descrição do evento: ");
                    String descricaoEvento = sc.nextLine();
                    gerencia.adicionarEvento(nomeEvento, dataEvento, descricaoEvento);
                    break;
                case 3:
                    System.out.println("Insira o ID do evento que desejar excluir: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    gerencia.removerEvento(id);
                    break;
                case 4:

                    gerencia.exibirEventosFuturos();
                    break;
                case 5:
                    sistema = false;
                    System.out.println("Sistema finalizado");
                    break;
                default:
                    System.out.println("Opção inválida inserida.");
            }
        }
    }
}
