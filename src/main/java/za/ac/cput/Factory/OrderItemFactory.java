/**
 * Mandisa Msongelwa
 * 217149073
 * Group 28
 */
package za.ac.cput.Factory;

import za.ac.cput.Entity.OrderItem;

//orderItem
public class OrderItemFactory {
    public static OrderItem createOrderItem(String itemID, int quantity, double totalAmount) {

        return new OrderItem.Builder().setItemID(itemID)
                .setQuantity(quantity)
                .setTotalAmount(totalAmount)
                .build();
    }
}
