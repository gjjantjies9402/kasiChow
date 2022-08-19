package za.ac.cput.Repository.Interface;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.Entity.Restaurant;
import za.ac.cput.Repository.iml.iRepository;

import java.util.List;
@Repository
public interface IRestaurantRepository extends JpaRepository<Restaurant, String> {

}
