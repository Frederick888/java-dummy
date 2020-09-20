package com.example.demo.repository;

import com.example.demo.dao.Apple;
import com.example.demo.dao.Tree;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppleRepository extends JpaRepository<Apple, Long> {
    List<Apple> findAllByTree(Tree tree);
}
