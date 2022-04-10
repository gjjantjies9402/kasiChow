package za.ac.cput.Repository.Interface;

import za.ac.cput.Entity.Store;
import za.ac.cput.Repository.iml.iRepository;

import java.util.List;

public interface IStoreRepository extends iRepository<Store, String> {

    List<Store> getAll();
}
