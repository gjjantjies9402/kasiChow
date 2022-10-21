package za.ac.cput.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.Entity.Ratings;
import za.ac.cput.Repository.Interface.IRatingsRepository;
import za.ac.cput.Service.Interface.IRatingsService;

import java.util.Set;
import java.util.stream.Collectors;

public class RatingsService implements IRatingsService {

    private static IRatingsService ratingsService = null;

    @Autowired
    private IRatingsRepository repository;

    private RatingsService() {
    }

    @Override
    public Ratings create(Ratings ratings) {
        return this.repository.save(ratings);
    }

    @Override
    public Ratings read(String s) {
        return this.repository.findById(s).orElse(null);
    }

    @Override
    public Ratings update(Ratings ratings) {
        if (this.repository.existsById(ratings.getOrderID()))
            return this.repository.save(ratings);
        return null;
    }

    @Override
    public boolean delete(String s) {
        this.repository.deleteById(s);
        if (this.repository.existsById(s))
            return false;
        else
            return true;    }

    @Override
    public Set<Ratings> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }
}
