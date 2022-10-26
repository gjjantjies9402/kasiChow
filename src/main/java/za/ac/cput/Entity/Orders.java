package za.ac.cput.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


/**
 Order.java
 Entity: Order
 Author: Zimkhitha Nkqenkqa 216280427
 Date: 10 April 2022
 */

@Entity
public class Orders {
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

    public Orders() {
    }

    private Orders(Orders.Builder buil) {
        this.orderID = buil.orderID;
        this.custID = buil.custID;
        this.driverID = buil.driverID;
        this.itemID = buil.itemID;
        this.trackStatus = buil.trackStatus;
        this.trackETA = buil.trackETA;

    }
    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public Customer getCustID() {
        return custID;
    }

    public Customer setCustID(Customer custID) {
        this.custID = custID;
        return custID;
    }

    public Driver getDriverID() {
        return driverID;
    }

    public Driver setDriverID(Driver driverID) {
        this.driverID = driverID;
        return driverID;
    }

    public MenuItem getItemID() {
        return itemID;
    }

    public MenuItem setItemID(MenuItem itemID) {
        this.itemID = itemID;
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
        return "Builder{" +
                "orderID=" + orderID +
                ", custID=" + custID +
                ", driverID=" + driverID +
                ", itemID=" + itemID +
                ", trackStatus='" + trackStatus + '\'' +
                ", trackETA='" + trackETA + '\'' +
                '}';
    }

    public static class Builder {
        private String orderID;
        private Customer custID;
        private Driver driverID;
        private MenuItem itemID;
        private String trackStatus;
        private String trackETA;

        public Builder setOrderID(String orderID) {
            this.orderID = orderID;
            return this;
        }

        public Builder setCustID(Customer custID) {
            this.custID = custID;
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

        public Builder copy(Orders ord) {
            this.orderID = ord.orderID;
            this.custID = ord.custID;
            this.driverID = ord.driverID;
            this.itemID = ord.itemID;
            this.trackStatus = ord.trackStatus;
            this.trackETA = ord.trackETA;
            return this;
        }

        public Orders build() {
            return new Orders(this);
        }

        }
    }