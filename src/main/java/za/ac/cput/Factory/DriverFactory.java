package za.ac.cput.Factory;


import za.ac.cput.Entity.Driver;
import za.ac.cput.util.Auth;

public class DriverFactory {

    public static Driver createDriver(String driverID, String driverFname, String driverLname, String driverContact){

        if (Auth.isNullorEmpty(driverID) ||Auth.isNullorEmpty(driverFname) || Auth.isNullorEmpty(driverLname) || Auth.isNullorEmpty(driverContact))
            return null;

        return new Driver.Builder()
                .setDriverID(driverID)
                .setDriverFname(driverFname)
                .setDriverLname(driverLname)
                .setDriverContact(driverContact)
                .build();

    }

}
