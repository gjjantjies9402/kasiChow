package za.ac.cput.Repository.Interface;

import za.ac.cput.Entity.registration;
import za.ac.cput.Repository.iml.iRepository;

import java.util.Set;

public interface registrationInterface extends iRepository<registration, String> {

    public Set<registration> getAll();
}
