package com.seanatives.surfcourseplanner.SurfCoursePlanner.app;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.TreeMap;

@Document
@Getter
@Setter
public class SurfCalendar {

    private Map<LocalDate, Map<LocalDateTime, SurfCourse>> surfCalendar = new TreeMap<>();

    public void addSurfCourse(LocalDate day, SurfCourse surfCourse) {
        Map<LocalDateTime, SurfCourse> surfCoursesForDay = surfCalendar.computeIfAbsent(day, k -> new TreeMap<>());
        addSurfCourse(surfCourse, surfCoursesForDay);
    }

    private static void addSurfCourse(SurfCourse surfCourse, Map<LocalDateTime, SurfCourse> surfCoursesForDay) {
        SurfCourse surfCourseAtTime = surfCoursesForDay.get(surfCourse.getTimeOfCourseStart());
        if (surfCourseAtTime != null) {
            throw new RuntimeException("There is already a surf course at this time!");
        } else {
            surfCoursesForDay.put(surfCourse.getTimeOfCourseStart(), surfCourse);
        }
    }

    public Map<LocalDateTime, SurfCourse> getCoursesForDay(LocalDate day) {
        return surfCalendar.get(day);
    }
}
