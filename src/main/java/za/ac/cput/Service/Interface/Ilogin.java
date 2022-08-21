/**
 * Mziyanda Mwanda
 * 215133765
 * ADP 3
 * Service interface implementation
 * */
package za.ac.cput.Service.Interface;

import org.springframework.stereotype.Service;
import za.ac.cput.Entity.Order;
import za.ac.cput.Entity.login;
import za.ac.cput.Service.IService;

import java.util.Set;
@Service
public interface Ilogin extends IService<login, String> {
    public Set<login> getAll();
}
