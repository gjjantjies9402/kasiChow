/**
 * Mziyanda Mwanda
 * 215133765
 * ADP 3
 * Controller class Test implementation
 * */

package za.ac.cput.Controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import za.ac.cput.Entity.registration;
import za.ac.cput.Factory.registrationFactory;

import static org.junit.jupiter.api.Assertions.*;

class RegistrationControllerTest {

    private static registration register = registrationFactory.createRegistration("Tom","Anele","tomA@gmail.com", "12345", "1235","tomA@gmail.com");

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/restaurant/";

    @Test
    public void a_created(){
        String url = baseURL + "create";
        ResponseEntity<registration> postResponse = restTemplate.postForEntity(url, register, registration.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        register = postResponse.getBody();
        System.out.println("Created data" + register);
        assertNotNull(register.getFirstName(), postResponse.getBody().getFirstName());
    }


    @Test
    public  void b_read(){
        String url = baseURL + "read/" + register.getFirstName();
        System.out.println("URL: " + url);
        ResponseEntity<registration> restaurantResponse = restTemplate.getForEntity(url, registration.class);
        assertEquals(register.getFirstName(), restaurantResponse.getBody().getFirstName());
    }

    @Test
    public  void  c_update(){
        String url = baseURL + "update";
        registration updated = new registration.Builder().copy(register).setFirstName("Luvo").build();
        System.out.println("URL: " + url);
        System.out.println("Updated Data: " + updated);
        ResponseEntity<registration> registrationResponse = restTemplate.postForEntity(url, updated, registration.class);
        assertNotNull(register.getFirstName(), registrationResponse.getBody().getFirstName());

    }


    @Test
    public void d_getAll(){
        String url = baseURL + "all";
        System.out.println("URL: " + url);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> registerEntity = new HttpEntity<>(null, headers);
        ResponseEntity<String> registerResponse = restTemplate.exchange(url, HttpMethod.GET, registerEntity, String.class);
        System.out.println(registerResponse);
        System.out.println(registerResponse.getBody());
    }
    @Test
    public void e_delete(){
        String url = baseURL + "delete/" + register.getFirstName();
        System.out.println("URL " + url);
        restTemplate.delete(url);
    }

}