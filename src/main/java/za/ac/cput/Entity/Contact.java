/**
 * Contact.java
 * Entity for Contact
 * Author: Kanya Ramncwana (218297521)
 * Date Created: 08 April 2022
 * Date Modefied: 07 August 2022
 *  - Adding entity and database connection

package za.ac.cput.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

@Table (name = "Contacts")

public class Contact {

    @Id
    @Column (name = "Contact ID")
    private String contID;

    private String primaryNr;
    private String secondaryNr;
    private String emailAddress;

    protected  Contact(){}

    public Contact(Builder builder) {

        this.contID = builder.contID;
        this.primaryNr = builder.primaryNr;
        this.secondaryNr = builder.secondaryNr;
        this.emailAddress = builder.emailAddress;

    }

    public String toString() {
        return "Contact{" +
                "Contact ID ='" + contID + '\'' +
                ", Primary Number ='" + primaryNr + '\'' +
                ", Secondary Number ='" + secondaryNr + '\'' +
                ", Email Address='" + emailAddress + '\'' +
                '}';
    }


    public String getContID() {

        return contID;
    }

    public String getPrimaryNr() {

        return primaryNr;
    }


    public String getSecondaryNr() {

        return secondaryNr;
    }

    public String getEmailAddress() {

        return emailAddress;
    }


    public static class Builder {

        private String contID, primaryNr, secondaryNr, emailAddress;



        public Builder setContID(String contID) {

            this.contID = contID;

            return this;
        }

        public Builder setPrimaryNr(String primaryNr) {

            this.primaryNr = primaryNr;

            return this;
        }

        public Builder setSecondaryNr(String secondaryNr) {

            this.secondaryNr = secondaryNr;

            return this;
        }

        public Builder setEmailAddress(String emailAddress) {

            this.emailAddress = emailAddress;

            return this;
        }

        public Contact build() {

            return new Contact(this);

        }
        public Builder copy(Contact contact) {

            this.contID = contact.contID;
            this.primaryNr = contact.primaryNr;
            this.secondaryNr = contact.secondaryNr;
            this.emailAddress = contact.emailAddress;

            return this;
        }
    }

}
