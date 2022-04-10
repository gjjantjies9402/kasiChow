package za.ac.cput.Factory;

import za.ac.cput.Entity.orderItem;

public class orderItemFactory {
    public static orderItem createOrderItem(int quantity, double price, double totalAmount) {

        return new orderItem.Builder().setQuantity(quantity)
                .setPrice(price)
                .setTotalAmount(totalAmount)
                .build();
    }
}
