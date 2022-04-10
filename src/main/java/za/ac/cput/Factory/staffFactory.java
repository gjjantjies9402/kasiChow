/**
 * Mziyanda Mwanda
 * 2133765
 * ADP 3
 *Assignment 1
 * Due date
 * 10 Aprile 2022
 * Factory:
 * Staff
 * **/
package za.ac.cput.Factory;

import za.ac.cput.Entity.staff;
import za.ac.cput.util.Auth;


public class staffFactory {
    public static staff createStaff(String adminName, String deliveryDriver, String assistant){

      //String staffId = Auth.generateId();
        return new staff.Builder()
                .setAdminName(adminName)
                .setDeliveryDriver(deliveryDriver)
                .setAssistant(assistant)
                .build();
    }
}
