package com.example.demo.dao;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Entity
@SuperBuilder
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "apple")
@DiscriminatorValue("RED")
public class RedApple extends Apple<RedAppleTree> {
}
