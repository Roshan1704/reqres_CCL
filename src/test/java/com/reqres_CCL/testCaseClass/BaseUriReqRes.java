package com.reqres_CCL.testCaseClass;

import static io.restassured.RestAssured.baseURI;

import org.testng.annotations.BeforeTest;

public class BaseUriReqRes {

    @BeforeTest
    public void before() 
    {
        baseURI = "https://reqres.in";
    }
}
