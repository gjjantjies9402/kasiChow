package za.ac.cput.Service.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.Entity.Receipt;
import za.ac.cput.Factory.ReceiptFactory;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class ReceiptServicesImplTest {
    @Autowired
    private static ReceiptServicesImpl receiptServices;
    private static Receipt receipt = ReceiptFactory.createReceipt("R123","O19","D12","C3456", 700);

    @Test
    void create() {

    }

    @Test
    void read() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    @Test
    public void getAll() {
        System.out.println("All Receipts: " + receipt);

    }
}