package com.seanatives.surfcourseplanner.SurfCoursePlanner.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/surfcalendar")
public class SurfCalendarController {
    private final SurfCalendarRepository surfCalendarRepository;

    @Autowired
    public SurfCalendarController(SurfCalendarRepository surfCalendarRepository) {
        this.surfCalendarRepository = surfCalendarRepository;
    }

    @GetMapping("/all")
    public List<SurfCalendar> getAllDocuments() {
        return surfCalendarRepository.findAll();
    }
    @GetMapping("/clear")
    public String clearAllDocuments() {
        surfCalendarRepository.deleteAll();
        return "removed";
    }

    @PostMapping("student/add")
    public String addStudent(@Param("name") String name, @Param("level") String surfLevel) {
        // logic needs to go here
        return String.format("Student %s added with level %s", name, surfLevel);
    }

    @PostMapping("surfcourse/add")
    public String addSurfCourse(@Param("coursDateTime") String coursDateTime) {
        // logic needs to go here
        return String.format("new SurfCourse at %s", coursDateTime);
    }

}
