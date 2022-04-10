package za.ac.cput.Repository.Interface;

import za.ac.cput.Entity.login;
import za.ac.cput.Entity.menu;
import za.ac.cput.Repository.iml.iReposoitory;

import java.util.Set;

public interface menuInterface extends iReposoitory<menu, String> {

    public Set<menu> getAll();
}
