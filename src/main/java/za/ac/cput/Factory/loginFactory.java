/**
 * Mziyanda Mwanda
 * 2133765
 * ADP 3
 *Assignment 1
 * Due date
 * 10 Aprile 2022
 * Factory:
 * Login
 * **/

package za.ac.cput.Factory;

import za.ac.cput.Entity.login;
import za.ac.cput.util.Auth;

public class loginFactory {
    public static login createLogin(String username, String password){

        if (Auth.isNullorEmpty(username) ||Auth.isNullorEmpty(password) )
            return null;

        return new login.Builder().setUsername(username)
                .setPassword(password)
                .build();

    }
}
