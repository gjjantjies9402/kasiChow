/*Item.java
Entity for Receipt
Author: Nikitha Mbokotwana (218337906)
Date: 08 April 2022
 */
package za.ac.cput.Entity;

public class Receipt {
    private String receiptID;
    private double orderNr;
    private String staffID;
    private String customerIMEI;
    private double amountPaid;

    //private constructer
    private Receipt(Builder builder){
        this.receiptID = builder.receiptID;
        this.orderNr = builder.orderNr;
        this.staffID = builder.staffID;
        this.customerIMEI = builder.customerIMEI;
        this.amountPaid = builder.amountPaid;
    }

    //getters

    public String getReceiptID() {
        return receiptID;
    }

    public double getOrderNr() {
        return orderNr;
    }

    public String getStaffID() {
        return staffID;
    }

    public String getCustomerIMEI() {
        return customerIMEI;
    }

    public double getAmountPaid() {
        return amountPaid;
    }
    //setters

    public void setReceiptID(String receiptID) {
        this.receiptID = receiptID;
    }

    public void setOrderNr(double orderNr) {
        this.orderNr = orderNr;
    }

    public void setStaffID(String staffID) {
        this.staffID = staffID;
    }

    public void setCustomerIMEI(String customerIMEI) {
        this.customerIMEI = customerIMEI;
    }

    public void setAmountPaid(double amountPaid) {
        this.amountPaid = amountPaid;
    }

    @Override
    public String toString() {
        return "Receipt{" +
                "receiptID='" + receiptID + '\'' +
                ", orderNr=" + orderNr +
                ", staffID='" + staffID + '\'' +
                ", customerIMEI='" + customerIMEI + '\'' +
                ", amountPaid=" + amountPaid +
                '}';
    }

    public static class Builder{
        private String receiptID;
        private double orderNr;
        private String staffID;
        private String customerIMEI;
        private double amountPaid;

        public Builder setReceiptID(String receiptID) {
            this.receiptID = receiptID;
            return this;
        }

        public Builder setOrderNr(double orderNr) {
            this.orderNr = orderNr;
            return this;
        }

        public Builder setStaffID(String staffID) {
            this.staffID = staffID;
            return this;
        }

        public Builder setCustomerIMEI(String customerIMEI) {
            this.customerIMEI = customerIMEI;
            return this;
        }

        public Builder setAmountPaid(double amountPaid) {
            this.amountPaid = amountPaid;
            return this;
        }

        public Builder copy(Receipt receipt){
            this.receiptID = receipt.receiptID;
            this.staffID = receipt.staffID;
            this.customerIMEI = receipt.customerIMEI;
            this.amountPaid = receipt.amountPaid;
            return this;
        }

        public Receipt build(){
            return new Receipt(this);
        }
    }
}
