/*DeliveryAddress.java
Factory for DeliveryAddress
Author: Kanya Ramncwana (218297521)
Date: 08 April 2022
 */

package za.ac.cput.Factory;

import za.ac.cput.Entity.Customer;
import za.ac.cput.Entity.DeliveryAddress;
import za.ac.cput.util.Auth;

public class DeliveryAddressFactory {

    public static DeliveryAddress createDeliveryAddress(String deliveryID, String streetAddress){

        if (Auth.isNullorEmpty(deliveryID) ||Auth.isNullorEmpty(streetAddress))
            return null;

        return new DeliveryAddress.Builder()
                .setDeliveryID(deliveryID)
                .setStreetAddress(streetAddress)
                .build();

    }
}
