$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/Features/homePage.feature");
formatter.feature({
  "name": "This feature file will validate Home Page functionality",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@regression"
    },
    {
      "name": "@homePage"
    }
  ]
});
formatter.scenario({
  "name": "User should be able to validate main tabs on HRM Homepage",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@regression"
    },
    {
      "name": "@homePage"
    }
  ]
});
formatter.step({
  "name": "user navigates to HRM Login Page",
  "keyword": "Given "
});
formatter.match({
  "location": "LoginPageSteps.user_navigates_to_HRM_Login_Page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user enters \"yoll-student\" username",
  "keyword": "When "
});
formatter.match({
  "location": "LoginPageSteps.user_enters_username(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user enters \"Bootcamp5#\" password",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginPageSteps.user_enters_password(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user clicks on login button",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginPageSteps.user_clicks_on_login_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user should be able to verify account name on HRM Homepage",
  "keyword": "And "
});
formatter.match({
  "location": "HomePageSteps.user_should_be_able_to_verify_account_name_on_HRM_Homepage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user verifies main tabs on HRM Homepage",
  "rows": [
    {
      "cells": [
        "tabname"
      ]
    },
    {
      "cells": [
        "Admin"
      ]
    },
    {
      "cells": [
        "PIM"
      ]
    },
    {
      "cells": [
        "Leave"
      ]
    },
    {
      "cells": [
        "Time"
      ]
    },
    {
      "cells": [
        "Recruitment"
      ]
    },
    {
      "cells": [
        "My Info"
      ]
    },
    {
      "cells": [
        "Performance"
      ]
    },
    {
      "cells": [
        "Dashboard"
      ]
    },
    {
      "cells": [
        "Directory"
      ]
    },
    {
      "cells": [
        "Maintenance"
      ]
    }
  ],
  "keyword": "And "
});
formatter.match({
  "location": "HomePageSteps.userVerifiesMainTabsOnHRMHomepage(DataTable)"
});
formatter.result({
  "status": "passed"
});
});