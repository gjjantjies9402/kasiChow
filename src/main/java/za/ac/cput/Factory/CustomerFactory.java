/*CustomerFactory.java
Factory for Customer
Author: Kanya Ramncwana (218297521)
Date: 08 April 2022
 */

package za.ac.cput.Factory;

import za.ac.cput.Entity.Customer;
import za.ac.cput.util.Auth;

public class CustomerFactory {

    public static Customer createCustomer(String custID, String firstName, String lastName, String primaryNr, String emailAddress, String custAddress){

        if (Auth.isNullorEmpty(custID) ||Auth.isNullorEmpty(firstName) || Auth.isNullorEmpty(lastName) || Auth.isNullorEmpty(primaryNr)  || Auth.isNullorEmpty(emailAddress) || Auth.isNullorEmpty(custAddress))
            return null;

        return new Customer.Builder()
                .setCustID(custID)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setPrimaryNr(primaryNr)
                .setEmailAddress(emailAddress)
                .setCustAddress(custAddress)
                .build();

    }
}
