package za.ac.cput.Factory;

import za.ac.cput.Entity.Supermarket;

/**
 * Author: GAYNOR JANTJIES 213069555
 * Factory class for creating instances of Supermarket.Class
 * Created: 9/04/2022
 * */
public class SupermarketFactory {

    public static Supermarket buildSupermarket(String marketId, String marketName, String marketLocation)

    {

        Supermarket supermarket = new Supermarket.Builder()
                .setMarketId(marketId)
                .setMarketName(marketName)
                .setMarketLocation(marketLocation)
                .build();


        return supermarket;
    }

}
