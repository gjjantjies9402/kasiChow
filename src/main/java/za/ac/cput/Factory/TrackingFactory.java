package za.ac.cput.Factory;
/**
 TrackingFactory.java
 TrackingFactory
 Author: Zimkhitha Nkqenkqa 216280427
 Date: 10 April 2022
 */

import za.ac.cput.Entity.Tracking;

public class TrackingFactory {
    public static Tracking createTracking(String orderNr, int trackETA, String trackStatus){
        return new Tracking.Builder().
                setOrderNr(orderNr).
                setTrackETA(trackETA).
                setTrackStatus(trackStatus).build();
    }

}