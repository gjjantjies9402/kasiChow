package za.ac.cput.Repository.Interface;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.Entity.Receipt;

@Repository
public interface iReceiptRepository extends JpaRepository<Receipt,String> {

}
