package com.v.controller;

import com.v.domain.AppUser;
import com.v.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by zhlingyu on 2016/7/28.
 */

@RestController
public class HelloController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping(value = "/user/{username}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public AppUser create(@PathVariable String username) {
        return userRepository.save(new AppUser(username));
    }

    @RequestMapping("/a")
    public String vv() {
        return  userRepository.save(new AppUser("vv")).getUsername();
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<AppUser> findAll() {
        final List<AppUser> resultList = new ArrayList<AppUser>();
        final Iterator<AppUser> all = userRepository.findAll().iterator();
        while (all.hasNext()){
            resultList.add(all.next());
        }
        return resultList;
    }
}
