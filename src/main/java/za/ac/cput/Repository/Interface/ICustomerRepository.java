package za.ac.cput.Repository.Interface;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.Entity.Customer;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, String> {
}
