package com.students.tests;

import com.student.base.TestBase;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

/**
 * Created by watchmaster on 8/28/17.
 */
public class StudentDeleteTest extends TestBase {

    /**
     * Test for Deleting student information
     */
    @Test
    public void deleteStudent(){
        //Put the student ID here
        String studentId="101";

        given()
                .when()
                .delete("/"+studentId)
                .then()
                .statusCode(204);
    }
}
