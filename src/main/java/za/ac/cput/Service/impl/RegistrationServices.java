/**
 * Mziyanda Mwanda
 * 215133765
 * ADP 3
 * Service class implementation
 * */
package za.ac.cput.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.Entity.registration;
import za.ac.cput.Repository.Interface.registrationInterface;
import za.ac.cput.Service.Interface.ICustomerService;
import za.ac.cput.Service.Interface.IRegistration;

import java.util.Set;
import java.util.stream.Collectors;
@Service

public class RegistrationServices implements IRegistration {

   private static RegistrationServices registrationServices = null;
    @Autowired
    private registrationInterface registrationRepository;

    private RegistrationServices()
    {

    }

    public static IRegistration getRegistrationServices() {

        if(registrationServices == null)
            registrationServices = new RegistrationServices();
        return registrationServices;

    }

    @Override
    public registration create(registration registration) {
        return this.registrationRepository.save(registration);
    }

    @Override
    public registration read(String s) {
        return this.registrationRepository.findById(s).orElse(null);
    }

    @Override
    public registration update(registration registration) {
        if (this.registrationRepository.existsById(registration.getUsername())){
        return this.registrationRepository.save(registration);}
        return null;
    }

    @Override
    public boolean delete(String s) {
       this.registrationRepository.deleteById(s);
       if (this.registrationRepository.existsById(s)){
           return false;
       }
        return true;
    }

    @Override
    public Set<registration> getAll() {
        return this.registrationRepository.findAll().stream().collect(Collectors.toSet());
    }
}
