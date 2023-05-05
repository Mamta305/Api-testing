package stepDefenition;

import java.io.IOException;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utility.Delete_file;
import utility.playloadconverting;


public class defenition {
       
	 public static String baseurl = "https://api.github.com";
	 public static String loginpayload;
	 public static  String body_data;
	 public static String repo_name;
	 public static String sha;
	 public static Delete_file delete=new Delete_file();
	 
	 public static String bearer_token="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";
		RequestSpecification requestspecification;
		Response response;
		JsonPath jsonpath;
	 @Given("Verify the list of repos for a user")
	 public void verify_the_list_of_repos_for_a_user() throws IOException {
	     // Write code here that turns the phrase above into concrete actions
	     
	 }
	 @When("Getting the repos {string} and provide username and access token")
	 public void getting_the_repos_and_provide_username_and_access_token(String url) {
	     // Write code here that turns the phrase above into concrete actions
		requestspecification=RestAssured.given();
		requestspecification.contentType(ContentType.JSON);
		requestspecification.header("Authorization","Bearer "+bearer_token);
		 response=requestspecification.get(baseurl+url);

	 }

	 @Then("successfully executed with  status {int}")
	 public void successfully_executed_with_status(Integer statuscode) {
	     // Write code here that turns the phrase above into concrete actions
		 Assert.assertEquals(200,response.getStatusCode());
//		 System.out.println(response.getBody().asString());
	 }

//tc=08
	 @Given("Verify the lanuguage in repo")
	 public void verify_the_lanuguage_in_repo() {
	     // Write code here that turns the phrase above into concrete actions
		 
		 
	 }
	 @When("Getting the repo {string} and pass the access token")
	 public void getting_the_repo_and_pass_the_access_token(String url) {
	     // Write code here that turns the phrase above into concrete actions
		 requestspecification=RestAssured.given();
			requestspecification.contentType(ContentType.JSON);
			requestspecification.header("Authorization","Bearer "+bearer_token);
			 response=requestspecification.get(baseurl+url);
//			System.out.println(response.asString());
	    
	 }
	 @Then("sucessfully executed with status {int}")
	 public void sucessfully_executed_with_status(Integer statuscode) {
	     // Write code here that turns the phrase above into concrete actions
		 Assert.assertEquals(statuscode,response.getStatusCode());
//		 System.out.println(response.getBody().asString());
	 }
//tc-09
	
	 @Given("Verify the public repos")
	 public void verify_the_public_repos() {
	     // Write code here that turns the phrase above into concrete actions
//		 delete.setMessage("delete message");
//		 delete.setSha(sha);
//		 delete.toString();
	    
	 }
	 @When("For getting public repo for a user {string} and pass the access token")
	 public void for_getting_public_repo_for_a_user_and_pass_the_access_token(String url) {
	     // Write code here that turns the phrase above into concrete actions
		 requestspecification=RestAssured.given();
			requestspecification.contentType(ContentType.JSON);
			requestspecification.header("Authorization","Bearer "+bearer_token);
			 response=requestspecification.get(baseurl+url);
	 }
	 @Then("successfully executed with  the status {int}")
	 public void successfully_executed_with_the_status(Integer statuscode) {
	     // Write code here that turns the phrase above into concrete actions
		 Assert.assertEquals(statuscode,response.getStatusCode());
		 System.out.println(response.getBody().asString());
	 }
//tc-10
	 @Given("Create the repo first")
	 public void create_the_repo_first() throws IOException {
	     // Write code here that turns the phrase above into concrete actions
		 loginpayload=playloadconverting.generateplayloadstring("login.json");
	 }
	 @When("for creating the repo {string} and get access platform")
	 public void for_creating_the_repo_and_get_access_platform(String resourcepath) {
	     // Write code here that turns the phrase above into concrete actions
		 requestspecification=RestAssured.given().body(loginpayload);
		    requestspecification.contentType(ContentType.JSON);
		    requestspecification.header("Authorization","Bearer "+bearer_token);
		   response=requestspecification.post(baseurl+resourcepath);
	    
	 }
	 @Then("successfully executed with status of {int}")
	 public void successfully_executed_with_status_of(Integer statuscode) {
	     // Write code here that turns the phrase above into concrete actions
		 Assert.assertEquals(statuscode,response.getStatusCode());
//		 System.out.println(response.asString(),"name");
		 jsonpath=new JsonPath(response.getBody().asString());
		 repo_name=jsonpath.get("full_name");
        System.out.println(repo_name);
	 }
	//tc -10
	 @Given("create the file")
	 public void create_the_file() throws IOException {
	     // Write code here that turns the phrase above into concrete actions
		body_data=playloadconverting.generateplayloadstring("body.json");
	 }
	 @When("for creating the file {string} and get access token")
	 public void for_creating_the_file_and_get_access_token(String resourcepath) {
	     // Write code here that turns the phrase above into concrete actions
		 requestspecification=RestAssured.given().body(body_data);
		    requestspecification.contentType(ContentType.JSON);
		    requestspecification.header("Authorization","Bearer "+bearer_token);
		   response=requestspecification.put(baseurl+resourcepath);
	 }
	 @Then("sucessfully executed with the status code {int}")
	 public void sucessfully_executed_with_the_status_code(Integer statuscode) {
	     // Write code here that turns the phrase above into concrete actions
		 Assert.assertEquals(statuscode,response.getStatusCode());
		 jsonpath=new JsonPath(response.getBody().asString());
		   sha=jsonpath.get("content.sha");
		   System.out.println(sha);
	 }
	 //tc-11
	 @Given("for delete a file")
	 public void for_delete_a_file() {
	     // Write code here that turns the phrase above into concrete actions
		 delete.setMessage("my commit message to github -1");
	     delete.setSha(sha);
	    
	 }
	 @When("for deleting the file {string} and pass the access token")
	 public void for_deleting_the_file_and_pass_the_access_token(String resourcepath) {
	     // Write code here that turns the phrase above into concrete actions
	     requestspecification=RestAssured.given().body(delete.toString());
		    requestspecification.contentType(ContentType.JSON);
		    requestspecification.header("Authorization","Bearer "+bearer_token);
		   response=requestspecification.delete(baseurl+resourcepath);
	     
	 }
	 @Then("successfully executed with the status code {int}")
	 public void successfully_executed_with_the_status_code(Integer statuscode) {
	     // Write code here that turns the phrase above into concrete actions
		 Assert.assertEquals(statuscode,response.getStatusCode());
        System.out.println(response.getBody().asString());
	 }
//tc-12
	 @Given("for listing repo tags")
	 public void for_listing_repo_tags() {
	     // Write code here that turns the phrase above into concrete actions
	   
	 }
	 @When("for listing the tags {string} and send access token")
	 public void for_listing_the_tags_and_send_access_token(String url) {
	     // Write code here that turns the phrase above into concrete actions
		 requestspecification=RestAssured.given();
			requestspecification.contentType(ContentType.JSON);
			requestspecification.header("Authorization","Bearer "+bearer_token);
			 response=requestspecification.get(baseurl+url);
	 }
	 @Then("successfully execute it with status of {int}")
	 public void successfully_execute_it_with_status_of(Integer statuscode) {
	     // Write code here that turns the phrase above into concrete actions
		 Assert.assertEquals(statuscode,response.getStatusCode());
		 System.out.println(response.asString());
	 }




















   
		
      }


