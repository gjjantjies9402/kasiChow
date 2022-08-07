package za.ac.cput.Repository.Interface;

import za.ac.cput.Entity.Restaurant;
import za.ac.cput.Repository.iml.iRepository;

import java.util.List;

public interface IRestaurantRepository extends iRepository<Restaurant, String> {

    List<Restaurant> getAll();
}
