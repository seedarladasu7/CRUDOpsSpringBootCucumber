package com.example.definitions;

import static io.restassured.RestAssured.given;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

@CucumberContextConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SpringbootCucumberTestDefinitions {

	private final static String BASE_URI = "http://localhost";
	private static String addURI = "";
	private HttpHeaders headers = null;
	double empid = 0;
	String employeeId = "";
	private RestTemplate restTemplate = null;
	private ResponseEntity response = null;
	private String responseBodyPost = null;

	@LocalServerPort
	private int port;

	private ValidatableResponse validatableResponse;

	private void configureRestAssured() {
		RestAssured.baseURI = BASE_URI;
		RestAssured.port = port;
	}

	protected RequestSpecification requestSpecification() {
		configureRestAssured();
		return given();
	}

	@Given("^I Set POST employee service api endpoint for save employee")
	public void iSetPostForSaveEmployee() throws Throwable {
		addURI = "http://localhost:8080/api/v1/employees";
		System.out.println("addURI:" + addURI);
	}

	@When("^I Set request HEADER for save employee")
	public void iSetRequestHeaderForSaveEmployee() throws Throwable {
		headers = new HttpHeaders();
		headers.add("Accept", "application/json");
		headers.add("Content-Type", "application/json");
	}

	@When("^Send a POST HTTP request for save employee")
	public void sendAPostHttpRequestForSaveEmployee() throws Throwable {
		String jsonBody = "{\"id\": 1,\"firstName\": \"Ramesh\",\"lastName\": \"Fadatare\",\"emailId\": \"ramesh@gmail.com\"}";
		HttpEntity<String> entity = new HttpEntity<String>(jsonBody, headers);
		restTemplate = new RestTemplate();
		response = this.restTemplate.postForEntity(addURI, entity, String.class);
	}

	@Then("^I receive valid Response for save employee")
	public void iReceiveValidResponseForSaveEmployee() throws Throwable {
		responseBodyPost = response.getBody().toString();
		System.out.println("responseBodyPost:" + responseBodyPost);

		employeeId = getEmployeeIdFromResponse(responseBodyPost);
		System.out.println("employeeId:" + employeeId);
		Assert.hasText(responseBodyPost, employeeId);

		Assert.isTrue(response.getStatusCode() == HttpStatus.OK);
		System.out.println("Employee Has been added successfully");
	}
	
	
	@Given("^I Set GET employee service api endpoint for get employee")
	public void iSetForGetEmployee() throws Throwable {
		addURI = "http://localhost:8080/api/v1/employees/1";
		System.out.println("addURI:" + addURI);
	}

	@When("^I Set request HEADER for get employee")
	public void iSetRequestHeaderForGetEmployee() throws Throwable {
		headers = new HttpHeaders();
		headers.add("Accept", "application/json");
		headers.add("Content-Type", "application/json");
	}

	@When("^Send a GET HTTP request for get employee")
	public void sendAPostHttpRequestForGetEmployee() throws Throwable {
		//String jsonBody = "{\"id\": 2,\"firstName\": \"Ramesh\",\"lastName\": \"Fadatare\",\"emailId\": \"ramesh@gmail.com\"}";
		//HttpEntity<String> entity = new HttpEntity<String>(jsonBody, headers);
		restTemplate = new RestTemplate();
		response = this.restTemplate.getForEntity(addURI, String.class);
	}

	@Then("^I receive valid Response for get employee")
	public void iReceiveValidResponseForGetEmployee() throws Throwable {
		responseBodyPost = response.getBody().toString();
		System.out.println("responseBodyPost:" + responseBodyPost);

		employeeId = getEmployeeIdFromResponse(responseBodyPost);
		System.out.println("employeeId:" + employeeId);
		Assert.hasText(responseBodyPost, employeeId);

		Assert.isTrue(response.getStatusCode() == HttpStatus.OK);
		System.out.println("Employee Has been added successfully");
	}
	
	
	
	
	@Given("^I Set GET employee service api endpoint for get all employees")
	public void iSetGetForGetEmployeeList() throws Throwable {
		addURI = "http://localhost:8080/api/v1/employees";
		System.out.println("addURI:" + addURI);
	}

	@When("^I Set request HEADER for get all employees")
	public void iSetRequestHeaderForGetEmployeeList() throws Throwable {
		headers = new HttpHeaders();
		headers.add("Accept", "application/json");
		headers.add("Content-Type", "application/json");
	}

	@When("^Send a GET HTTP request for get all employees")
	public void sendAPostHttpRequestForGetEmployeeList() throws Throwable {
		//String jsonBody = "{\"id\": 3,\"firstName\": \"Ramesh\",\"lastName\": \"Fadatare\",\"emailId\": \"ramesh@gmail.com\"}";
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
		restTemplate = new RestTemplate();
		response = this.restTemplate.exchange(addURI, HttpMethod.GET, entity, String.class);
	}

	@Then("^I receive valid Response for get all employees")
	public void iReceiveValidResponseForGetEmployeeList() throws Throwable {
		responseBodyPost = response.getBody().toString();
		System.out.println("responseBodyPost:" + responseBodyPost);

		employeeId = getEmployeeIdFromResponse(responseBodyPost);
		System.out.println("employeeId:" + employeeId);
		Assert.hasText(responseBodyPost, employeeId);

		Assert.isTrue(response.getStatusCode() == HttpStatus.OK);
		System.out.println("Employee Has been added successfully");
	}
	
	
	
	
	@Given("^I Set PUT employee service api endpoint for update employee")
	public void iSetPostForUpdateEmployee() throws Throwable {
		addURI = "http://localhost:8080/api/v1/employees/1";
		System.out.println("addURI:" + addURI);
	}

	@When("^I Set request HEADER for update employee")
	public void iSetRequestHeaderForUpdateEmployee() throws Throwable {
		headers = new HttpHeaders();
		headers.add("Accept", "application/json");
		headers.add("Content-Type", "application/json");
	}

	@When("^Send a PUT HTTP request for update employee")
	public void sendAPostHttpRequestForUpdateEmployee() throws Throwable {
		String jsonBody = "{\"id\": 1,\"firstName\": \"Ramesh\",\"lastName\": \"Fadatare\",\"emailId\": \"ram@gmail.com\"}";
		HttpEntity<String> entity = new HttpEntity<String>(jsonBody, headers);
		restTemplate = new RestTemplate();
		response = this.restTemplate.exchange(addURI, HttpMethod.PUT, entity, String.class);
	}

	@Then("^I receive valid Response for update employee")
	public void iReceiveValidResponseForUpdateEmployee() throws Throwable {
		responseBodyPost = response.getBody().toString();
		System.out.println("responseBodyPost:" + responseBodyPost);

		employeeId = getEmployeeIdFromResponse(responseBodyPost);
		System.out.println("employeeId:" + employeeId);
		Assert.hasText(responseBodyPost, employeeId);

		Assert.isTrue(response.getStatusCode() == HttpStatus.OK);
		System.out.println("Employee Has been added successfully");
	}
	
	
	
	@Given("^I Set DELETE employee service api endpoint for delete employee")
	public void iSetDeleteForDeleteEmployee() throws Throwable {
		addURI = "http://localhost:8080/api/v1/employees/1";
		System.out.println("addURI:" + addURI);
	}

	@When("^I Set request HEADER for delete employee")
	public void iSetRequestHeaderForDeleteEmployee() throws Throwable {
		headers = new HttpHeaders();
		headers.add("Accept", "application/json");
		headers.add("Content-Type", "application/json");
	}

	@When("^Send a DELETE HTTP request for delete employee")
	public void sendAPostHttpRequestForDeleteEmployee() throws Throwable {
		//String jsonBody = "{\"id\": 5,\"firstName\": \"Ramesh\",\"lastName\": \"Fadatare\",\"emailId\": \"ramesh@gmail.com\"}";
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
		restTemplate = new RestTemplate();
		response = this.restTemplate.exchange(addURI, HttpMethod.DELETE, entity, String.class);
	}

	@Then("^I receive valid Response for delete employee")
	public void iReceiveValidResponseForDeleteEmployee() throws Throwable {
		responseBodyPost = response.getBody().toString();
		System.out.println("responseBodyPost:" + responseBodyPost);

		//employeeId = getEmployeeIdFromResponse(responseBodyPost);
		//System.out.println("employeeId:" + employeeId);
		//Assert.hasText(responseBodyPost, employeeId);

		Assert.isTrue(response.getStatusCode() == HttpStatus.OK);
		System.out.println("Employee Has been deleted successfully");
	}
	
	
	
	private String getEmployeeIdFromResponse(String resp) {
		String empId = "";

		try {
			JSONArray array = new JSONArray(new JSONObject(resp));

			for (int i = 0; i < array.length(); i++) {
				JSONObject object = array.getJSONObject(i);
				System.out.println(object.getString("id"));
				System.out.println(object.getString("firstName"));
				System.out.println(object.getString("lastName"));
				System.out.println(object.getString("emailId"));
				empId = object.getString("id");
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return empId;
	}

}
