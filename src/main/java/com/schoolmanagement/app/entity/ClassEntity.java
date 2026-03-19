package com.schoolmanagement.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "class_room")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ClassEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,unique = true)
    private String name;

    @Column(nullable = false)
    private Integer capacity;

    @ManyToOne
    @JoinColumn(name = "grade")
    private Grade grade;

    @ManyToOne
    @JoinColumn(name = "teacher")
    private Teacher teacher;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "classEntity")
    private List<Lesson> lessons=new ArrayList<>();

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "classEntity")
    private List<Student> students=new ArrayList<>();

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "classEntity")
    private List<Event> events=new ArrayList<>();

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "classEntity")
    private List<Announcement> announcements=new ArrayList<>();
}
