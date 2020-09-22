package com.example.demo.service.impl;

import com.example.demo.dao.Apple;
import com.example.demo.dao.Colour;
import com.example.demo.dao.Tree;
import com.example.demo.repository.TreeRepository;
import com.example.demo.service.AppleTreeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class AppleTreeServiceImpl implements AppleTreeService {
    private TreeRepository treeRepository;

    @Autowired
    public AppleTreeServiceImpl(TreeRepository treeRepository) {
        this.treeRepository = treeRepository;
    }

    @Override
    public void execute() {
        Apple redApple = Apple.builder().colour(Colour.RED).build();
        try {
            Tree tree = treeRepository.findOne((long) 1);
            List<Apple> apples = tree.getApples();
            apples.stream().forEach(apple -> log.info("{}", apple.getColour()));
        } catch (Exception ex) {
            log.error(ex.getMessage());
        }
    }
}
