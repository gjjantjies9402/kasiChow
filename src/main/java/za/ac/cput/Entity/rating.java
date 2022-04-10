/**
 * Mandisa Msongelwa
 * 217149073
 * Group 28
 */
package za.ac.cput.Entity;

public class rating {
    private int rateID;
    private int orderNr;
    private String rateStars;
    private String rateReview;


    //private constructor
    private rating(Builder builder) {
        this.rateID = builder.rateID;
        this.orderNr = builder.orderNr;
        this.rateStars = builder.rateStars;
        this.rateReview = builder.rateReview;
    }

    //Getters & Setters & toString


    public String getRateID() {
        return rateID;
    }

    public void setRateID(int rateID) {
        this.rateID = rateID;
    }

    public int getOrderNr() {
        return orderNr;
    }

    public void setOrderNr(int orderNr) {
        this.orderNr = orderNr;
    }

    public String getRateStars() {
        return rateStars;
    }

    public void setRateStars(String rateStars) {
        this.rateStars = rateStars;
    }

    public String getRateReview() {
        return rateReview;
    }

    public void setRateReview(String rateReview) {
        this.rateReview = rateReview;
    }


    @Override
    public String toString() {
        return "Rating{" +
                "rateID='" + rateID + '\'' +
                ", orderNr=" + orderNr +
                ", rateStars='" + rateStars + '\'' +
                ", rateReview='" + rateReview + '\'' +
                '}';
    }

    public static class Builder{
        private int rateID;
        private int orderNr;
        private String rateStars;
        private String rateReview;


        //Setters
        public Builder setRateID(int rateID) {
            this.rateID = rateID;
            return this;
        }

        public Builder setOrderNr(int orderNr) {
            this.orderNr = orderNr;
            return this;
        }

        public Builder setRateStars(String rateStars) {
            this.rateStars = rateStars;
            return this;
        }

        public Builder setRateReview(String rateReview) {
            this.rateReview = rateReview;
            return this;
        }



        Builder copy(rating rating) {
            this.rateID = rating.rateID;
            this.orderNr = rating.orderNr;
            this.rateStars = rating.rateStars;
            this.rateReview = rating.rateReview;
            return this;
        }

        public rating build() {
            return new rating(this);
        }
    }
}
