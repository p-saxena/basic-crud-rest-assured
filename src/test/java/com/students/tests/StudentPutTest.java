package com.students.tests;

import com.student.base.TestBase;
import com.student.model.Student;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

/**
 * Created by watchmaster on 8/28/17.
 */
public class StudentPutTest extends TestBase {

    @Test
    public void updateNewStudent() {
        ArrayList<String> courses = new ArrayList();
        courses.add("Java");
        courses.add("C++");

        Student student = new Student();
        student.setFirstName("Mark");
        student.setLastName("Taylor");
        student.setEmail("xyz@gmail.com");
        student.setProgramme("Computer Science");
        student.setCourses(courses);

        given()
                .contentType(ContentType.JSON)
                .when()
                .body(student)  // include body in PUT
                .put("/101") // resource name needs id after basePath
                .then()
                .statusCode(200);
    }
}
