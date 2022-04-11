package za.ac.cput.Entity;

/**
 * Author: GAYNOR JANTJIES 213069555
 * POJO Store.java
 *  Store Entity file to be implemented
 * Created: 9/04/2022
 * */



public class Store {


    private String storeId;
    private String restaurantId;
    private String marketId;


//    protected Store(){}

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
