package com.reqres_CCL.testCaseClass;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import com.reqres_CCL.pageClass.APIRequestClass;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class loginUserTest  extends BaseUriReqRes {

    @Test
    public void testLoginUserSuccess() {
        // Test case for successful user login
        Response response = APIRequestClass.loginUser("eve.holt@reqres.in", "cityslicka");

        // Assert the response status code is 200 (OK)
        assertEquals(response.getStatusCode(), 200);

        // Add more assertions based on your API response structure
        assertTrue(response.getBody().asString().contains("token"));
    }

    @Test
    public void testLoginUserInvalidEmail() {
        // Test case for attempting to login with an invalid email
        Response response = APIRequestClass.loginUser("invalid_email", "cityslicka");

        // Assert the response status code is not successful (e.g., 4xx or 5xx)
        assertTrue(response.getStatusCode() >= 400);
    }

    @Test
    public void testLoginUserInvalidPassword() {
        // Test case for attempting to login with an invalid password
        Response response = APIRequestClass.loginUser("eve.holt@reqres.in", "invalid_password");

        // Assert the response status code is not successful (e.g., 4xx or 5xx)
        assertTrue(response.getStatusCode() >= 400);
    }

    @Test
    public void testLoginUserMissingEmail() {
        // Test case for attempting to login without providing an email
        Response response = APIRequestClass.loginUser("", "cityslicka");

        // Assert the response status code is not successful (e.g., 4xx or 5xx)
        assertTrue(response.getStatusCode() >= 400);
    }

    @Test
    public void testLoginUserMissingPassword() {
        // Test case for attempting to login without providing a password
        Response response = APIRequestClass.loginUser("eve.holt@reqres.in", "");

        // Assert the response status code is not successful (e.g., 4xx or 5xx)
        assertTrue(response.getStatusCode() >= 400);
    }
}

