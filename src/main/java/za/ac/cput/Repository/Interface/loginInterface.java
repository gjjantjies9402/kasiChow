package za.ac.cput.Repository.Interface;

import za.ac.cput.Entity.login;
import za.ac.cput.Repository.iml.iReposoitory;

import java.util.Set;

public interface loginInterface extends iReposoitory<login, String> {

    public Set<login> getAll();


}
