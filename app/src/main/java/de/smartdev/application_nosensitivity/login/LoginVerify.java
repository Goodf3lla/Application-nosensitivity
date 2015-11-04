package de.smartdev.application_nosensitivity.login;

import java.util.regex.Pattern;

/**
 * Created by Andi on 02.11.2015.
 */
public class LoginVerify {
    private static final Pattern[] passwordRegexes = new Pattern[4];

    {
        passwordRegexes[0] = Pattern.compile(".*[A-Z].*");
        passwordRegexes[1] = Pattern.compile(".*[a-z].*");
        passwordRegexes[2] = Pattern.compile(".*\\d.*");
        passwordRegexes[3] = Pattern.compile(".*[~!].*");
    }

    private boolean isLegalPassword(String pass) {
        int counter = 0;
        for (int i = 0; i < passwordRegexes.length; i++) {
            if (passwordRegexes[i].matcher(pass).matches()) {
                counter++;
            }
        }
        return counter > 2;
    }

    private boolean isLegalUsername(String user) {
        return true;
    }

    private boolean isLegalEmailaccount(String email) {
        return email.contains("@");
    }

    public boolean checkSign_in(String username, String password) {//TODO: change to http-get-request
        if (username.equals("")) {
            return false;
        }
        return !password.equals("");
    }

    public boolean checkSign_up(String email, String username, String password) {
        if (!isLegalPassword(password)) {
            return false;
        } else if (!isLegalEmailaccount(email)) {
            return false;
        } else return isLegalUsername(username);
    }

}
