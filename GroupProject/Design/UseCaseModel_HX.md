# Use Case Model

*This is the template for your use case model. The parts in italics are concise explanations of what should go in the 
corresponding sections and should not appear in the final document.*

**Author**: Team 27

## 1 Use Case Diagram

*This section should contain a use case diagram with all the actors and use cases for the system, suitably connected.*

## 2 Use Case Descriptions

*1. Enter Current Job Details*
- *Requirements:*
This use case allows the user to input or edit his/her current job details.

- *Pre-conditions:*
None

- *Post-conditions:*
None

- *Scenarios:*
When choosing to Enter Current Job Details, a user will: 
(1). Be shown a user interface to enter (if it is the first time) or edit all of the details of their current job, 
which consist of: a. Title, b. Company, c. Location (entered as city and state), 
d. Overall cost of living in the location (expressed as an index), e. Yearly salary, f. Signing bonus, g. Yearly bonus, 
h. Retirement benefits (as percentage matched), i. Leave time (vacation days and holiday and/or sick leave, 
as a single overall number of days). 
(2). Be able to either save the job details or cancel and exit without saving, returning in both cases to the main menu.

*2. Enter Job Offers*
- *Requirements:*
This use case allows the user to input, find, edit, or delete his/her job offers.

- *Pre-conditions:*
None

- *Post-conditions:*
None

- *Scenarios:*
When choosing to Enter Job Offers, a user will:
(1). Be shown a user interface to enter all of the details of the offer, which are the same ones listed above for the 
current job.
(2). Be able to either save the job offer details or cancel.
(3). Be able to: a. enter another offer, b. return to the main menu, or c. compare the offer with the current job 
details (if present).


*3. Adjust Comparison Settings*
- *Requirements:*
This use case allows the user to give personalized weights on various aspects of jobs, based on the user's interest.

- *Pre-conditions:*
None

- *Post-conditions:*
None

- *Scenarios:*
When choosing to Adjust Comparison Settings, the user can assign integer weights to five variables: Yearly salary, 
Signing bonus, Yearly bonus, Retirement benefits, and Leave time.


*4. Compare Job Offers*
- *Requirements:*
This use case allows the user to give personalized weights on various aspects of jobs, based on the user's interest.

- *Pre-conditions:*
At least two job offers (the "current job details" could be counted as one job offer) have been inputted.

- *Post-conditions:*
None

- *Scenarios:*
When choosing to Compare Job Offers, a user will:
(1) Be shown a list of job offers, displayed as Title and Company, ranked from best to worst (see below for details), 
and including the current job (if present), clearly indicated. (2) Select two jobs to compare and trigger the 
comparison. (3) Be shown a table comparing the two jobs, displaying, for each job: a. Title, b. Company, c. Location, 
d. Yearly salary adjusted for cost of living, e. Signing bonus adjusted for cost of living, f. Yearly bonus adjusted 
for cost of living, g. Retirement benefits (as percentage matched), h. Leave time. (4) Be offered to perform another 
comparison or go back to the main menu.
