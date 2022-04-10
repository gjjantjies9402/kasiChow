package za.ac.cput.Repository;

import za.ac.cput.Entity.login;
import za.ac.cput.Repository.Interface.loginInterface;

import java.util.HashSet;
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
}
