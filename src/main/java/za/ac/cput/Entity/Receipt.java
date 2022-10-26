/**Receipt.java
 * Entity for Receipt
 * Author: Nikitha Mbokotwana (218337906)
 * Date: 08 April 2022
 **/
package za.ac.cput.Entity;

import org.hibernate.annotations.Fetch;

import javax.persistence.*;

@Entity
public class Receipt {
    @Id
    @GeneratedValue
    private String receiptID;
    @ManyToOne(targetEntity = Orders.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "order_cust_id")
    private Orders order;

    protected Receipt() {}

    //private constructor
    private Receipt(Builder builder) {
        this.receiptID = builder.receiptID;
        this.order = builder.order;
    }

    public String toString() {
        return "Receipt{" +
                "receiptID='" + receiptID + '\'' +
                ", order=" + order +
                '}';
    }
    //getters
    public String getReceiptID() {
        return receiptID;
    }
    public Orders getOrder() {
        return order;
    }

    //setters
    public void setReceiptID(String receiptID) {
        this.receiptID = receiptID;
    }
    public void setOrder(Orders order) {
        this.order = order;
    }

    public static class Builder{
        private String receiptID;
        private Orders order;

        public Builder setReceiptID(String receiptID){
            this.receiptID =receiptID;
            return this;
        }
        public Builder setOrder(Orders order){
            this.order = order;
            return this;
        }
        public Receipt build(){
            return new Receipt(this);
        }

        public Builder copy(Receipt receipt){
            this.receiptID = receipt.receiptID;
            this.order = receipt.order;
            return this;
        }

    }


}
