package za.ac.cput.Service.Interface;


import za.ac.cput.Entity.Supermarket;
import za.ac.cput.Service.IService;

import java.util.List;

public interface SupermarketService extends IService<Supermarket, String> {

    List<Supermarket> getAll();
}