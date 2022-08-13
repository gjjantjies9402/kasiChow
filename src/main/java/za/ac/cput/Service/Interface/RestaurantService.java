package za.ac.cput.Service.Interface;

import za.ac.cput.Entity.Restaurant;
import za.ac.cput.Service.IService;

import java.util.Set;

public interface RestaurantService extends IService<Restaurant, String> {

    Set<Restaurant> getAll();
}
