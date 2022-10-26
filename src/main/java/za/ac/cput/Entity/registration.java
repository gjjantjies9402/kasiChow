/**
 * Mziyanda Mwanda
 * 2133765
 * ADP 3
 *Assignment 1
 * Due date
 * 10 Aprile 2022
 * Entity:
 * Registration
 * **/
package za.ac.cput.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class registration {

    @Id
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String confirmPassword;
    private String emailAddress;

    public registration() {}

    //Constructor
    private registration(Builder builder){
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.username = builder.username;
        this.password = builder.password;
        this.confirmPassword = builder.confirmPassword;
        this.emailAddress = builder.emailAddress;
    }

    //Getters and Setters


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
    //Tostring


    public String toString() {
        return "registration{" +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                '}';
    }

    //Builder Pattern starts
    public static class Builder{
        private String firstName;
        private String lastName;
        private String username;
        private String password;
        private String confirmPassword;
        private String emailAddress;



        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return  this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
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

        public Builder setConfirmPassword(String confirmPassword){
            this.confirmPassword = confirmPassword;
            return this;
        }

        public Builder setEmailAddress(String emailAddress) {
            this.emailAddress = emailAddress;
            return this;
        }

        public Builder copy(registration reg){
            this.firstName = reg.firstName;
            this.lastName = reg.lastName;
            this.username = reg.username;
            this.password = reg.password;
            this.confirmPassword = reg.confirmPassword;
            this.emailAddress = reg.emailAddress;

            return this;
        }

        public registration build(){
            return new registration(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        registration that = (registration) o;
        return firstName.equals(that.firstName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName);
    }
}

