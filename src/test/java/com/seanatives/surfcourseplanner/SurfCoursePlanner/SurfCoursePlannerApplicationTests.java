package com.seanatives.surfcourseplanner.SurfCoursePlanner;

import com.seanatives.surfcourseplanner.SurfCoursePlanner.app.Student;
import com.seanatives.surfcourseplanner.SurfCoursePlanner.app.SurfCalendar;
import com.seanatives.surfcourseplanner.SurfCoursePlanner.app.SurfCourse;
import com.seanatives.surfcourseplanner.SurfCoursePlanner.app.SurfInstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;
import static java.util.Arrays.copyOfRange;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@SpringBootTest
class SurfCoursePlannerApplicationTests {

	@Test
	void createSimpleCalendar() {
		SurfCalendar surfCalendar = new SurfCalendar();

		LocalDate aDay = LocalDate.parse("2023-12-03");
		Student studentOne = new Student();
		Student studentTwo = new Student();
		List<Student> students = asList(studentOne, studentTwo);
		SurfInstructor surfInstructorOne = new SurfInstructor();
		SurfCourse surfCourse = new SurfCourse(surfInstructorOne, students, LocalDateTime.of(2023, 9, 7, 9,0));

		surfCalendar.addSurfCourse(aDay, surfCourse);

		Student studentThree = new Student();
		List<Student> moreStudents = asList(studentOne, studentTwo, studentThree);
		SurfCourse surfCourseTwo = new SurfCourse(surfInstructorOne, students, LocalDateTime.of(2023, 9, 7, 11,0));

		surfCalendar.addSurfCourse(aDay, surfCourseTwo);

		Map<LocalDateTime, SurfCourse> coursesForDay = surfCalendar.getCoursesForDay(aDay);
		assertThat(coursesForDay.size(), is(2));
		assertThat(coursesForDay, hasEntry(LocalDateTime.of(2023, 9,7,9,0), surfCourse));
		assertThat(coursesForDay, hasEntry(LocalDateTime.of(2023, 9,7,11,0), surfCourseTwo));
	}



}
