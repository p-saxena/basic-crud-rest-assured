package com.student.base;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

/**
 * Created by watchmaster on 8/28/17.
 */
public class TestBase {

    /**
     * do initialization which is part of 'given' section in @test.
     */
    @BeforeClass
    public static void init()
    {
        RestAssured.baseURI="http://localhost";
        RestAssured.port=8080;
        RestAssured.basePath="/student";
    }
}
