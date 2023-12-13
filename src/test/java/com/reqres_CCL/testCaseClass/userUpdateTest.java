package com.reqres_CCL.testCaseClass;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import com.reqres_CCL.pageClass.APIRequestClass;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class userUpdateTest extends BaseUriReqRes {

    @Test
    public void testUpdateUserSuccess() {
        // Test case for a successful user update
        Response response = APIRequestClass.updateUser(2, "morpheus", "zion resident");

        // Assert the response status code is 200 (OK)
        assertEquals(response.getStatusCode(), 200);

        // Add more assertions based on your API response structure
        assertTrue(response.getBody().asString().contains("morpheus"));
        assertTrue(response.getBody().asString().contains("zion resident"));
    }

    @Test
    public void testUpdateUserNonexistentUser() {
        // Test case for updating a nonexistent user
        Response response = APIRequestClass.updateUser(999, "neo", "the one");

        // Assert the response status code is 404 (Not Found)
        assertEquals(response.getStatusCode(), 404);
    }

    @Test
    public void testUpdateUserInvalidName() {
        // Test case for updating a user with an invalid name
        Response response = APIRequestClass.updateUser(2, "", "zion resident");

        // Assert the response status code is not successful (e.g., 4xx or 5xx)
        assertTrue(response.getStatusCode() >= 400);
    }

    @Test
    public void testUpdateUserInvalidJob() {
        // Test case for updating a user with an invalid job
        Response response = APIRequestClass.updateUser(2, "morpheus", "");

        // Assert the response status code is not successful (e.g., 4xx or 5xx)
        assertTrue(response.getStatusCode() >= 400);
    }

    @Test
    public void testUpdateUserMissingData() {
        // Test case for updating a user with missing data
        Response response = APIRequestClass.updateUser(2, null, null);

        // Assert the response status code is not successful (e.g., 4xx or 5xx)
        assertTrue(response.getStatusCode() >= 400);
    }
}

