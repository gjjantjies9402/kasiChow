package za.ac.cput.Repository.Interface;

import za.ac.cput.Entity.Receipt;
import za.ac.cput.Repository.iml.iRepository;

import java.util.Set;

public interface iReceiptRepository extends iRepository<Receipt,String> {
    public Set<Receipt> getAll();
}
