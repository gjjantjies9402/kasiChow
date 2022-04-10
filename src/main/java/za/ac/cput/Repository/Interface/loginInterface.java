package za.ac.cput.Repository.Interface;

import za.ac.cput.Entity.login;
import za.ac.cput.Repository.iml.iRepository;

import java.util.Set;

public interface loginInterface extends iRepository<login, String> {

    public Set<login> getAll();


}
