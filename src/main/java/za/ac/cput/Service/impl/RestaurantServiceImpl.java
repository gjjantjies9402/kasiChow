package za.ac.cput.Service.impl;
/*
 * Author: GAYNOR JANTJIES 213069555
 * POJO RestaurantServiceImpl.java
 *  Restaurant Service file to be implemented
 * Created: 13/08/2022
 * */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.Entity.Restaurant;
import za.ac.cput.Repository.Interface.IRestaurantRepository;
import za.ac.cput.Service.Interface.RestaurantService;
import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {

 private static RestaurantService restaurantService = null;
    @Autowired
    private IRestaurantRepository repository;

    @Override
    public List<Restaurant> getAll() {
        return this.repository.findAll();
    }

@Override
    public Restaurant create(Restaurant restaurant){
    try {
        return this.repository.save(restaurant);
    }catch(Exception e) {
        System.out.println("This is the execution"+e.getMessage());
    }

    return restaurant;
    }
@Override
    public Restaurant read(String ab){
        return this.repository.findById(ab).orElse(null);
    }

@Override
    public Restaurant update(Restaurant restaurant) {
        if(this.repository.existsById(restaurant.getRestaurantId())) {
            return this.repository.save(restaurant);
        }
        return null;
    }
@Override
    public boolean delete(String restaurantID) {
        this.repository.deleteById(restaurantID);
    return !this.repository.existsById(restaurantID);
    }

}
