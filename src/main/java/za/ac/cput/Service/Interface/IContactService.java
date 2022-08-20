package za.ac.cput.Service.Interface;

import za.ac.cput.Entity.Contact;
import za.ac.cput.Service.IService;

import java.util.List;

public interface IContactService extends IService<Contact, String> {

    Contact create(Contact contact);
    Contact read(String id);
    Contact update(Contact contact);
    boolean delete(String id);

    List<Contact> getAllContacts();

}
