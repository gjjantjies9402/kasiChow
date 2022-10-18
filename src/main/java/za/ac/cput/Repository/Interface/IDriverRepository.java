package za.ac.cput.Repository.Interface;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.Entity.Driver;

@Repository
public interface IDriverRepository extends JpaRepository <Driver, String> {
}
