package za.ac.cput.Service.impl;
/*
 * Author: GAYNOR JANTJIES 213069555
 * POJO SupermarketServiceImpl.java
 * Supermarket Service file to be implemented
 * Created: 13/08/2022
 * */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.Entity.Supermarket;
import za.ac.cput.Repository.Interface.ISupermarketRepository;
import za.ac.cput.Service.Interface.SupermarketService;

import java.util.List;
@Service
public class SupermarketServiceImpl implements SupermarketService {

    @Autowired
    private ISupermarketRepository repository;

    @Override
    public List<Supermarket> getAll() {
        return this.repository.findAll();
    }

    @Override
    public Supermarket create(Supermarket supermarket){
        try {
            return this.repository.save(supermarket);
        }catch(Exception e) {
            System.out.println("This is the execution"+e.getMessage());
        }

        return supermarket;
    }
    @Override
    public Supermarket read(String ab){
        return this.repository.findById(ab).orElse(null);
    }

    @Override
    public Supermarket update(Supermarket supermarket) {
        if(this.repository.existsById(supermarket.getMarketId())) {
            return this.repository.save(supermarket);
        }
        return null;
    }
    @Override
    public boolean delete(String marketID) {
        this.repository.deleteById(marketID);
        return !this.repository.existsById(marketID);
    }

}