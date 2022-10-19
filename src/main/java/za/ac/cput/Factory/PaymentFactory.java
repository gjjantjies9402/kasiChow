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
    public static Payment createPayment(String paymentType, String receiptID){
        if (Auth.isNullorEmpty(paymentType) || Auth.isNullorEmpty(receiptID)){
            return null;
        }
        return new Payment.Builder().setPaymentType(paymentType)
                .setReceiptID(receiptID)
                .build();
    }
}
