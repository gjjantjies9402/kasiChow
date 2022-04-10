package za.ac.cput.Repository;
/**
 * Author: GAYNOR JANTJIES 213069555
 * Repository class for creating instances of Restaurant.Class
 * Created: 10/04/2022
 * */
import za.ac.cput.Entity.Restaurant;
import za.ac.cput.Repository.Interface.IRestaurantRepository;


import java.util.ArrayList;
import java.util.List;

public class RestaurantRepository implements IRestaurantRepository {

    private static RestaurantRepository restaurantRepository = null;
    private List<Restaurant> restaurantRepositoryDB = null;

    private RestaurantRepository(){
        restaurantRepositoryDB = new ArrayList<Restaurant>();
    }

    public static RestaurantRepository getRestaurantRepository(){

        if (restaurantRepository == null)
            restaurantRepository = new RestaurantRepository();

        return restaurantRepository;
    }
    @Override
    public Restaurant create(Restaurant restaurant) {
        boolean created = restaurantRepositoryDB.add(restaurant);
        if(created)
            return restaurant;
        else
            return null;
    }

    @Override
    public Restaurant read(String restaurantId) {
        for (Restaurant res:restaurantRepositoryDB) {
            if (res.getRestaurantId() == restaurantId)
                return res;
        }
        return null;
    }

    @Override
    public Restaurant update(Restaurant r) {
        Restaurant oldRestaurant = read(r.getRestaurantId());
        if (oldRestaurant != null){
            restaurantRepositoryDB.remove(oldRestaurant);
            restaurantRepositoryDB.add(r);
            return r;
        }
        return null;
    }

    @Override
    public boolean delete(String restaurantId) {
        Restaurant delRestaurant = read(restaurantId);
        if (delRestaurant == null)
            return false;
        restaurantRepositoryDB.remove(delRestaurant);
        return true;
    }

    @Override
    public List<Restaurant> getAll() {
        return null;
    }
}
