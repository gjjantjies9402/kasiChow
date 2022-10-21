/**ReceiptController.java
 * Controller for Receipt
 * Author: Nikitha Mbokotwana (218337906)
 * Date: 17 October 2022
 **/
package za.ac.cput.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Entity.Receipt;
import za.ac.cput.Factory.ReceiptFactory;
import za.ac.cput.Service.impl.ReceiptServicesImpl;
import java.util.Set;

@RestController
@RequestMapping("/receipt")
public class ReceiptController {
    @Autowired
    private ReceiptServicesImpl receiptServices;

    @PostMapping("/create")
    public Receipt create (@RequestBody Receipt receipt)
    {
        Receipt newReceipt = ReceiptFactory.createReceipt
                (
                receipt.getReceiptID(),
                receipt.getOrderNr(),
                receipt.getDriverID(),
                receipt.getCustomerID(),
                receipt.getAmountPaid()
                );
        return receiptServices.create(newReceipt);

    }

    @GetMapping("/read/{receiptID}")
    public Receipt read (@PathVariable String receiptID)
    {
        return receiptServices.read(receiptID);
    }

    @PostMapping ("/update")
    public Receipt update (@RequestBody Receipt receipt)
    {
        Receipt update = receiptServices.update(receipt);

        return update;
    }

    @DeleteMapping ("/delete/{receiptID}")
    public boolean delete (@PathVariable(value = "receiptID") String receiptID)
    {
        return receiptServices.delete(receiptID);
    }

    @GetMapping ("/getAll")
    public Set<Receipt> getAll()
    {

        return receiptServices.getAll();
    }

}
