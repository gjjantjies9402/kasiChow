package za.ac.cput.Service.impl;
/*
  Author: GAYNOR JANTJIES 213069555
  POJO StoreServiceImpl.java
   Store Service file to be implemented
  Created: 13/08/2022
  */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.Entity.Store;
import za.ac.cput.Repository.Interface.IStoreRepository;
import za.ac.cput.Service.Interface.StoreService;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class StoreServiceImpl implements StoreService {



    @Autowired
    private IStoreRepository repository;

    public Set<Store> getAll(){
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }


    @Override
    public Store create(Store store){
        return this.repository.save(store);
    }
    @Override
    public Store read(String ab){
        return this.repository.findById(ab).orElse(null);
    }

    @Override
    public Store update(Store store) {
        if(this.repository.existsById(store.getStoreId())) {
            return this.repository.save(store);
        }
        return null;
    }
    @Override
    public boolean delete(String storeID) {
        this.repository.deleteById(storeID);
        return !this.repository.existsById(storeID);
    }

}
