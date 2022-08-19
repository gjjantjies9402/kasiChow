package za.ac.cput.Factory;
/**
 OrderFactory.java
 OrderFactory
 Author: Zimkhitha Nkqenkqa 216280427
 Date: 10 April 2022
 */

import za.ac.cput.Entity.Order;

public class OrderFactory {
    public static Order createOrder(String orderNr, int custID, int custIMEI, int storeRefID, String orderUpdate){
        //int orderNr = GenericHelper.generateId();
       return new Order.Builder().setOrderNr(orderNr).
               setCustID(custID).
               setCustIMEI(custIMEI).
               setStoreRefID(storeRefID).
               setOrderUpdate(orderUpdate).build();
     //   return order;
    }
}
