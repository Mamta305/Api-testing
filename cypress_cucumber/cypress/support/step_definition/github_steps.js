import {before, Given, When, And, Then} from "cypress-cucumber-preprocessor/steps";

let token="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";
let baseUrl = Cypress.config().baseUrl;
let name="Dummy";
let res;
let owner="Mamta305";
let fname="cont";
let sha;
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