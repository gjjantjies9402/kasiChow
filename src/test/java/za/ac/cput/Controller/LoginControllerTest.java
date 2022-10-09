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
import za.ac.cput.Entity.login;
import za.ac.cput.Factory.loginFactory;

import static org.junit.jupiter.api.Assertions.*;

class LoginControllerTest {

    private static login loginB = loginFactory.createLogin("123456", "Mzi@gmail.com", "123456");

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/login/";

    @Test
    public void e_created(){
        String url = baseURL + "create";
        System.out.println("URL:" + url);
        System.out.println("Post data:" + loginB);
        ResponseEntity<login> postResponse = restTemplate.postForEntity(url, loginB, login.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        loginB = postResponse.getBody();
        System.out.println("saved data" + loginB);
        assertEquals(loginB.getId(), postResponse.getBody().getId());
    }

    @Test
    public void d_getAll(){
        String url = baseURL + "all";
        System.out.println("URL: " + url);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> loginEntity = new HttpEntity<>(null, headers);
        ResponseEntity<String> loginResponse = restTemplate.exchange(url, HttpMethod.GET, loginEntity, String.class);
        System.out.println(loginResponse);
        System.out.println(loginResponse.getBody());
    }

    @Test
    public  void c_read(){
        String url = baseURL + "read/" + loginB.getId();
        System.out.println("URL: " + url);
        ResponseEntity<login> loginResponse = restTemplate.getForEntity(url, login.class);
        assertEquals(loginB.getId(), loginResponse.getBody().getId());
    }

    @Test
    public  void  b_update(){
        login updated = new login.Builder().copy(loginB).setUsername("La@gmail.com").build();
        String url = baseURL + "update";
        System.out.println("URL" + url);
        System.out.println("Post data:" + updated);
        ResponseEntity<login> loginResponse = restTemplate.postForEntity(url, updated, login.class);
        assertEquals(loginB.getId(), loginResponse.getBody().getId());
    }

    @Test
    public void a_delete(){
        String url = baseURL + "delete/" + loginB.getId();
        System.out.println("URL " + url);
        restTemplate.delete(url);
    }

}