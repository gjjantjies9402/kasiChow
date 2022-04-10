package za.ac.cput.Repository;

import za.ac.cput.Entity.Store;
import za.ac.cput.Entity.login;
import za.ac.cput.Repository.Interface.IStoreRepository;
import za.ac.cput.Repository.Interface.loginInterface;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class loginRepository implements loginInterface {
    private static loginRepository repository = null;
    private Set<login> loginDB = null;

    private loginRepository(){
        loginDB = new HashSet<login>();
    }

    public static loginRepository getRepository(){
        if (repository == null){
            repository = new loginRepository();
        }
        return repository;
    }
    @Override
    public login create(login login) {
        boolean success = loginDB.add(login);
        if (!success)
            return null;

        return login;
    }

    @Override
    public login read(String id) {
       login log = loginDB.stream()
               .filter(l -> l.getId().equals(id))
               .findAny()
               .orElse(null);
       return log   ;
    }

    @Override
    public login update(login login ) {
        login oldLogin = read(login.getUsername());

        if (oldLogin != null){
            loginDB.remove(oldLogin);
            loginDB.add(login);
            return  login;
        }
        return null;
    }

    @Override
    public boolean delete(String id) {
        login loginDelete = read(id);

        if (loginDelete == null)
        return false;
        loginDB.remove(loginDelete);
        return true;
    }

    @Override
    public Set<login> getAll() {
        return loginDB;
    }

    public static class StoreRepository implements IStoreRepository {

        private static StoreRepository storeRepository = null;
        private List<Store> storeRepositoryDB = null;

        private StoreRepository(){
            storeRepositoryDB = new ArrayList<Store>();
        }

        public static StoreRepository getStoreRepository(){

            if (storeRepository == null)
                storeRepository = new StoreRepository();

            return storeRepository;
        }
    @Override
        public Store create(Store store) {
            boolean created = storeRepositoryDB.add(store);
            if(created)
                return store;
            else
                return null;
        }

    @Override
        public Store read(String storeId) {
            for (Store sto:storeRepositoryDB) {
                if (sto.getStoreId() == storeId)
                    return sto;
            }
            return null;
        }

    @Override
        public Store update(Store s) {
            Store oldStore = read(s.getStoreId());
            if (oldStore != null){
                storeRepositoryDB.remove(oldStore);
                storeRepositoryDB.add(s);
                return s;
            }
            return null;
        }

    @Override
        public boolean delete(String storeId) {
            Store delStore = read(storeId);
            if (delStore == null)
                return false;
            storeRepositoryDB.remove(delStore);
            return true;
        }

        @Override
        public List<Store> getAll() {
            return null;
        }
    }
}
