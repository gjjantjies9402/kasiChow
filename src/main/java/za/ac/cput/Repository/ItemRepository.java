//package za.ac.cput.Repository;
//import za.ac.cput.Entity.Item;
//import za.ac.cput.Repository.Interface.iItemRepository;
//
//import java.util.HashSet;
//import java.util.Set;
//
//public class ItemRepository implements iItemRepository {
//    private static ItemRepository repository = null;
//    private Set<Item> itemDB = null;
//
//    private ItemRepository() {
//        itemDB = new HashSet<Item>();
//    }
//
//    public static ItemRepository getRepository() {
//        if (repository == null)
//            repository = new ItemRepository();
//    return repository;
//}
//    @Override
//    public Item create(Item item) {
//        boolean created = itemDB.add(item);
//        if(created)
//            return item;
//        else
//            return null;
//    }
//
//    @Override
//    public Item read(String s) {
//        for (Item item : itemDB) {
//            if (item.getItemID().equals(item))
//                return item;
//        }
//        return null;
//    }
//
//    @Override
//    public Item update(Item item) {
//        Item updateItem = read(item.getItemID());
//
//        if (updateItem != null){
//            itemDB.remove(updateItem);
//            itemDB.add(item);
//            return item;
//        }
//        return null;
//    }
//
//    @Override
//    public boolean delete(String s) {
//        Item itemDeleted = read(s);
//
//        if (itemDeleted == null)
//            return true;
//        itemDB.remove(itemDeleted);
//        return true;
//    }
//    @Override
//    public Set<Item> getAll() {
//        return null;
//    }
//}
