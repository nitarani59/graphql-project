package com.nita.graphql_project.repository;

import com.nita.graphql_project.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
