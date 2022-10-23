/**
 * Customer.java
 * Entity for Customer
 * Author: Kanya Ramncwana (218297521)
 * Date: 08 April 2022
 * Date Modefied: 07 August 2022
 *  - Adding entity and database connection
 */

package za.ac.cput.Entity;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer {

    @Id
    private String custID;
    private String firstName;
    private String lastName;
    private String primaryNr;
    private String emailAddress;
    private String custAddress;

    public Customer () {}

    public Customer(Builder builder) {

        this.custID = builder.custID;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.primaryNr = builder.primaryNr;
        this.emailAddress = builder.emailAddress;
        this.custAddress = builder.custAddress;

    }


    public String getCustID() {

        return custID;
    }

    public void setCustID(String custID) {
        this.custID = custID;
    }

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

    public String getPrimaryNr() {

        return primaryNr;
    }

    public void setPrimaryNr(String primaryNr) {
        this.primaryNr = primaryNr;
    }

    public String getEmailAddress() {

        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getCustAddress() {

        return custAddress;

    }


    public void setCustAddress(String custAddress) {
        this.custAddress = custAddress;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "custID='" + custID + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", primaryNr='" + primaryNr + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", custAddress='" + custAddress + '\'' +
                '}';
    }

    public static class Builder {

        private String custID;
        private String firstName;
        private String lastName;
        private String primaryNr;
        private String emailAddress;
        private String custAddress;



        public Builder setCustID(String custID) {

            this.custID = custID;

            return this;
        }

        public Builder setFirstName(String firstName) {

            this.firstName = firstName;

            return this;
        }

        public Builder setLastName(String lastName) {

            this.lastName = lastName;

            return this;
        }

        public Builder setPrimaryNr(String primaryNr) {

            this.primaryNr = primaryNr;

            return this;
        }

        public Builder setEmailAddress(String emailAddress) {

            this.emailAddress = emailAddress;

            return this;
        }

        public Builder setCustAddress(String custAddress) {

            this.custAddress = custAddress;

            return this;
        }

        public Customer build() {

            return new Customer(this);

        }
        public Builder copy(Customer customer) {

            this.custID = customer.custID;
            this.firstName = customer.firstName;
            this.lastName = customer.lastName;
            this.primaryNr = customer.primaryNr;
            this.emailAddress = customer.emailAddress;
            this.custAddress = customer.custAddress;

            return this;
        }
    }

}
