package za.ac.cput.Factory;

import za.ac.cput.Entity.Contact;
import za.ac.cput.util.Auth;

public class ContactFactory {

    public static Contact createContact(String contID, String primaryNr, String secondaryNr, String emailAddress){

        if (Auth.isNullorEmpty(contID) ||Auth.isNullorEmpty(primaryNr) || Auth.isNullorEmpty(emailAddress) )
            return null;

        return new Contact.Builder()
                .setContID(contID)
                .setPrimaryNr(primaryNr)
                .setSecondaryNr(secondaryNr)
                .setEmailAddress(emailAddress)
                .build();

    }
}

