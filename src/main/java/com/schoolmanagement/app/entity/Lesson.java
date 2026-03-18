package com.schoolmanagement.app.entity;

import com.schoolmanagement.app.entity.types.Day;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

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
    @JoinColumn(name = "class")
    private ClassEntity class;
}
