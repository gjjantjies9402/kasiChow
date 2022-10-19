/**Payment.java
 * Entity for Payment
 * Author: Nikitha Mbokotwana (218337906)
 * Date: 08 April 2022
 **/
package za.ac.cput.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Payment {
    @Id
    private String receiptID;
    private String paymentType;

    protected Payment(){

    }
    //private constructers
    private Payment(Builder builder){
        this.paymentType = builder.paymentType;
        this.receiptID = builder.receiptID;
    }

    //getters
    public String getPaymentType() {
        return paymentType;
    }

    public String getReceiptID() {
        return receiptID;
    }

    //setters
    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public void setReceiptID(String receiptID) {
        this.receiptID = receiptID;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentType='" + paymentType + '\'' +
                ", receiptID='" + receiptID + '\'' +
                '}';
    }

    public static class Builder{
        private String paymentType;
        private String receiptID;

        public Builder setPaymentType(String paymentType) {
            this.paymentType = paymentType;
            return this;
        }

        public Builder setReceiptID(String receiptID) {
            this.receiptID = receiptID;
            return this;
        }
        public Builder copy(Payment payment){
            this.receiptID = payment.receiptID;
            this.paymentType = payment.paymentType;
            return this;
        }

        public Payment build(){
            return new Payment(this);
        }
    }
}
