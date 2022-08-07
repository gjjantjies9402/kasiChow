package za.ac.cput.Repository.Interface;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.Entity.Store;

@Repository
public interface IStoreRepository extends JpaRepository<Store, String> {

}
