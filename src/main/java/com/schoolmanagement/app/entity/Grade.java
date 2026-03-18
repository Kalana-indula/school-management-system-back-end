package com.schoolmanagement.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "grade")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,unique = true)
    private Integer level;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL,mappedBy = "grade")
    private List<Student> students;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "grade")
    private List<ClassEntity>  classes;
}
