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

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class RestaurantServiceImpl implements RestaurantService {


   @Autowired
    private IRestaurantRepository repository;

    public Set<Restaurant> getAll(){
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }


//
//    public Restaurant getRestaurantId(String restaurantID) {
//        Restaurant ab = null;
//        Set<Restaurant> restaurants = getAll();
//        for(Restaurant restaurant : restaurants){
//            if(restaurant.getRestaurantId().equals(restaurantID)){
//                ab = restaurant;
//                break;
//            }
//        }
//        return ab;
//    }
@Override
    public Restaurant create(Restaurant enroll){
        return this.repository.save(enroll);
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
