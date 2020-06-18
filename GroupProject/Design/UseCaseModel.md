
# Use Case Model

**Author**: Team27

## 1 Use Case Diagram

![Job Offer Use Case Diagram](https://github.gatech.edu/gt-omscs-se-2020summer/6300Summer20Team27/blob/master/GroupProject/Images/JobOfferApp_UseCaseDiag.png)


## 2 Use Case Descriptions

*Following are the details of the Use Case Diagram from Section#1*

## Current Job Details:

- ***Requirements**: 
	When the app is started, the user is presented with the main menu, which allows the user to
				 (1) enter current job details, 
				 (2) enter job offers, 
				 (3) adjust the comparison settings, or 
				 (4) compare job offers (disabled if no job offers were entered yet).*
				 
- ***Pre-conditions**: Application must be up and running.*
- ***Post-conditions**: All the mandatory fields should be filled on the screen*
- ***Scenarios**: Following are the sequence of events that characterize this use case:*
		(a). User should be displayed a form/screen to fill the necessary details of current job. 
		(b). User should be able to save the details of current job
		(c ). If current job details already exists then user should be able to edit the current job details
		(d). If user wants to discard and cancel, then user should be allowed to cancel and return to main menu.
 

## Enter Job Offers

 ***Requirements:*** This use case allows the user to input, find, edit, or delete his/her job offers.

- ***Pre-conditions:*** None

- ***Post-conditions:*** None

- ***Scenarios:***
When choosing to Enter Job Offers, a user will:
(1). Be shown a user interface to enter all of the details of the offer, which are the same ones listed above for the current job.
(2). Be able to either save the job offer details or cancel.
(3). Be able to (1) enter another offer, (2) return to the main menu, or (3) compare the offer with the current job details (if present).




## Adjust Comparison Settings


- ***Requirements:*** This use case allows the user to give personalized weights on various aspects of jobs, based on the user's interest.

- ***Pre-conditions:*** None

- ***Post-conditions:*** None

- ***Scenarios:***
When choosing to Adjust Comparison Settings, the user can assign integer weights to five variables: Yearly salary, Signing bonus, Yearly bonus, Retirement benefits, and Leave time.




## Compare Job Offers


- ***Requirements:*** This use case allows the user to give personalized weights on various aspects of jobs, based on the user's interest.

- ***Pre-conditions:*** At least two job offers (including the current job) has been inputted.

- ***Post-conditions:*** None

- ***Scenarios:***
When choosing to Compare Job Offers, a user will:
(1) Be shown a list of job offers, displayed as Title and Company, ranked from best to worst (see below for details), and including the current job (if present), clearly indicated. 
(2) Select two jobs to compare and trigger the comparison. 
(3) Be shown a table comparing the two jobs, displaying, for each job: a. Title, b. Company, c. Location, d. Yearly salary adjusted for cost of living, e. Signing bonus adjusted for cost of living, f. Yearly bonus adjusted for cost of living, g. Retirement benefits (as percentage matched), h. Leave time. 
(4) Be offered to perform another comparison or go back to the main menu.


