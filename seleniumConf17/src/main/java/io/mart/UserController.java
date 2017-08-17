package io.mart;

import io.mart.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserRepository repository;

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    @ResponseBody
    User createUser(@RequestBody User user){
        return repository.createUsers(user);
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    @ResponseBody
    Collection<User> allUsers(){
        return repository.allUsers();
    }

    @RequestMapping(value = "/user/{name}", method = RequestMethod.GET)
    @ResponseBody
    User getUserByName(@PathVariable("name") String name){
        return repository.getByName(name);
    }
}
