|Sl No.|Defect|Detected By|Assigned To|Status|Notes|
|---|---|---|---|---|---|
| 1  |  the "Compare Job offers" page is not yet connected with the database | Hui  | Sreekumar  | resolved  | |
| 2  |  the "Job offers" page does not show which job is the current job. |  Hui | Zeke  |  resolved | |
| 3  | the "current Job details" will not remember the user's input, which would be nice if it can (I can try to fix this if needed).   |  Hui | Hui  |  resolved | |
| 4. | in "job offers" page, the "cost of living index" blank can still be inputed. Is this design by purpose? I thought we want to calculate the cost of living index by the database.| Hui | Zeke | canceled | Alex said it was fine|
| 5. | lack message when new job saved| |Sreekumar |resolved | |
| 6. | hui has some left over code in JobOffers.java that need to be deleted | Hui | Hui | resolved  | |
| .7 | Allow users to update thier current job's info  | Zeke | Zeke | resolved | |
| .8 | Title is not being saved correctly from job offers | Zeke | Zeke | resolved | |
| .9 | compare job offers (disabled if no job offers were entered yet | Zeke | | ongoing|To be precise, this functionality will be enabled if there are either (1) at least two job offers, in the case there is no current job, or (2) at least one job offer, in the case there is a current job. |
|10|Selection not working correctly from Job Offers page|Pankaj|Sreekumar|resolved| |
|11|Edit button not populating the selected Job offer|Sreekumar|Sreekumar|resolved| |
|12|App crashes when current job selected and database is empty|Sreekumar|Sreekumar|resolved| |
|13|App crashes when Add job selected and database is empty|Sreekumar|Sreekumar|resolved| |
|14|The compare function in the "job offers" page does not work|Hui | | | |
|15|The current job is not being correctly marked. Instead of marking the current job, the app always mark the "last job" as the current job| Hui|Hui |canceled | this is rather mystery. I cannot reproduce this error anymore. let's fix others first|
|16|After inputing a new job offer via the "ADD" button and clicking "SAVE", then the Android's "back", the "Job Offers" page does not automatically refresh | Hui| | | |
|17| the "EDIT" button on the "job offers" page does not work|Hui | | | |
|18| when using a brand new database (you can remove your database by either 'nuking' it, or delete the app from your simulator android phone, the restart the android studio), if you click "current job", the app will crash. This is because the in "currentJobDetails.java, lines 64-83, trys to query the database w/o an current job available. to fix this, we will need to add an empty current job upon the creation of the database. How to recreate the bug: 1. start the app in simulator. 2. uninstall the app in the simulator phone by long-clicking on it and then dragging it to the trash can. 3. select "yes" when the system asks if you want to uninstall the app. 4. restart the android stuido, and run the code. 5. click "CURRENT JOB" button in the main menu. | Hui |Hui | resolved| |
|19|unable to enter 0 for cost of living|Sreekumar|Sreekumar|resolved| |
|20| | | | | |
| | | | | | |
| | | | | | |
