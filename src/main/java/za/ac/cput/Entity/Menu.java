/**
 * Mandisa Msongelwa
 * 217149073
 * Group 28
 */
package za.ac.cput.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Menu {
    @Id
    private int menuID;
    private String menuCategory;

    protected Menu(){}

    //private constructor
    private Menu(Builder builder) {
        this.menuID = builder.menuID;
        this.menuCategory = builder.menuCategory;
    }

    //Getters & Setters & toString

    public int getMenuID() {
        return menuID;
    }

    public void setMenuID(int menuID) {
        this.menuID = menuID;
    }

    public String getMenuCategory() {
        return menuCategory;
    }

    public void setMenuCategory(String menuCategory) {
        this.menuCategory = menuCategory;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "menuID='" + menuID + '\'' +
                ", menuCategory='" + menuCategory + '\'' +
                '}';
    }

    public static class Builder {
        private int menuID;
        private String menuCategory;

        //Setters

        public Builder setMenuID(int menuID) {
            this.menuID = menuID;
            return this;
        }

        public Builder setMenuCategory(String menuCategory) {
            this.menuCategory = menuCategory;
            return this;
        }

        Builder copy(Menu menu) {
            this.menuID = menu.menuID;
            this.menuCategory = menu.menuCategory;
            return this;
        }

        public Menu build() {
            return new Menu(this);
        }
    }
}
