/**
 * Mandisa Msongelwa
 * 217149073
 * Group 28
 */

package za.ac.cput.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class OrderItem {
    @Id
    private String itemID;
    private int quantity;
    private double totalAmount;

    protected OrderItem(){}

    //Private constructor
    private OrderItem(Builder builder) {
        this.itemID = builder.itemID;
        this.quantity = builder.quantity;
        this.totalAmount = builder.totalAmount;
    }

    //Getters & Setters & toString
    public String getItemID() {
        return itemID;
    }

//    public void setItemID(String itemID) {
//        this.itemID = itemID;
//    }

    public int getQuantity() {
        return quantity;
    }

//    public void setQuantity(int quantity) {
//        this.quantity = quantity;
//    }

    public double getTotalAmount() {
        return totalAmount;
    }

//    public void setTotalAmount(double totalAmount) {
//        this.totalAmount = totalAmount;
//    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "Item ID=" + itemID +
                " Quantity=" + quantity +
                ", Total Amount=" + totalAmount +
                '}';
    }

    public static class Builder {
        private String itemID;
        private int quantity;
        private double totalAmount;


        public Builder setItemID(String itemID) {
            this.itemID = itemID;
            return this;
        }
        public Builder setQuantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public Builder setTotalAmount(double totalAmount) {
            this.totalAmount = totalAmount;
            return this;
        }

        public Builder copy(OrderItem oItem) {
            this.itemID = oItem.itemID;
            this.quantity = oItem.quantity;
            this.totalAmount = oItem.totalAmount;
            return this;
        }

        public OrderItem build() {

            return new OrderItem(this);
        }
    }


}
