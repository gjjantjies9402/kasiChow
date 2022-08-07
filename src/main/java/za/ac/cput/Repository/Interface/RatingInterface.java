package za.ac.cput.Repository.Interface;

import za.ac.cput.Entity.Rating;
import za.ac.cput.Repository.iml.iRepository;

import java.util.Set;

public interface RatingInterface extends iRepository<Rating, String> {

    public Set<Rating> getAll();
}
