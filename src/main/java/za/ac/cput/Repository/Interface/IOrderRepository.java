package za.ac.cput.Repository.Interface;
/**
 IOrderRepository.java
 IOrderRepository
 Author: Zimkhitha Nkqenkqa 216280427
 Date: 10 April 2022
 */


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.Entity.Order;

@Repository
public interface IOrderRepository extends JpaRepository<Order, String> {
        }