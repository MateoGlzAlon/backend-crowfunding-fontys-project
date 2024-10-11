package com.fontys.crowdfund.persistence.impl;

import com.fontys.crowdfund.model.User;
import com.fontys.crowdfund.persistence.UserRepository;
import com.fontys.crowdfund.persistence.dto.OutputDTOUser;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private static int NEXT_ID = 1;
    private final List<User> savedUsers;

    public UserRepositoryImpl() {
        this.savedUsers = new ArrayList<>();
    }

    @Override
    public boolean existsByEmail(String email) {
        return this.savedUsers
                .stream()
                .anyMatch(user -> user.getEmail().equals(email));
    }

    @Override
    public boolean existsById(int userId) {
        return this.savedUsers
                .stream()
                .anyMatch(user -> user.getId() == userId);
    }

    @Override
    public OutputDTOUser findById(int userId) {
        User user = this.savedUsers
                .stream()
                .filter(u -> u.getId() == userId)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));

        return convertToDTO(user); // Use the utility method for conversion
    }

    @Override
    public OutputDTOUser findByEmail(String userEmail) {
        User user = this.savedUsers
                .stream()
                .filter(u -> u.getEmail().equals(userEmail))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("User not found with email: " + userEmail));

        return convertToDTO(user); // Use the utility method for conversion
    }

    public User findUserByEmail(String userEmail) {
        return this.savedUsers
                .stream()
                .filter(user -> user.getEmail().equals(userEmail))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("User not found with email: " + userEmail));
    }

    @Override
    public OutputDTOUser save(User user) {
        user.setId(NEXT_ID);
        NEXT_ID++;
        savedUsers.add(user);
        return convertToDTO(user); // Use the utility method for conversion
    }

    @Override
    public List<OutputDTOUser> findAll() {
        return this.savedUsers.stream()
                .map(this::convertToDTO) // Use the utility method for conversion
                .collect(Collectors.toList());
    }

    @Override
    public int count() {
        return this.savedUsers.size();
    }

    @Override
    public OutputDTOUser deleteById(int id) {
        for (User user : this.savedUsers) {
            if (user.getId() == id) {
                this.savedUsers.remove(user);
                return convertToDTO(user); // Use the utility method for conversion
            }
        }
        return null; // or throw new UserNotFoundException("User not found with ID: " + id);
    }

    // Utility method to convert User to OutputDTOUser
    private OutputDTOUser convertToDTO(User user) {
        return OutputDTOUser.builder()
                .id(user.getId())
                .email(user.getEmail())
                .name(user.getName())
                .build();
    }
}
