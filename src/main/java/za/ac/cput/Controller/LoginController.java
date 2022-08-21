package za.ac.cput.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.Entity.login;
import za.ac.cput.Service.impl.LoginService;

import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("kasichow/login/type/")
public class LoginController {


    private LoginService loginService;

    @Autowired public LoginController(LoginService loginService){
        this.loginService = loginService;
    }

    @PostMapping("create")
    public login create(@RequestBody login log){

        login created = this.loginService.create(log);
        return loginService.create(created);
    }
    @GetMapping("read/{id}")
    public login read(@PathVariable String loginId){

        return this.loginService.read(loginId);
    }

    @PutMapping("update")
    public login update(@RequestBody login loginB){
        return this.loginService.update(loginB);
    }
    @DeleteMapping("delete")
    public boolean delete(@PathVariable String id){
        this.loginService.delete(id);
        return true;
    }
    @GetMapping("getAll")
    public Set<login> getAll(){
        return this.loginService.getAll();
    }



}
