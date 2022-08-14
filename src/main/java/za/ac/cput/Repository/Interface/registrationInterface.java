/**
 * Mziyanda Mwanda
 * 2133765
 * ADP 3
 *Assignment 1
 * Due date
 * 10 Aprile 2022
 * Interface
 * Registration
 * **/
package za.ac.cput.Repository.Interface;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.Entity.registration;
import za.ac.cput.Repository.iml.iRepository;

import java.util.Set;
@Repository
public interface registrationInterface extends JpaRepository<registration, String> {

    //public Set<registration> getAll();
}
