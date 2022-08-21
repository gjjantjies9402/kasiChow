/*DeliveryAddressInterface.java
Interface for DeliveryAddressRepository
Author: Kanya Ramncwana (218297521)
Date: 09 April 2022*/

package za.ac.cput.Repository.Interface;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.Entity.DeliveryAddress;
import za.ac.cput.Repository.iml.iRepository;

import java.util.Set;

@Repository
public interface IDeliveryAddressRepository extends JpaRepository<DeliveryAddress,String> {



}
