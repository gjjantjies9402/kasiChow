package za.ac.cput.Repository.Interface;

import za.ac.cput.Entity.menu;
import za.ac.cput.Entity.rating;
import za.ac.cput.Repository.iml.iReposoitory;

import java.util.Set;

public interface ratingInterface extends iReposoitory<rating, String> {

    public Set<rating> getAll();
}
