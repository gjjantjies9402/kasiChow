package za.ac.cput.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Driver {

    @Id
    private String driverID;
    private String driverFname;
    private String driverLname;
    private String driverContact;

    protected Driver () {}

    public Driver(Driver.Builder builder) {

        this.driverID = builder.driverID;
        this.driverFname = builder.driverFname;
        this.driverLname = builder.driverLname;
        this.driverContact = builder.driverContact;

    }

    public String toString() {
        return "Contact{" +
                "Driver ID='" + driverID + '\'' +
                ", Driver First Name='" + driverFname + '\'' +
                ", Driver Last Name='" + driverLname + '\'' +
                ", Driver Contact='" + driverContact + '\'' +
                '}';
    }


    public String getDriverID() {

        return driverID;
    }


    public String getDriverFname() {

        return driverFname;
    }

    public String getDriverLname() {

        return driverLname;
    }

    public String getDriverContact() {

        return driverContact;
    }


    public static class Builder {

        private String driverID, driverFname, driverLname, driverContact;



        public Driver.Builder setDriverID(String driverID) {

            this.driverID = driverID;

            return this;
        }

        public Driver.Builder setDriverFname(String driverFname) {

            this.driverFname = driverFname;

            return this;
        }

        public Driver.Builder setDriverLname(String driverLname) {

            this.driverLname = driverLname;

            return this;
        }

        public Driver.Builder setDriverContact(String driverContact) {

            this.driverContact = driverContact;

            return this;
        }


        public Driver build() {

            return new Driver(this);

        }
        public Driver.Builder copy(Driver driver) {

            this.driverID = driver.driverID;
            this.driverFname = driver.driverFname;
            this.driverLname = driver.driverLname;
            this.driverContact = driver.driverContact;

            return this;
        }
    }

}
