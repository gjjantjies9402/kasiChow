/*ContactInterface.java
Interface for ContactRepository
Author: Kanya Ramncwana (218297521)
Date: 09 April 2022*/

package za.ac.cput.Repository.Interface;


import za.ac.cput.Entity.Contact;
import za.ac.cput.Repository.iml.iRepository;

import java.util.Set;

public interface ContactInterface extends iRepository<Contact,String>
{

        public Set<Contact> getAll();

}
