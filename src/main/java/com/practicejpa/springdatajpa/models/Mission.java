package com.practicejpa.springdatajpa.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_mission")
public class Mission {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private int duration;

    @ManyToMany(mappedBy = "missions")
    private List<Employee> employees;
}
