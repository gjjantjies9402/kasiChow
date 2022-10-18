package za.ac.cput.Controller;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import za.ac.cput.Entity.Customer;
import za.ac.cput.Entity.Driver;
import za.ac.cput.Factory.DriverFactory;

import static org.junit.jupiter.api.Assertions.*;


@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DriverControllerTest {

    private static Driver driver = DriverFactory.createDriver("25896", "Luzuko", "Bhedengu", "0785214935");

    @Autowired
    private TestRestTemplate restTemplate;
    private final String baseURL = "http://localhost:8090/driver";

    public static Driver getDriver() {

        return driver;

    }

    public static void setDriver(Driver driver) {

        DriverControllerTest.driver = driver;
    }

    @Test
    void create() {

        String url = baseURL + "/create";
        ResponseEntity<Driver> postResponse = restTemplate.postForEntity(url, driver , Driver.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        driver = postResponse.getBody();
        System.out.println("Saved: " + driver);
        assertEquals(driver.getDriverID(), postResponse.getBody().getDriverID());

    }

    @Test
    void read() {

        String url = baseURL + "/read/" + driver.getDriverID();
        System.out.println("URL: " + url);
        ResponseEntity<Driver> response = restTemplate.getForEntity(url, Driver.class);
        assertEquals(driver.getDriverID(), response.getBody().getDriverID());

    }

    @Test
    void update() {

        Driver update = new Driver.Builder().copy(driver).setDriverContact("0619654213").build();
        String url = baseURL + "/update";
        System.out.println("Updated: " + update);
        ResponseEntity<Driver> response = restTemplate.postForEntity(url, update, Driver.class);
        assertNotNull(response.getBody());

    }

    @Test
    void delete() {

        String url = baseURL + "/delete/" + driver.getDriverID();
        System.out.println("URL: " + url);
        restTemplate.delete(url);

    }

    @Test
    void getAll() {

        String url = baseURL + "/getall/";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<Driver> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println("Display All: ");
        System.out.println(response);
        System.out.println(response.getBody());

    }
}