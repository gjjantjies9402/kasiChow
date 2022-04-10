package za.ac.cput.Repository.Interface;

import za.ac.cput.Entity.registration;
import za.ac.cput.Repository.iml.iReposoitory;

import java.util.Set;

public interface registrationInterface extends iReposoitory<registration, String> {

    public Set<registration> getAll();
}
