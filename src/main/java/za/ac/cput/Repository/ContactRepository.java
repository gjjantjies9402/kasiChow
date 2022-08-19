/*ContactRepository.java
Repository for Contact
Author: Kanya Ramncwana (218297521)
Date: 09 April 2022*//*


package za.ac.cput.Repository;

import za.ac.cput.Entity.Contact;
import za.ac.cput.Repository.Interface.ContactInterface;

import java.util.HashSet;
import java.util.Set;

public class ContactRepository implements ContactInterface {


    private static ContactRepository repository = null;
    private Set<Contact> contactDB;

    private ContactRepository() {

        contactDB = new HashSet<Contact>();

    }

    public static ContactRepository getRepository(){
        if (repository == null)
        {
            repository = new ContactRepository();
        }
        return repository;
    }


    @Override
    public Contact create(Contact contact) {

        boolean success = contactDB.add(contact);
        if (!success)
            return null;
        return contact;

    }

    @Override
    public Contact read(String id) {
        Contact contact = contactDB.stream()
                .filter(c -> c.getContID().equals(id))
                . findAny()
                .orElse(null);

        return contact;
    }

    @Override
    public Contact update(Contact contact) {

        Contact prevCont = read(contact.getContID());

        if (prevCont != null)
        {
            contactDB.remove(prevCont);
            contactDB.add(contact);

            return contact;
        }

        return  contact;
    }

    @Override
    public boolean delete(String id) {

        Contact contactDelete = read(id);

        if(contactDelete == null)
            return  false;
        contactDB.remove(contactDelete);
        return  true;

    }

    @Override
    public Set<Contact> getAll() {
        return contactDB;
    }
}
*/
