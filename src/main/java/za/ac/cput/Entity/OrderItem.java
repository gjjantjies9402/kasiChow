/**
 * Mandisa Msongelwa
 * 217149073
 * Group 28
 */

package za.ac.cput.Entity;

public class OrderItem {

    private int quantity;
    private double price;
    private double totalAmount;

    //private constructor
    private OrderItem(Builder builder) {
        this.price = builder.price;
        this.quantity = builder.quantity;
        this.totalAmount = builder.totalAmount;
    }

    //Getters & Setters & toString
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "quantity=" + quantity +
                ", price=" + price +
                ", totalAmount=" + totalAmount +
                '}';
    }

    public static class Builder {
        private int quantity;
        private double price;
        private double totalAmount;

        public Builder setQuantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public Builder setPrice(double price) {
            this.price = price;
            return this;
        }

        public Builder setTotalAmount(double totalAmount) {
            this.totalAmount = totalAmount;
            return this;
        }

        public Builder copy(OrderItem oItem) {
            this.price = oItem.price;
            this.quantity = oItem.quantity;
            this.totalAmount = oItem.totalAmount;
            return this;
        }

        public OrderItem build() {

            return new OrderItem(this);
        }
    }


}
