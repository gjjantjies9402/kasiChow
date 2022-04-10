/**
 * Mandisa Msongelwa
 * 217149073
 * Group 28
 */
package za.ac.cput.Repository;

import za.ac.cput.Entity.menu;
import za.ac.cput.Entity.rating;
import za.ac.cput.Repository.Interface.ratingInterface;

import java.util.HashSet;
import java.util.Set;

public class ratingRepository implements ratingInterface {
    private static ratingRepository repository = null;
    private Set<rating> ratingsDb = null;

    private ratingRepository(){
        ratingsDb = new HashSet<rating>();
    }

    public static ratingRepository getRepository(){
        if (repository == null){
            repository = new ratingRepository();
        }
        return repository;
    }

    @Override
    public rating create(rating rates) {
        boolean success = ratingsDb.add(rates);
        if (!success)
            return null;

        return rates;
    }

    @Override
    public rating read(String id) {
        rating r = null;
            if (r.equals(ratingsDb))
   
        return r;
   
        return null;
    }

    @Override
    public rating update(rating rate ) {
        rating newRating = read(rate.getRateReview());

        if (newRating != null){
            ratingsDb.remove(newRating);
            ratingsDb.add(rate);
            return  rate;
        }
        return null;
    }

    @Override
    public boolean delete(String id) {
        rating delRating = read(id);

        if (delRating == null)
            return false;
        ratingsDb.remove(delRating);
        return true;
    }

    @Override
    public Set<rating> getAll() {
        return ratingsDb;
    }
}
