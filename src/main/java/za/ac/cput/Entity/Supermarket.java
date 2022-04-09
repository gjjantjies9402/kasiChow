package za.ac.cput.Entity;
/**
 * Author: GAYNOR JANTJIES 213069555
 * POJO Supermarket.java
 *  Supermarket Entity file to be implemented
 * Created: 9/04/2022
 * */

public class Supermarket {

    private int supermarketId;
    private String supermarketName;
    private String supermarketLocation;

    private Supermarket(Supermarket.Builder sm){

        this.supermarketId = sm.supermarketId;
        this.supermarketName = sm.supermarketName;
        this.supermarketLocation = sm.supermarketLocation;
    }

    public int getSupermarketId() {
        return supermarketId;
    }

    public String getSupermarketName() {
        return supermarketName;
    }

    public String getSupermarketLocation() {
        return supermarketLocation;
    }

    @Override
    public String toString() {
        return "Builder{" +
                "supermarketId=" + supermarketId +
                ", supermarketName='" + supermarketName + '\'' +
                ", supermarketLocation='" + supermarketLocation + '\'' +
                '}';
    }


    public static class Builder {


        private int supermarketId;
        private String supermarketName;
        private String supermarketLocation;



        public Supermarket.Builder setSupermarketId(int supermarketId) {
            this.supermarketId = supermarketId;
            return this;
        }
        public Supermarket.Builder setSupermarketName(String supermarketName) {
            this.supermarketName = supermarketName;
            return this;
        }
        public Supermarket.Builder setSupermarketLocation(String supermarketLocation) {
            this.supermarketLocation = supermarketLocation;
            return this;
        }


        public Supermarket.Builder copy(Supermarket smk){
            this.supermarketId = smk.supermarketId;
            this.supermarketName = smk.supermarketName;
            this.supermarketLocation = smk.supermarketLocation;

            return this;
        }

        public Supermarket build() {
            return new Supermarket(this);
        }


    }}
