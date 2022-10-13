package za.ac.cput.Repository.Interface;
/**
 RatingsRepository.java
 TrackingRepository
 Author: Zimkhitha Nkqenkqa 216280427
 Date: 10 April 2022
 */


//public class RatingsRepository implements IRatingsRepository {
//    private static RatingsRepository ratingsRepository = null;
//    private Set<Ratings> ratingsRepositoryDB = null;
//
//    private TrackingRepository() {
//        ratingsRepositoryDB = new HashSet<Ratings>();
//    }
//
//    public static TrackingRepository getRepository() {
//        if (ratingsRepository == null) {
//            ratingsRepository = new ratingsRepository();
//        }
//        return ratingsRepository;
//    }
//
//    @Override
//    public Set<Ratings> getAll() {
//        return ratingsRepositoryDB;
//    }
//
//    @Override
//    public Ratings create(Ratings ratings) {
//        boolean success = ratingsRepositoryDB.add(ratings);
//        if (!success)
//            return null;
//        return Ratings;
//    }
//
//    @Override
//    public Ratings read(String s) {
//        Ratings ratings = ratingsRepositoryDB.stream()
//                .filter(e -> e.getOrderID().equals(s))
//                .findAny()
//                .orElse(null);
//        return Ratings;
//    }
//
//    @Override
//    public Ratings update(Ratings ratings) {
//        Ratings prvRatings = read(ratings.getOrderID());
//        if (prvRatings != null) {
//            ratingsRepositoryDB.remove(prvRatings);
//            ratingsRepositoryDB.add(ratings);
//            return Ratings;
//        }
//        return null;
//    }
//
//    @Override
//    public boolean delete(String s) {
//        Ratings customerToDelete = read(s);
//        if(customerToDelete == null)
//            return false;
//        ratingsRepositoryDB.remove(customerToDelete);
//        return true;
//    }
//}
