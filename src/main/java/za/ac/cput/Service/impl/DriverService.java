package za.ac.cput.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.Entity.Driver;
import za.ac.cput.Repository.Interface.IDriverRepository;
import za.ac.cput.Service.Interface.IDriverService;

import java.util.List;
import java.util.Optional;

@Service
public class DriverService implements IDriverService {

    private static IDriverService driverService = null;

    @Autowired
    private IDriverRepository driverRepository;

    private DriverService()
    {


    }

//    public static IDriverService getDriverService() {
//
//        if(driverService == null)
//            driverService = new DriverService();
//        return driverService;
//
//    }
    @Override
    public Driver create(Driver driver) {
        try {
            return this.driverRepository.save(driver);
        }catch(Exception e) {
            System.out.println("This is the execution"+e.getMessage());
        }

        return driver;
    }

    @Override
    public Driver read(String s) {
        Optional<Driver> optDriver = this.driverRepository.findById(s);
        return optDriver.orElse(null);
    }

    @Override
    public Driver update(Driver driver) {
        if (this.driverRepository.existsById(driver.getDriverID())) {
            return this.driverRepository.save(driver);
        }

        return null;
    }

    @Override
    public boolean delete(String s) {

        this.driverRepository.deleteById(s);

        return !this.driverRepository.existsById(s);

    }

    @Override
    public List<Driver> getAll() {
        return this.driverRepository.findAll();
    }
}
