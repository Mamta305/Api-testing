Feature: API Testing of Github

Scenario: CREATE A REPOSITORY FOR A AUTHENTICATED USER
Given Given I initiate a "POST" request with the following data
When Body is ready with the filename1 "praLogin.json"
Then Create a repository from provided specification with "/user/repos"
And Veryfy the status code is1 201


Scenario: GET A REPOSITORY
Given I initiate a "GET" request with the following data
When Get a repository from provided specification with "/repos/"
Then Verify the status code is 200

Scenario: REPLACE ALL REPOSITORY TOPICS
Given I initiate a "PUT" request with the following data
When Body is ready with the filename2 "topic.json"
Then Replace all topics of repository from provided specification with "/repos/"
And Veryfy the status code is2 200

Scenario: GET ALL REPOSITORY TOPICS
Given I initiate a "GET" request with the following data
When Get a topic of repository from provided specification with "/repos/"
Then Veryfy the status code is3 200

Scenario: CREATE AN AUTOLINK REFERENCE FOR A REPOSITORY
Given I initiate a "POST" request with the following data
When Body is ready with the filename "autolink.json"
Then Create a Autolink Reference for a repository from provided specification with "/repos/"
And Veryfy the status code is4 201

Scenario: GET AN AUTOLINK REFERENCE FOR A REPOSITORY
Given I initiate a "GET" request with the following data
When Get Autolink Reference for a repository from provided specification with "/repos/"
Then Veryfy the status code is5 200

Scenario: DELETE FROM AN AUTOLINK REFERENCE FOR A REPOSITORY
Given I initiate a "DELETE" request with the following data
When Delete Autolink Reference for a repository from provided specification with "/repos/"
Then Veryfy the status code is6 204

Scenario: DELETE A REPOSITORY
Given I initiate a "DELETE" request with the following data
When Delete a repository from provided specification with "/repos/"
Then Veryfy the status code is 204
