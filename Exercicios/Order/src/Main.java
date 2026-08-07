import entities.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Product product;
        OrderItem orderItem;

        System.out.println("Loja");
        System.out.println("Insira os dados do cliente: ");
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Data de nascimento: (DD/MM/YYYY)");
        LocalDate dataNascimento = LocalDate.parse(sc.nextLine(), dtf);
        System.out.println("Insira o Status do pedido: ");
        System.out.print("PENDING_PAYMENT, PROCESSING, SHIPPED ou DELIVERED ");
        String status = sc.nextLine();
        Client client = new Client(nome, email, dataNascimento);
        System.out.print("Quantos itens terá esse pedido ? ");
        int N = sc.nextInt();
        sc.nextLine();
        LocalDateTime date = LocalDateTime.now();
        Order order = new Order(date, OrderStatus.valueOf(status.trim().toUpperCase()), client);
        for (int i = 1; i <= N; i++) {
            System.out.println("Insira o " + i + "º item do pedido");
            System.out.print("Nome do produto: ");
            String produto = sc.nextLine();
            System.out.print("Valor do produto: ");
            double valor = sc.nextDouble();
            sc.nextLine();
            System.out.print("Quantidade de itens: ");
            int qtd = sc.nextInt();
            sc.nextLine();
            product = new Product(produto, valor);
            orderItem = new OrderItem(qtd, valor, product);
            order.addItem(orderItem);
        }

        System.out.println(order);

        sc.close();
    }
}