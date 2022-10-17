package za.ac.cput.Factory;

import za.ac.cput.Entity.Driver;
import za.ac.cput.util.Auth;

public class DriverFactory {
    public static Driver createId(String name) {
        String Id = Auth.generateId();

        Driver driver = new Driver.Builder()
                .setId(Id)
                .setName(name)
                .build();

        return driver;
    }
}
