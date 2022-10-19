//package za.ac.cput.Repository;
//
//import za.ac.cput.Entity.Receipt;
//import za.ac.cput.Repository.Interface.iReceiptRepository;
//
//import java.util.HashSet;
//import java.util.Set;
//
//@Deprecated
//public class ReceiptRepository implements iReceiptRepository {
//    private static ReceiptRepository repository = null;
//    private Set<Receipt> receiptDB = null;
//
//    private ReceiptRepository(){
//        receiptDB = new HashSet<Receipt>();
//    }
//
//    public static ReceiptRepository getRepository() {
//        if (repository == null)
//            repository = new ReceiptRepository();
//        return repository;
//    }
//
//
//    @Override
//    public Receipt create(Receipt receipt) {
//        boolean created = receiptDB.add(receipt);
//        if(created)
//            return receipt;
//        else
//            return null;
//    }
//    @Override
//    public Receipt read(String s) {
//        for (Receipt receipt : receiptDB) {
//            if (receipt.getReceiptID().equals(receipt))
//                return receipt;
//        }
//        return null;
//    }
//
//    @Override
//    public Receipt update(Receipt receipt) {
//        Receipt updateReceipt = read(receipt.getReceiptID());
//
//        if (updateReceipt != null){
//            receiptDB.remove(updateReceipt);
//            receiptDB.add(receipt);
//            return receipt;
//        }
//        return null;
//    }
//
//    @Override
//    public boolean delete(String s) {
//        Receipt receiptDeleted = read(s);
//
//        if (receiptDeleted == null)
//            return false;
//        receiptDB.remove(receiptDeleted);
//        return true;
//    }
//
//    @Override
//    public Set<Receipt> getAll() {
//        return null;
//    }
//
//}
