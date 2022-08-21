package za.ac.cput.Repository.Interface;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.Entity.Contact;

@Repository
public interface IContactRepository extends JpaRepository <Contact, String> {
}
