package za.ac.cput.Factory;

import za.ac.cput.Entity.Customer;
import za.ac.cput.util.Auth;

public class CustomerFactory {

    public static Customer createCustomer(String custID, String firstName, String lastName, String custIMEI){

        if (Auth.isNullorEmpty(custID) ||Auth.isNullorEmpty(firstName) || Auth.isNullorEmpty(lastName) || Auth.isNullorEmpty(custIMEI) )
            return null;

        return new Customer.Builder()
                .setCustID(custID)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setCustIMEI(custIMEI)
                .build();

    }
}
