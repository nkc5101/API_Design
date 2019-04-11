
Default login(different account types): 
	     Patient:
               username: username 
	       password: password

             Doctor:
	       username: doctor
	       password: rulez

             Insurance Company:
               username: insurance
               password: sucks

             Pharmacist:
               username: pharma
               password: password

             Nurse:
               username: nurse
               password: password

RE-FACTOR PLAN
1. We implemented an option where the user would be able to decide what 
doctor they would want. The classes that are affected is the AddAppointmentUI.fxml
class which has the drop down menu. Another class is AddAppointmentUIController.java class as well. 
This class controls the action of showing the doctor you can pick from. This class was implemented by 
Nick.

2. The runtime error that was a bad smell cannot be fixed. This error is something
that happens when you are creating a FXML application.

3. We implemented final variables in our updated classes. The classes that are effected 
AddAppointmentUIController.java, AppointmentController.java, BillController.java, PatientController.java,
We added final to the variables so they we can no longer call those variables in other classes. This was implemented by 
Mark. 

4. This is concerning the two use cases that we implemented. The first case we implemented was
adding a credit card for billing purposes. This is to view a bill and pay the bill. The classes that 
are affected by this is AddAppointmentUIController.java, AppointmentController.java, AddAppointmentUI.fxml.
This case was implemented by Nate. The second use case we implemented was the notification case. This is to give the 
users a notification when it concerns anything with the application. This was implemented by Mark.

5. getters and setters

6. 