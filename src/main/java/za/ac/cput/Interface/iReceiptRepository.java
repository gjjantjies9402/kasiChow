package za.ac.cput.Interface;

import za.ac.cput.Entity.Receipt;

import java.util.Set;

public interface iReceiptRepository extends iReposoitory<Receipt,String> {
    public Set<Receipt> getAll();
}
