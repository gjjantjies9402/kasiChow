package za.ac.cput.Repository.Interface;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.Entity.Supermarket;

@Repository
public interface ISupermarketRepository extends JpaRepository<Supermarket, String> {


        }