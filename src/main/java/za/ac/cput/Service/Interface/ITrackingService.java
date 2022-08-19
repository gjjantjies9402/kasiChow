package za.ac.cput.Service.Interface;

import za.ac.cput.Entity.Tracking;
import za.ac.cput.Service.IService;
import java.util.Set;

public interface ITrackingService extends IService<Tracking, Integer> {
    public Set<Tracking> getAll();
}