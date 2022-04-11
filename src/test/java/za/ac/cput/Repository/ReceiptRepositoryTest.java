package za.ac.cput.Repository;

import org.junit.jupiter.api.Test;
import za.ac.cput.Entity.Receipt;
import za.ac.cput.Factory.ReceiptFactory;

import static org.junit.jupiter.api.Assertions.*;

class ReceiptRepositoryTest {
    private static ReceiptRepository receiptRepository = ReceiptRepository.getRepository();
    private static Receipt receipt = ReceiptFactory.createReceipt("5746577",25,"674567","5764565",789);

    @Test
    void create(){
        Receipt create = receiptRepository.create(receipt);
        assertEquals(receipt.getReceiptID(), create.getCustomerIMEI());
        System.out.println("Created: " + create);
    }
    @Test
    void read(){
        Receipt read = receiptRepository.read(receipt.getReceiptID());
        assertNull(read);
        System.out.println("Read: " + read);
    }
    @Test
    void update(){
        Receipt update = new Receipt.Builder().copy(receipt)
                .setReceiptID("43221132")
                .setCustomerIMEI("5437657")
                .setStaffID("867564")
                .setAmountPaid(1000)
                .setOrderNr(45)
                .build();
        System.out.println("Update: " + update);
    }
    @Test
    void delete() {
        boolean delete = PaymentRepository.getRepository().delete(receipt.getReceiptID());
        assertTrue(delete);
        System.out.println("Delete: " + delete);
    }

    @Test
    void getAll() {
        System.out.println("Show all");
        System.out.println(PaymentRepository.getRepository().getAll());
    }

}