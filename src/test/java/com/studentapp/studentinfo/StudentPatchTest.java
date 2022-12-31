package com.studentapp.studentinfo;

import com.studentapp.model.StudentPojo;
import com.studentapp.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

/*
 *  Created by Jay
 */
public class StudentPatchTest extends TestBase {

    @Test
    public void updateStudentWithPatch(){
        //Homework
        StudentPojo studentPojo = new StudentPojo();
        studentPojo.setEmail("prime1245@gmail.com");
        Response response = given()
                .header("Content-Type", "application/json")
                .pathParam("id", 1)
                .body(studentPojo)
                .when()
                .patch("/{id}");
        response.then().statusCode(201);
        response.prettyPrint();
    }
}
