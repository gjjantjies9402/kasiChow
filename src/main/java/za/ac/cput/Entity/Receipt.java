/**Receipt.java
 * Entity for Receipt
 * Author: Nikitha Mbokotwana (218337906)
 * Date: 08 April 2022
 **/
package za.ac.cput.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Receipt {
    @Id
    private String receiptID;
    private String orderNr;
    private String customerID;
    private String driverID;
    private double amountPaid;

    protected Receipt(){

    }
    //private constructer
    private Receipt(Builder builder){
        this.receiptID = builder.receiptID;
        this.orderNr = builder.orderNr;
        this.customerID = builder.customerID;
        this.driverID = builder.driverID;
        this.amountPaid = builder.amountPaid;
    }

    //getters

    public String getReceiptID() {
        return receiptID;
    }

    public String getOrderNr() {
        return orderNr;
    }

    public String getCustomerID() {
        return customerID;
    }
    public String getDriverID(){return driverID;}
    public double getAmountPaid() {
        return amountPaid;
    }
    //setters

    public void setReceiptID(String receiptID) {
        this.receiptID = receiptID;
    }

    public void setOrderNr(String orderNr) {
        this.orderNr = orderNr;
    }

    public void setCustomerID(String staffID) {
        this.customerID = customerID;
    }
    public void setDriverID(String driverID){this.driverID = driverID;}
    public void setAmountPaid(double amountPaid) {
        this.amountPaid = amountPaid;
    }

    @Override
    public String toString() {
        return "Receipt{" +
                "receiptID='" + receiptID + '\'' +
                ", orderNr=" + orderNr +
                ", customerID='" + customerID + '\'' +
                ", driverID='" + driverID + '\'' +
                ", amountPaid=" + amountPaid +
                '}';
    }

    public static class Builder{
        private String receiptID;
        private String orderNr;
        private String customerID;
        private String driverID;
        private double amountPaid;

        public Builder setReceiptID(String receiptID) {
            this.receiptID = receiptID;
            return this;
        }

        public Builder setOrderNr(String orderNr) {
            this.orderNr = orderNr;
            return this;
        }

       public Builder setCustomerID(String customerID){
            this.customerID = customerID;
            return this;
       }

       public Builder setDriverID(String driverID){
            this.driverID = driverID;
            return this;
       }

        public Builder setAmountPaid(double amountPaid) {
            this.amountPaid = amountPaid;
            return this;
        }

        public Builder copy(Receipt receipt){
            this.receiptID = receipt.receiptID;
            this.customerID = receipt.customerID;
            this.driverID = receipt.driverID;
            this.amountPaid = receipt.amountPaid;
            return this;
        }

        public Receipt build(){
            return new Receipt(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Receipt receipt = (Receipt) o;
        return Objects.equals(receiptID, receipt.receiptID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(receiptID);
    }
}
