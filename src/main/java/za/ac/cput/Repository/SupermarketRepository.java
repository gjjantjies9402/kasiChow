package za.ac.cput.Repository;

import za.ac.cput.Entity.Supermarket;
import za.ac.cput.Repository.Interface.ISupermarketRepository;

import java.util.ArrayList;
import java.util.List;

public class SupermarketRepository implements ISupermarketRepository {

    private static SupermarketRepository supermarketRepository = null;
    private List<Supermarket> supermarketRepositoryDB = null;

    private SupermarketRepository(){
        supermarketRepositoryDB = new ArrayList<Supermarket>();
    }

    public static SupermarketRepository getSupermarketRepository(){

        if (supermarketRepository == null)
            supermarketRepository = new SupermarketRepository();

        return supermarketRepository;
    }
    @Override
    public Supermarket create(Supermarket market) {
        boolean created = supermarketRepositoryDB.add(market);
        if(created)
            return market;
        else
            return null;
    }

    @Override
    public Supermarket read(String marketId) {
        for (Supermarket mar:supermarketRepositoryDB) {
            if (mar.getMarketId() == marketId)
                return mar;
        }
        return null;
    }

    @Override
    public Supermarket update(Supermarket m) {
        Supermarket oldStore = read(m.getMarketId());
        if (oldStore != null){
            supermarketRepositoryDB.remove(oldStore);
            supermarketRepositoryDB.add(m);
            return m;
        }
        return null;
    }

    @Override
    public boolean delete(String marketId) {
        Supermarket delMarket = read(marketId);
        if (delMarket == null)
            return false;
        supermarketRepositoryDB.remove(delMarket);
        return true;
    }

    @Override
    public List<Supermarket> getAll() {
        return null;
    }
}
