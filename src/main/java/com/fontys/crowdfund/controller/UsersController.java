package com.fontys.crowdfund.controller;

import com.fontys.crowdfund.business.GetUsersUseCase;
import com.fontys.crowdfund.domain.GetUsersResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UsersController {
    private final GetUsersUseCase getUsersUseCase;

    @GetMapping
    public ResponseEntity<GetUsersResponse> getUsers() {
        return ResponseEntity.ok(getUsersUseCase.getUsers());
    }

}
