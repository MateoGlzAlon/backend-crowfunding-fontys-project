package fontys.sem3.school.business.impl;

import fontys.sem3.school.business.GetUsersUseCase;
import fontys.sem3.school.domain.User;
import fontys.sem3.school.domain.GetUsersResponse;
import fontys.sem3.school.persistence.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GetUsersUseCaseImpl implements GetUsersUseCase {
    private final UserRepository userRepository;

    @Override
    public GetUsersResponse getUsers() {
        List<User> users = userRepository.findAll()
                .stream()
                .map(UserConverter::convert)
                .toList();

        return GetUsersResponse.builder()
                .users(users)
                .build();
    }
}
