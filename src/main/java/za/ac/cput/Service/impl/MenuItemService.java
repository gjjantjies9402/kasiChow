package za.ac.cput.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.Entity.MenuItem;
import za.ac.cput.Repository.Interface.iMenuItemRepository;
import za.ac.cput.Service.Interface.IMenuItemService;

import java.awt.*;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class MenuItemService implements IMenuItemService {

    @Autowired
    private static MenuItemService service = null;
    private iMenuItemRepository menuItemRepository;

    @Override
    public Set<MenuItem> getAll() {return this.menuItemRepository.findAll().stream().collect(Collectors.toSet());}


    @Override
    public MenuItem create(MenuItem menuItem) {
        return this.menuItemRepository.save(menuItem);
    }

    @Override
    public MenuItem read(String s) {
        return this.menuItemRepository.findById(s).orElseGet(null);
    }

    @Override
    public MenuItem update(MenuItem menuItem) {
        return this.menuItemRepository.save(menuItem);
    }

    @Override
    public boolean delete(String s) {
        this.menuItemRepository.deleteById(s);
        return true;
    }
}
//
//
