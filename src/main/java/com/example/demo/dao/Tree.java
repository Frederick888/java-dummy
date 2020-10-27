package com.example.demo.dao;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Singular;
import lombok.experimental.SuperBuilder;

@Entity
@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@DiscriminatorColumn(name = "colour")
@EqualsAndHashCode(exclude = { "apples" })
public class Tree<APPLE extends Apple> {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String species;

    @Singular
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "tree")
    private List<APPLE> apples;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, insertable = false, updatable = false)
    private Colour colour;
}
