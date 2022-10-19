///*Item.java
//Entity for Item
//Author: Nikitha Mbokotwana (218337906)
//Date: 08 April 2022
// */
//package za.ac.cput.Entity;
//
//import javax.persistence.Entity;
//import javax.persistence.Id;
//
//@Entity
//public class Item {
// @Id
//    private String itemID;
//    private String itemName;
//    private double itemPrice;
//protected Item (){
//}
//    //private constructer
//    private Item(Builder builder){
//        this.itemID = builder.itemID;
//        this.itemName = builder.itemName;
//        this.itemPrice = builder.itemPrice;
//    }
//
//    //getters
//    public String getItemID() {
//        return itemID;
//    }
//
//    public String getItemName() {
//        return itemName;
//    }
//
//    public double getItemPrice() {
//        return itemPrice;
//    }
//
//    //setters
//    public void setItemID(String itemID) {
//        this.itemID = itemID;
//    }
//
//    public void setItemName(String itemName) {
//        this.itemName = itemName;
//    }
//
//    public void setItemPrice(double itemPrice) {
//        this.itemPrice = itemPrice;
//    }
//
//    @Override
//    public String toString() {
//        return "Item{" +
//                "itemID='" + itemID + '\'' +
//                ", itemName='" + itemName + '\'' +
//                ", itemPrice=" + itemPrice +
//                '}';
//    }
//
//    public static class Builder{
//        private String itemID;
//        private String itemName;
//        private double itemPrice;
//
//        public Builder setItemID(String itemID) {
//            this.itemID = itemID;
//            return this;
//        }
//
//        public Builder setItemName(String itemName) {
//            this.itemName = itemName;
//            return this;
//        }
//
//        public Builder setItemPrice(double itemPrice) {
//            this.itemPrice = itemPrice;
//            return this;
//        }
//
//        public Builder copy(Item item){
//            this.itemID = item.itemID;
//            this.itemName = item.itemName;
//            this.itemPrice = item.itemPrice;
//            return this;
//        }
//
//        public Item build(){
//            return new Item(this);
//        }
//    }
//}
