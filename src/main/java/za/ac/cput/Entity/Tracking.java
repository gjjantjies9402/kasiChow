package za.ac.cput.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
/**
 Tracking.java
 Entity: Tracking
 Author: Zimkhitha Nkqenkqa 216280427
 Date: 10 April 2022
 */
@Entity
public class Tracking {
    @Id
    private int  trackETA;
    private String trackStatus, orderNr;

    private Tracking(Builder builder) {
        this.orderNr = builder.orderNr;
        this.trackETA = builder.trackETA;
        this.trackStatus = builder.trackStatus;
    }

    public Tracking() {

    }

    public String getOrderNr() {
        return orderNr;
    }

    public int getTrackETA() {
        return trackETA;
    }

    public String isTrackStatus() {
        return trackStatus;
    }

    @Override
    public String toString() {
        return "Tracking{" +
                "orderNr=" + orderNr +
                ", trackETA=" + trackETA +
                ", trackStatus=" + trackStatus +
                '}';
    }

    public static class Builder {
        private String orderNr;
        private int trackETA;
        private String trackStatus;


        public Builder setOrderNr(String orderNr) {
            this.orderNr = orderNr;
            return this;
        }

        public Builder setTrackETA(int trackETA) {
            this.trackETA = trackETA;
            return this;
        }

        public Builder setTrackStatus(String trackStatus) {
            this.trackStatus = trackStatus;
            return this;
        }

        public Builder copy(Tracking tracking) {
            this.orderNr = tracking.orderNr;
            this.trackETA = tracking.trackETA;
            this.trackStatus = tracking.trackStatus;
            return this;
        }

        public Tracking build() {
            return new Tracking(this);
        }
    }
}
