/**
 * ContactService.java
 *  Service for Contact
 *  Author: Kanya Ramncwana (218297521)
 *  Date Created: 10 August 2022
 * */

package za.ac.cput.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.Entity.Contact;
import za.ac.cput.Repository.Interface.IContactRepository;
import za.ac.cput.Service.Interface.IContactService;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ContactService implements IContactService {

    private static ContactService contactService;

    @Autowired
    private IContactRepository contactRepository;

    private ContactService() {

    }

    public static ContactService getContactService() {
        if (contactService == null) contactService = new ContactService();
        return contactService;
    }

    @Override
    public Contact create(Contact contact) {
        return this.contactRepository.save(contact);
    }

    @Override
    public Contact read(String s) {
        Optional<Contact> optionalContact = this.contactRepository.findById(s);
        return optionalContact.orElse(null);
    }

    @Override
    public Contact update(Contact contact) {
        return this.contactRepository.save(contact);
    }

    @Override
    public boolean delete(String s) {
        this.contactRepository.deleteById(s);

        if(this.contactRepository.existsById(s)) return false;
        else return true;
    }


    @Override
    public List<Contact> getAllContacts() {
        return this.contactRepository.findAll();
    }

    /*private static ContactService service = null;

    @Autowired
    private IContactRepository repository;

    public static ContactService getService() {

        if(service == null) {
            service = new ContactService();
        }

        return service;
    }

    private ContactService()
    {
        this.repository = repository;

    }

    public Set<Contact> getAll() {

       return this.repository.findAll().stream().collect(Collectors.toSet());

    }


    public Set<Contact> getAllGmailEmails() {

        Set<Contact> contacts = getAll();
        Set<Contact> emails = new HashSet<>();
        for (Contact contact : contacts) {
            if(contact.getEmailAddress().trim().toLowerCase().endsWith("gmail.com")) {
                emails.add(contact);
            }
        }
       return emails;
    }

    public Contact getContactEmails (String s) {

        Set<Contact> contacts = getAll();
        return contacts.stream().filter(contact -> contact.getEmailAddress().trim().equalsIgnoreCase(s))
                .findAny().orElse(null);
    }

    @Override
    public Contact create(Contact contact) {

       return this.repository.save(contact);


    }

    @Override
    public Contact read(String s) {

        return this.repository.findById(s).orElseGet(null);

    }

    @Override
    public Contact update(Contact contact) {

        if(this.repository.existsById(contact.getContID())) {
            return this.repository.save(contact);
        }

        return null;
    }

    @Override
    public boolean delete(String s) {

        this.repository.deleteById(s);

        if(this.repository.existsById(s)) return false;
        else return true;

    }

    @Override
    public List<Contact> getAllContacts() {
        return this.repository.findAll();
    }*/
}
