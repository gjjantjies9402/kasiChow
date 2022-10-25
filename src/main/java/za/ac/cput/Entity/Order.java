package za.ac.cput.Entity;

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
    private String custID;
    @ManyToOne
    @JoinColumn(name = "driver_id_driver_id")
    private String driverID;
    @ManyToOne
    @JoinColumn(name = "item_id_item_id")
    private int itemID;

    public Order() {
    }

    private Order(Order.Builder buil) {
        this.custID = buil.custID;
        this.orderID = buil.orderID;
        this.driverID = buil.driverID;
        this.itemID = buil.itemID;
        this.trackStatus = buil.trackStatus;
        this.trackETA = buil.trackETA;

    }

    public String getCustID() {
        return custID;
    }

    public void setCustID(String custID) {
        this.custID = custID;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getDriverID() {
        return driverID;
    }

    public void setDriverID(String driverID) {
        this.driverID = driverID;
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
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
        return "Builder{" +
                "custID=" + custID +
                ", orderID=" + orderID +
                ", driverID=" + driverID +
                ", itemID=" + itemID +
                ", trackStatus='" + trackStatus + '\'' +
                ", trackETA='" + trackETA + '\'' +
                '}';
    }

    public static class Builder {
        private String custID;
        private String orderID;
        private String driverID;
        private int itemID;
        private String trackStatus;
        private String trackETA;

        public Builder setCustID(String custID) {
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

        public Builder copy(Order ord) {
            this.custID = ord.custID;
            this.orderID = ord.orderID;
            this.driverID = ord.driverID;
            this.itemID = ord.itemID;
            this.trackStatus = ord.trackStatus;
            this.trackETA = ord.trackETA;
            return this;
        }

        public Order build() {
            return new Order(this);
        }

        }
    }