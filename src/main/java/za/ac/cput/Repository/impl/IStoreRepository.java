package za.ac.cput.Repository.impl;

import za.ac.cput.Entity.Store;
import za.ac.cput.Repository.iRepository;

import java.util.List;

public interface IStoreRepository extends iRepository <Store, String> {

    List<Store> getAll();
}
