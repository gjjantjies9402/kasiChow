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
import za.ac.cput.Factory.CustomerFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CustomerControllerTest {

    private static Customer customer = CustomerFactory.createCustomer("21852", "Mandisa", "Msongelwa", "0789642013", "mandymsongelwa@gmail.com", "59 Grace Land Khayelitsha, Cape Town, 7500");

//    public static String ADMIN_USERNAME = "admin";
//    public static String ADMIN_PASSWORD = "password";

    @Autowired
    private TestRestTemplate restTemplate;
    private final String baseURL = "http://localhost:8090/customer";

    public static Customer getCustomer() {

        return customer;

    }

    public static void setCustomer(Customer customer) {

        CustomerControllerTest.customer = customer;
    }


    @Test
    void create() {

        String url = baseURL + "/create";
        ResponseEntity<Customer> postResponse = restTemplate.postForEntity(url, customer , Customer.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        customer = postResponse.getBody();
        System.out.println("Saved: " + customer);
        assertEquals(customer.getCustID(), postResponse.getBody().getCustID());

    }

    @Test
    void read() {

        String url = baseURL + "/read/" + customer.getCustID();
        System.out.println("URL: " + url);
        ResponseEntity<Customer> response = restTemplate.getForEntity(url, Customer.class);
        assertEquals(customer.getCustID(), response.getBody().getCustID());

    }

    @Test
    void update() {

        Customer update = new Customer.Builder().copy(customer).setPrimaryNr("0679654213").build();
        String url = baseURL + "/update";
        System.out.println("Updated: " + update);
        ResponseEntity<Customer> response = restTemplate.postForEntity(url, update, Customer.class);
        assertNotNull(response.getBody());

    }

    @Test
    void delete() {

        String url = baseURL + "/delete/" + customer.getCustID();
        System.out.println("URL: " + url);
        restTemplate.delete(url);

    }

    @Test
    void getAll() {

        String url = baseURL + "/getall/";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<Customer> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println("Display All: ");
        System.out.println(response);
        System.out.println(response.getBody());

    }
}