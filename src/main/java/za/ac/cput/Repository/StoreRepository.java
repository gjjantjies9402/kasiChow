//package za.ac.cput.Repository;
///**
// * Author: GAYNOR JANTJIES 213069555
// * Repository class for creating instances of Store.Class
// * Created: 10/04/2022
// * */
//import za.ac.cput.Entity.Store;
//import za.ac.cput.Repository.Interface.IStoreRepository;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class StoreRepository implements IStoreRepository {
//
//    private static StoreRepository storeRepository = null;
//    private List<Store> storeRepositoryDB = null;
//
//    private StoreRepository(){
//        storeRepositoryDB = new ArrayList<Store>();
//    }
//
//    public static StoreRepository getStoreRepository(){
//
//        if (storeRepository == null)
//            storeRepository = new StoreRepository();
//
//        return storeRepository;
//    }
//    @Override
//    public Store create(Store store) {
//        boolean created = storeRepositoryDB.add(store);
//        if(created)
//            return store;
//        else
//            return null;
//    }
//
//    @Override
//    public Store read(String storeId) {
//        for (Store sto:storeRepositoryDB) {
//            if (sto.getStoreId() == storeId)
//                return sto;
//        }
//        return null;
//    }
//
//    @Override
//    public Store update(Store s) {
//        Store oldStore = read(s.getStoreId());
//        if (oldStore != null){
//            storeRepositoryDB.remove(oldStore);
//            storeRepositoryDB.add(s);
//            return s;
//        }
//        return null;
//    }
//
//    @Override
//    public boolean delete(String storeId) {
//        Store delStore = read(storeId);
//        if (delStore == null)
//            return false;
//        storeRepositoryDB.remove(delStore);
//        return true;
//    }
//
//    @Override
//    public List<Store> getAll() {
//        return null;
//    }
//}
