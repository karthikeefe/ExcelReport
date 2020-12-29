package TestMaven.TestMaven;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class APITest {
	
	@Test
	public void getTest() {
		String certificatesTrustStorePath = "C:\\Users\\karthikeyans.ka\\Java\\jdk-14.0.1\\lib/security/cacerts";
		System.setProperty("javax.net.ssl.trustStore", certificatesTrustStorePath);
		System.setProperty("javax.net.ssl.trustStorePassword", "changeit");
		System.out.println(System.getProperty("java.home"));
		
		
		RestAssured.baseURI = "https://gorest.co.in/public-api";
		RequestSpecification httpRequest = RestAssured.given();
		Response responce = httpRequest.request(Method.GET, "/users?name=Jai%20Varma");
		String responceBody = responce.getBody().asString();
		System.out.println(responceBody);
	}

}
