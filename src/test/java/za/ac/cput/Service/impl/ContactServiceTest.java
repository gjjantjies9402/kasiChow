package za.ac.cput.Service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.Entity.Contact;
import za.ac.cput.Factory.ContactFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class ContactServiceTest {

    private static ContactService service = ContactService.getContactService();

    private static Contact contact = ContactFactory.createContact("4525", "0793621456", "0732148963", "sibumake@gmail.com");

    private static Contact contact2 = ContactFactory.createContact("7895", "0618932478", "0678932145", "zbulwana@outlook.com");

    private static Contact contact3 = ContactFactory.createContact("1234", "0836547890", "0662148963", "lisaxhamela@gmail.com");

    @Test
    void getService() {

        ContactService contactService = ContactService.getContactService();

    }

    @Test
    void create() {

        Contact created = service.create(contact2);
        assertEquals(created.getContID(), contact2.getContID());
        System.out.println("Create: " + created);

    }


    @Test
    void read() {

        Contact cont = service.read(contact.getPrimaryNr());
        assertNotNull(cont);
        System.out.println("Read: " + cont);

    }

    @Test
    void update() {

        Contact updated = new Contact.Builder().copy(contact3).setSecondaryNr("0669660059").build();
        assertNotNull(service.update(updated));
        System.out.println("Update: " + updated);

    }

    @Test
    void delete() {

        boolean success = service.delete(contact.getContID());
        assertTrue (success);
        System.out.println("Delete: " + success);

    }

    @Test
    void getAllContacts() {

        System.out.println("Contacts: ");
        System.out.println(service.getAllContacts());

    }

}