package io.codeKonnects.userservice.controller;

import io.codeKonnects.userservice.entity.Users;
import io.codeKonnects.userservice.service.UserService;
import io.codeKonnects.userservice.valueobject.ResponseTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/")
    public Users saveUser(@RequestBody Users users) {
        log.info("Inside saveUser of UserController");
        return userService.saveUser(users);
    }
    @GetMapping("/{id}")
    public ResponseTemplate getUserWithDepartment(@PathVariable("id") Long userId) {
        log.info("Inside getUserWithDepartment of UserController");
        return userService.getUserWithDepartment(userId);
    }
}
