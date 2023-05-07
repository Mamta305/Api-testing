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
	
	 public static String baseUrl = "https://api.github.com";
	// public static String token="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";
	 public static String token= "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";
	 public static String access_Token = "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"; 
	 public static String owner;
	 public static String repo;
	 public static int autolink_id;
	 public static String payload;
	 public static String LoginPayLoad;
	 RequestSpecification requestSpecification;
	
	 JsonPath jsonPath;
	
	
       
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

	// TC01 to TC-06  
	
		// 1. CREATE A REPOSITORY FOR A AUTHENTICATED USER
	
		@Given("Start With  base url of our Project")
		public void start_with_base_url_of_our_project() throws IOException {
			 LoginPayLoad=	playloadconverting.generateplayloadstring("data.json");
		}
		@When("Creration of Repo Execute {string} and provide accessToken")
		public void creration_of_repo_execute_and_provide_access_token(String resource) {
			  requestSpecification = RestAssured.given().body(LoginPayLoad);
			   requestSpecification.contentType(ContentType.JSON);
			   requestSpecification.header("Authorization", "Bearer "+ access_Token );
		    	response  = requestSpecification.post(baseUrl + resource);
		    	JsonPath js =new JsonPath(response.asString()); 
		    	repo = js.get("name"); 
		    	owner = js.get("owner.login"); 
		        System.out.println(repo);
		    	System.out.println(owner);
		   
		}
		@Then("successfully execute with status code {int}")
		public void successfully_execute_with_status_code(int statuscode) {
			Assert.assertEquals(statuscode, response.getStatusCode());
			System.out.println(response.getStatusCode());
		}


		
	  // 2. UPDATE A REPOSITORY 
		
		@Given("Base url of our Project {string} for update")
		public void base_url_of_our_project_for_update(String url) throws IOException {
			 LoginPayLoad=	playloadconverting.generateplayloadstring("updatedData.json");
//			 System.err.println(LoginPayLoad); 
		}
		@When("I update the repository {string} with owner {string} and repo {string}")
		public void for_update_our_repo_with_authorization(String resource,String owner, String repo) {
			   requestSpecification = RestAssured.given().body(LoginPayLoad);
			   requestSpecification.contentType(ContentType.JSON);
			   requestSpecification.header("Authorization", "Bearer "+ access_Token );
		       response  = requestSpecification.patch(baseUrl+resource );
		}
		@Then("Updated successfully execute with status code {int}")
		public void updated_successfully_execute_with_status_code(int statuscode) {
			
			Assert.assertEquals(statuscode, response.getStatusCode());
			System.out.println(response.getStatusCode());
		}

	  // 3. DELETE A REPOSITORY
		
		@Given("Check for authenticated with GitHub API")
		public void check_for_authenticated_with_git_hub_api() {
			 
		}
		@When("Delete the repository {string} with owner {string} and repo {string}")
		public void delete_the_repository_with_owner_and_repo(String resource, String owner , String repo) {
			   requestSpecification = RestAssured.given();
			   requestSpecification.header("Authorization", "Bearer "+ access_Token );
		    	response  = requestSpecification.delete(resource + owner + "/" + repo);
		}
		@Then("The repository should be deleted successfully with status code {int}")
		public void the_repository_should_be_deleted_successfully_with_status_code(int statuscode) {
			Assert.assertEquals(statuscode, response.getStatusCode());
			System.out.println(response.getStatusCode());
		}
	  
		// 4. GET A REPOSITORY

		@Given("Check for the authentication with GitHub API")
		public void check_for_the_authentication_with_git_hub_api() {
			RestAssured.given()
	        .header("Authorization", "Bearer " + access_Token)
	        .when()
	        .get("https://api.github.com/user")
	        .then()
	        .statusCode(200);
			
		}
		@When("Get the repository {string} information for the owner {string} and repo {string}")
		public void get_the_repository_information_for_the_owner_and_repo(String resource, String owner,String repo) {
			   requestSpecification = RestAssured.given();
			   requestSpecification.header("Authorization", "Bearer "+ access_Token );
		    	response  = requestSpecification.get(resource + owner + "/" + repo);
			
		}
		@Then("The Repository Information should be returned successfully with ststus code {int}")
		public void the_repository_information_should_be_returned_successfully_with_ststus_code(int statuscode) {
			Assert.assertEquals(statuscode, response.getStatusCode());
			System.out.println(response.getStatusCode());
			
		}
		
	    // CREATE  FILE CONTENT
		
		@Given("Check Authentication with GitHub API")
		public void check_authentication_with_git_hub_api() throws IOException {
			 LoginPayLoad=	playloadconverting.generateplayloadstring("createFile.json");
//			 System.out.println(LoginPayLoad); 
		}
		
		
		@When("Resource is {string} use to create or update file with path {string}")
		public void resource_is_use_to_create_or_update_file_with_path(String resource, String path) {
			   requestSpecification = RestAssured.given().body(LoginPayLoad);
			   requestSpecification.contentType(ContentType.JSON);
			   requestSpecification.header("Authorization", "Bearer "+ access_Token );
		       response  = requestSpecification.put(baseUrl + resource);
		}
	    
		@Then("The file should be created or updated successfully with status code {int}")
		public void the_file_should_be_created_or_updated_successfully_with_status_code(int statuscode) {
			Assert.assertEquals(statuscode, response.getStatusCode());
			System.out.println(response.getStatusCode());
		}



	 
		// 5. CREATE A FORK 
		
		@Given("User Authentication Check with GitHub API")
		public void user_authentication_check_with_GitHub_API() throws IOException {
			 LoginPayLoad=	playloadconverting.generateplayloadstring("forkedBody.json");
			 System.out.println(LoginPayLoad);  
			 RestAssured.given()
	        .header("Authorization", "Bearer " + access_Token)
	        .when()
	        .get("https://api.github.com/user")
	        .then()
	        .statusCode(200);
			
		}
		@When("Fork Repository with resource {string}")
		public void fork_repository_with_resource(String resource) {
			 requestSpecification = RestAssured.given().body(LoginPayLoad);
			 requestSpecification.contentType(ContentType.JSON);
		     requestSpecification.header("Authorization", "Bearer "+ access_Token );
	    	 response  = requestSpecification.post(baseUrl + resource);
//	    	 System.out.println(response.getBody().asString());
	    	 
	    	 
		}
	   @Then("Repository should be forked successfully with status code {int}")
		public void repository_should_be_forked_successfully_with_status_code(int statuscode) {
			Assert.assertEquals(statuscode, response.getStatusCode());
			System.out.println(response.getStatusCode());
		}
		
		// 6. LIST FORKS
	  
	   @Given("User should Authentication Check with GitHub API")
	   public void User_should_Authentication_Check_with_GitHub_API() {
		   RestAssured.given()
	       .header("Authorization", "Bearer " + access_Token)
	       .when()
	       .get("https://api.github.com/user")
	       .then()
	       .statusCode(200);
		   
	   }
	   @When("After forked we get the list of repository with resource {string}")
	   public void after_forked_we_get_the_list_of_repository_with_resource(String resource) {
		    response= RestAssured.given()
	       .header("Authorization", "Bearer " + access_Token)
	       .when()
	       .get(baseUrl + resource);
	       System.out.println(response.getBody().asString());
		   
	   }
	   @Then("Lists of forks should be returned successfully with status code {int}")
	   public void lists_of_forks_should_be_returned_successfully_with_status_code(int statuscode) {
			Assert.assertEquals(statuscode, response.getStatusCode());
			System.out.println(response.getStatusCode());
		   }
	
		
		
	// TC07 to TC12
		
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
	 public void successfully_executed_with_status(int statuscode) {
	     // Write code here that turns the phrase above into concrete actions
			Assert.assertEquals(statuscode, response.getStatusCode());
			System.out.println(response.getStatusCode());
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
	 public void sucessfully_executed_with_status(int statuscode) {
	     // Write code here that turns the phrase above into concrete actions
			Assert.assertEquals(statuscode, response.getStatusCode());
			System.out.println(response.getStatusCode());
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
	 public void successfully_executed_with_the_status(int statuscode) {
	     // Write code here that turns the phrase above into concrete actions
			Assert.assertEquals(statuscode, response.getStatusCode());
			System.out.println(response.getStatusCode());
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
	 public void successfully_executed_with_status_of(int statuscode) {
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
	 public void sucessfully_executed_with_the_status_code(int statuscode) {
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
	 public void successfully_executed_with_the_status_code(int statuscode) {
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
	 public void successfully_execute_it_with_status_of(int statuscode) {
	     // Write code here that turns the phrase above into concrete actions
		 Assert.assertEquals(statuscode,response.getStatusCode());
		 System.out.println(response.asString());
	 }


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
	 public void veryfy_the_status_code_is1(int statusCode) {
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
	 public void verify_the_status_code_is(int statusCode) {
			Assert.assertEquals(statusCode, response.getStatusCode());
			System.out.println(response.getStatusCode());
	    
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
	 public void veryfy_the_status_code_is2(int statusCode) {
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
	 public void veryfy_the_status_code_is3(int statusCode) {
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
	 public void veryfy_the_status_code_is4(int statusCode) {
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
	 public void veryfy_the_status_code_is5(int statusCode) {
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
	 public void veryfy_the_status_code_is6(int statusCode) {
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
	 public void veryfy_the_status_code_is(int statusCode) {
		 Assert.assertEquals(statusCode, response.getStatusCode());
	    
	 }

















   
		
      }


