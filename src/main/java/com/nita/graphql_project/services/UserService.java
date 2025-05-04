package com.nita.graphql_project.services;

import com.nita.graphql_project.entity.User;

import java.util.List;

public interface UserService {


    public User createUser(User user);

    public List<User> getAll();

    public User getUser(Long id);

    public User updateUser(User user);

    public void deleteUser(Long id);
}
