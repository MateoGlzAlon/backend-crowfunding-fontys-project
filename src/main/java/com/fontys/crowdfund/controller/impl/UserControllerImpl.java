package com.fontys.crowdfund.controller.impl;

import com.fontys.crowdfund.controller.UserController;
import com.fontys.crowdfund.persistence.dto.OutputDTO.OutputDTOUser;
import com.fontys.crowdfund.persistence.dto.InputDTO.InputDTOUser;
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

    @Override
    @GetMapping
    public List<OutputDTOUser> getAllUsers() {
        return userService.getAllUsers();
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<OutputDTOUser> getUserById(@PathVariable int id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @Override
    @PostMapping
    public ResponseEntity<OutputDTOUser> createUser(@RequestBody InputDTOUser userDTO) {
        return ResponseEntity.ok(userService.createUser(userDTO));
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<OutputDTOUser> deleteProject(@PathVariable int id) {
        return ResponseEntity.ok().build();
    }
}
