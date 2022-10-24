package za.ac.cput.Service.Interface;


import za.ac.cput.Entity.Driver;
import za.ac.cput.Entity.Restaurant;
import za.ac.cput.Service.IService;

import java.util.List;

public interface RestaurantService extends IService<Restaurant, String> {

    List<Restaurant> getAll();
}
