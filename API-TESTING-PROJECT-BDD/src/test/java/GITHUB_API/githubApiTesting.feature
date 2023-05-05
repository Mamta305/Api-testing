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


#=======================

Scenario: CREATE A REPOSITORY FOR A AUTHENTICATED USER
When Body is ready with the filename1 "praLogin.json"
Then Create a repository from provided specification with "/user/repos"
And Veryfy the status code is1 201


Scenario: GET A REPOSITORY
When Get a repository from provided specification with "/repos/"
Then Verify the status code is 200

Scenario: REPLACE ALL REPOSITORY TOPICS
When Body is ready with the filename2 "topic.json"
Then Replace all topics of repository from provided specification with "/repos/"
And Veryfy the status code is2 200

Scenario: GET ALL REPOSITORY TOPICS
When Get a topic of repository from provided specification with "/repos/"
Then Veryfy the status code is3 200

Scenario: CREATE AN AUTOLINK REFERENCE FOR A REPOSITORY
When Body is ready with the filename "autolink.json"
Then Create a Autolink Reference for a repository from provided specification with "/repos/"
And Veryfy the status code is4 201

Scenario: GET AN AUTOLINK REFERENCE FOR A REPOSITORY
When Get Autolink Reference for a repository from provided specification with "/repos/"
Then Veryfy the status code is5 200

Scenario: DELETE FROM AN AUTOLINK REFERENCE FOR A REPOSITORY
When Delete Autolink Reference for a repository from provided specification with "/repos/"
Then Veryfy the status code is6 204

Scenario: DELETE A REPOSITORY
When Delete a repository from provided specification with "/repos/"
Then Veryfy the status code is 204