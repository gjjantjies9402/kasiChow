/**Payment.java
 * Entity for Payment
 * Author: Nikitha Mbokotwana (218337906)
 * Date: 08 April 2022
 **/
package za.ac.cput.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Payment {
    @Id
    private String paymentID;
    //get this from payment type
    private String paymentType;
    private String nameOnCard;
    private String creditCardNumber;
    private String expMonth;
    private String expYear;
    private int cvv;

    public Payment(){

    }
    //private constructers
    private Payment(Builder builder){
        this.paymentID = builder.paymentID;
        this.paymentType = builder.paymentType;
        this.nameOnCard = builder.nameOnCard;
        this.creditCardNumber = builder.creditCardNumber;
        this.expMonth = builder.expMonth;
        this.expYear = builder.expYear;
        this.cvv = builder.cvv;
    }

    public String toString() {
        return "Payment{" +
                "ID='" + paymentID + '\'' +
                ", Payment Type='" + paymentType + '\'' +
                ", Name On Card='" + nameOnCard + '\'' +
                ", Credit Card Number='" + creditCardNumber + '\'' +
                ", Expiry Month='" + expMonth + '\'' +
                ", Expiry Year='" + expYear + '\'' +
                ", Cvv=" + cvv +
                '}';
    }

    //getters
    public String getPaymentID() {
        return paymentID;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public String getNameOnCard() {
        return nameOnCard;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public String getExpMonth() {
        return expMonth;
    }

    public String getExpYear() {
        return expYear;
    }

    public int getCvv() {
        return cvv;
    }

    public static class Builder{
        private String paymentID, paymentType, nameOnCard, creditCardNumber, expMonth, expYear;
        private int cvv;

        public Builder setPaymentID(String paymentID) {
            this.paymentID = paymentID;
            return this;
        }

        public Builder setPaymentType(String paymentType) {
            this.paymentType = paymentType;
            return this;
        }
        public Builder setNameOnCard(String nameOnCard) {
            this.nameOnCard = nameOnCard;
            return this;
        }

        public Builder setCreditCardNumber(String creditCardNumber) {
            this.creditCardNumber = creditCardNumber;
            return this;
        }

        public Builder setExpMonth(String expMonth) {
            this.expMonth = expMonth;
            return this;
        }
        public Builder setExpYear(String expYear) {
            this.expYear = expYear;
            return this;
        }
        public Builder setCvv(int cvv) {
            this.cvv = cvv;
            return this;
        }
        public Payment build(){
            return new Payment(this);
        }

        public Builder copy(Payment payment){
            this.paymentID = payment.paymentID;
            this.paymentType = payment.paymentType;
            this.nameOnCard = payment.nameOnCard;
            this.creditCardNumber = payment.creditCardNumber;
            this.expMonth = payment.expMonth;
            this.expYear = payment.expYear;
            this.cvv = payment.cvv;

            return this;
        }

    }
}
