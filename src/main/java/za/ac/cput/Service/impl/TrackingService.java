package za.ac.cput.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.Entity.Tracking;
import za.ac.cput.Repository.Interface.ITrackingRepository;
import za.ac.cput.Service.Interface.ITrackingService;

import java.util.Set;
import java.util.stream.Collectors;

public class TrackingService implements ITrackingService {

    private static ITrackingService iTrackingService = null;

    @Autowired
    private ITrackingRepository repository;

    private TrackingService() {
    }

    @Override
    public Tracking create(Tracking tracking) {
        return this.repository.save(tracking);
    }

    @Override
    public Tracking read(String s) {
        return this.repository.findById(s).orElse(null);
    }

    @Override
    public Tracking update(Tracking tracking) {
        if (this.repository.existsById(tracking.getOrderNr()))
            return this.repository.save(tracking);
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
    public Set<Tracking> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }
}
