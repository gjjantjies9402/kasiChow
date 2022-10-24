package za.ac.cput.Factory;
/**
 OrderFactory.java
 OrderFactory
 Author: Zimkhitha Nkqenkqa 216280427
 Date: 10 April 2022
 */

import za.ac.cput.Entity.Customer;
import za.ac.cput.Entity.Driver;
import za.ac.cput.Entity.MenuItem;
import za.ac.cput.Entity.Order;

public class OrderFactory {
    public static Order createOrder(Customer custID, String orderID, Driver driverID, MenuItem itemID, String trackStatus, String trackETA){

       return new Order.Builder().setCustID(custID).
               setOrderID(orderID).
               setDriverID(driverID).
               setItemID(itemID).
               setTrackStatus(trackStatus).
               setTrackETA(trackETA).build();

    }
}
