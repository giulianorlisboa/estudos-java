import entities.Order;
import enums.OrderStatus;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Order pedido = new Order(1, new Date(), OrderStatus.PEDING_PAYMENT);

        System.out.println(pedido);

        OrderStatus os1 = OrderStatus.DELIVERED;
        OrderStatus os2 = OrderStatus.valueOf("PROCESSING");

        System.out.println(os1); //java ja passa o tostring automatico, ja sai formatado como texto e nao como referencia
        System.out.println(os2); // esse metodo serve para ler o Enum, quando vem do Jason por exemplo.

        System.out.println(os1.ordinal()); // identificar a posição, o PROCESSING é o segundo, tudo começa em 0.

        System.out.println(os1.name()); // Coleta o nome do Enum.

        if (pedido.getOrderStatus() == OrderStatus.PROCESSING) {
            System.out.println("Pedido em processamento");
        } // verificação com "==" tambem funciona.

        switch (pedido.getOrderStatus()) {
            case PEDING_PAYMENT -> System.out.println("Aguardando pagamento");
            case PROCESSING -> System.out.println("Em processamento");
            case SHIPPED -> System.out.println("Enviado");
            case DELIVERED -> System.out.println("Entregue");
        }
    }
}