package com.seanatives.surfcourseplanner.SurfCoursePlanner.app;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document
@Getter
@Setter
public class SurfCourse {
    private SurfInstructor surfInstructor;
    private List<Student> students;
    private LocalDateTime timeOfCourseStart;

    public SurfCourse(SurfInstructor surfInstructor, List<Student> students, LocalDateTime timeOfCourseStart) {

        this.surfInstructor = surfInstructor;
        this.students = students;
        this.timeOfCourseStart = timeOfCourseStart;
    }
}
