const { defineConfig } = require("cypress");
const cucumber = require('cypress-cucumber-preprocessor').default;
 async function setupNodeEvents(on, config) {
  on('file:preprocessor', cucumber());
  // implement node event listeners here
  //this is required for the pre processor to be generated json,were my test files  if it wants run files,plugins
  return config;
}
module.exports = defineConfig({
  e2e: {
    setupNodeEvents,
    //you have to provide the path of the test script
    //will be stored as specpattern
    //for 
  //  specPattern:'cypress/integration/example/*.js',
    // for bdd cucumber
    specPattern:'cypress/UAT/features/*.{js,feature}',
    baseUrl:"https://api.github.com",
    // env:{
    //   orangehrm:"https://opensource-demo.orangehrmlive.com/web/index.php/auth/login",
    //   rahulsh:"https://rahulshettyacademy.com/",

    // }
  },
  chromeWebSecurity:false
});
