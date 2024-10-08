package com.fontys.crowdfund.controller.impl;

import com.fontys.crowdfund.controller.UserController;
import com.fontys.crowdfund.persistence.dto.GetDTOProject;
import com.fontys.crowdfund.persistence.dto.GetDTOUser;
import com.fontys.crowdfund.persistence.dto.PostDTOUser;
import com.fontys.crowdfund.business.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserControllerImpl implements UserController {

    private UserService userService;

    @GetMapping
    public List<GetDTOUser> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetDTOUser> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PostMapping
    public ResponseEntity<GetDTOUser> createUser(@RequestBody PostDTOUser userDTO) {
        return ResponseEntity.ok(userService.createUser(userDTO));
    }
}
