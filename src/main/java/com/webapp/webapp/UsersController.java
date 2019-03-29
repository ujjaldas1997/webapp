package com.webapp.webapp;

import com.webapp.webapp.models.Users;
import com.webapp.webapp.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UsersController {
    @Autowired
    private UsersRepository repository;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Users> getAllUsers(){
        return repository.findAll();
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public Users getUserByUsername(@PathVariable("username") String username){
        return repository.findByUsername(username);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public void createUser(@Valid @RequestBody Users user){
        repository.save(user);
    }
}
