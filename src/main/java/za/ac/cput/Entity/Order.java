package za.ac.cput.Entity;
/**
 Order.java
 Entity: Order
 Author: Zimkhitha Nkqenkqa 216280427
 Date: 10 April 2022
 */

public class Order {
    private int custID, custIMEI, storeRefID;
    private String orderUpdate, orderNr;

    private Order(Builder builder) {
        this.orderNr = builder.orderNr;
        this.custID = builder.custID;
        this.custIMEI = builder.custIMEI;
        this.storeRefID = builder.storeRefID;
        this.orderUpdate = builder.orderUpdate;
    }
    public Order() {

    }

    public String getOrderNr() {
        return orderNr;
    }

    public int getCustID() {
        return custID;
    }

    public int getCustIMEI() {
        return custIMEI;
    }

    public int getStoreRefID() {
        return storeRefID;
    }

    public String isOrderUpdate() {
        return orderUpdate;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderNr=" + orderNr +
                ", custID=" + custID +
                ", custIMEI=" + custIMEI +
                ", storeRefID=" + storeRefID +
                ", orderUpdate=" + orderUpdate +
                '}';
    }
    public static class Builder {
        private String orderNr;
        private int custID;
        private int custIMEI;
        private int storeRefID;
        private String orderUpdate;

        public Builder setOrderNr(String orderNr) {
            this.orderNr = orderNr;
            return this;
        }

        public Builder setCustID(int custID) {
            this.custID = custID;
            return this;
        }

        public Builder setCustIMEI(int custIMEI) {
            this.custIMEI = custIMEI;
            return this;
        }

        public Builder setStoreRefID(int storeRefID) {
            this.storeRefID = storeRefID;
            return this;
        }

        public Builder setOrderUpdate(String orderUpdate) {
            this.orderUpdate = orderUpdate;
            return this;
        }

        public Builder copy(Order order) {
            this.orderNr = order.orderNr;
            this.custID = order.custID;
            this.custIMEI = order.custIMEI;
            this.storeRefID = order.storeRefID;
            this.orderUpdate = order.orderUpdate;
            return this;
        }

        public Order build() {
            return new Order(this);
        }
    }
}
