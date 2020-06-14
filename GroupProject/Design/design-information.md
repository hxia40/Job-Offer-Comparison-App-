# Design Information Document


The intense information flow from a constantly evolving and demanding job market could overwhelm many job-seekers.  This app is designed as a tool to help job-seekers compare offers.  After all, no one knows the “perfect job” better than the user. Using this app, a user could record job offers, compare a job offer against another, or against the user’s current job.  Moreover, this app supports weighted comparison. That is,  the user could assign higher “weights” to certain aspects (e.g. yearly salary or leaving time), and find the job offer that fits his/her interest most. 
Here, we will explain how are we going to realize each of the requirements of this app:

		

## Requirement # 1:

 
		When the app is started, the user is presented with the main menu, which allows the user to
		 (1) enter current job details, 
		 (2) enter job offers, 
		 (3) adjust the comparison settings, or 
		 (4) compare job offers (disabled if no job offers were entered yet).
		
		This is realized by our 5 separate pages, with acknowledging that page 5, the job 
		comparison will only be available if they have enough jobs to compare.

To realize this requirement, we have designed five 5 specialized pages: Main Menu, Current Job detail entry, Job offer detail entry, Job preference settings, and Job comparison (if there are pending job offer/offers available). The “main menu” page presents the links to other pages, which are: Current Job detail entry, Job offer detail entry, Job preference settings, and Job comparison. In details, we handle these options under the class "JobController”, using these methods:"addJobOffer()" , "updateJobOffer()", "removeJobOffer()",  "getJobOffer()", "compareJobOffer()", and “rankJobOffer()”.  The last two methods are disabled if no job offer exist. We also added the "comparisonSettings" attribute to this class, which will be handled by the “ComparisonSettings” class. The user is able to choose one in four of these methods using the "onClick()" method in the class "AppManager".


## Requirement # 2:

 
		When choosing to enter current job details, a user will:
		a.	Be shown a user interface to enter (if it is the first time) or edit all of the 
			details of their current job, which consist of: Title, Company, Location (entered as
			city and state), Overall cost of living in the location (expressed as an index), 
			Yearly salary, Signing bonus, Yearly bonus, Retirement benefits (as percentage 
			matched), Leave time (vacation days and holiday and/or sick leave, as a single 
			overall number of days)
		b.	Be able to either save the job details or cancel and exit without saving, returning
			in both cases to the main menu.

This requirement is realized by our page for current job details. In details, this page allows the user to enter his/her current job details. If the user has already done so, this page will allow the user to edit the current job details. In both case scenarios, the user will be promoted to fill the following blanks: Title, Company, City, State, Overall cost of living in the location, Yearly salary, Signing bonus, Yearly bonus, Retirement benefits, and Leave time. In this page, the user can press the “cancel” button at any time and choose if he/she wants to save the filled/edited job details information, or simply discard it. After all the blanks are filled, the user will be redirected to the main menu.
This page is handled with our “Job” class that stores the relevant fields in three sub classes: “JobCompany”, “JobLocation”, and “JobBenefits”. The “Job” class also has a method named "validateJobOffer()”, which will validate the information the user has entered to prevent syntax errors, such as no blank entries, or days in vacation cannot exceed the total working days in the year, etc. 

## Requirement # 3:

 
		When choosing to enter job offers, a user will:
		a. Be shown a user interface to enter all of the details of the offer, which are the
		   same ones listed above for the current job.
		b. Be able to either save the job offer details or cancel.
		c. Be able to 
			(1) enter another offer, 
			(2) return to the main menu, or 
			(3) compare the offer with the current job details (if present).

This requirement is realized using the “Job offer detail entry” page.  Upon visiting this page, the user will be prompted to enter the job offer information in a same manner as how they are promoted to enter the current jobs details (refer to Requirement#2). Actually, both the Job offers and the current job details will be sharing the “Job” class, and are differentiated by the “isCurrent” attribute. Thus, similar to the “current job details” page, the user could enter and save a job offer in a similar manner. The details of the inputted job offer will be validated by syntax checking, as mentioned above. The job offer comparison function is handled with the “JobController” class using the “compareJobOffers()” method, along the weights that are stored in the “ComparisonSettings” class. Please refer to our description to Requirement#5 for details.

## Requirement # 4:

 
		When adjusting the comparison settings, the user can assign integer weights to:
			Yearly salary, 
			Signing bonus, 
			Yearly bonus, 
			Retirement benefits, 
			Leave time
		If no weights are assigned, all factors are considered equal.

To meet this requirement, we allow the user to set his/her weights for five variables. In the Job preference settings page, the user will be able to add custom weights to the following variables (by default, the weights to all five variables are equal): Yearly salary, Signing bonus, Yearly bonus, Retirement benefits, and Leave time. This requirement is realized using the “ComparisonSettings” class and the “updateWeightage()” method, which will set the attributes of the class to match what the user specifies. 


## Requirement # 5:

 
		When choosing to compare job offers, a user will:
	a.	Be shown a list of job offers, displayed as Title and Company, ranked from best to worst
		(see below for details), and including the current job (if present), clearly indicated.
	b.	Select two jobs to compare and trigger the comparison.
	c.	Be shown a table comparing the two jobs, displaying, for each job:
			Title, 
			Company, 
			Location, 
			Yearly salary adjusted for cost of living, 
			Signing bonus adjusted for cost of living, 
			Yearly bonus adjusted for cost of living, 
			Retirement benefits (as percentage matched), 
			Leave time
	d.	Be offered to perform another comparison or go back to the main menu

This requirement is handled using the Job comparison page, which enables the user to compare job offers. In this page, the user will see a list of important details in their offers, such as company name and location, in descending order based on their preferences. The user’s current job will be distinctly visible, and will also be available to compare with other job offers.
Beyond the list of job offers, the user is also able to select two specific jobs and make a more detailed comparison on the following details: Title, Company, Location, Yearly salary, Signing bonus, Yearly bonus, Retirement benefits, and Leave time.
This information is stored as attributes in three classes. They are: “JobCompany”, “JobLocation”, and “JobBenefits”, and is used to generate the comparison information using the "compareJobOffer()"method under the “JobController” class.
When the user has finished viewing this comparison, he/she may either choose to start another comparison, or return to the main menu. This is realized using the methods "compareJobOffer()", and "return()", respectively, under the classes "JobController", and "AppManager", respectively.

## Requirement # 6-9:

		Requirement#6
		When ranking jobs, a job’s score is computed as the weighted sum of:
			AYS + ASB + AYB + (RBP * AYS) + (LT * AYS / 260)
		where:
		AYS = yearly salary adjusted for cost of living
		ASB = signing bonus adjusted for cost of living
		AYB = yearly bonus adjusted for cost of living
		RBP = retirement benefits percentage
		LT = leave time
		For example, if the weights are 2 for the yearly salary, 2 for the retirement benefits,
		and 1 for all other factors, the score would be computed as:
		2/7 * AYS + 1/7 * ASB + 1/7 * AYB + 2/7 * (RBP * AYS) + 1/7 * (LT * AYS / 260)
		
		Requirement#7
		The user interface must be intuitive and responsive.
		
		Requirement#8
		The performance of the app should be such that users do not experience any considerable
		lag between their actions and the response of the app.
		
		Requirement#9
		For simplicity, you may assume there is a single system running the app (no 
		communication or saving between devices is necessary).

The “JobController” class has a “rankJobOffers()” method that uses the equation in the Requirement#6, which also uses the attributes in the “ComparisonSettings” class. But in general, Requirements#6-9 do not directly affect the design and do not need to be shown, meeting their requirements will vary based on implementation techniques and methods.
