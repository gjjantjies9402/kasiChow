/**ReceiptController.java
 * Controller for Receipt
 * Author: Nikitha Mbokotwana (218337906)
 * Date: 17 October 2022
 **/
package za.ac.cput.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Entity.Receipt;
import za.ac.cput.Factory.ReceiptFactory;
import za.ac.cput.Service.impl.ReceiptServicesImpl;

import java.util.Set;

@Controller
@RequestMapping("/receipt")
public class ReceiptController {

    @Autowired
    private ReceiptServicesImpl receiptServices;
    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("receipts", receiptServices.getAll());
        return "receipt";
    }
    @PostMapping("/create")
    public Receipt create (@RequestBody Receipt receipt)
    {
        Receipt newReceipt = ReceiptFactory.createReceipt(
                receipt.getReceiptID(),
                receipt.getOrderID(),
                receipt.getCustID(),
                receipt.getDriverID(),
                receipt.getItemID());
        return receiptServices.create(receipt);
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

    @GetMapping ("/getall")
    public Set<Receipt> getAll()
    {
        return receiptServices.getAll();
    }

}
