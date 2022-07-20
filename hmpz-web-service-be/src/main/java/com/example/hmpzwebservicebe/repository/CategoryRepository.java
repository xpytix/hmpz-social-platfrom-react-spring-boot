package com.example.hmpzwebservicebe.repository;

import com.example.hmpzwebservicebe.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}