package za.ac.cput.Repository.Interface;

import za.ac.cput.Entity.Supermarket;
import za.ac.cput.Repository.iml.iRepository;

import java.util.List;

public interface ISupermarketRepository extends iRepository<Supermarket, String> {

        List<Supermarket> getAll();
        }