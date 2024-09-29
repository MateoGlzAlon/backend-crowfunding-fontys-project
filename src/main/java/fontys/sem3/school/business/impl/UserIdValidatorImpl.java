package fontys.sem3.school.business.impl;

import fontys.sem3.school.business.UserIdValidator;
import fontys.sem3.school.business.exception.InvalidUserException;
import fontys.sem3.school.persistence.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UserIdValidatorImpl implements UserIdValidator {
    private final UserRepository userRepository;

    @Override
    public void validateId(Long userId) {
        if (userId == null || !userRepository.existsById(userId)) {
            throw new InvalidUserException();
        }
    }
}
