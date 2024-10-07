package com.fontys.crowdfund.persistence.impl;

import com.fontys.crowdfund.model.User;
import com.fontys.crowdfund.persistence.UserRepository;
import com.fontys.crowdfund.persistence.dto.UserDTO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private static long NEXT_ID = 1;

    private final List<UserDTO> savedUsers;

    public UserRepositoryImpl() {
        this.savedUsers = new ArrayList<>();
    }

    @Override
    public boolean existsByEmail(String email) {
        return this.savedUsers
                .stream()
                .anyMatch(userDTO -> userDTO.getEmail().equals(email));
    }

    @Override
    public boolean existsById(long userId) {
        return this.savedUsers
                .stream()
                .anyMatch(userDTO -> userDTO.getId() == userId);
    }

    @Override
    public UserDTO findById(long userId) {

        System.out.println("Find by ID : -- " + this.savedUsers);


        return this.savedUsers
                .stream()
                .filter(userDTO -> userDTO.getId() == userId)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));
    }

    @Override
    public UserDTO findByEmail(String userEmail) {

        System.out.println("Find by Email : -- " + this.savedUsers);

        for (UserDTO userDTO : this.savedUsers) {
            System.out.println("EMAIL : |" + userDTO.getEmail() + "|");
        }

        return this.savedUsers
                .stream()
                .filter(userDTO -> userDTO.getEmail().equals(userEmail))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("User not found with email: " + userEmail));
    }

    @Override
    public UserDTO save(UserDTO user) {
        user.setId(NEXT_ID);
        NEXT_ID++;
        savedUsers.add(user);
        return user;
    }

    @Override
    public List<UserDTO> findAll() {
        return Collections.unmodifiableList(savedUsers);
    }

    @Override
    public int count() {
        return this.savedUsers.size();
    }
}
