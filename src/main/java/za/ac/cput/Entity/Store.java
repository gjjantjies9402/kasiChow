package za.ac.cput.Entity;

/**
 * Author: GAYNOR JANTJIES 213069555
 * POJO Store.java
 *  Store file to be implemented
 * Created: 9/04/2022
 * */



public class Store {


    private int storeId;
    private int supermarketId;
    private int marketId;


//    protected Store(){}

    private Store(Builder s) {
        this.storeId = s.storeId;
        this.supermarketId = s.supermarketId;
        this.marketId = s.marketId;
    }

    public int getStoreId() {
        return storeId;
    }

    public int getSupermarketId() {
        return supermarketId;
    }

    public int getMarketId() {
        return marketId;
    }

   @Override
    public java.lang.String toString() {
        return "Store{" +
                "storeId='" + storeId + '\'' +
                ", supermarketId=" + supermarketId +
                ", marketId=" + marketId +
                '}';
    }

    public static class Builder {

        private int storeId;
        private int supermarketId;
        private int marketId;

        public Builder setStoreId(int storeId) {
            this.storeId = storeId;
            return this;
        }

        public Builder setSupermarketId(int supermarketId) {
            this.supermarketId = supermarketId;
            return this;
        }
        public Builder setMarketId(int marketId) {
            this.marketId = marketId;
            return this;
        }


        public Builder copy(Store st) {
            this.storeId = st.storeId;
            this.supermarketId = st.supermarketId;
            this.marketId = st.marketId;

            return this;
        }

        public Store build() {
            return new Store(this);
        }
    }
}
