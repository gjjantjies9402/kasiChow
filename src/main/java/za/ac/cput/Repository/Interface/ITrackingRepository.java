package za.ac.cput.Repository.Interface;
/**
 ITrackingRepository.java
 ITrackingRepository
 Author: Zimkhitha Nkqenkqa 216280427
 Date: 10 April 2022
 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.Entity.Tracking;


@Repository
public interface ITrackingRepository extends JpaRepository<Tracking, String> {
}
