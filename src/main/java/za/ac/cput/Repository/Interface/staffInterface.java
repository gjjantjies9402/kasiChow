/**
 * Mziyanda Mwanda
 * 2133765
 * ADP 3
 * DB connection
 * **/


package za.ac.cput.Repository.Interface;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.Entity.staff;
import za.ac.cput.Repository.iml.iRepository;

import java.util.Set;
@Repository
public interface staffInterface extends JpaRepository<staff, String> {

    //public Set<staff> getAll();
}
