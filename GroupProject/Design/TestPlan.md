# Test Plan

**Team 27**:

## 1 Testing Strategy

### 1.1 Overall strategy

*This section should provide details about your unit-, integration-, system-, and regression-testing strategies. In particular, it should discuss which activities you will perform as part of your testing process, and who will perform such activities.*

### Unit Testing

Our system is made up of three units, the UI, the databse and the Java procedural code. Unit testing will be within those units.

* UI
  * Primaraly making sure changes do not cause error and/or negatively affect the astetic look of other componets.
* Database
  * Primaraly making sure that no database constraints are violated, if the constraints are set up correctly this shouldn't be possible.
  * Keeping backups and making sure changes do not create a diviation from previous backups if that was not intended.
* Java Code
  * Making sure procedures parameters, names and data types are not changed in only a single place. General bug testing and makign sure functions match their description.

### Integration Testing

This looks at how individual units interact with each other, there is no way for the UI and database to interact directly, so that integratoin does not really need to be checked outside of system testing.

* UI-Java code
  * Making sure components line up and data types stay consistent.
* Database-Java code
  * Making sure calls stay consistent in names, datatypes and functionality.
  * Modifying data sending it to the database and then calling data from database and making sure it is correct.
  
### System Testing

This is where we test all units together. There will be two components to this.

* First component: Data entry and retreival.
  * We will enter data into the UI and look at where it should be displayed again with the UI.
  * This tests the path to and from the database through the Java code.
* Second componet: Common actions we expect the user to do.
  * These will test things like none functional requirments like speed and feel.
  * They can also test overall working of the system to do what is specified.

### Regression Testing

This is the testing we will do to ensure our new features do not break old features

* We will have a set of automated tests that are like the Assignment 4's tests that simple test basic connection and access.
* We will have Unit and Integration tests that we will run depending on the scope of the change.
* Finally we will run tests one level above the change. 
  * If a function calls another function and we change thats called function, we will test the caller function as well.

### 1.2 Test Selection

*Here you should discuss how you are going to select your test cases, that is, which black-box and/or white-box techniques you will use. If you plan to use different techniques at different testing levels (e.g., unit and system), you should clarify that.*

### Black-box Testing selection

* We will select test cases that attempt to cover all catagories of data we expect from each input and action.
  * While we would only garentee one test of each type.
* We will also use something I was taught as gray-box testing, where we look at the code via white-box testing and pick test cases that may be difficult for the code.
  * Examples of this are at array index limits or ensuring we have a test case where we hit all combinations of a case statment.
  
### White-box Testing selection

* We will examine the code for possible errors and logical inconcistencies.
  *  We will probably not use straight White-box technics
    * We will look at the code to gather good test cases for Black-box testing
    * We will also check the code against function desriptions, which we know isn't how White-box testing is traditionally done.

### 1.3 Adequacy Criterion

*Define how you are going to assess the quality of your test cases. Typically, this involves some form of functional or structural coverage. If you plan to use different techniques at different testing levels (e.g., unit and system), you should clarify that.*

### 1.4 Bug Tracking

We have a very lively Telegram channel that all teams communication is done on.
We will open another channel for bugs and enhancement requests. Each post can be replied to and comments are tracked per post.
This will allow us to see when work is done.

### 1.5 Technology

We plan to use JUnit testing for our automated testing witin the Java code.
Database testing will use built in features in SQLite, like contraints we build in that work closer to bug prevention.
We will also have a database make file with backup so that we can do version testing and revert changes.


## 2 Test Cases

*This section should be the core of this document. You should provide a table of test cases, one per row. For each test case, the table should provide its purpose, the steps necessary to perform the test, the expected result, the actual result (to be filled later), pass/fail information (to be filled later), and any additional information you think is relevant.*
