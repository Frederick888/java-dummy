package com.example.demo;

import com.example.demo.dao.RedApple;
import com.example.demo.dao.RedAppleTree;
import com.example.demo.dao.Tree;
import com.example.demo.repository.AppleRepository;
import com.example.demo.repository.TreeRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DemoApplicationTests {
    @Autowired
    private TreeRepository treeRepository;
    @Autowired
    private AppleRepository appleRepository;

    @Test
    public void test() {
        Long treeId, appleId;
        {
            RedAppleTree tree = RedAppleTree.builder().apple(RedApple.builder().build()).build();
            tree = treeRepository.save(tree);
            treeId = tree.getId();
            appleId = tree.getApples().get(0).getId();
        }

        {
            Tree tree = treeRepository.getOne(treeId);
            System.out.println("Tree Class:   " + tree.getClass().toString());
            System.out.println("Tree Colour:  " + tree.getColour());
            System.out.println("Apple Class:  " + tree.getApples().get(0).getClass());
        }
    }
}
