package de.smartdev.application_nosensitivity.login;

/**
 * Created by Andi on 02.11.2015.
 */
public class LoginVerify {
    public boolean checkSign_in(String username, String password) {
        if (username.equals("")) {
            return false;
        }
        return !password.equals("");
    }

}
