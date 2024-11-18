package com.example.demo_one_to_many.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Classes {
    @Id
    private Long id;
    private String name;

    @OneToMany(mappedBy = "classes")
    private List<Student> students;
}
