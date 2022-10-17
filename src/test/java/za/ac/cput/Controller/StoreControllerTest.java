package za.ac.cput.Controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import za.ac.cput.Entity.Store;
import za.ac.cput.Factory.StoreFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class StoreControllerTest {

   private static Store sto = StoreFactory.buildStore("012","KFC-023","SPAR-055" );


    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/store/";


    @Test
    public void a_created(){
        String url = baseURL + "create";
        ResponseEntity<Store> postResponse = restTemplate.postForEntity(url, sto, Store.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        sto = postResponse.getBody();
        System.out.println("Created data" + sto);
        assertNotNull(sto.getStoreId(), postResponse.getBody().getStoreId());
    }


    @Test
    public  void b_read(){
        String url = baseURL + "read/" + sto.getStoreId();
        System.out.println("URL: " + url);
        ResponseEntity<Store> storeResponse = restTemplate.getForEntity(url, Store.class);
        assertEquals(sto.getStoreId(), storeResponse.getBody().getStoreId());
    }

    @Test
    public  void  c_update(){
        Store updated = new Store.Builder().copy(sto).setStoreId("213069555").build();
        String url = baseURL + "update";
        System.out.println("URL" + url);
        System.out.println("Updated Data:" + updated);
        ResponseEntity<Store> storeResponse = restTemplate.postForEntity(url, updated, Store.class);
        assertEquals(sto.getStoreId(), storeResponse.getBody().getStoreId());
    }

    @Test
    public void d_getAll(){
        String url = baseURL + "all";
        System.out.println("URL: " + url);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> storeEntity = new HttpEntity<>(null, headers);
        ResponseEntity<String> storeResponse = restTemplate.exchange(url, HttpMethod.GET, storeEntity, String.class);
        System.out.println(storeResponse);
        System.out.println(storeResponse.getBody());
    }
    @Test
    public void e_delete(){
        String url = baseURL + "delete/" + sto.getStoreId();
        System.out.println("URL " + url);
        restTemplate.delete(url);
    }


}