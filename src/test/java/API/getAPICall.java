package API;


import static org.hamcrest.Matcher.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class getAPICall
{
    @Test
    public void testSearch() {
        RestAssured.baseURI ="https://reqres.in";
        RestAssured.basePath ="/api";
        RequestSpecification httpRequest = RestAssured.given();
        Response response1 = httpRequest.queryParam("page", "2")
                .param("id", "10")
                .when().get("/users")
                .then().log().all()
                .extract().response();
        Assert.assertEquals(response1.statusCode(), 200);
     response1.then().body("data.first_name", equalTo("Byron"));

    }

}
