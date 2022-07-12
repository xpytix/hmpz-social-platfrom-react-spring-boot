package com.example.hmpzwebservicebackend.repository;

import com.example.hmpzwebservicebackend.model.Role;
import com.example.hmpzwebservicebackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {

    Optional<Role> findByName(String name);
}
