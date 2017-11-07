package com.students.tests;

import com.student.base.TestBase;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;


/**
 * Created by watchmaster on 8/27/17.
 */
public class StudentGetTest extends TestBase {

    /**
     * Rest assured uses BDD way of writing tests in given, when, then format.
     */
    @Test
    public void getAllStudentInformation(){
        /**
         * given()
            * initialization is done in given section. Eg:
            * set cookies,add auth,adding parameters,setting request header info.
         * .when()
            * in this section we consume the application resource using one of the http verbs. Eg:
            * GET,POST,PUT,DELETE..etc
         * .then()
            * in this section we perform operations on response.
            *  Validate response status code,extract response, extract headers,cookies,extract the response body
         * test to get list of all the students by using GET method on '/student/list' and validation response status code
         */

        Response response=	given()
                .when()
                .get("/list"); // access 'list' resource ie- /student/list. get method returns Response object.

        //System.out.println(response.body().prettyPrint());

        //Validate the status code

        given()
                .when()
                .get("/list")
                .then()
                .statusCode(200);

    }
    /**
     * test to get details of a particular student by using GET method on '/student/:id' and validation response status code
     */
    @Test
    public void getStudentInfo(){
        Response response=given()
                .when()
                .get("/1");

        //	System.out.println(response.body().prettyPrint());

        given()
                .when()
                .get("/1")
                .then()
                .statusCode(200);
    }

    /**
     * test to get details of 2 students who are enrolled in Financial Analysis by using GET method on '/list?programme=Financial Analysis&limit=2' and validation response status code
     */
    @Test
    public void getStudentsFromFA(){

        Response response= given()
                .param("programme", "Financial Analysis")
                .param("limit",2)
                .when()
                .get("/list");

        System.out.println(response.prettyPeek());

        given()
                .param("programme", "Financial Analysis")
                .param("limit",2)
                .when()
                .get("/list")
                .then()
                .statusCode(200);
    }
}
