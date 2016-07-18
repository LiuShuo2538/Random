/**
 * Created by ${LiuShuo} on 2016/7/13.
 */
public class Order<T> {
    private String orderName;
    private int orderId;
    private T t;

    public Order() {
    }

    public Order(String orderName, int orderId, T t) {
        this.orderName = orderName;
        this.orderId = orderId;
        this.t = t;
    }


    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderName='" + orderName + '\'' +
                ", orderId=" + orderId +
                ", t=" + t +
                '}';
    }

    public <E> E getE(E e){

        return e;
    }





}
