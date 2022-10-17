package za.ac.cput.Repository;

//import java.util.HashSet;
//import java.util.Set;
//
//public class DriverRepositoryImpl implements DriverRepository {
//    private static DriverRepository repository = null;
//    private Set < Driver > driverDB;
//
//    private DriverRepositoryImpl() { this.driverDB = new HashSet<>();}
//
//    public static DriverRepository getRepository() {
//        if (repository == null) repository = new DriverRepositoryImpl();
//        return repository;
//    }
//
//    @Override
//    public Set< Driver > getAll() {
//        return driverDB;
//    }
//
//    @Override
//    public Driver create(Driver driver) {
//        this.driverDB.add(driver);
//        return driver;
//    }
//
//    @Override
//    public Driver read(String driverID) {
//        for (Driver driver: driverDB) {
//            if (driver.getId().equalsIgnoreCase(driverID))
//                return driver;
//        }
//        return null;
//    }
//
//    @Override
//    public Driver update(Driver driver) {
//        Driver read = read(driver.getId());
//        if (read != null) {
//            this.driverDB.remove(read);
//            this.driverDB.add(driver);
//            return driver;
//        }
//        return null;
//    }
//
//    @Override
//    public boolean delete(String driverID) {
//        Driver driver = read(driverID);
//        if (driver != null) {
//            this.driverDB.remove(driverID);
//            return true;
//        }
//        return false;
//    }
//}
