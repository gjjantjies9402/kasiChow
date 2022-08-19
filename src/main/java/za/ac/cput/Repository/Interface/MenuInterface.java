package za.ac.cput.Repository.Interface;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.Entity.Menu;
import za.ac.cput.Repository.iml.iRepository;

import java.util.Set;

@Repository
public interface MenuInterface extends JpaRepository<Menu, String> {

//    public Set<Menu> getAll();
}
