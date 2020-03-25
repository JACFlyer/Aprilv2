# Overview
_Applied Pregnancy Informatics_

The onset of true contractions can be difficult to determine for a mom to be.  Knowing the right time to go to
the hospital can make the difference between having a successful self-designed birth plan
and, being admitted before one intended to be.  At times, an ER provider might simply send
mom home, frustrated, and with instructions on when to return.  This is often a waste of time and
resources for both the hospital and the patient.

It is the intention of this project to develop an evidence-based application that provides
accurate and safe coaching to the patient regarding her stage of labor.  The patient will be able to document
contraction pattern, experiences of pain, and fetal heart rate.  A future version of the app will
allow for a basic abdominal ultrasound to capture the presence of amniotic fluid, and the recording of
an image of the cervix to assist in the interpretation of labor progression.  In so doing,
the application will promote the wellness of both the mother and child.

Using this product involves downloading the app to ones smart-phone or tablet,
and linking USB adaptable assessment devices to the system.  This _April Suite_ will be
implemented during a routine pre-natal visit.  The attending provider 
will subsequently have access to the patient's profile for monitoring and response purposes. 



# Intended Users
* Pregnant women near their expected date of delivery 
* Patient spouses and support team members  
* Attending medical providers  
* Community pregnancy support service providers  



# User Stories
### [Link to Vignettes](user-stories.md)



# Current State of the Application
The application is not yet ready to deploy for testing.  The database is accessible, while database
queries have not yet been tested.  Subsequently, the data definition language documentation
is not current.

The Home page is functional and blank.  It is intended to display the patient's first name after
the _Welcome_.  Also, application functionality information, and user instructions should
be displayed here.  

The add action buttons on the Action page are not yet connected for user input and database
updating.  Also, the recycler-view feature, displaying all user entries in chronological order, is
not complete.  

The profile page does not display profile information, rather it records and stores the
information through edit text buttons.  This page should read like a page in a true medical chart
with the option of editing demographic information and clinical history. 

The overall aesthetic of the app is not specific to women near delivery.  The color scheme and fonts
should be improved while maintaining the simplicity of the design.  Icons should be implemented
judiciously.  Collaboration with a student of the digital design cohort was attempted yet did not
produce usable images.  Customized icons should be considered a stretch goal.

GoogleSignIn functionality is also not complete.  This feature will facilitate the HIPAA compliance
of the application. 

The API for real-time fetal heart rate monitoring and recording, has not been implemented.
The cost of acquiring a heart rate monitor is considerable.  However, an over-the-counter wireless
pulse-oximeter may be an option for testing and establishing viability of the concept.

The above corrections should be implemented with priority.  The changes will provide a functional
application to round-off phase I development.

Functional stretch goals include the USB adaptable ultrasound technology and vaginal camera.
These components remain the core functionality of the application and beyond the scope of this project.
  


# User Interface Design Documentation
### [Wireframe Diagram](wireframe.md)  



# Data Model Design Documentation
        
### [Entity Relationship Diagram](erd.md)    

### [Assessment Entity](https://github.com/JACFlyer/Aprilv2/blob/master/app/src/main/java/edu/cnm/deepdive/aprilv2/model/entity/Assessment.java)    
### [Assessment Repository](https://github.com/JACFlyer/Aprilv2/blob/master/app/src/main/java/edu/cnm/deepdive/aprilv2/model/repository/AssessmentRepository.java)    

### [Journal Entity](https://github.com/JACFlyer/Aprilv2/blob/master/app/src/main/java/edu/cnm/deepdive/aprilv2/model/entity/Journal.java)    
### [Journal Dao](https://github.com/JACFlyer/Aprilv2/blob/master/app/src/main/java/edu/cnm/deepdive/aprilv2/model/dao/JournalDao.java)    

### [Contraction Entity](https://github.com/JACFlyer/Aprilv2/blob/master/app/src/main/java/edu/cnm/deepdive/aprilv2/model/entity/Contraction.java)    
### [Contraction Dao](https://github.com/JACFlyer/Aprilv2/blob/master/app/src/main/java/edu/cnm/deepdive/aprilv2/model/dao/ContractionDao.java)    

### [Fetal Heart Rate Entity](https://github.com/JACFlyer/Aprilv2/blob/master/app/src/main/java/edu/cnm/deepdive/aprilv2/model/entity/FetalHeartRate.java)    
### [Fetal Heart Rate Dao](https://github.com/JACFlyer/Aprilv2/blob/master/app/src/main/java/edu/cnm/deepdive/aprilv2/model/dao/FetalHeartRateDao.java)    

### [Data Definition Language](ddl.md)

### [Database Class](https://github.com/JACFlyer/Aprilv2/blob/master/app/src/main/java/edu/cnm/deepdive/aprilv2/service/AprilDatabase.java)



# Technical Requirements and Dependencies        
*  Minimum Android API 21 required
*  App tested on Samsung S6.  All testing was in vertical orientation.  Results of running in landscape mode unknown.  
*  Androidx, Stetho, Google Code, SquareUp, Commons, Reactivex, Javax, JUnit, and Reactive Streams libraries used.



# Javadoc-generated Technical Documentation



# Copyrights and Licenses
This application was designed, developed and coded by J. Asa Cade.
Copyright pending:  Cade Clinical Consulting, LLC, 2020



# Build Instructions
*  Install and launch the application on an Android device (minimum API 21) or emulator.
*  Navigate the app following the user instruction.
*  Escape the app using the back arrow button on your device's navigation bar.
*  Launch the application, again, by touching the _April_ icon on your device's applications list.



# Basic User Instructions
### [User Instructions](user-instructions.md)  
