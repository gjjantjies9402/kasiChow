package za.ac.cput.Service.Interface;

import za.ac.cput.Entity.Driver;
import za.ac.cput.Service.IService;

import java.util.Set;

public interface IDriverService extends IService<Driver, String> {
    Set<Driver> getAll();

    Set<Driver> getAllStartWithB();
}
