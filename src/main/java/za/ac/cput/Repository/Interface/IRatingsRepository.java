package za.ac.cput.Repository.Interface;
/**
 IRatingsRepository.java
 IRatingsRepository
 Author: Zimkhitha Nkqenkqa 216280427
 Date: 10 April 2022
 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.Entity.Ratings;

@Repository
public interface IRatingsRepository extends JpaRepository<Ratings, String> {
}