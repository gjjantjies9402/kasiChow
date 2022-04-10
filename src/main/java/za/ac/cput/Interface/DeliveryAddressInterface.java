/*DeliveryAddressInterface.java
Interface for DeliveryAddressRepository
Author: Kanya Ramncwana (218297521)
Date: 09 April 2022*/

package za.ac.cput.Interface;


import za.ac.cput.Entity.DeliveryAddress;

import java.util.Set;

public interface DeliveryAddressInterface extends iRepository<DeliveryAddress,String> {

    public Set<DeliveryAddress> getAll();

}
