/**
 * Mziyanda Mwanda
 * 2133765
 * ADP 3
 *Assignment 1
 * Due date
 * 10 Aprile 2022
 * Entity:
 * Login
 * **/
package za.ac.cput.Entity;

public class login {
    private String username;
    private String password;

    private login(Builder builder){
        this.username = builder.username;
        this.password = builder.password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "login{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }


    public static class Builder{
        private String username;
        private String password;

        public Builder setUsername(String username) {
            this.username = username;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder copy(login login){
            this.username = login.username;
            this.password = login.password;
            return this;
        }

        public login build(){
            return new login(this);
        }
    }
}
