package com.reqres_CCL.testCaseClass;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.reqres_CCL.pageClass.APIRequestClass;

import io.restassured.response.Response;

public class getUserTest extends BaseUriReqRes 
{
    @Test
    public void testGetAllUsersPaged() 
    {
//		Scanner sc= new Scanner(System.in);
//		System.out.print("Enter page number: ");
//		int page_number= sc.nextInt();
		int page_number=2;
    	String path="/api/users";
    	path = path+"?page="+page_number;
        Response response = APIRequestClass.getUserData(path);
        Assert.assertEquals(response.getStatusCode(), 200, "Something went wrong");
     // Regular expression assertion for partial match
        Assert.assertTrue(response.contentType().toLowerCase().matches("application/json".toLowerCase() + ".*"),
                "Content Type mismatch");

    }
//
    @Test
    public void testGetSingleUser() 
    {
//		Scanner sc= new Scanner(System.in);
//		System.out.print("Enter user id: ");
//		int user_id= sc.nextInt();
		int user_id=2;
		String USERS_ENDPOINT="/api/users";
		USERS_ENDPOINT = USERS_ENDPOINT+"/"+user_id;
        Response response = APIRequestClass.getUserData(USERS_ENDPOINT);
        
      //User Not found
        Assert.assertNotEquals(response.getStatusCode(), 404, "User Not Found with user id: "+user_id+" ");
        
        Assert.assertEquals(response.getStatusCode(), 200, "Something went wrong");
        Assert.assertTrue(response.contentType().toLowerCase().matches("application/json".toLowerCase() + ".*"),
                "Content Type mismatch");
        Object id = response.path("data.id");
        Assert.assertEquals(id, user_id,"Wrong users details");
        long actualResponseTime = response.getTime();
        Assert.assertTrue(actualResponseTime < 1000, "Response time is not less than 1 sec");
        
    }
    
    @Test
    public void testGetAllUnknownUsersPaged() 
    {
    	String path="/api/unknown";
        Response response = APIRequestClass.getUserData(path);
        Assert.assertEquals(response.getStatusCode(), 200, "Something went wrong");
     // Regular expression assertion for partial match
        Assert.assertTrue(response.contentType().toLowerCase().matches("application/json".toLowerCase() + ".*"),
                "Content Type mismatch");

    }
//
    @Test
    public void testGetSingleUnknownUser() 
    {
//		Scanner sc= new Scanner(System.in);
//		System.out.print("Enter user id: ");
//		int user_id= sc.nextInt();
		int user_id=2;
		String USERS_ENDPOINT="/api/unknown";
		USERS_ENDPOINT = USERS_ENDPOINT+"/"+user_id;
        Response response = APIRequestClass.getUserData(USERS_ENDPOINT);
        
      //Unknown User Not found
        Assert.assertNotEquals(response.getStatusCode(), 404, "User Not Found with user id: "+user_id+" ");
        
        Assert.assertEquals(response.getStatusCode(), 200, "Something went wrong");
        Assert.assertTrue(response.contentType().toLowerCase().matches("application/json".toLowerCase() + ".*"),
                "Content Type mismatch");
        Object id = response.path("data.id");
        Assert.assertEquals(id, user_id,"Wrong users details");
        long actualResponseTime = response.getTime();
        Assert.assertTrue(actualResponseTime < 1000, "Response time is not less than 1 sec");
        
    }

}
