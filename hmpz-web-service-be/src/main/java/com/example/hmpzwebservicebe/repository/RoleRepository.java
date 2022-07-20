package com.example.hmpzwebservicebe.repository;

import com.example.hmpzwebservicebe.model.ERole;
import com.example.hmpzwebservicebe.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}