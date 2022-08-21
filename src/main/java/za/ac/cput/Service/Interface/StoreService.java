package za.ac.cput.Service.Interface;


import za.ac.cput.Entity.Store;
import za.ac.cput.Service.IService;

import java.util.Set;

public interface StoreService extends IService<Store, String> {

    Set<Store> getAll();
}
