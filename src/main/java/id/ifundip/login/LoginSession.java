package id.ifundip.login;

public class LoginSession {
	private String email;

    public LoginSession() {
        setEmail("");
    }

    public LoginSession(String email) {
        setEmail(email);
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public Boolean check() {
        return getEmail() != "";
    }

    public void storeData(Login login) {
        if (login.attempt()) {
            setEmail(login.getEmail());
        }

        throw new RuntimeException("Can't login");
    }
}
