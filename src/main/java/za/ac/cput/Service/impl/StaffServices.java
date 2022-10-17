/**
 * Mziyanda Mwanda
 * 215133765
 * ADP 3
 * Service class implementation
 * */
package za.ac.cput.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.Entity.staff;
import za.ac.cput.Repository.Interface.staffInterface;
import za.ac.cput.Service.Interface.IStaff;

import java.util.Set;
import java.util.stream.Collectors;
@Service
public class StaffServices implements IStaff {

    @Autowired
    private static IStaff staffServices = null;
    private staffInterface staffrepository;


    @Override
    public staff create(staff staff) {
        return this.staffrepository.save(staff);
    }

    @Override
    public staff read(String s) {
        return this.staffrepository.findById(s).orElseGet(null);
    }

    @Override
    public staff update(staff staff) {
        return this.staffrepository.save(staff);
    }

    @Override
    public boolean delete(String s) {
        this.staffrepository.deleteById(s);
        if (this.staffrepository.existsById(s)){
            return false;
        }
        return true;

    }

    @Override
    public Set<staff> getAll() {
        return this.staffrepository.findAll().stream().collect(Collectors.toSet());
    }
}
