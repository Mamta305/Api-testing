package stepDefenition;

import java.io.IOException;

import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utility.playloadconverting;

public class defenition {
       
	 public static String baseUrl = "https://api.github.com";
	 public static String token="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";
	 public static String owner;
	 public static String repo;
	 public static int autolink_id;
	 public static String payload;
	 RequestSpecification requestSpecification;
	 Response response;
	 JsonPath jsonPath;
	 
	 
	 @When("Body is ready with the filename1 {string}")
	 public void body_is_ready_with_the_filename1(String filename) throws IOException {
		 payload=playloadconverting.generateplayloadstring(filename);
		 System.out.println(payload);
	    
	 }
	 @Then("Create a repository from provided specification with {string}")
	 public void create_a_repository_from_provided_specification_with(String resources) {
		 
		 requestSpecification=RestAssured.given().body(payload);
		 requestSpecification.contentType(ContentType.JSON);
		 requestSpecification.header("Authorization","Bearer "+token);
		 response=requestSpecification.post(baseUrl+resources);
		 String res= response.asString();	
		 System.out.println(res);
		 
		 jsonPath=new JsonPath(res);
		 
		 owner=jsonPath.get("owner.login");
		 System.out.println(owner);
		 
		 repo=jsonPath.get("name");
		 System.out.println(repo);
	    
	 }
	 @Then("Veryfy the status code is1 {int}")
	 public void veryfy_the_status_code_is1(Integer statusCode) {
		 Assert.assertEquals(statusCode, response.getStatusCode());
	 }


	 @When("Get a repository from provided specification with {string}")
	 public void get_a_repository_from_provided_specification_with(String resources) {
		 
		 requestSpecification=RestAssured.given().header("Authorization","Bearer "+token);
		 requestSpecification.contentType(ContentType.JSON);
		 response=requestSpecification.get(baseUrl+resources+owner+"/"+repo);
		 String res= response.asString();	
		 System.out.println(res);
	     
	 }
	 @Then("Verify the status code is {int}")
	 public void verify_the_status_code_is(Integer statusCode) {
		 Assert.assertEquals(statusCode, response.getStatusCode());
	    
	 }

	 
	 @When("Body is ready with the filename2 {string}")
	 public void body_is_ready_with_the_filename2(String filename) throws IOException {
		 payload=playloadconverting.generateplayloadstring(filename);
		 System.out.println(payload);
	    
	 }
	 @Then("Replace all topics of repository from provided specification with {string}")
	 public void replace_all_topics_of_repository_from_provided_specification_with(String resources) {
		 
		 requestSpecification=RestAssured.given().body(payload);
		 requestSpecification.contentType(ContentType.JSON);
		 requestSpecification.header("Authorization","Bearer "+token);
		 response=requestSpecification.put(baseUrl+resources+owner+"/"+repo+"/topics");
		 String res= response.asString();	
		 System.out.println(res);
	    
	 }
	 @Then("Veryfy the status code is2 {int}")
	 public void veryfy_the_status_code_is2(Integer statusCode) {
		 Assert.assertEquals(statusCode, response.getStatusCode());
	     
	 }
	 
	 
	 @When("Get a topic of repository from provided specification with {string}")
	 public void get_a_topic_of_repository_from_provided_specification_with(String resources) {
		 requestSpecification=RestAssured.given().header("Authorization","Bearer "+token);
		 requestSpecification.contentType(ContentType.JSON);
		 response=requestSpecification.get(baseUrl+resources+owner+"/"+repo+"/topics");
		 String res= response.asString();	
		 System.out.println(res);
	     
	    
	 }
	 @Then("Veryfy the status code is3 {int}")
	 public void veryfy_the_status_code_is3(Integer statusCode) {
		 Assert.assertEquals(statusCode, response.getStatusCode());
	     
	 }
	 
	 
	 @When("Body is ready with the filename {string}")
	 public void body_is_ready_with_the_filename(String filename) throws IOException {
		 payload=playloadconverting.generateplayloadstring(filename);
		 System.out.println(payload);
	    
	 }
	 @Then("Create a Autolink Reference for a repository from provided specification with {string}")
	 public void create_a_autolink_reference_for_a_repository_from_provided_specification_with(String resources) {
		 
		 requestSpecification=RestAssured.given().body(payload);
		 requestSpecification.contentType(ContentType.JSON);
		 requestSpecification.header("Authorization","Bearer "+token);
		 response=requestSpecification.post(baseUrl+resources+owner+"/"+repo+"/autolinks");
		 String res= response.asString();	
		 System.out.println(res);
		 
		 jsonPath=new JsonPath(res);
		 
		 autolink_id=jsonPath.get("id");
		 System.out.println(autolink_id);
	     
	 }
	 @Then("Veryfy the status code is4 {int}")
	 public void veryfy_the_status_code_is4(Integer statusCode) {
		 Assert.assertEquals(statusCode, response.getStatusCode());
	     
	 }

	 
	 @When("Get Autolink Reference for a repository from provided specification with {string}")
	 public void get_autolink_reference_for_a_repository_from_provided_specification_with(String resources) {
		 requestSpecification=RestAssured.given().header("Authorization","Bearer "+token);
		 requestSpecification.contentType(ContentType.JSON);
		 response=requestSpecification.get(baseUrl+resources+owner+"/"+repo+"/autolinks/"+autolink_id);
		 String res= response.asString();	
		 System.out.println(res);
		 
	    
	 }
	 @Then("Veryfy the status code is5 {int}")
	 public void veryfy_the_status_code_is5(Integer statusCode) {
		 Assert.assertEquals(statusCode, response.getStatusCode());
	     
	 }
	 
	 
	 @When("Delete Autolink Reference for a repository from provided specification with {string}")
	 public void delete_autolink_reference_for_a_repository_from_provided_specification_with(String resources) {
		 
		 requestSpecification=RestAssured.given().header("Authorization","Bearer "+token);
		 requestSpecification.contentType(ContentType.JSON);
		 response=requestSpecification.delete(baseUrl+resources+owner+"/"+repo+"/autolinks/"+autolink_id);
		 String res= response.asString();	
		 System.out.println(res);
	    
	 }
	 @Then("Veryfy the status code is6 {int}")
	 public void veryfy_the_status_code_is6(Integer statusCode) {
		 Assert.assertEquals(statusCode, response.getStatusCode());
	    
	 }
	 
	 
	 @When("Delete a repository from provided specification with {string}")
	 public void delete_a_repository_from_provided_specification_with(String resources) {
		 requestSpecification=RestAssured.given().header("Authorization","Bearer "+token);
		 requestSpecification.contentType(ContentType.JSON);
		 response=requestSpecification.delete(baseUrl+resources+owner+"/"+repo);
		 String res= response.asString();	
		 System.out.println(res);
	     
	 }
	 @Then("Veryfy the status code is {int}")
	 public void veryfy_the_status_code_is(Integer statusCode) {
		 Assert.assertEquals(statusCode, response.getStatusCode());
	    
	 }
	 
   
		
      }


