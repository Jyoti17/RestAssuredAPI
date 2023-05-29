package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.payload.Product;
import io.restassured.response.Response;


public class ProductTest {
	
	Faker faker;
	Product productpayload;
	
	
	@BeforeClass
	public void setup()
	
	{
		
		faker = new Faker();
		productpayload = new Product();
		
		productpayload.setProductname(faker.name().name());
	}
  @Test(priority=1)
	public void testProduct()  
	{
	  
	  Response response = UserEndPoints.createProduct(productpayload);
	  response.then().log().all();
	  Assert.assertEquals(response.getStatusCode(), 200);
	}
  
  /*@Test(priority=2)
  public void testGetProductByName()
  {
	  Response response= UserEndPoints.createProduct(productpayload)
	  response.then().log().all();
	  Assert.assertEquals(response.getStatusCode(), 200);
	  
	  
	  	
  }*/
	
}

