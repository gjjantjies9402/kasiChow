/*DeliveryAddress.java
Entity for DeliveryAddress
Author: Kanya Ramncwana (218297521)
Date: 08 April 2022
 */

package za.ac.cput.Entity;

public class DeliveryAddress {

    private String deliveryID,streetAddress;

    public DeliveryAddress(Builder builder) {

        this.deliveryID = builder.deliveryID;
        this.streetAddress = builder.streetAddress;

    }

    @Override
    public String toString() {
        return "Delivery Address{" +
                "Delivery ID='" + deliveryID + '\'' +
                ", Street Address='" + streetAddress + '\'' +
                '}';
    }


    public String getDeliveryID() {

        return deliveryID;
    }


    public String getStreetAddress() {

        return streetAddress;
    }



    public static class Builder {

        private String deliveryID, streetAddress;



        public Builder setDeliveryID(String deliveryID) {

            this.deliveryID = deliveryID;

            return this;
        }

        public Builder setStreetAddress(String streetAddress) {

            this.streetAddress = streetAddress;

            return this;
        }



        public DeliveryAddress build() {

            return new DeliveryAddress(this);

        }
        public Builder copy(DeliveryAddress delivery) {

            this.deliveryID = delivery.deliveryID;
            this.streetAddress = delivery.streetAddress;

            return this;
        }
    }
}