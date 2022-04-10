package za.ac.cput.Repository;

import za.ac.cput.Entity.Receipt;
import za.ac.cput.Repository.Interface.iReceiptRepository;

import java.util.Set;

public class ReceiptRepository implements iReceiptRepository {


    @Override
    public Set<Receipt> getAll() {
        return null;
    }

    @Override
    public Receipt create(Receipt receipt) {
        return null;
    }

    @Override
    public Receipt read(String s) {
        return null;
    }

    @Override
    public Receipt update(Receipt receipt) {
        return null;
    }

    @Override
    public boolean delete(String s) {
        return false;
    }
}
