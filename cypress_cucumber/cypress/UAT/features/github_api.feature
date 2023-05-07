Feature: API Testing Project with Cypress-Cucumber

    # TC01 - TC06

    # 1. CREATE A REPOSITORY FOR A AUTHENTICATED USER
    Scenario: CREATE A REPOSITORY FOR A AUTHENTICATED USER
        Given Creration of Repo Execute with resource "/user/repos" by providing accessToken
        Then successfully execute with status code "201"
        And Print the status code for Create repository


    # 2. UPDATE A REPOSITORY
    Scenario: UPDATE A REPOSITORY
        Given For update the repository to this resource "/repos/" with owner and repo
        Then Updated successfully execute with status code "200"

    # 3. GET A REPOSITORY
    Scenario: GET A REPOSITORY
        Given Get the repository by resource "/repos/{owner}/{repo}" with the help of the owner and repo info
        Then The Repository Information should be returned successfully with ststus code "200"
        And Print the status code for get repository

    # CREATE FILE CONTENT
    Scenario: Create or update file content in an empty repository
        Given Update the repo by Resource "/repos/{owner}/{repo}/contents/{path}" with some path
        Then The file should be created successfully with status code 201
        And Print the status code for create file content

    # 5. CREATE A FORK
    Scenario: CREATE A FORK
        Given Fork Repository with resource "/repos/{owner}/{repo}/forks"
        Then Repository should be forked successfully with status code 202
        And Print the status code for fork the repository

    # 6. LIST FORKS
    Scenario:  LIST FORKS
        Given After forked we get the list forks of repository with resource "/repos/{owner}/{repo}/forks"
        Then Lists of forks should be returned successfully with status code 200
        And Print the status code for List Forks the repository

    # 4. DELETE A REPOSITORY
    Scenario: DELETE A REPOSITORY
        Given Delete the repository "/repos/{owner}/{repo}" with owner and repo info
        Then The repository should be deleted successfully with status code 204
        And Print the status code for Delete repository


    # TC06 - TC12
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

    Scenario: Creating the repo
        Given Create the repo first
        When for creating the repo  and pass access token
        Then successfully executed with status of 201

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

    Scenario: Delete a Repository on Github
        Given delete the repository with DELETE request
        When Deleting my repo with the resource available
        Then successfully executed with the status code 204

    # >>>>>>> f0ebf18edd63a66965c501c4d1ed8a64f1804cd1


    # Pratibhav--------------------------------------------------------------

    @sanity
    Scenario: CREATE A REPOSITORY FOR A AUTHENTICATED USER
        Given I initiate a "POST" request for creating the Repository
        When Create a repository from provided specification with "/user/repos"
        And Veryfy the status code is1 201

    @sanity
    Scenario: GET A REPOSITORY
        Given I initiate a "GET" request for geting the Repository
        When Get a repository from provided specification with "/repos/"
        Then Verify the status code is 200

    @sanity
    Scenario: REPLACE ALL REPOSITORY TOPICS
        Given I initiate a "PUT" request for replacing the Repository's all topics
        Then Replace all topics of repository from provided specification with "/repos/"
        And Veryfy the status code is2 200

    @sanity
    Scenario: GET ALL REPOSITORY TOPICS
        Given I initiate a "GET" request for geting the Repository's all topics
        When Get a topic of repository from provided specification with "/repos/"
        Then Veryfy the status code is3 200

    @sanity
    Scenario: CREATE AN AUTOLINK REFERENCE FOR A REPOSITORY
        Given I initiate a "POST" request for creating the Autolink Repository
        Then Create a Autolink Reference for a repository from provided specification with "/repos/"
        And Veryfy the status code is4 201

    @sanity
    Scenario: GET AN AUTOLINK REFERENCE FOR A REPOSITORY
        Given I initiate a "GET" request for geting the Autolink Repository
        When Get Autolink Reference for a repository from provided specification with "/repos/"
        Then Veryfy the status code is5 200

    @sanity
    Scenario: DELETE FROM AN AUTOLINK REFERENCE FOR A REPOSITORY
        Given I initiate a "DELETE" request for deleting the Autolink Repository
        When Delete Autolink Reference for a repository from provided specification with "/repos/"
        Then Veryfy the status code is6 204

    @sanity
    Scenario: DELETE A REPOSITORY
        Given I initiate a "DELETE" request for deleting the Repository
        When Delete a repository from provided specification with "/repos/"
        Then Veryfy the status code is 204