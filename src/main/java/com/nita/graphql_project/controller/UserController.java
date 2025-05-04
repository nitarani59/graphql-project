package com.nita.graphql_project.controller;


import com.nita.graphql_project.dto.UserDto;
import com.nita.graphql_project.entity.User;
import com.nita.graphql_project.services.UserService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UserController {

    // This class is responsible for handling user-related operations
    // such as creating, updating, deleting, and retrieving user data
    // It interacts with the UserService to perform these operations

    private final UserService userService;

    /**
     * Constructor for the UserController class.
     *
     * @param userService An instance of the UserService class, which provides
     *                     methods for interacting with user data.
     */
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Retrieves a list of all users.
     *
     * @return A list of User objects representing all users.
     */
    @QueryMapping(name = "findAllUsers")
    public List<User> findAllUsers() {
        return userService.getAll();
    }

    /**
     * Retrieves a user by their ID.
     *
     * @param id The ID of the user to retrieve.
     * @return The User object representing the user with the specified ID.
     */
    @QueryMapping("findUserById")
    public User findUserById(@Argument Long id) {
        return userService.getUser(id);
    }

    /**
     * Creates a new user.
     *
     * @param user The User object representing the new user to be created.
     * @return The User object representing the newly created user.
     */
    @MutationMapping("createUser")
    public User createUser(@Argument(name = "user") UserDto user) {
        User user1 = new User();
        user1.setName(user.getName());
        user1.setEmail(user.getEmail());
        user1.setPhone(user.getPhone());
        user1.setAddress(user.getAddress());
        user1.setPassword(user.getPassword());
        user1.setRole(user.getRole());
        return userService.createUser(user1);
    }

    /**
     * Updates an existing user.
     *
     * @param user The User object representing the updated user data.
     * @return The User object representing the updated user.
     */
    @MutationMapping("updateUser")
    public User updateUser(@Argument User user) {
        return userService.updateUser(user);
    }

    /**
     * Deletes a user by their ID.
     *
     * @param id The ID of the user to be deleted.
     * @return A boolean indicating whether the user was successfully deleted.
     */
    @MutationMapping("deleteUser")
    public void deleteUser(@Argument Long id) {
        userService.deleteUser(id);
    }
}
