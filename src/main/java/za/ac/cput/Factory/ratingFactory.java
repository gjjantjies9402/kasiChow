/**
 * Mandisa Msongelwa
 * 217149073
 * Group 28
 */
package za.ac.cput.Factory;

import za.ac.cput.Entity.rating;

import java.time.LocalDateTime;

public class ratingFactory {
    public static rating createRating(int rateID, int orderNr, String rateStars, String rateReview) {

        return new rating.Builder().setRateID(rateID)
                .setOrderNr(orderNr)
                .setRateStars(rateStars)
                .setRateReview(rateReview)
                .build();
    }
}
