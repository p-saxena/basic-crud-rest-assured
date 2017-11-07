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
 * POST requires message body so we need to create it.
 * Message body is created by creating object of POJO class-Student
 * The fields required in POST like firstName,lastName etc appear as member variables in the POJO class Student
 * Rest Assured supports mapping java objects to and from JSON/XML. For JSON, we must jave jackson or Gson in class path
 */
public class StudentPostTest extends TestBase {

    @Test
    public void createNewStudent() {
        ArrayList<String> courses = new ArrayList();
        courses.add("Java");
        courses.add("C++");

        Student student = new Student();
        student.setFirstName("John");
        student.setLastName("Doe");
        student.setEmail("xyz@gmail.com");
        student.setProgramme("Computer Science");
        student.setCourses(courses);

        given()
                .contentType(ContentType.JSON)
                .when()
                .body(student)  // include body in POST
                .post() // resource name is already included in basePath
                .then()
                .statusCode(201);
    }
}
