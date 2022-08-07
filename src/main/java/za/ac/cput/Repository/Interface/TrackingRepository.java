package za.ac.cput.Repository.Interface;
/**
 TrackingRepository.java
 TrackingRepository
 Author: Zimkhitha Nkqenkqa 216280427
 Date: 10 April 2022
 */

import za.ac.cput.Entity.Tracking;

import java.util.HashSet;
import java.util.Set;


public class TrackingRepository implements ITrackingRepository {
    private static TrackingRepository trackingRepository = null;
    private Set<Tracking> trackingRepositoryDB = null;

    private TrackingRepository() {
        trackingRepositoryDB = new HashSet<Tracking>();
    }

    public static TrackingRepository getRepository() {
        if (trackingRepository == null) {
            trackingRepository = new TrackingRepository();
        }
        return trackingRepository;
    }

    @Override
    public Set<Tracking> getAll() {
        return trackingRepositoryDB;
    }

    @Override
    public Tracking create(Tracking tracking) {
        boolean success = trackingRepositoryDB.add(tracking);
        if (!success)
            return null;
        return tracking;
    }

    @Override
    public Tracking read(String s) {
        Tracking tracking = trackingRepositoryDB.stream()
                .filter(e -> e.getOrderNr().equals(s))
                .findAny()
                .orElse(null);
        return tracking;
    }

    @Override
    public Tracking update(Tracking tracking) {
        Tracking prvTracking = read(tracking.getOrderNr());
        if (prvTracking != null) {
            trackingRepositoryDB.remove(prvTracking);
            trackingRepositoryDB.add(tracking);
            return tracking;
        }
        return null;
    }

    @Override
    public boolean delete(String s) {
        Tracking customerToDelete = read(s);
        if(customerToDelete == null)
            return false;
        trackingRepositoryDB.remove(customerToDelete);
        return true;
    }
}
