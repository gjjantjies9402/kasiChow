///**
// * Mandisa Msongelwa
// * 217149073
// * Group 28
// */
//package za.ac.cput.Repository;
//
//import za.ac.cput.Entity.Rating;
//import za.ac.cput.Repository.Interface.RatingInterface;
//
//import java.util.HashSet;
//import java.util.Set;
//
//public class RatingRepository implements RatingInterface {
//    private static RatingRepository repository = null;
//    private Set<Rating> ratingsDb = null;
//
//    private RatingRepository(){
//        ratingsDb = new HashSet<Rating>();
//    }
//
//    public static RatingRepository getRepository(){
//        if (repository == null){
//            repository = new RatingRepository();
//        }
//        return repository;
//    }
//
//    @Override
//    public Rating create(Rating rates) {
//        boolean success = ratingsDb.add(rates);
//        if (!success)
//            return null;
//
//        return rates;
//    }
//
//    @Override
//    public Rating read(String id) {
//        Rating r = null;
//            if (r.equals(ratingsDb))
//
//        return r;
//
//        return null;
//    }
//
//    @Override
//    public Rating update(Rating rate ) {
//        Rating newRating = read(rate.getRateReview());
//
//        if (newRating != null){
//            ratingsDb.remove(newRating);
//            ratingsDb.add(rate);
//            return  rate;
//        }
//        return null;
//    }
//
//    @Override
//    public boolean delete(String id) {
//        Rating delRating = read(id);
//
//        if (delRating == null)
//            return false;
//        ratingsDb.remove(delRating);
//        return true;
//    }
//
//    @Override
//    public Set<Rating> getAll() {
//        return ratingsDb;
//    }
//}
