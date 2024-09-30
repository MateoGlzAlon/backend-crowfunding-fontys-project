package com.fontys.crowdfund.controller;

import com.fontys.crowdfund.business.CreateUserUseCase;
import com.fontys.crowdfund.business.GetUsersUseCase;
import com.fontys.crowdfund.domain.CreateUserRequest;
import com.fontys.crowdfund.domain.CreateUserResponse;
import com.fontys.crowdfund.domain.GetUsersResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UsersController {
    private final GetUsersUseCase getUsersUseCase;
    private final CreateUserUseCase createUserUseCase;

    @GetMapping
    public ResponseEntity<GetUsersResponse> getUsers() {
        return ResponseEntity.ok(getUsersUseCase.getUsers());
    }

    @PostMapping()
    public ResponseEntity<CreateUserResponse> createUser(@RequestBody @Valid CreateUserRequest request) {
        CreateUserResponse response = createUserUseCase.createUser(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
