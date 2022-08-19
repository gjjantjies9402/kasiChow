/**
 * Mziyanda Mwanda
 * 2133765
 * ADP 3
 *Assignment 1
 * Due date
 * 10 Aprile 2022
 * Interface
 * Login
 * **/
package za.ac.cput.Repository.Interface;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.Entity.login;
import za.ac.cput.Repository.iml.iRepository;

import java.util.Set;

public interface loginInterface extends JpaRepository<login, String> {

    //public Set<login> getAll();


}
