package com.seanatives.surfcourseplanner.SurfCoursePlanner.app;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.PrimitiveIterator;

@Document
@Getter
@Setter
public class Student {

    private String name;
    private SurfLevel level;
    public Student() {

    }
    public Student(String name, SurfLevel level) {
        this.name=name;
        this.level = level;
    }
}
