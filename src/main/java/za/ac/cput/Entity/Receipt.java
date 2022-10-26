/**Receipt.java
 * Entity for Receipt
 * Author: Nikitha Mbokotwana (218337906)
 * Date: 08 April 2022
 **/
package za.ac.cput.Entity;

import javax.persistence.*;

@Entity
public class Receipt {
    @Id
    @GeneratedValue
    private String receiptID;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Orders orderID;
    @OneToOne
    @JoinColumn(name = "cust_id")
    private Customer custID;
    @OneToOne
    @JoinColumn(name = "driver_id")
    private Driver driverID;
    @ManyToOne
    @JoinColumn(name = "item_id")
    private MenuItem itemID;

    protected Receipt() {}

    //private constructor
    private Receipt(Builder builder) {
        this.receiptID = builder.receiptID;
        this.orderID = builder.orderID;
        this.custID = builder.custID;
        this.driverID = builder.driverID;
        this.itemID = builder.itemID;
    }


    //getters
    public String getReceiptID() {
        return receiptID;
    }
    public Orders getOrderID() {
        return orderID;
    }
    public Customer getCustID() {
        return custID;
    }
    public Driver getDriverID() {
        return driverID;
    }
    public MenuItem getItemID() {
        return itemID;
    }

    //setters
    public void setReceiptID(String receiptID) {
        this.receiptID = receiptID;
    }
    public void setOrderID(Orders orderID) {
        this.orderID = orderID;
    }
    public void setCustID(Customer custID) {
        this.custID = custID;
    }
    public void setDriverID(Driver driverID) {
        this.driverID = driverID;
    }
    public void setItemID(MenuItem itemID) {
        this.itemID = itemID;
    }

    public static class Builder{
        private String receiptID;
        private Orders orderID;
        private Customer custID;
        private Driver driverID;
        private MenuItem itemID;

        public Builder setReceiptID(String receiptID){
            this.receiptID =receiptID;
            return this;
        }
        public Builder setOrder(Orders orderID){
            this.orderID = orderID;
            return this;
        }
        public Builder setCustID(Customer custID){
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

        public Receipt build(){
            return new Receipt(this);
        }

        public Builder copy(Receipt receipt){
            this.receiptID = receipt.receiptID;
            this.orderID = receipt.orderID;
            this.custID = receipt.custID;
            this.driverID = receipt.driverID;
            this.itemID = receipt.itemID;
            return this;
        }

    }


}
