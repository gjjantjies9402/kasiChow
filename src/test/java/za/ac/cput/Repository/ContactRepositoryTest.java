
/*
package za.ac.cput.Repository;

import org.junit.jupiter.api.Test;
import za.ac.cput.Entity.Contact;
import za.ac.cput.Factory.ContactFactory;

import static org.junit.jupiter.api.Assertions.*;

class ContactRepositoryTest {

    private static ContactRepository repository = ContactRepository.getRepository();

    private static Contact contact = ContactFactory.createContact("2135", "07156984230", "0815324691", "zekhethelo@gmail.com");
    private static Contact contact2 = ContactFactory.createContact("832", "073582462830", "0832256391", "lucas.brown@gmail.com");
    private static Contact contact3 = ContactFactory.createContact("053", "067152822830", "07852523391", "angelicastephan@gmail.com");



    @Test
    void a_create() {

        Contact created = repository.create(contact);
        Contact created2 = repository.create(contact3);
        assertNotEquals(created.getContID(), created2.getContID());
        System.out.println("Created: " + created);
        System.out.println("Created: " + created2);
    }

    @Test
    void b_read() {

        Contact read = repository.read(contact3.getContID());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void c_update() {

        Contact update = new Contact.Builder().copy(contact2).setPrimaryNr("0788446269").build();
        assertNotNull(repository.update(update));
        System.out.println("Updated:" + update);

    }

    @Test
    void d_delete() {

        boolean success = repository.delete(contact.getContID());
        assertTrue(success);
        System.out.println("Deleted:" + success);
    }

    @Test
    void e_getAll() {

        System.out.println("Display All: ");
        System.out.println(repository.getAll());
    }
}*/

//package za.ac.cput.Repository;
//
//import org.junit.jupiter.api.Test;
//import za.ac.cput.Entity.Contact;
//import za.ac.cput.Factory.ContactFactory;
//import za.ac.cput.Repository.Interface.IContactRepository;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@Deprecated
//class ContactRepositoryTest {
//
//    private static IContactRepository repository;
//
//    private static Contact contact = ContactFactory.createContact("2135", "07156984230", "0815324691", "zekhethelo@gmail.com");
//    private static Contact contact2 = ContactFactory.createContact("832", "073582462830", "0832256391", "lucas.brown@gmail.com");
//    private static Contact contact3 = ContactFactory.createContact("053", "067152822830", "07852523391", "angelicastephan@gmail.com");
//
//
//
//    @Test
//    void a_create() {
//
//        Contact created = repository.save(contact);
//        Contact created2 = repository.save(contact3);
//        assertNotEquals(created.getContID(), created2.getContID());
//        System.out.println("Created: " + created);
//        System.out.println("Created: " + created2);
//    }
//
//    @Test
//    void b_read() {
//
//        Contact read = repository.rea
//
//       /* Contact read = repository.read(contact3.getContID());
//        assertNotNull(read);
//        System.out.println("Read: " + read);*/
//    }
//
//    @Test
//    void c_update() {
//
//        Contact update = new Contact.Builder().copy(contact2).setPrimaryNr("0788446269").build();
//        assertNotNull(repository.update(update));
//        System.out.println("Updated:" + update);
//
//    }
//
//    @Test
//    void d_delete() {
//
//        boolean success = repository.delete(contact.getContID());
//        assertTrue(success);
//        System.out.println("Deleted:" + success);
//    }
//
//    @Test
//    void e_getAll() {
//
//        System.out.println("Display All: ");
//        System.out.println(repository.getAll());
//    }
//}

