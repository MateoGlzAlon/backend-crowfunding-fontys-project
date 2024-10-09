package com.fontys.crowdfund.persistence.impl;

import com.fontys.crowdfund.model.Project;
import com.fontys.crowdfund.model.User;
import com.fontys.crowdfund.persistence.UserRepository;
import com.fontys.crowdfund.persistence.dto.GetDTOProject;
import com.fontys.crowdfund.persistence.dto.GetDTOUser;
import com.fontys.crowdfund.persistence.dto.UserDTO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private static long NEXT_ID = 1;

    private final List<User> savedUsers;

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
    public GetDTOUser findById(long userId) {

        System.out.println("Find by ID : -- " + this.savedUsers);

        User user = this.savedUsers
                .stream()
                .filter(userDTO -> userDTO.getId() == userId)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));

        return GetDTOUser.builder()
                .id(user.getId())
                .email(user.getEmail())
                .name(user.getName()).build();
    }

    @Override
    public GetDTOUser findByEmail(String userEmail) {


        User user =  this.savedUsers
                .stream()
                .filter(userDTO -> userDTO.getEmail().equals(userEmail))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("A | User not found with email: " + userEmail));

        return GetDTOUser.builder()
                .id(user.getId())
                .email(user.getEmail())
                .name(user.getName()).build();
    }


    public User findUserByEmail(String userEmail) {
        return this.savedUsers
                .stream()
                .filter(userDTO -> userDTO.getEmail().equals(userEmail))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("B | User not found with email: " + userEmail));
    }

    @Override
    public GetDTOUser save(User user) {
        user.setId(NEXT_ID);
        NEXT_ID++;
        savedUsers.add(user);
        return GetDTOUser.builder()
                .id(user.getId())
                .email(user.getEmail())
                .name(user.getName()).build();

    }

    @Override
    public List<GetDTOUser> findAll() {

        List<GetDTOUser> dtoUsers = new ArrayList<>();

        for (User user : this.savedUsers) {
            GetDTOUser dtoUser = GetDTOUser.builder()
                    .id(user.getId())
                    .name(user.getName())
                    .email(user.getEmail())
                    .build();

            dtoUsers.add(dtoUser);
        }

        return Collections.unmodifiableList(dtoUsers);
    }

    @Override
    public int count() {
        return this.savedUsers.size();
    }

    @Override
    public GetDTOUser deleteById(int id) {
        for (User user : this.savedUsers) {
            if (user.getId() == id) {
                this.savedUsers.remove(user);
                return GetDTOUser.builder()
                        .id(user.getId())
                        .name(user.getName())
                        .email(user.getEmail())
                        .build();
            }
        }
        return null; // or throw new ProjectNotFoundException("Project not found with id: " + projectId);
    }
}
