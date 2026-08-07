package entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private LocalDateTime date;
    private OrderStatus status;
    private Client client;

    private List<OrderItem> items = new ArrayList<>();
    private static final DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    public Order() {}

    public Order(LocalDateTime date, OrderStatus status, Client client) {
        this.date = date;
        this.status = status;
        this.client = client;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public List<OrderItem> getOrderItem() {
        return items;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void addItem(OrderItem item) {
        items.add(item);
    }

    public void removeItem(OrderItem item) {
        items.remove(item);
    }

    public Double total() {
        Double total = 0.0;
        for (OrderItem item : items) {
            total += item.subTotal();
        }
        return total;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Resumo do pedido:\n");
        sb.append("Hora do pedido: ").append(date.format(dtf2)).append("\n");
        sb.append("Status: ");
        sb.append(status + "\n");
        sb.append("Cliente: ")
                .append(client.getName())
                .append(" ("+client.getBirthDate().format(dtf1)+") ")
                .append(" - ")
                .append(client.getEmail())
                .append("\n");
        sb.append("Itens do pedido:\n");
        for (OrderItem item : items) {
            sb.append(item.toString() + "\n");
        }
        sb.append("Valor total: ");
        sb.append("$ ").append(String.format("%.2f", total()));
        return sb.toString();
    }
}
