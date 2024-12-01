// UserController.java
package com.fontys.crowdfund.controller;

import com.fontys.crowdfund.persistence.dto.outputdto.OutputDTOUser;
import com.fontys.crowdfund.persistence.dto.inputdto.InputDTOUser;
import com.fontys.crowdfund.persistence.specialdto.UserProjectDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface UserController {

    @GetMapping
    List<OutputDTOUser> getAllUsers();

    @GetMapping("/{id}")
    ResponseEntity<OutputDTOUser> getUserById(@PathVariable int id);

    @GetMapping("/project/{id}")
    ResponseEntity<UserProjectDTO> getUserDataForProject(@PathVariable int id);

    @GetMapping("/email/{email}")
    ResponseEntity<Integer> getUserIdFromEmail(@PathVariable String email);

    @PostMapping
    ResponseEntity<OutputDTOUser> createUser(@RequestBody InputDTOUser userDTO);

    @DeleteMapping("/{id}")
    ResponseEntity<OutputDTOUser> deleteProject(@PathVariable int id);
}
