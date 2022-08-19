/*ReceiptFactory.java
Factory for Receipt
Author: Nikitha Mbokotwana (218337906)
Date: 08 April 2022
 */
package za.ac.cput.Factory;

import za.ac.cput.Entity.Receipt;
import za.ac.cput.util.Auth;

public class ReceiptFactory {
    //creating receipt object
    public static Receipt createReceipt(String receiptID, double orderNr,String staffID,String customerIMEI,double amountPaid){

        if(Auth.isNullorEmpty(customerIMEI) || Auth.isNullorEmpty(receiptID)){
            return null;
        }
        return new Receipt.Builder().setReceiptID(receiptID)
                .setOrderNr(orderNr)
                .setStaffID(staffID)
                .setCustomerIMEI(customerIMEI)
                .setAmountPaid(amountPaid)
                .build();
    }
}
