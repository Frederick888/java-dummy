package com.example.demo.dao;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode(exclude = {"apples"})
public class Tree {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String species;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "tree")
    private List<Apple> apples;
}
