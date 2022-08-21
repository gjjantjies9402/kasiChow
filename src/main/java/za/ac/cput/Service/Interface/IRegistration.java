/**
 * Mziyanda Mwanda
 * 215133765
 * ADP 3
 * Service Interface implementation
 * */
package za.ac.cput.Service.Interface;

import org.springframework.stereotype.Service;
import za.ac.cput.Entity.Order;
import za.ac.cput.Entity.registration;
import za.ac.cput.Service.IService;

import java.util.Set;
@Service
public interface IRegistration extends IService<registration, String> {
    public Set<registration> getAll();
}
