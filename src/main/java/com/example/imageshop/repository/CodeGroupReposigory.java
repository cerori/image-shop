package com.example.imageshop.repository;

import com.example.imageshop.domain.CodeGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CodeGroupReposigory extends JpaRepository<CodeGroup, String> {
}
