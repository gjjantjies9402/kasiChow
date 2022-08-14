package za.ac.cput.Service.Interface;

import org.springframework.stereotype.Service;
import za.ac.cput.Entity.Order;
import za.ac.cput.Entity.staff;
import za.ac.cput.Service.IService;

import java.util.Set;
@Service
public interface IStaff extends IService<staff, String> {
    public Set<staff> getAll();
}
