package com.example.demo.dao;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "tree")
@DiscriminatorValue("RED")
@SuperBuilder
public class RedAppleTree extends Tree<RedApple> {
}
