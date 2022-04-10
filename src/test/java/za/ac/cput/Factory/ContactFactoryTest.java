package za.ac.cput.Factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.Entity.Contact;


import static org.junit.jupiter.api.Assertions.*;

class ContactFactoryTest {

    @Test
    void createContact() {

        Contact contact = ContactFactory.createContact("153", "0832561497", "", "nosiviwenqakuqa@gmail.com");
        assertNotNull(contact);
        System.out.println("Contact Created: "+contact);
    }
}