//package za.ac.cput.Repository;
//
//
//import za.ac.cput.Entity.Payment;
//import za.ac.cput.Entity.Receipt;
//import za.ac.cput.Repository.Interface.iPaymentRepository;
//
//import java.util.HashSet;
//import java.util.Set;
//
//public class PaymentRepository implements iPaymentRepository {
////    private static PaymentRepository repository = null;
////    private Set<Payment> paymentDB = null;
////
////    private PaymentRepository(){
////        paymentDB = new HashSet<Payment>();
////    }
////    public static PaymentRepository getRepository() {
////        if (repository == null)
////            repository = new PaymentRepository();
////        return repository;
////    }
////
////
////    @Override
////    public Payment create(Payment payment) {
////        boolean created = paymentDB.add(payment);
////        if(created)
////            return payment;
////        else
////            return null;
////    }
////
////    @Override
////    public Payment read(String s) {
////        for (Payment payment : paymentDB) {
////            if (payment.getPaymentType().equals(payment))
////                return payment;
////        }
////        return null;
////    }
////
////    @Override
////    public Payment update(Payment payment) {
////        Payment updatePayment = read(payment.getPaymentType());
////
////        if (updatePayment != null){
////            paymentDB.remove(updatePayment);
////            paymentDB.add(payment);
////            return payment;
////        }
////        return null;
////    }
////    @Override
////    public boolean delete(String s) {
////        Payment paymentDeleted = read(s);
////
////        if (paymentDeleted == null)
////            return false;
////        paymentDB.remove(paymentDeleted);
////        return true;
////    }
////
////    @Override
////    public Set<Payment> getAll() {
////        return null;
////    }
////}
