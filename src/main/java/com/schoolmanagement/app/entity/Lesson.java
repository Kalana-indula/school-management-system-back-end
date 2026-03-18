package com.schoolmanagement.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.schoolmanagement.app.entity.types.Day;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "lesson")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Day day;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    @ManyToOne(optional = false)
    @JoinColumn(name = "teacher")
    private Teacher teacher;

    @ManyToOne(optional = false)
    @JoinColumn(name = "subject")
    private Subject subject;

    @ManyToOne
    @JoinColumn(name = "class_room")
    private ClassEntity classEntity;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "lesson")
    private List<Exam> exams=new ArrayList<>();

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "lesson")
    private List<Assignment> assignments=new ArrayList<>();

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "lesson")
    private List<Attendance> attendances=new ArrayList<>();
}
