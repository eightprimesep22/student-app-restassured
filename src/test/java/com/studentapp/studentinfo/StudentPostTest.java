package com.studentapp.studentinfo;

import com.studentapp.model.StudentPojo;
import com.studentapp.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

/*
 *  Created by Jay
 */
public class StudentPostTest extends TestBase {

    @Test
    public void createStudent() {

        List<String> courseList = new ArrayList<>();
        courseList.add("Selenium");
        courseList.add("API");

        StudentPojo studentPojo = new StudentPojo();
        studentPojo.setFirstName("Prime");
        studentPojo.setLastName("Testing");
        studentPojo.setEmail("prime1245@gmail.com");
        studentPojo.setProgramme("Automation Tester");
        studentPojo.setCourses(courseList);

        Response response = given().log().all()
                .header("Content-Type","application/json")
                .when()
                .body(studentPojo)
                .post();
        response.prettyPrint();
        response.then().log().all().statusCode(201);
    }
}
