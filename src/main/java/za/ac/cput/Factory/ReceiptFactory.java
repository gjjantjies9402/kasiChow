/**ReceiptFactory.java
 * Factory for Receipt
 * Author: Nikitha Mbokotwana (218337906)
 * Date: 08 April 2022
 **/
package za.ac.cput.Factory;

import za.ac.cput.Entity.Receipt;
import za.ac.cput.util.Auth;

public class ReceiptFactory {
    //creating receipt object
    public static Receipt createReceipt(String receiptID, String orderNr,String driverID,String customerID,double amountPaid){

        if(Auth.isNullorEmpty(customerID) || Auth.isNullorEmpty(receiptID)){
            return null;
        }
        return new Receipt.Builder().setReceiptID(receiptID)
                .setOrderNr(orderNr)
                .setCustomerID(customerID)
                .setDriverID(driverID)
                .setAmountPaid(amountPaid)
                .build();
    }
}
