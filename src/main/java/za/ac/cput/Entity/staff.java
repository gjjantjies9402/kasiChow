/**
 * Mziyanda Mwanda
 * 2133765
 * ADP 3
 *Assignment 1
 * Due date
 * 10 Aprile 2022
 * Entity:
 * Staff
 * **/
package za.ac.cput.Entity;

public class staff {
    //Declaration of the attributes

    private String adminName;
    private String deliveryDriver;
    private String assistant ;

    //Builder Constructor
    private staff(Builder builder){
        this.adminName = builder.adminName;
        this.deliveryDriver = builder.deliveryDriver;
        this.assistant= builder.assistant;
    }

    //Getters and Setters


    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getDeliveryDriver() {
        return deliveryDriver;
    }

    public void setDeliveryDriver(String deliveryDriver) {
        this.deliveryDriver = deliveryDriver;
    }

    public String getAssistant() {
        return assistant;
    }

    public void setAssistant(String assistant) {
        this.assistant = assistant;
    }

    //Builder starts
    public static class Builder{

        private String adminName;
        private String deliveryDriver;
        private String assistant ;



        public Builder setAdminName(String adminName) {
            this.adminName = adminName;
            return this;
        }

        public Builder setDeliveryDriver(String deliveryDriver) {
            this.deliveryDriver = deliveryDriver;
            return this;
        }

        public Builder setAssistant(String assistant) {
            this.assistant = assistant;
            return this;
        }

        public Builder copy( staff staff){
            this.adminName = staff.adminName;
            this.deliveryDriver = staff.deliveryDriver;
            this.assistant = staff.assistant;
            return this;
        }
        public staff build(){
            return  new staff(this);
        }
    }

}
