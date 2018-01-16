package com.giroux.kevin.dofustuff.network;


import com.giroux.kevin.dofustuff.commons.security.User;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserWS {

    @RequestMapping(method = RequestMethod.GET, value = "/{login}")
    public User retrieveUserByLogin(@PathVariable("login") final String login){


        return null;
    }


    @RequestMapping(method = RequestMethod.PUT, value = "/")
    public void createOrUpdateUser(@RequestBody final User user){


    }


    @RequestMapping(method = RequestMethod.DELETE, value = "/{login}")
    public void deleteUser(@PathVariable("login") final String login){


    }
}
