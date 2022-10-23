package za.ac.cput.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Driver {

    @Id
    private String driverID ;
    private String driverFname;
    private String driverLname;
    private String driverContact;

    public Driver () {}

    public Driver(Builder builder) {

        this.driverID = builder.driverID;
        this.driverFname = builder.driverFname;
        this.driverLname = builder.driverLname;
        this.driverContact = builder.driverContact;

    }




    public String getDriverID() {

        return this.driverID;
    }

    public void setDriverID(String driverID) {
        this.driverID = driverID;
    }

    public String getDriverFname() {

        return this.driverFname;
    }

    public void setDriverFname(String driverFname) {
        this.driverFname = driverFname;
    }

    public String getDriverLname() {

        return this.driverLname;
    }

    public void setDriverLname(String driverLname) {
        this.driverLname = driverLname;
    }

    public String getDriverContact() {

        return this.driverContact;
    }

    public void setDriverContact(String driverContact) {
        this.driverContact = driverContact;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "driverID='" + driverID + '\'' +
                ", driverFname='" + driverFname + '\'' +
                ", driverLname='" + driverLname + '\'' +
                ", driverContact='" + driverContact + '\'' +
                '}';
    }

    public static class Builder {

        private String driverID;
        private String driverFname;
        private String driverLname;
        private String driverContact;



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
