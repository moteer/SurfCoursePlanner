package com.seanatives.surfcourseplanner.SurfCoursePlanner.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

@Component
public class DatabaseLoader implements CommandLineRunner {

    private final SurfCalendarRepository repository;

    @Autowired
    public DatabaseLoader(SurfCalendarRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... strings) throws Exception {
        SurfCalendar surfCalendar = new SurfCalendar();
        SurfInstructor surfInstructor = new SurfInstructor("Lara");
        SurfInstructor surfInstructorRoy = new SurfInstructor("Roy");

        Student studentOne = new Student("Resi", SurfLevel.BEGINNERPLUS);
        Student studentTwo = new Student("Erik", SurfLevel.FIRSTTIMER);
        List<Student> students = new ArrayList<>();
        students.add(studentOne);
        students.add(studentTwo);

        LocalDate day = LocalDate.of(2023,1,1);
        LocalDateTime time = LocalDateTime.of(day, LocalTime.of(9, 0));

        surfCalendar.addSurfCourse(day, new SurfCourse(surfInstructor, students, time));
        this.repository.save(surfCalendar);

        students.add(new Student("Anna", SurfLevel.INTERMEDIATE));
        LocalDate day2 = day.plusDays(1);
        surfCalendar.addSurfCourse(day2, new SurfCourse(surfInstructorRoy, students, LocalDateTime.of(day2, LocalTime.of(11, 0))));
        this.repository.save(surfCalendar);
    }
}
