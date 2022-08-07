package za.ac.cput.Entity;


import java.io.Serializable;
import java.util.Objects;

public class StoreRestMarketID implements Serializable {

    private String storeId, restaurantId, marketId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StoreRestMarketID that = (StoreRestMarketID) o;
        return storeId.equals(that.storeId) && restaurantId.equals(that.restaurantId) && marketId.equals(that.marketId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(storeId, restaurantId, marketId);
    }
}
