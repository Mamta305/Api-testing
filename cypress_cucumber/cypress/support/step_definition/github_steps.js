import {before, Given, When, And, Then} from "cypress-cucumber-preprocessor/steps";

let token="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";
let baseUrl = Cypress.config().baseUrl;
let name="Dummy";
let res;
let owner="Mamta305";
let fname="cont";
let sha;

var baseUrl_A = "https://api.github.com";
var token_A = "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";
var repo_A = 'postmanRepo';
var updatedRepo = 'updatedPostmanRepo';
var owner_A = "Abhay0123";
var path_A = "createdFile"



// 1. CREATE A REPOSITORY FOR A AUTHENTICATED USER
Given("Creration of Repo Execute with resource {string} by providing accessToken",(resource)=>{
  cy.request({
      method: 'POST',
      url: baseUrl_A+resource,
      headers: {
        Authorization: `Bearer ${token_A}`,
        "Content-Type": "application/json"
      },
       body: {
         name: repo_A,
         description:"repository creation"
      },
}).as('createdRepo')

})
Then("successfully execute with status code {string}",(code)=>{
cy.get("@createdRepo").should((res)=>{
   expect(res.status).to.equal(201);
})  
})
And("Print the status code for Create repository",()=>{
  cy.get("@createdRepo").then((res)=>{
      console.log(res.body)
      cy.log(res.body);
   })
}) 
//# 2. UPDATE A REPOSITORY
Given('For update the repository to this resource {string} with owner and repo',(resource)=>{
     cy.request({
      method: 'PATCH',
      url: baseUrl_A + resource + owner_A +"/"+ repo_A,
      headers: {
        Authorization: `Bearer ${token_A}`,
        "Content-Type": "application/json"
      },
       body: {
         name: updatedRepo,
         description:"repository creation"
      },
}).as('forUpdateRepo')
})

Then('Updated successfully execute with status code {string}',(code)=>{
  cy.get("@forUpdateRepo").should((res)=>{
     expect(res.status).to.equal(200);
  })  
})

// 3. GET A REPOSITORY
Given('Get the repository by resource {string} with the help of the owner and repo info',(resource)=>{
  cy.request({
      method: 'GET',
      url: `${baseUrl_A}/repos/${owner_A}/${updatedRepo}`,
      headers: {
        Authorization: `Bearer ${token_A}`,
        "Content-Type": "application/json"
      }
}).as('getRepo')
})
Then("The Repository Information should be returned successfully with ststus code {string}",(code)=>{
  cy.get("@getRepo").should((res)=>{
      expect(res.status).to.equal(200);
   }) 
}) 
And("Print the status code for get repository",()=>{
  cy.get("@getRepo").then((res)=>{
      cy.log(res);
   }) 
})

// 4. DELETE A REPOSITORY
Given('Delete the repository {string} with owner and repo info',(resource)=>{
  cy.request({
      method: 'DELETE',
      url: `${baseUrl_A}/repos/${owner_A}/${updatedRepo}`,
      headers: {
        Authorization: `Bearer ${token_A}`,
        "Content-Type": "application/json"
      }
}).as('deleteRepo')
})
Then("The repository should be deleted successfully with status code 204",(code)=>{
  cy.get("@deleteRepo").should((res)=>{
      expect(res.status).to.equal(204);
   }) 
}) 
And("Print the status code for Delete repository",()=>{
  cy.get("@deleteRepo").then((res)=>{
      cy.log(res);
   }) 
})

//CREATE FILE CONTENT 
Given('Update the repo by Resource {string} with some path',(resource)=>{
  cy.request({
      method: 'PUT',
      url: `${baseUrl_A}/repos/${owner_A}/${updatedRepo}/contents/${path_A}`,
      headers: {
        Authorization: `Bearer ${token_A}`,
        "Content-Type": "application/json"
      },
      body:{
            message:"my commit message",
            committer:{"name":"Monalisa Octocat","email":"octocat@github.com"},
            content:"bXkgbmV3IGZpbGUgY29udGVudHM="
          }
}).as('createdFileInRepo')
})
Then("The file should be created successfully with status code 201",(code)=>{
  cy.get("@createdFileInRepo").should((res)=>{
      expect(res.status).to.equal(201);
   }) 
}) 
And("Print the status code for create file content",()=>{
  cy.get("@createdFileInRepo").then((res)=>{
      cy.log(res);
   }) 
})

// 5. CREATE A FORK 
Given('Fork Repository with resource {string}',(resource)=>{
  cy.request({
      method: 'POST',
      url: `${baseUrl_A}/repos/${owner_A}/${updatedRepo}/forks`,
      headers: {
        Authorization: `Bearer ${token_A}`,
        "Accept": "application/json"
      },
      body:{
         
          "name":"forked-repo-cypress-cucumber",
         
      }
}).as('forkedRepo')
})
Then("Repository should be forked successfully with status code 202",(code)=>{
  cy.get("@forkedRepo").should((res)=>{
     
      expect(res.status).to.equal(202);
   }) 
}) 
And("Print the status code for fork the repository",()=>{
  cy.get("@forkedRepo").then((res)=>{
      cy.log(res);
   }) 
})

// 6. LIST FORKS
Given('After forked we get the list forks of repository with resource {string}',(resource)=>{
  cy.request({
      method: 'GET',
      url: `${baseUrl_A}/repos/${owner_A}/${updatedRepo}/forks`,
      headers: {
        Authorization: `Bearer ${token_A}`,
        "Content-Type": "application/json"
      }
}).as('listForkedRepo')
})
Then("Lists of forks should be returned successfully with status code 200",(code)=>{
  cy.get("@listForkedRepo").should((res)=>{
      expect(res.status).to.equal(200);
   }) 
}) 
And("Print the status code for List Forks the repository",()=>{
  cy.get("@listForkedRepo").then((res)=>{
      cy.log(res.body);
   }) 
})
//tc-07
Given('Verify the list of repos for a user',()=>{


})

When('Getting the repos from api and provide username and access token',()=>{
    cy.request({
        method: 'GET',
        url: `${baseUrl}/user/repos`,
        headers: {
          Authorization: `Bearer ${token}`,
          accept:"application/json",
        },
      }).as('repositories')
})
Then('successfully executed with  status 200',()=>{
    cy.get("@repositories").should((response) => {
        expect(response.status).to.equal(200);
        expect(response.body).to.be.an("array");
      });
})
//tc-08
When('Getting the repo language and pass the access token',()=>{
    cy.request({
        method: 'GET',
        url: `${baseUrl}/repos/Mamta305/Api-testing/languages`,
        headers: {
          Authorization: `Bearer ${token}`,
          accept:"application/json",
        },
      }).as('repositories')
})
Then('sucessfully executed with the status 200',()=>{
    cy.get("@repositories").should((response) => {
        // cy.log(response.body);
        expect(response.status).to.equal(200);
      });
    })
//tc-09
    Given('Verify the public repos',()=>{
//for getting access token

    })
    
    When('For getting public repo for a user  and pass the access token',()=>{
        cy.request({
            method: 'GET',
            url: `${baseUrl}/repositories`,
            headers: {
              Authorization: `Bearer ${token}`,
              accept:"application/json",
            },
          }).as('repositories')
    })
    Then('successfully executed with  the status 200',()=>{
        cy.get("@repositories").should((response) => {
            expect(response.status).to.equal(200);
            // expect(response.body).to.be.an("array");
          });
    })

//tc-10
Given('Create the repo first',()=>{
    //for getting access token
    
        })
        
        When('for creating the repo  and pass access token',()=>{
            cy.request({
                method: 'POST',
                url: `${baseUrl}/user/repos`,
                headers: {
                  Authorization: `Bearer ${token}`,
                  accept:"application/json",
                },
                body:{"name":name,
                "description":"This is your first repo!",
                "homepage":"https://github.com",
                "private":false,
                "is_template":true
            }
              }).as('repositories')
        })
        Then('successfully executed with status of 201',()=>{
            cy.get("@repositories").then((response) => {
                expect(response.status).to.equal(201);
                // cy.task("log", response.body);
                res=JSON.parse(JSON.stringify(response.body));
                cy.log(res.body);
                // expect(response.body).to.be.an("array");
              });

              
        })
Given('create the file',()=>{
    //for getting access token
    
        })
        
        When('for creating the file in repo and passing the access token',()=>{
            cy.request({
                method: 'PUT',
                url: `${baseUrl}/repos/${owner}/${name}/contents/${fname}`,
                headers: {
                  Authorization: `Bearer ${token}`,
                  accept:"application/json",
                },
                body:{
                    "message":"my commit message to github -1",
                    "committer":{"name":"Monalisa Octocat",
                    "email":"octocat@github.com"},
                    "content":"bXkgbmV3IGZpbGUgY29udGVudHM="
            }
              }).as('repositories')
        })
        Then('sucessfully executed with the status code 201',()=>{
            cy.get("@repositories").then((response) => {
                // console.log(response.body.content.sha);
                expect(response.status).to.equal(201);
                // cy.task("log", response.body);
                res=JSON.parse(JSON.stringify(response.body));
                sha=res.content.sha;
                cy.log(sha);
                // expect(response.body).to.be.an("array");
              });

              
        })
        //tc-11

        Given('for delete a file',()=>{
            //for getting access token
            
                })
                
                When('for deleting the file  and pass the access token',()=>{
                    cy.request({
                        method: 'DELETE',
                        url: `${baseUrl}/repos/${owner}/${name}/contents/${fname}`,
                        headers: {
                          Authorization: `Bearer ${token}`,
                          accept:"application/json",
                        },
                        body:{
                        "message":"my commit message",
                            "committer":{"name":"Monalisa Octocat",
                            "email":"octocat@github.com"},
                            "sha":sha,
                        }
                
                      }).as('repositories')
                })
                Then('successfully executed with the status code 200',()=>{
                    cy.get("@repositories").then((response) => {
                        // console.log(response.body.content.sha);
                        expect(response.status).to.equal(200);
                        // cy.task("log", response.body);
                        cy.log(response.body);
                        // expect(response.body).to.be.an("array");
                      });
                })
                //tc-12
                Given('for listing repo tags',()=>{
                    //for getting access token
                    
                        })
                        
                        When('for listing the tags  and send access token',()=>{
                            cy.request({
                                method: 'GET',
                                url: `${baseUrl}/repos/${owner}/${name}/tags`,
                                headers: {
                                  Authorization: `Bearer ${token}`,
                                  accept:"application/json",
                                },
                              }).as('repositories')
                        })
                        Then('successfully executed with  the status 200',()=>{
                            cy.get("@repositories").should((response) => {
                                expect(response.status).to.equal(200);
                                cy.log(response.body);
                                // expect(response.body).to.be.an("array");
                              });
                        })