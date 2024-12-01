package com.fontys.crowdfund.controller.impl;

import com.fontys.crowdfund.controller.UserController;
import com.fontys.crowdfund.persistence.dto.outputdto.OutputDTOUser;
import com.fontys.crowdfund.persistence.dto.inputdto.InputDTOUser;
import com.fontys.crowdfund.business.UserService;
import com.fontys.crowdfund.persistence.specialdto.UserProjectDTO;
import jakarta.annotation.security.RolesAllowed;
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
    @RolesAllowed({"admin"})
    public List<OutputDTOUser> getAllUsers() {
        return userService.getAllUsers();
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<OutputDTOUser> getUserById(@PathVariable int id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @Override
    @GetMapping("/project/{id}")
    public ResponseEntity<UserProjectDTO> getUserDataForProject(@PathVariable int id) {
        return ResponseEntity.ok(userService.getUserDataForProject(id));
    }


    @GetMapping("/email/{email}")
    @Override
    public ResponseEntity<Integer> getUserIdFromEmail(@PathVariable String email) {
        return ResponseEntity.ok(userService.getUserIdFromEmail(email));
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
