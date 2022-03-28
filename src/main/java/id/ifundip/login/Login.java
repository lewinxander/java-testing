package id.ifundip.login;

import id.ifundip.user.*;

public class Login {
    private String email;
    private String password;

    public Login() {
        setEmail("");
        setPassword("");
    }

    public Login(String email, String password) {
        setEmail(email);
        setPassword(password);
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Boolean validate() {
        if (getEmail().trim() == "")
            return false;

        if (getPassword().trim() == "")
            return false;

        return true;
    }

    public Boolean attempt() {
        if (!validate())
            return false;

        UserService userService = new UserService();
        User user = userService.whereEmail(getEmail());

        if (user.isEmpty())
            return false;

        if (getPassword() != user.getPassword())
            return false;

        return true;
    }
}
