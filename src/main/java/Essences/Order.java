package Essences;

import java.util.List;

public class Order {
    private long orderID;
    private boolean status;
    private List<Product> ordersProduct;

    public Order(long orderID, boolean status, List<Product> ordersProduct) {
        this.orderID = orderID;
        this.status = status;
        this.ordersProduct = ordersProduct;
    }

    public long getOrderID() {
        return orderID;
    }

    public void setOrderID(long orderID) {
        this.orderID = orderID;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<Product> getOrdersProduct() {
        return ordersProduct;
    }

    public void setOrdersProduct(List<Product> ordersProduct) {
        this.ordersProduct = ordersProduct;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (getOrderID() != order.getOrderID()) return false;
        if (isStatus() != order.isStatus()) return false;
        return getOrdersProduct() != null ? getOrdersProduct().equals(order.getOrdersProduct()) : order.getOrdersProduct() == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (getOrderID() ^ (getOrderID() >>> 32));
        result = 31 * result + (isStatus() ? 1 : 0);
        result = 31 * result + (getOrdersProduct() != null ? getOrdersProduct().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderID=" + orderID +
                ", status=" + status +
                ", ordersProduct=" + ordersProduct +
                '}';
    }
}
