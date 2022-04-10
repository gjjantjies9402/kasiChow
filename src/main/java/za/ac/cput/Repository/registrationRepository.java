package za.ac.cput.Repository;

import za.ac.cput.Entity.registration;
import za.ac.cput.Repository.Interface.registrationInterface;

import java.util.HashSet;
import java.util.Set;

public class registrationRepository implements registrationInterface {
    private static registrationRepository regRepository = null;
    private Set<registration> registrationDB = null;

    private registrationRepository(){
        registrationDB = new HashSet<registration>();
    }

    public static registrationRepository getRegRepository(){
        if (regRepository == null){
            regRepository = new registrationRepository();
        }
        return regRepository;
    }

    @Override
    public registration create(registration registration) {
        boolean  created = registrationDB.add(registration);
        if (!created)
        return null;

        return registration;
    }

    @Override
    public registration read(String s) {
      for (registration r : registrationDB) {
         if (r.getFirstName().equals(s))
         return r;
         }
         return null;
    }

    @Override
    public registration update(registration registration) {
        registration updateRegistration = read(registration.getFirstName());

        if (updateRegistration != null){
            registrationDB.remove(updateRegistration);
            registrationDB.add(registration);
            return registration;
        }
        return null;
    }

    @Override
    public boolean delete(String s) {
        registration registrationDeleted = read(s);

        if (registrationDeleted == null)
        return false;
        registrationDB.remove(registrationDeleted);
        return true;
    }

    @Override
    public Set<registration> getAll() {
        return registrationDB;
    }

    public static class RestaurantRepository {
    }
}
