package fontys.sem3.school.controller;

import fontys.sem3.school.business.GetUsersUseCase;
import fontys.sem3.school.domain.GetUsersResponse;
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
