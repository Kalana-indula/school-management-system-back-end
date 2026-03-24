package com.schoolmanagement.app.repository.projection;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
public class ParentListProjection {
    private Long id;
    private String name;
    private String phone;
    private String address;
    private String email;
    private List<String> students = new ArrayList<>();

    public ParentListProjection(Long id, String name, String phone, String address, String email) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.email = email;
    }

    public void addStudent(String studentName) {
        if (studentName != null) {
            students.add(studentName);
        }
    }
}
