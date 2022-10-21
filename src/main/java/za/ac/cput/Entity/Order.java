package za.ac.cput.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
/**
 Order.java
 Entity: Order
 Author: Zimkhitha Nkqenkqa 216280427
 Date: 10 April 2022
 */

@Entity
public class Order {
    @Id
    private int custID;
    private String orderID;
    private String driverID;
    private int itemID;
    private String trackStatus;
    private String trackETA;

    protected Order() {
    }

    private Order(Builder builder) {
        this.custID = builder.custID;
        this.orderID = builder.orderID;
        this.driverID = builder.driverID;
        this.itemID = builder.itemID;
        this.trackStatus = builder.trackStatus;
        this.trackETA = builder.trackETA;

    }

    public int getCustID() {
        return custID;
    }

    public String getOrderID() {
        return orderID;
    }

    public String getDriverID() {
        return driverID;
    }

    public int getItemID() {
        return itemID;
    }

    public String getTrackStatus() {
        return trackStatus;
    }

    public String getTrackETA() {
        return trackETA;
    }

    @Override
    public String toString() {
        return "Order{" +
                "custID=" + custID +
                ", orderID=" + orderID +
                ", driverID=" + driverID +
                ", itemID=" + itemID +
                ", trackStatus='" + trackStatus + '\'' +
                ", trackETA='" + trackETA + '\'' +
                '}';
    }

    public static class Builder {
        private int custID;
        private String orderID;
        private String driverID;
        private int itemID;
        private String trackStatus;
        private String trackETA;

        public Builder setCustID(int custID) {
            this.custID = custID;
            return this;
        }

        public Builder setOrderID(String orderID) {
            this.orderID = orderID;
            return this;
        }

        public Builder setDriverID(String driverID) {
            this.driverID = driverID;
            return this;
        }

        public Builder setItemID(int itemID) {
            this.itemID = itemID;
            return this;
        }

        public Builder setTrackStatus(String trackStatus) {
            this.trackStatus = trackStatus;
            return this;
        }

        public Builder setTrackETA(String trackETA) {
            this.trackETA = trackETA;
            return this;
        }

        public Builder copy(Order order) {
            this.custID = order.custID;
            this.orderID = order.orderID;
            this.driverID = order.driverID;
            this.itemID = order.itemID;
            this.trackStatus = order.trackStatus;
            this.trackETA = order.trackETA;
            return this;
        }

        public Order build() {
            return new Order(this);
        }
    }
}
