package models;

public class Login {

    private String _username;
    private String _password;
    private String specialCharacters = "[!+-?%&$§/=*,;~]";
    private String numbers = "0123456789";


    // getter-/Setter

    public String getUsername() {
        return this._username;
    }

    public void setUsername(String username) {

        if (username.length() > 6) {
            this._username = username;
        }
    }


    public String getPassword() {
        return this._password;
    }

    public void setPassword(String password) {

        if (password.length() > 8) {
            if (password.matches(specialCharacters)) {
                if (!password.matches(numbers)) {
                    this._password = password;

                }
            }
        }
    }

    // ctors

    public Login() {
        this("", "");
    }

    public Login(String username, String password) {
        this.setUsername(username);
        this.setPassword(password);
    }

    // toString()

    @Override
    public String toString() {
        return this.getUsername() + "" + this.getPassword();
    }

    public boolean authenticate(String username, String password){
        if ((username.equals(this._username)) && (password.equals(this._password))){
            return true;
        }

        else{
            return false;
        }
    }
}
