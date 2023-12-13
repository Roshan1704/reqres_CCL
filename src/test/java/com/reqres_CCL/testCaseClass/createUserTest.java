package com.reqres_CCL.testCaseClass;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.reqres_CCL.pageClass.APIRequestClass;

import io.restassured.response.Response;

public class createUserTest  extends BaseUriReqRes
{
	@Test
    public void testRegisterUser() 
    {
    	String REGISTER_ENDPOINT = "api/register";
    	String json = "{\r\n"
    			+ "    \"email\": \"eve.holt@reqres.in\",\r\n"
    			+ "    \"password\": \"pistol\"\r\n"
    			+ "}";
    	Response response = APIRequestClass.registerUser(json,REGISTER_ENDPOINT);
    	
    	Assert.assertEquals(response.getStatusCode(), 200, "Not Registered, Something went wrong");
    	Assert.assertTrue(response.contentType().toLowerCase().matches("application/json".toLowerCase() + ".*"),
                "Content Type mismatch");
    }
    
    @Test
    public void testCreateUser() 
    {
    	String REGISTER_ENDPOINT = "api/users";
    	String json = "{\r\n"
    			+ "    \"name\": \"morpheus\",\r\n"
    			+ "    \"job\": \"leader\"\r\n"
    			+ "}";
    	Response response = APIRequestClass.registerUser(json,REGISTER_ENDPOINT);
    	
    	Assert.assertEquals(response.getStatusCode(), 201, "Not Registered, Something went wrong");
    	Assert.assertTrue(response.contentType().toLowerCase().matches("application/json".toLowerCase() + ".*"),
                "Content Type mismatch");
    }
    

}
