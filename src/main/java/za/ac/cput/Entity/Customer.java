/*Customer.java
Entity for Customer
Author: Kanya Ramncwana (218297521)
Date: 08 April 2022
 */

package za.ac.cput.Entity;

public class Customer {

    private String custID,firstName, lastName, custIMEI;

    public Customer(Builder builder) {

        this.custID = builder.custID;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.custIMEI = builder.custIMEI;

    }

    @Override
    public String toString() {
        return "Contact{" +
                "Customer ID='" + custID + '\'' +
                ", First Name='" + firstName + '\'' +
                ", Last Name='" + lastName + '\'' +
                ", Customer IMEI='" + custIMEI + '\'' +
                '}';
    }


    public String getCustID() {

        return custID;
    }


    public String getFirstName() {

        return firstName;
    }

    public String getLastName() {

        return lastName;
    }

    public String getCustIMEI() {

        return custIMEI;
    }


    public static class Builder {

        private String custID, firstName, lastName, custIMEI;



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
        public Builder setCustIMEI(String custIMEI) {

            this.custIMEI = custIMEI;

            return this;
        }

        public Customer build() {

            return new Customer(this);

        }
        public Builder copy(Customer customer) {

            this.custID = customer.custID;
            this.firstName = customer.firstName;
            this.lastName = customer.lastName;
            this.custIMEI = customer.custIMEI;

            return this;
        }
    }

}
