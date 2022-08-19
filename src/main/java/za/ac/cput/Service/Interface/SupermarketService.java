package za.ac.cput.Service.Interface;

import za.ac.cput.Entity.Supermarket;
import za.ac.cput.Service.IService;

import java.util.Set;

public interface SupermarketService extends IService<Supermarket, String> {

    Set<Supermarket> getAll();
}