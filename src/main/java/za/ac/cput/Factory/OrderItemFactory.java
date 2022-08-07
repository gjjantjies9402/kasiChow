/**
 * Mandisa Msongelwa
 * 217149073
 * Group 28
 */
package za.ac.cput.Factory;

import za.ac.cput.Entity.OrderItem;

public class OrderItemFactory {
    public static OrderItem createOrderItem(int quantity, double price, double totalAmount) {

        return new OrderItem.Builder().setQuantity(quantity)
                .setPrice(price)
                .setTotalAmount(totalAmount)
                .build();
    }
}
