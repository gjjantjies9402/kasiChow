package za.ac.cput.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.Entity.login;
import za.ac.cput.Repository.Interface.loginInterface;
import za.ac.cput.Service.Interface.Ilogin;

import java.util.Set;
import java.util.stream.Collectors;
@Service
public class LoginService implements Ilogin {

    @Autowired
    private static Ilogin loginServices = null;
    private loginInterface loginRepository;

    @Override
    public login create(login logs){
        return this.loginRepository.save(logs);
    }

    @Override
    public login read(String login){
        return this.loginRepository.findById(login).orElseGet(null);
    }

    @Override
    public login update(login logs){
        return this.loginRepository.save(logs);
    }

    @Override
    public boolean delete(String s){
        this.loginRepository.deleteById(s);
        if (this.loginRepository.existsById(s)){
            return false;
        }
        return true;
    }

    @Override
    public Set<login> getAll() {
        return this.loginRepository.findAll().stream().collect(Collectors.toSet());
    }
}
