package com.seanatives.surfcourseplanner.SurfCoursePlanner.app;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface SurfCalendarRepository extends MongoRepository<SurfCalendar, String> {
}
