package com.seanatives.surfcourseplanner.SurfCoursePlanner.app;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
@Setter
public class SurfInstructor {
    private String name;
    public SurfInstructor() {

    };

    public SurfInstructor(String name) {
        this.name = name;
    }
}
