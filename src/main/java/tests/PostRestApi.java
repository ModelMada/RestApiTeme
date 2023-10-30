package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import utils.BaseComponent;

public class PostRestApi extends BaseComponent{
	
	@Test(priority=1)
	public void postRestApiTema() {
	File fisier = new File("data.json");
	Response response = RestAssured
			.given()
				.header("accept", "application/json")
				.header("Content-Type", "application/json")
				.body(fisier)
			.when()
				.post("/api/v1/books")
			.then()
				.assertThat().statusCode(200)
				.extract().response(); 
	
	System.out.println(response.asPrettyString());
	System.out.println(response.getStatusCode());
	
	String id = response.jsonPath().getString("id");
	System.out.println(id);
	
	assertEquals(id, "13021993");

	
}
}
