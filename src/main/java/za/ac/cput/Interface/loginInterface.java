package za.ac.cput.Interface;

import za.ac.cput.Entity.login;

import java.util.Set;

public interface loginInterface extends  iReposoitory<login, String>{

    public Set<login> getAll();


}
