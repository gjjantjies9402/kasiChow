package za.ac.cput.Repository.Interface;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.Entity.Rating;
import za.ac.cput.Repository.iml.iRepository;

import java.util.Set;

@Repository
public interface RatingInterface extends JpaRepository<Rating, String> {

//    public Set<Rating> getAll();
}
