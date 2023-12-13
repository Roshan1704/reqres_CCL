package com.reqres_CCL.pageClass;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class APIRequestClass 
{
	public static Response registerUser(String json,String REGISTER_ENDPOINT) 
    {
		Response response = given()
				.contentType(ContentType.JSON)
	            .body(json)
	        .when()
	            .post(REGISTER_ENDPOINT);
	            
	        return response;
    }
	
	public static Response getUserData(String path) 
	{
        Response response = given()
            .when()
            .get(path);
        return response;
    }
	
	public static Response updateUser(int userId, String name, String job) {
        String REGISTER_ENDPOINT = "/api/users/" + userId;

        Response response = given()
                .contentType(ContentType.JSON)
                .body("{\"name\": \"" + name + "\", \"job\": \"" + job + "\"}")
                .when()
                .put(REGISTER_ENDPOINT)
                .then()
                .extract()
                .response();
		return response;
}
	
	public static Response patchUser(int userId, String name, String job) {
        String endpoint = "/api/users/" + userId;

        return RestAssured.given()
                .contentType(ContentType.JSON)
                .body("{\"name\": \"" + name + "\", \"job\": \"" + job + "\"}")
                .when()
                .patch(endpoint)
                .then()
                .extract()
                .response();
    }
	
	public static Response deleteUser(int userId) {
        String endpoint = "/api/users/" + userId;

        return RestAssured.given()
                .when()
                .delete(endpoint)
                .then()
                .extract()
                .response();
    }
	
	public static Response loginUser(String email, String password) {
        String endpoint = "/api/login";

        return RestAssured.given()
                .contentType(ContentType.JSON)
                .body("{\"email\": \"" + email + "\", \"password\": \"" + password + "\"}")
                .when()
                .post(endpoint)
                .then()
                .extract()
                .response();
    }
	
	
	
	
}
