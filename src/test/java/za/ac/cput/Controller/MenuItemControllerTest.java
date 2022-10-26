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
import za.ac.cput.Entity.MenuItem;
import za.ac.cput.Entity.OrderItem;
import za.ac.cput.Factory.MenuItemFactory;
import za.ac.cput.Factory.OrderItemFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

class MenuItemControllerTest {

    private static MenuItem mItem = MenuItemFactory.createMenuItem("001", "Mains", "Beef Burger", 28.99);
    private static MenuItem mItem1 = MenuItemFactory.createMenuItem("039", "Refreshments", "Creme Soda", 18.99);
    private static MenuItem mItem2 = MenuItemFactory.createMenuItem("020", "Groceries", "Rice",128.99);

    @Autowired
    private TestRestTemplate restTemplate;
    private final String baseURL = "http://localhost:8090/menuItem/";

    public static MenuItem getMenuItem() {

        return mItem;
    }

    public static void setMenuItem(MenuItem menuItem) {
        MenuItemControllerTest.mItem = menuItem;
    }

    @Test
    public void create() {
        String url = baseURL + "/create";
        ResponseEntity<MenuItem> postResponse = restTemplate.postForEntity(url, mItem, MenuItem.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        mItem = postResponse.getBody();
        System.out.println("Created: " + mItem);
        assertEquals(mItem.getItemID(), postResponse.getBody().getItemID());
    }

    @Test
    public void read() {
        String url = baseURL + "/read/" + mItem.getItemID();
        System.out.println("URL: " + url);
        ResponseEntity<MenuItem> response = restTemplate.getForEntity(url, MenuItem.class);
        assertEquals(mItem.getItemID(), response.getBody().getItemID());
    }

    @Test
    public void update() {
        String url = baseURL + "update";
        MenuItem updated = new MenuItem.Builder().copy(mItem).setItemPrice(15.50).build();
        System.out.println("URL: " + url);
        System.out.println("Updated: " + updated);
        ResponseEntity<MenuItem> response = restTemplate.postForEntity(url, updated, MenuItem.class);
        assertNotNull(response.getBody());
    }

    @Test
    public void getAll() {
        String url = baseURL + "/getall/";
        System.out.println("URL: " + url);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> menuItemEntity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, menuItemEntity, String.class);
        System.out.println("Show All: ");
        System.out.println(response);
        System.out.println(response.getBody());
    }

    @Test
    public void delete() {
        String url = baseURL + "/delete/" + mItem1.getItemID();
        System.out.println("URL " + url);
        restTemplate.delete(url);
    }


}
//