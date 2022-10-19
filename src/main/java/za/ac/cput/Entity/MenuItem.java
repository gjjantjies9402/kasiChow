/*Item.java
Entity for MenuItem
Author: Mandisa Msongelwa [217149073]
Date: 08 April 2022
 */
package za.ac.cput.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MenuItem {
    @Id
    private String itemID;
    private String itemName;
    private double itemPrice;
    private String menuCategory;
    protected MenuItem(){
    }
    //private constructer
    private MenuItem(Builder builder){
        this.itemID = builder.itemID;
        this.itemName = builder.itemName;
        this.itemPrice = builder.itemPrice;
        this.menuCategory = builder.menuCategory;
    }

    //Getters
    public String getItemID() {
        return itemID;
    }

    public String getItemName() {
        return itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public String getMenuCategory() {
        return menuCategory;
    }

    //setters
    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public void setMenuCategory(String menuCategory) {
        this.menuCategory = menuCategory;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemID='" + itemID + '\'' +
                ", itemName='" + itemName + '\'' +
                ", itemPrice=" + itemPrice +
                ", menuCategory=" + menuCategory +
                '}';
    }

    public static class Builder{
        private String itemID;
        private String itemName;
        private double itemPrice;
        private String menuCategory;

        public Builder setItemID(String itemID) {
            this.itemID = itemID;
            return this;
        }

        public Builder setItemName(String itemName) {
            this.itemName = itemName;
            return this;
        }

        public Builder setItemPrice(double itemPrice) {
            this.itemPrice = itemPrice;
            return this;
        }

        public Builder setMenuCategory(String menuCategory) {
            this.menuCategory = menuCategory;
            return this;
        }

        public Builder copy(MenuItem item){
            this.itemID = item.itemID;
            this.itemName = item.itemName;
            this.itemPrice = item.itemPrice;
            this.menuCategory = item.menuCategory;
            return this;
        }

        public MenuItem build(){
            return new MenuItem(this);
        }
    }
}
