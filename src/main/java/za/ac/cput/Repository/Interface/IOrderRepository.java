package za.ac.cput.Repository.Interface;
/**
 IOrderRepository.java
 IOrderRepository
 Author: Zimkhitha Nkqenkqa 216280427
 Date: 10 April 2022
 */


import za.ac.cput.Entity.Order;
import za.ac.cput.Repository.iml.iRepository;

import java.util.Set;

public interface IOrderRepository extends iRepository<Order, String> {
    Set<Order> getAll();
        }