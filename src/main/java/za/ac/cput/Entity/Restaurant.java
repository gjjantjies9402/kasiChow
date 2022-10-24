package za.ac.cput.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/*
 * Author: GAYNOR JANTJIES 213069555
 * POJO Restaurant.java
 *  Restaurant Entity file to be implemented
 * Created: 9/04/2022
 *  * Modified : 07/08/2022
 *  * add the entity to database
 *  * establish a connection to db
 * */
@Entity
public class Restaurant {
    @Id
    private String restaurantId;
    private String restaurantName;
    private String restaurantLocation;

    public Restaurant(){}

    private Restaurant(Restaurant.Builder rs){

        this.restaurantId = rs.restaurantId;
        this.restaurantName = rs.restaurantName;
        this.restaurantLocation = rs.restaurantLocation;
    }

    public String getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(String restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getRestaurantLocation() {
        return restaurantLocation;
    }

    public void setRestaurantLocation(String restaurantLocation) {
        this.restaurantLocation = restaurantLocation;
    }

    public String toString() {
        return "Builder{" +
                "restaurantId=" + restaurantId +
                ", restaurantName='" + restaurantName + '\'' +
                ", restaurantLocation='" + restaurantLocation + '\'' +
                '}';
    }


    public static class Builder {


        private String restaurantId;
        private String restaurantName;
        private String restaurantLocation;



        public Builder setRestaurantId(String restaurantId) {
            this.restaurantId = restaurantId;
            return this;
        }
        public Builder setRestaurantName(String restaurantName) {
            this.restaurantName = restaurantName;
            return this;
        }
        public Builder setRestaurantLocation(String restaurantLocation) {
            this.restaurantLocation = restaurantLocation;
            return this;
        }


        public Builder copy(Restaurant r){
            this.restaurantId = r.restaurantId;
            this.restaurantName = r.restaurantName;
            this.restaurantLocation = r.restaurantLocation;

            return this;
        }

        public Restaurant build() {
            return new Restaurant(this);
        }


    }
}
