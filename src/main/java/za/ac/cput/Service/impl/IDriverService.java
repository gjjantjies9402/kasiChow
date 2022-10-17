package za.ac.cput.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.Entity.Driver;
import za.ac.cput.Factory.DriverFactory;
import za.ac.cput.Repository.Interface.DriverRepository;

import java.util.HashSet;
import java.util.Set;

@Service
public class IDriverService implements za.ac.cput.Service.Interface.IDriverService {

    private static za.ac.cput.Service.Interface.IDriverService service = null;
    @Autowired
    private DriverRepository repository;


    public static za.ac.cput.Service.Interface.IDriverService getService() {
        if (service == null) service = new IDriverService();
        return service;
    }

    @Override
    public Set<Driver> getAll() {
        return new HashSet<>(this.repository.findAll());
    }

    @Override
    public Set<Driver> getAllStartWithB() {
        Set<Driver> drivers = getAll();
        Set<Driver> driversWithB = new HashSet<>();
        for (Driver driver : drivers) {
            if (driver.getName().trim().toLowerCase().startsWith("b")) {
                driversWithB.add(driver);
            }
        }
        return driversWithB;
    }

    @Override
    public Driver create(Driver driver) {
        Driver newDriver = DriverFactory.createId(driver.getName());
        return this.repository.save(newDriver);
    }

    @Override
    public Driver read(String s) {
        return this.repository.findById(s).orElse(null);
    }

    @Override
    public Driver update(Driver driver) {
        if (this.repository.existsById(driver.getId()))
            return this.repository.save(driver);
        return null;
    }

    @Override
    public boolean delete(String s) {
        if (s != null) {
            this.repository.deleteById(s);
            return true;
        }
        return false;
    }
}
