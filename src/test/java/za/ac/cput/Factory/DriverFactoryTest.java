package za.ac.cput.Factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.Entity.Driver;

import static org.junit.jupiter.api.Assertions.*;

class DriverFactoryTest {

    @Test
    void createDriver() {

        Driver driver = DriverFactory.createDriver("753", "Siyalakha", "Bhotweni", "0785236941");
        assertNotNull(driver);
        System.out.println("Driver Created: "+driver);

    }
}