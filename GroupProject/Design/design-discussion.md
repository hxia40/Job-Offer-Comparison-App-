**Hui Xia:**
As suggested by the assignment requirement, we have proposed various designs of the UML class diagram for this project, and then merged our designs in a group meeting. The UML class diagram designs proposed by the other group members (besides me) are similar, which is drawn based on the design model, and contains many software behaviors, and demonstrates all proposed pages of the app. They argue that it is more demonstrative to include purely executive classes and methods, such as the “AppManager” class, and the “onClick()” method, in the UML design.  On the other hand, I have drawn a UML based on domain model, which provides visual representation of the real-world classes, attributes, and relationships. That is, my UML design did not contain the purely executive classes and methods. After discussion, we agreed that using the design model her serves our purpose better, as it directly shows how to implement the domain model into the software. Thus, we merged our UML designs in the favor of the design model. 

**Sreekumar Hariharan:**
For the first phase of the project, all the members of our team worked on their own interpretation of the design as UML or design documentation. We collaborated on team meetings and chats to cross reference and combine the ideas to come up with the final deliverable. My approach to this phase was to focus on the requirements from the end user as well as system design perspective. For instance, although the low level requirements like removing a job offer from the application was not defined explicitly, that was taken into account to make the user journey more complete. Similarly, the requirement does not specify anything more than specifying the name of the company, but we decided that it would be a good idea to keep that as a subclass so that it can be scaled up and reused if required in the further iterations of the product. We also created subclasses for job location and job benefits in order to support reusability and segregation of features. After combining the ideas into the final UML document, we also discussed the approach to document the same in the best way to make the design clear to the reader.

**Richard Wood:**
For a group that met a week ago I think we have amazing team work. We have alot of strong personalites that come at this problem with years or experience. That might actually be our weakness, most of us have handled things in the real world that are exponentially larger and complex than this example. Our attempt to future proof it and optimize was a point of frustration when the assignment had minimal requirements to produce an ideal system. All that to say, we used peoples stregnths. We diversified our ideas, by having individual people do parts of the assignment individually and then we brought them together for group discusions. With more than one person doing the same bit of work, it not only increased visibility of ideas, but also forced people to present their ideas that may have disagreed with others. While I had say and contributions to the UML class diagram, I was not the primary on it. My strengths are in databases and system design, so I wrote the initial system design document, even before seeing our class diagram. I then modified the design document to reference and be in alignment to the class diagram. I was fortunite to have my work reviewed and improved to make the document more clear to individuals who hadn't sat through our hours of meetings on project vision.

**Pankaj Chouhan:**
Initially we as a team had multiple sessions to understand the requirement clearly. Once we all were assured enough considering requirements, we agreed to turn back and do some schoolwork to come up with individual design. In that task, my primary design for the Job Offer Comparison Application consist of ten distinctive classes, which I will be expounding in underneath segments. Once all of us had our own design, all the team members had multiple rounds of sessions to understand each other’s point of view. Finally, we came up with a more refined and robust design, for which each one of us has a mutual consent. Following are the classes from primary design:

	MainMenu: This class will be the entry point of the application. It will be
	used by GUI to display the four menus for four screens, respectively. This
	class contains a public function “displayMenus()” and a composite object 
	“GUIController”.

	GUIController: This class is an interface between frontend and backend. All
	the operations performed from frontend will be pipelined through 
	GUIController and its child controllers. Four child controllers are there for 
	four separate screens. This is done based on Single Responsibility Principle 
	and Interface Segregation Principle. GUIController has a JobController 
	instance, which has the business logic and will be acting as the backend 
	controller.

	CurrentJobDetailsUI: This is the child controller for CurrentJobDetails 
	screen. This will be used to render the current job details form and can be 
	saved or cancel

	JobOfferUI: This is the child controller for Job Offer screen. This will be
	used to render the Job Offer form and can be saved or cancel. It can be used 
	to add new job offers or edit existing Job Offers.

	ComparisonSettingsUI: This is the child controller for Comparison Settings 
	screen. This will be used to render the Comparison Settings form to adjust 
	settings.

	CompareJobsUI: This is the child controller for CurrentJobDetails screen. 
	This will be used to render the current job details form and can be saved or 
	cancel.

	JobController: This is a backend controller, which will receive controls from
	frontend. Control of any operations from GUI will be transferred to 
	JobController. Here actual business logic going to materialize.

	JobDetails, JobLocation, ComparisonSessings: These are the bean classes and 
	will be acting as data structures to store the respective form details and 
	stored in memory or into database.

Overall, idea in the above design was to have high cohesion and loose coupling between front end and back end classes. Also, tried to follow Interface Segregation Principle and Single Responsibility Principle as part of design, to keep design more scalable and easier to plugin future requirement changes.

**Summary:**
I feel the greatest lesson we learned was each other’s strength and weaknesses and how to be a team in general. For the design itself, we had valuable conversations, and we were all forward looking in our suggestions. We are at a good place to move forward with this project and have a clear path forward. The most obvious lessons learned was when we all got together and talked through the UML for the class diagram, many of us came into the class knowing how to do class diagrams. Our discussion allowed us to see what parts of class diagrams we knew that may be specific to our company or previous class and we were able to generalize our knowledge. Lastly, I think we now have a better idea of how much work we should expect each week and once this assignment is graded and when we have grader feedback a better understanding of our effort and capabilities.
