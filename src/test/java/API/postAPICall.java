package API;




import io.restassured.module.jsv.JsonSchemaValidator;
import org.json.JSONObject;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.io.File;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.hasValue;


public class postAPICall {
    @Test
    public void test1_post() {

        JSONObject request = new JSONObject();

        request.put("name", "Bryant");
        request.put("Job", "BA");

        given().
                header("Content-type","application/json").
                contentType(ContentType.JSON).
                body(request.toString()).
                when().post("https://reqres.in/api/users").
                then().statusCode(201).log().all()
                .assertThat().body(JsonSchemaValidator.
                        matchesJsonSchema(new File("src\\test\\java\\API\\schema.json")))
                .assertThat().body("$", hasKey("id"));


    }

}
