package za.ac.cput.Service.Interface;

import za.ac.cput.Entity.MenuItem;
import za.ac.cput.Service.IService;

import java.util.Set;

public interface IMenuItemService extends IService<MenuItem, String> {

    Set<MenuItem> getAll();
}
//
