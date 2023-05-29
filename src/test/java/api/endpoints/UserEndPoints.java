package api.endpoints;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.given;

import api.payload.Product;

public class UserEndPoints {

	public static Response createProduct(Product payload)
	{
	RequestSpecification request =given().auth().basic("deepakp+eon@yugensys.com", "Yugen@123");
		Response response = request.given().header("Device-Api-Key", "BLOeL92U.EM1HWmQmmT538ZSuUWwLHByBZyuS4uXK")
			
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(payload)
	    .when()
	    .post(Routes.post_url);
		return response;
	}
	
	public static Response ReadProduct(String productName)
	{
		Response response = given()
			.pathParam("name" , productName)
			    .when()
			    .get(Routes.get_url);
				return response;
	}
	
	

	
}
