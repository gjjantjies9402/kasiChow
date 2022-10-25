/**ReceiptServices.java
 * Service for Receipt
 * Author: Nikitha Mbokotwana (218337906)
 * Date: 17 October 2022
 **/
package za.ac.cput.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.Entity.Receipt;
import za.ac.cput.Repository.Interface.iReceiptRepository;
import za.ac.cput.Service.Interface.IReceiptService;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ReceiptServicesImpl implements IReceiptService {

    @Autowired
    private iReceiptRepository repository;


    @Override
    public Receipt create(Receipt receipt) {
        return this.repository.save(receipt);
    }

    @Override
    public Receipt read(String receiptID) {
        return this.repository.findById(receiptID).orElseGet(null);
    }

    @Override
    public Receipt update(Receipt receipt) {
        if(this.repository.existsById(receipt.getReceiptID())){
            return this.repository.save(receipt);
        }
        return null;
    }

    @Override
    public boolean delete(String receiptID) {
        this.repository.deleteById(receiptID);
        if (this.repository.existsById(receiptID))
            return false;
        else
            return true;
    }

    @Override
    public Set<Receipt> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }
}
