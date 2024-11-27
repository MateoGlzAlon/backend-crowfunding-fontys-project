// UserController.java
package com.fontys.crowdfund.controller;

import com.fontys.crowdfund.persistence.dto.OutputDTO.OutputDTOUser;
import com.fontys.crowdfund.persistence.dto.InputDTO.InputDTOUser;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface UserController {

    @GetMapping
    List<OutputDTOUser> getAllUsers();

    @GetMapping("/{id}")
    ResponseEntity<OutputDTOUser> getUserById(@PathVariable int id);

    @PostMapping
    ResponseEntity<OutputDTOUser> createUser(@RequestBody InputDTOUser userDTO);

    @DeleteMapping("/{id}")
    ResponseEntity<OutputDTOUser> deleteProject(@PathVariable int id);
}
