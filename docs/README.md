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



# User Interface Design Documentation
### [Wireframe Diagram](wireframe.md)  



# Data Model Design Documentation
        
### [Entity Relationship Diagram](erd.md)    

### [Client Profile Entity](https://github.com/JACFlyer/april/blob/master/app/src/main/java/edu/cnm/deepdive/april/model/entity/ClientProfile.java)    
### [Client Profile Dao](https://github.com/JACFlyer/april/blob/master/app/src/main/java/edu/cnm/deepdive/april/model/dao/ClientProfileDao.java)    
### [Client Profile Repository](https://github.com/JACFlyer/april/blob/master/app/src/main/java/edu/cnm/deepdive/april/model/repository/ClientProfileRepository.java)    

### [Assessment Entity](https://github.com/JACFlyer/april/blob/master/app/src/main/java/edu/cnm/deepdive/april/model/entity/Assessment.java)    
### [Assessment Dao](https://github.com/JACFlyer/april/blob/master/app/src/main/java/edu/cnm/deepdive/april/model/dao/AssessmentDao.java)    
### [Assessment Repository](https://github.com/JACFlyer/april/blob/master/app/src/main/java/edu/cnm/deepdive/april/model/repository/AssessmentRepository.java)    

### [Labor Entity](https://github.com/JACFlyer/april/blob/master/app/src/main/java/edu/cnm/deepdive/april/model/entity/Labor.java)    
### [Labor Dao](https://github.com/JACFlyer/april/blob/master/app/src/main/java/edu/cnm/deepdive/april/model/dao/LaborDao.java)    
### [Labor Repository](https://github.com/JACFlyer/april/blob/master/app/src/main/java/edu/cnm/deepdive/april/model/repository/LaborRepository.java)    

### [Fetal Condition Entity](https://github.com/JACFlyer/april/blob/master/app/src/main/java/edu/cnm/deepdive/april/model/entity/FetalCondition.java)    
### [Fetal Condition Dao](https://github.com/JACFlyer/april/blob/master/app/src/main/java/edu/cnm/deepdive/april/model/dao/FetalConditionDao.java)    
### [Fetal Condition Repository](https://github.com/JACFlyer/april/blob/master/app/src/main/java/edu/cnm/deepdive/april/model/repository/FCRepository.java)    

### [Data Definition Language](ddl.md)

### [Database Class](https://github.com/JACFlyer/april/blob/master/app/src/main/java/edu/cnm/deepdive/april/service/AprilDatabase.java)



# Technical Requirements and Dependencies        
* Google GPS for 911 connection, [Bandwidth 911 Access](https://bandwidth.com/911).  This link will allow for seamless transition from a negative assessment to calling for help.  April is not dependent on this function.

* Fetal Heart Rate monitoring software and Wi-Fi enabled emitter, [Edan SDI Ultrasonic Pocket Doppler](https://fetaldoppler.net/fd340-fetal-doppler.html).  This API and device allows for the capture of the fetal heart rate.  This feature supports the critical project functionality of April.
 
* Cervical Camera software and Wi Fi enabled device, [SVAKOM Siime Inteligent Camera](https://www.amazon.com/Authentic-Wireless-Vibrator-Waterproof-Massager/dp/B01DVQOLEA/ref=pd_day0_c_121_3/130-5634076-1338833?_encoding=UTF8&pd_rd_i=B01DVQOLEA&pd_rd_r=73fa6798-7050-40d9-8039-7dced9229204&pd_rd_w=EwUVf&pd_rd_wg=Bgb5y&pf_rd_p=47a9d55c-4dbb-48fe-a136-8e1abc72e8e6&pf_rd_r=F66E8CJ6654ZK5TQJQA5&psc=1&refRID=F66E8CJ6654ZK5TQJQA5
).  This API and device allow the condition of the cervix to be captured in real-time images.  The device supports the critical project functionality of April.  Future versions of the app will allow for AI interpretation of the database of cervical images in the attempt to develop a predictive algorhythm of visible cervical condition and time-to-delivery.

* Abdominal Ultrasound software and Wi Fi enabled transducer, [MobiSante](http://www.mobisante.com/).  This API and device will allow for the evaluation of residual amniotic fluid after the ROM.  Fetal presentation will also be observable by the provider while mom is yet at home.  The device supports advanced functionality of April.

* Considering and alternative corded Android capable camera fixed to vaginal suppository inserter.  This is a USB enabled Endoscope [Camera](https://www.amazon.com/Anykit-Megapixels-Inspection-Waterproof-Semi-Rigid/dp/B07NW4C7JG/ref=sr_1_17?keywords=vaginal+camera&qid=1582731129&sr=8-17) applied with an [Applicator](https://www.amazon.com/BoriCap-Suppository-Suppositories-Individually-Recommended/dp/B01M1NJOIF/ref=sr_1_24?keywords=vaginal+camera&qid=1582731694&sr=8-24)
This device is a more likely application for the immediate project yet a stretch goal.



# Javadoc-generated Technical Documentation



# Copyrights and Licenses



# Build Instructions



# Basic User Instructions



# Required Implementation Elements

Multiple Screens with intuitive navigation

Use of the SQLite database

Dynamic data-driven UI components

Use of shared preferences

User login/authentication

Custom drawable assets



# Optional Implementation Elements

Settings screen

Effective separation of concerns

Code quality and style