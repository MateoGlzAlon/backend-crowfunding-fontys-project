package fontys.sem3.school.business;

import fontys.sem3.school.business.exception.InvalidUserException;

public interface UserIdValidator {
    void validateId(Long userId) throws InvalidUserException;
}
