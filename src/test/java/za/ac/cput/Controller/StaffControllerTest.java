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
import za.ac.cput.Entity.staff;
import za.ac.cput.Factory.registrationFactory;
import za.ac.cput.Factory.staffFactory;

import static org.junit.jupiter.api.Assertions.*;

class StaffControllerTest {

    private static staff staffs = staffFactory.createStaff("Clive","leon","John");

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/restaurant/";

    @Test
    public void a_created(){
        String url = baseURL + "create";
        ResponseEntity<staff> postResponse = restTemplate.postForEntity(url, staffs, staff.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        staffs = postResponse.getBody();
        System.out.println("Created data" + staffs);
        assertNotNull(staffs.getAdminName(), postResponse.getBody().getAdminName());
    }


    @Test
    public  void b_read(){
        String url = baseURL + "read/" + staffs.getAdminName();
        System.out.println("URL: " + url);
        ResponseEntity<staff> staffResponse = restTemplate.getForEntity(url, staff.class);
        assertEquals(staffs.getAdminName(), staffResponse.getBody().getAdminName());
    }

    @Test
    public  void  c_update(){
        String url = baseURL + "update";
        staff updated = new staff.Builder().copy(staffs).setAdminName("shaun").build();
        System.out.println("URL: " + url);
        System.out.println("Updated Data: " + updated);
        ResponseEntity<staff> staffResponse = restTemplate.postForEntity(url, updated, staff.class);
        assertNotNull(staffs.getAdminName(),staffResponse.getBody().getAdminName());

    }


    @Test
    public void d_getAll(){
        String url = baseURL + "all";
        System.out.println("URL: " + url);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> staffEntity = new HttpEntity<>(null, headers);
        ResponseEntity<String>staffResponse = restTemplate.exchange(url, HttpMethod.GET, staffEntity, String.class);
        System.out.println(staffResponse);
        System.out.println(staffResponse.getBody());
    }
    @Test
    public void e_delete(){
        String url = baseURL + "delete/" + staffs.getAdminName();
        System.out.println("URL " + url);
        restTemplate.delete(url);
    }

}