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
    @ManyToOne(targetEntity = Order.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "order_cust_id")
    private Order order;

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
    public Order getOrder() {
        return order;
    }

    //setters
    public void setReceiptID(String receiptID) {
        this.receiptID = receiptID;
    }
    public void setOrder(Order order) {
        this.order = order;
    }

    public static class Builder{
        private String receiptID;
        private Order order;

        public Builder setReceiptID(String receiptID){
            this.receiptID =receiptID;
            return this;
        }
        public Builder setOrder(Order order){
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
