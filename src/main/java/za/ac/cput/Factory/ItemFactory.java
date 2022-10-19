///*ItemFactory.java
//Factory for Item
//Author: Nikitha Mbokotwana (218337906)
//Date: 08 April 2022
// */
//package za.ac.cput.Factory;
//
//import za.ac.cput.Entity.Item;
//import za.ac.cput.util.Auth;
//
//public class ItemFactory {
//
//    //creating item object
//    public static Item createItem(String itemID,String itemName,double itemPrice){
//
//        if(Auth.isNullorEmpty(itemID))
//        {
//            return null;
//        }
//        return new Item.Builder().setItemID(itemID)
//                .setItemName(itemName)
//                .setItemPrice(itemPrice)
//                .build();
//    }
//}
