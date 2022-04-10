/**
 * Mziyanda Mwanda
 * 2133765
 * ADP 3
 *Assignment 1
 * Due date
 * 10 Aprile 2022
 * Repository
 * Staff
 * **/
package za.ac.cput.Repository;

import za.ac.cput.Entity.staff;
import za.ac.cput.Repository.Interface.staffInterface;

import java.util.HashSet;
import java.util.Set;

public class staffRepository implements staffInterface {
    private static staffRepository stRepository  = null;
    private Set<staff> staffDb = null;

    private staffRepository(){
        staffDb = new HashSet<>();
    }

    public static staffRepository getStRepository(){
        if (stRepository == null){
            stRepository = new staffRepository();
        }
        return stRepository;
    }

    @Override
    public staff create(staff staff) {
        boolean created = staffDb.add(staff);
        if(!created)
        return null;

        return staff;
    }

    @Override
    public staff read(String id) {
        staff st = staffDb.stream()
                .filter(s -> s.getAdminName().equals(id))
                .findAny()
                .orElse(null);
        return st;
    }

    @Override
    public staff update(staff staff) {
        staff updated = read(staff.getAdminName());

        if (updated != null){
             staffDb.remove(updated);
             staffDb.add(staff);

             return staff;
        }
        return null;
    }

    @Override
    public boolean delete(String id) {
        staff staffDelete = read(id);

        if (staffDelete == null)
        return false;
        staffDb.remove(staffDelete);
        return true;
    }

    @Override
    public Set<staff> getAll() {
        return staffDb;
    }
}

