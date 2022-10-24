package za.ac.cput.Entity;

import org.springframework.beans.factory.annotation.Required;

import javax.persistence.*;

/**
 Order.java
 Entity: Order
 Author: Zimkhitha Nkqenkqa 216280427
 Date: 10 April 2022
 */

@Entity
public class Order {
    @Id
    private String orderID;
    private String trackStatus;
    private String trackETA;
    @ManyToOne
    @JoinColumn(name = "cust_id_cust_id")
    private Customer custID;
    @ManyToOne
    @JoinColumn(name = "driver_id_driver_id")
    private Driver driverID;
    @ManyToOne
    @JoinColumn(name = "item_id_item_id")
    private MenuItem itemID;



    public Order() {
    }

    private Order(Builder builder) {
        this.custID = builder.custID;
        this.orderID = builder.orderID;
        this.driverID = builder.driverID;
        this.itemID = builder.itemID;
        this.trackStatus = builder.trackStatus;
        this.trackETA = builder.trackETA;

    }

    public Customer getCustID() {
        return custID;
    }


    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public Driver getDriverID() {
        return driverID;
    }

    public MenuItem getItemID() {
        return itemID;
    }

    public String getTrackStatus() {
        return trackStatus;
    }

    public void setTrackStatus(String trackStatus) {
        this.trackStatus = trackStatus;
    }

    public String getTrackETA() {
        return trackETA;
    }

    public void setTrackETA(String trackETA) {
        this.trackETA = trackETA;
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
        private Customer custID;
        private String orderID;
        private Driver driverID;
        private MenuItem itemID;
        private String trackStatus;
        private String trackETA;

        public Builder setCustID(Customer custID) {
            this.custID = custID;
            return this;
        }

        public Builder setOrderID(String orderID) {
            this.orderID = orderID;
            return this;
        }

        public Builder setDriverID(Driver driverID) {
            this.driverID = driverID;
            return this;
        }

        public Builder setItemID(MenuItem itemID) {
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
