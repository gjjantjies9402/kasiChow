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

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class login {
    @Id
    private String id;
    private String username;
    private String password;

    protected login(){}

    private login(Builder builder){
        this.id = builder.id;
        this.username = builder.username;
        this.password = builder.password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String toString() {
        return "login{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }


    public static class Builder{
        private String id;
        private String username;
        private String password;

        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Builder setUsername(String username) {
            this.username = username;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder copy(login login){
            this.id = login.id;
            this.username = login.username;
            this.password = login.password;
            return this;
        }

        public login build(){
            return new login(this);
        }
    }
}
