package com.schoolmanagement.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.schoolmanagement.app.entity.types.UserGender;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "teacher")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,unique = true)
    private String username;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    @Column(nullable = false,unique = true)
    private String email;

    @Column(nullable = false,unique = true)
    private String phone;

    @Column(nullable = false)
    private String address;

    private String img;

    @Column(nullable = false)
    private String bloodType;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserGender gender;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime birthday;

    @ManyToMany
    @JoinTable(
            name = "teacher_subjects",
            joinColumns = @JoinColumn(name = "teacher_id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id")
    )
    private List<Subject>  subjects=new ArrayList<>();

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "teacher")
    private List<Lesson> lessons=new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "teacher")
    private List<ClassEntity> classes=new ArrayList<>();
}
