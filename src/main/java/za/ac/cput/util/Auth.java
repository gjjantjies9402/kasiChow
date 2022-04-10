package za.ac.cput.util;

import org.apache.commons.validator.EmailValidator;

import java.util.UUID;

public class Auth {

    public static boolean isNullorEmpty(String s){
        return (s== null || s.equals("") || s.isEmpty() || s.equalsIgnoreCase("null"));
    }

    public static boolean isValid(String e){
        EmailValidator ev = EmailValidator.getInstance();
        return ev.isValid(e);
    }


    public static String generateId(){
        return UUID.randomUUID().toString();
    }
}
