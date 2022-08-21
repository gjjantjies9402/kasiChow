//package za.ac.cput.Repository;
//
//import org.junit.jupiter.api.Test;
//import za.ac.cput.Entity.Payment;
//import za.ac.cput.Factory.PaymentFactory;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class PaymentRepositoryTest {
//    private static PaymentRepository paymentRepository = PaymentRepository.getRepository();
//    private static Payment payment = PaymentFactory.createPayment("Card","22296867");
//
//    @Test
//    void create(){
//        Payment create = paymentRepository.create(payment);
//        assertEquals(payment.getPaymentType(), create.getReceiptID());
//        System.out.println("Created: " + create);
//    }
//    @Test
//    void read(){
//        Payment read = paymentRepository.read(payment.getPaymentType());
//        assertNull(read);
//        System.out.println("Read: " + read);
//    }
//    @Test
//    void update(){
//        Payment update = new Payment.Builder().copy(payment)
//                .setPaymentType("Cash")
//                .setReceiptID("5437657675")
//                .build();
//        System.out.println("Update: " + update);
//    }
//    @Test
//    void delete() {
//        boolean delete = PaymentRepository.getRepository().delete(payment.getPaymentType());
//        assertTrue(delete);
//        System.out.println("Delete: " + delete);
//    }
//
//    @Test
//    void getAll() {
//        System.out.println("Show all");
//        System.out.println(PaymentRepository.getRepository().getAll());
//    }
//
//}