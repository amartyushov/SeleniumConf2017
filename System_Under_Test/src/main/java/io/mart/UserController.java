package io.mart;

import io.mart.dto.User;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
    @ApiOperation(nickname = "createUser", value = "Create a user", notes = "", response = User.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "An array with failed indexes"),
            @ApiResponse(code = 400, message = "")})
    User createUser(@RequestBody User user){
        return repository.createUsers(user);
    }

    @ApiOperation(nickname = "getUsers", value = "Get users", notes = "", response = User.class, responseContainer = "List")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "An array with failed indexes"),
            @ApiResponse(code = 400, message = "")})
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
