# Test Plan

**Team 27**:

## 1 Testing Strategy

### 1.1 Overall strategy

*This section should provide details about your unit-, integration-, system-, and regression-testing strategies. In particular, it should discuss which activities you will perform as part of your testing process, and who will perform such activities.*

### Unit Testing

Our system consists three major components: the UI, the databse and the Java procedural code. Unit testing will be within those units. The primary target of the Unit Testing over each of the components are:

* UI
  * Ensure that the UI is error-free, and does not negatively affect the function of other componets.
* Database
  * Ensure that no database constraints are violated, by methods such as examining the constraint set-up.
  * Ensure that the changes on the data does not create unintended diviation.
* Java Code
  * Ensure that the procedures parameters, names and data types are consistant. 
  * Ensure that the functions' performance match their description and purpose.

### Integration Testing

As this is a rather simple app, the UI and database do not interact directly. Thus, the Integration testing will be performed as a subsection of the System Testing (described below). The primary target of the Integration Testing over each of the components are:

* UI-Java code
  * Ensure that all components line up correctly, and that all data types remain consistent.
* Database-Java code
  * Ensure tha all function calls remain consistent, in terms of names, datatypes and functionality.
  * We will furthur perform Integration gest by directly modifying the data, send the data to the database and then calling the respective data from the database. We expect the data called from the data base will match with our modification.
  
### System Testing

This is where we test all units together. The primary target of the System Testing over each of the components are:.

* First component: Data entry and retreival.
  * We will test this component by entering data into the UI, and then check whether our input could be displayed correctly in the UI. This method tests the path to and from the database through the Java code.
* Second componet: Common actions we expect the user to do.
  * We will test this component by subjectively expericing the app's functiion such as feeling the like running speed. This method can also reveal the overall perforance of our app.

### Regression Testing

By oerforming the Regression testing, we ensure that the newly-implemented features do not break existing ones.

* We will implement a set of automated tests (e.g. similar to the Assignment 4's tests) to examine basic connectiones and accesses.
* We will perform Unit and Integration testing along the development of the app.
* We will perform testing over higher-level related functions as well. For example, if a function, which has neen revised, calls another function, we will test both the called and the caller functions.

### 1.2 Test Selection

*Here you should discuss how you are going to select your test cases, that is, which black-box and/or white-box techniques you will use. If you plan to use different techniques at different testing levels (e.g., unit and system), you should clarify that.*

### Black-box Testing selection

* We will select test cases that attempt to cover all catagories of data we expect from each input and action.
  * Due to man-power limitatiin, we could garentee only one test for each type of interested data.
* We will also perform the so-called gray-box testing, in which we test the app with selected (based on our reasoning) test cases that we might be difficult for the code.
  * Under the grey-boxing, we targret to reach > 90% of statement coverage.
  
### White-box Testing selection

* We will examine the code for possible errors and logical inconcistencies.
  *  Instead of conventional White-box technics, we will:
    * We will read the code together, and m=nominate test cases for Black-box testing.
    * We will also check the code against function desriptions, and perform testing to ensure the functions are excuecting in the expected manner.

### 1.3 Adequacy Criterion

We will consider our test suite as adequent if they fulfill these criterias:
* Statement coverage: For each  executable statement in the app, there is a test case that executes that statement.
* Transition coverage: For each interface transition in the app, there is a test case that traverses that transition.
* Path coverage: For all finite-length subpaths starting from the app's Main Menu, there is at least one test case that includes such subpath.

### 1.4 Bug Tracking

We maintain a lively Telegram channel for team-communication.
We maintain a Defects.md (in this folder) for bugs and enhancement requests tracking. 

### 1.5 Technology

We plan to use JUnit testing for our automated testing witin the Java code.
We will test the database using built-in features in SQLite.
We will also maintain a database make file with backup, so that we can do perform version testing and revert changes if needed.


## 2 Test Cases

*This section should be the core of this document. You should provide a table of test cases, one per row. For each test case, the table should provide its purpose, the steps necessary to perform the test, the expected result, the actual result (to be filled later), pass/fail information (to be filled later), and any additional information you think is relevant.*



Test Case # | Purpose | Steps | Expected Result | Actual Result | Pass/fail Information | Additional Information
------------ | ------------- | ------------- | ------------- | ------------- | ------------- | ------------- 
 1 | Test if the "Enter Current Job Details" interface could refuse to save incomplete input.| 1. Navigate to the "Enter Current Job Details" interface. 2. Enter partial information. I.e. Only enter title, company, and Yearly Salary. 3. Press the "save" button | The app will raise an error, which prevents the user to save partial information.|Save is prevented and missing feilds are flagged|Pass||
 2 | Test if the "Enter Current Job Details" interface could handle the user's input properly under extreme conditions.| 1. Navigate to the "Enter Current Job Details" interface. 2. Enter complete information for all the blanks. 3. Kill the app.| The app will NOT save any inputs. All current job details will remain unchanged.|The app will NOT save any inputs. All current job details will remain unchanged.|Pass| |
 3 | Test if the "Enter Current Job Details" interface could handle the user's input properly under extreme conditions.| 1. Navigate to the "Enter Current Job Details" interface. 2. Enter complete information for all the blanks. 3. Press the "save" button. 4. Kill the app.| The app will save the inputs.|The app saved all the inputs|Pass| |
 4 | Test if the "Compare Job Offers: List" interface could handle incomplete input in an robust manner.| 1. Manually add an job offer to the database (i.e. not via the app), fill 100,000 into "Yearly Salary", and leave all other information blank. 2. Navigate to the "Compare Job offers" interface. | The app should list the incomplete job offer based on available information. However, in the list, the "Title" and the "Company" of this job will be shown as blank. The app will still calculate the rank of this job offer based on its incomplete information, and rank it in the list properly.|The app puts null for the missing values, this should not be a legal state to be in, but it passed either way| Pass||
 5 | Test if the "Compare Job Offers: Compare" interface could handle incomplete input in an robust manner.| 1. Manually add an job offer to the database (i.e. not via the app), fill 100,000 into "Yearly Salary", and leave all other information blank. 2. Navigate to the "Compare Job offers: List" interface. 3. Choose the said incomplete job offer, and compare it with an complete job offer in the "Compare Job offers: Compare" interface.| The app will still perform the comparison using the incomplete information, but leaving the unfilled slots blank.| same as in test #4|Pass | |
 6 | Test if the "MainMenu" is displayed on the screen or not.| 1. Load the Job Offer Android Application. 2. Verify on the front screen, "MainMenu" button is displayed or not.| The app should have the MainMenu button as soon as app is loaded.| The app should have the MainMenu button as soon as app is loaded.| Pass| |
 7 | Test if the "Enter Current Job Details" interface allows to edit the existing current job details.| 1. Load the Job Offer Android Application. 2. Navigate to the "Enter Current Job Details" interface. 3. Open the existing current job details. 4. Try to modify the existing current job details.| User should be able to edit and save the existing current job details.|the useris able to save the current job details | Pass | |
 8 | Test if the "Enter Current Job Details" interface allows to exit without saving to the "MainMenu".| 1. Load the Job Offer Android Application. 2. Navigate to the "Enter Current Job Details" interface. 3. Enter current job details. 4. Do not save and try to exit without saving.| User should be able to exit without saving the form data to the "MainMenu".| The user could exit without saving| Pass | |
 9 | Test if the "Enter Job Offers" interface allows to cancel and return to "MainMenu".| 1. Load the Job Offer Android Application. 2. Navigate to the "Enter Job Offers" interface. 3. Enter current job details. 4. Do not save and try to cancel and return to "MainMenu".| User should be able to cancel and return to "MainMenu".| User is able to cancel and return to "MainMenu".| Pass| |
 10 | Test if the "Enter Job Offers" interface allows to edit the existing job offer.| 1. Load the Job Offer Android Application. 2. Navigate to the "Enter Job Offers" interface. 3. Open the existing current job details. 4. Try to modify the existing current job details.| User should be able to edit and save the existing current job offer.| The user is able to edit and save the existing current job offer.|Pass | |
 





