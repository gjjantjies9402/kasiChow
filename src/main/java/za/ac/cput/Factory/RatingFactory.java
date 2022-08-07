/**
 * Mandisa Msongelwa
 * 217149073
 * Group 28
 */
package za.ac.cput.Factory;

import za.ac.cput.Entity.Rating;

public class RatingFactory {
    public static Rating createRating(String rateID, int orderNr, String rateStars, String rateReview) {

        return new Rating.Builder().setRateID(rateID)
                .setOrderNr(orderNr)
                .setRateStars(rateStars)
                .setRateReview(rateReview)
                .build();
    }
}
