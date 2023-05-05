Feature: Testing the Github Api
Scenario: Verify the list of repo
Given Verify the list of repos for a user
When Getting the repos "/user/repos" and provide username and access token
Then successfully executed with  status 200

Scenario: Get the language in repo
Given Verify the lanuguage in repo
When Getting the repo "/repos/Mamta305/Api-testing/languages" and pass the access token
Then sucessfully executed with status 200

Scenario: Get the public repo
Given Verify the public repos
When For getting public repo for a user "/repositories" and pass the access token
Then successfully executed with  the status 200

Scenario: Creating the repo
Given Create the repo first 
When for creating the repo "/user/repos" and get access platform
Then successfully executed with status of 201

Scenario: Create and update the file content
Given create the file
When for creating the file "/repos/Mamta305/Hello-5/contents/res" and get access token
Then sucessfully executed with the status code 201

Scenario: Delete a file 
Given for delete a file
When for deleting the file "/repos/Mamta305/Hello-5/contents/res" and pass the access token
Then successfully executed with the status code 200

Scenario: List repository tags
Given for listing repo tags
When for listing the tags "/repos/Mamta305/Hello-5/tags" and send access token 
Then successfully execute it with status of 200
