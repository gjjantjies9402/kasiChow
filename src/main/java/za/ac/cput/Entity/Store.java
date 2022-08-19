package za.ac.cput.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

/**
 * Author: GAYNOR JANTJIES 213069555
 * POJO Store.java
 *  Store Entity file to be implemented
 * Created: 9/04/2022
 * Modified : 07/08/2022
 * add the entity to database
 * establish a connection to db
 * */


@Entity
@IdClass(StoreRestMarketID.class)
public class Store {

    @Id
    private String storeId, restaurantId, marketId;


    protected Store(){}

    private Store(Builder s) {
        this.storeId = s.storeId;
        this.restaurantId = s.restaurantId;
        this.marketId = s.marketId;
    }

    public String getStoreId() {
        return storeId;
    }

    public String getRestaurantId() {
        return restaurantId;
    }

    public String getMarketId() {
        return marketId;
    }

   public java.lang.String toString() {
        return "Store{" +
                "storeId='" + storeId + '\'' +
                ", restaurantId=" + restaurantId +
                ", marketId=" + marketId +
                '}';
    }

    public static class Builder {

        private String storeId;
        private String restaurantId;
        private String marketId;

        public Builder setStoreId(String storeId) {
            this.storeId = storeId;
            return this;
        }

        public Builder setRestaurantId(String restaurantId) {
            this.restaurantId = restaurantId;
            return this;
        }
        public Builder setMarketId(String marketId) {
            this.marketId = marketId;
            return this;
        }


        public Builder copy(Store st) {
            this.storeId = st.storeId;
            this.restaurantId = st.restaurantId;
            this.marketId = st.marketId;

            return this;
        }

        public Store build() {
            return new Store(this);
        }
    }
}
