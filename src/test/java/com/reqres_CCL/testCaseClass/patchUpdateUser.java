package com.reqres_CCL.testCaseClass;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import com.reqres_CCL.pageClass.APIRequestClass;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class patchUpdateUser {

    @Test
    public void testPatchUserSuccess() {
        Response response = APIRequestClass.patchUser(2, "morpheus", "zion resident");
        assertEquals(response.getStatusCode(), 200);
        assertTrue(response.getBody().asString().contains("morpheus"));
        assertTrue(response.getBody().asString().contains("zion resident"));
    }

    @Test
    public void testPatchUserNonexistentUser() {
        Response response = APIRequestClass.patchUser(999, "neo", "the one");
        assertEquals(response.getStatusCode(), 404);
    }

    @Test
    public void testPatchUserInvalidName() {
        Response response = APIRequestClass.patchUser(2, "", "zion resident");
        assertTrue(response.getStatusCode() >= 400);
    }

    @Test
    public void testPatchUserInvalidJob() {
        Response response = APIRequestClass.patchUser(2, "morpheus", "");
        assertTrue(response.getStatusCode() >= 400);
    }

    @Test
    public void testPatchUserMissingData() {
        Response response = APIRequestClass.patchUser(2, null, null);
        assertTrue(response.getStatusCode() >= 400);
    }
}
