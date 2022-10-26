package za.ac.cput.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
/**
 Ratings.java
 Entity: Ratings
 Author: Zimkhitha Nkqenkqa 216280427
 Date: 10 April 2022
 */
@Entity
public class Ratings {
    @Id
    private int rateID;
    private String orderID;
    private int  rateScale;
    private String rateReview;

    public Ratings() {
    }

    private Ratings(Builder builder) {
        this.rateID = builder.rateID;
        this.orderID = builder.orderID;
        this.rateScale = builder.rateScale;
        this.rateReview = builder.rateReview;

    }

    public int getRateID() {
        return rateID;
    }

    public String getOrderID() {
        return orderID;
    }

    public int getRateScale() {
        return rateScale;
    }

    public String getRateReview() {
        return rateReview;
    }

    @Override
    public String toString() {
        return "Ratings{" +
                "rateID=" + rateID +
                ", orderID='" + orderID + '\'' +
                ", rateScale=" + rateScale +
                ", rateReview='" + rateReview + '\'' +
                '}';
    }

    public static class Builder {
        private int rateID;
        private String orderID;
        private int rateScale;
        private String rateReview;


        public Builder setRateID(int rateID) {
            this.rateID = rateID;
            return this;
        }

        public Builder setOrderID(String orderID) {
            this.orderID = orderID;
            return this;
        }

        public Builder setRateScale(int rateScale) {
            this.rateScale = rateScale;
            return this;
        }

        public Builder setRateReview(String rateReview) {
            this.rateReview = rateReview;
            return this;
        }

        public Builder copy(Ratings ratings) {
            this.rateID = ratings.rateID;
            this.orderID = ratings.orderID;
            this.rateScale = ratings.rateScale;
            this.rateReview = ratings.rateReview;
            return this;
        }

        public Ratings build() {
            return new Ratings(this);
        }
    }
}
