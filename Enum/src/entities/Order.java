package entities;

import enums.OrderStatus;

import java.util.Date;

public class Order {
    private Integer orderId;
    private Date moment;
    private OrderStatus orderStatus;

    public Order(){}

    public Order(Integer orderId, Date moment, OrderStatus orderStatus) {
        this.orderId = orderId;
        this.moment = moment;
        this.orderStatus = orderStatus;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Date getMoment() {
        return moment;
    }

    public void setMoment(Date moment) {
        this.moment = moment;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", moment=" + moment +
                ", orderStatus=" + orderStatus +
                '}';
    }
}
