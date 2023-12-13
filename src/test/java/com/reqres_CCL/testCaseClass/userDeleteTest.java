package com.reqres_CCL.testCaseClass;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import com.reqres_CCL.pageClass.APIRequestClass;

import static org.testng.Assert.assertEquals;

public class userDeleteTest extends BaseUriReqRes {

    @Test
    public void testDeleteUserSuccess() {
        // Test case for successfully deleting a user
        Response response = APIRequestClass.deleteUser(2);

        // Assert the response status code is 204 (No Content)
        assertEquals(response.getStatusCode(), 204);
    }

    @Test
    public void testDeleteNonexistentUser() {
        // Test case for deleting a nonexistent user
        Response response = APIRequestClass.deleteUser(999);

        // Assert the response status code is 404 (Not Found)
        assertEquals(response.getStatusCode(), 404);
    }

    @Test
    public void testDeleteUserTwice() {
        // Test case for deleting a user twice
        APIRequestClass.deleteUser(2);
        Response response = APIRequestClass.deleteUser(2);

        // Assert the response status code is 404 (Not Found)
        assertEquals(response.getStatusCode(), 404);
    }

    @Test
    public void testDeleteUserWithoutAuthorization() 
    {
    	Response response = APIRequestClass.deleteUser(2);
        
        assertEquals(response.getStatusCode(), 401);
        // or
        // assertEquals(response.getStatusCode(), 403);
    }

    @Test
    public void testDeleteUserNegativeId() {
        // Test case for attempting to delete a user with a negative user ID
        Response response = APIRequestClass.deleteUser(-2);

        // Assert the response status code is 400 (Bad Request)
        assertEquals(response.getStatusCode(), 400);
    }
}

