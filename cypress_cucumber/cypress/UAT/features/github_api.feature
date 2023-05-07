Feature: To test GITHUB API

Scenario: LIST REPOSITORIES FOR A USER
Given Verify the list of repos for a user
When  Getting the repos from api and provide username and access token
Then successfully executed with  status 200

Scenario: GET THE LANGUAGE IN REPO
When Getting the repo language and pass the access token
Then sucessfully executed with the status 200

Scenario: Get the public repo
Given Verify the public repos
When For getting public repo for a user  and pass the access token
Then successfully executed with  the status 200

# Scenario: Creating the repo
# Given Create the repo first 
# When for creating the repo  and pass access token
# Then successfully executed with status of 201

Scenario: Create and update the file content
Given create the file
When for creating the file in repo and passing the access token
Then sucessfully executed with the status code 201

Scenario: Delete a file 
Given for delete a file
When for deleting the file  and pass the access token
Then successfully executed with the status code 200

Scenario: List repository tags
Given for listing repo tags
When for listing the tags  and send access token
Then successfully executed with  the status 200
