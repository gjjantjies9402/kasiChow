package za.ac.cput.Repository.Interface;
/**
 ITrackingRepository.java
 ITrackingRepository
 Author: Zimkhitha Nkqenkqa 216280427
 Date: 10 April 2022
 */

import za.ac.cput.Entity.Tracking;
import za.ac.cput.Repository.iml.iRepository;

import java.util.Set;

public interface ITrackingRepository extends iRepository<Tracking, String> {
    Set<Tracking> getAll();
}
