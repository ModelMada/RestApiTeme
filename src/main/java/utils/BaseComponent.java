package utils;

import org.testng.annotations.BeforeClass;
import io.restassured.RestAssured;

public class BaseComponent {
	@BeforeClass
	public void setup() {
		RestAssured.baseURI = "https://fakerestapi.azurewebsites.net";
	}
}
