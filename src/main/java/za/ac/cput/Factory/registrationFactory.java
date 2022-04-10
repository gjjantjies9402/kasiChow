/**
 * Mziyanda Mwanda
 * 2133765
 * ADP 3
 *Assignment 1
 * Due date
 * 10 Aprile 2022
 * Factory:
 * Registration
 * **/
package za.ac.cput.Factory;

import za.ac.cput.Entity.registration;
import za.ac.cput.util.Auth;


public class registrationFactory {

    //creating object
    public static registration createRegistration(String firstName, String lastName, String username, String password, String confirmPassword, String emailAddress){

        if (Auth.isNullorEmpty(password) || Auth.isNullorEmpty(confirmPassword))
            return null;
        if (Auth.isValid(emailAddress))
            return null;

        return new registration.Builder().setFirstName(firstName)
                .setLastName(lastName)
                .setUsername(username)
                .setPassword(password)
                .setConfirmPassword(confirmPassword)
                .setEmailAddress(emailAddress)
                .build();
    }
}
