/**PaymentFactory.java
 * Factory for Payment
 * Author: Nikitha Mbokotwana (218337906)
 * Date: 08 April 2022
 **/
package za.ac.cput.Factory;

import za.ac.cput.Entity.Payment;
import za.ac.cput.util.Auth;

public class PaymentFactory {
    //creating Payment object
    public static Payment createPayment(String paymentID, String paymentType, String nameOnCard,String creditCardNumber,String expMonth, String expYear, int cvv){
        if (Auth.isNullorEmpty(paymentID) || Auth.isNullorEmpty(paymentType) || Auth.isNullorEmpty(nameOnCard) ||Auth.isNullorEmpty(creditCardNumber) || Auth.isNullorEmpty(expMonth) || Auth.isNullorEmpty(expYear))
            return null;

        return new Payment.Builder()
                .setPaymentID(paymentID)
                .setPaymentType(paymentType)
                .setNameOnCard(nameOnCard)
                .setCreditCardNumber(creditCardNumber)
                .setExpMonth(expMonth)
                .setExpYear(expYear)
                .setCvv(cvv)
                .build();
    }
}
