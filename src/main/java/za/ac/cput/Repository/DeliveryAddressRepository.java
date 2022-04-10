/*DeliveryAddressRepository.java
Repository for DeliveryAddress
Author: Kanya Ramncwana (218297521)
Date: 09 April 2022*/

package za.ac.cput.Repository;

import za.ac.cput.Entity.DeliveryAddress;
import za.ac.cput.Repository.Interface.DeliveryAddressInterface;

import java.util.HashSet;
import java.util.Set;

public class DeliveryAddressRepository implements DeliveryAddressInterface {

    private static DeliveryAddressRepository repository = null;
    private Set<DeliveryAddress> deliveryDB;

    private DeliveryAddressRepository() {

        deliveryDB = new HashSet<DeliveryAddress>();

    }

    public static DeliveryAddressRepository getRepository(){
        if (repository == null)
        {
            repository = new DeliveryAddressRepository();
        }
        return repository;
    }


    @Override
    public DeliveryAddress create(DeliveryAddress deliveryAddress) {

        boolean success = deliveryDB.add(deliveryAddress);
        if (!success)
            return null;
        return deliveryAddress;
    }

    @Override
    public DeliveryAddress read(String s) {

        DeliveryAddress deliveryAddress = deliveryDB.stream()
                .filter(c -> c.getDeliveryID().equals(s))
                . findAny()
                .orElse(null);

        return deliveryAddress;
    }

    @Override
    public DeliveryAddress update(DeliveryAddress deliveryAddress) {

        DeliveryAddress prevDelivery = read(deliveryAddress.getDeliveryID());

        if (prevDelivery != null)
        {
            deliveryDB.remove(prevDelivery);
            deliveryDB.add(deliveryAddress);

            return deliveryAddress;
        }
       return deliveryAddress;

    }

    @Override
    public boolean delete(String s) {

        DeliveryAddress delete = read(s);

        if(delete == null)
            return  false;
        deliveryDB.remove(delete);
        return  true;
    }

    @Override
    public Set<DeliveryAddress> getAll() {
        return deliveryDB;
    }
}
