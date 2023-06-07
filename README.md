# ClubManagement
[project is still in progress . . .]

## Created with
* Java 17
* Spring Boot 3
* MySQL Database


## About
It is a REST API project allowing to manage football clubs and their staff (coaches, players) using CRUD operations. The end client is supplied with the JSON responses.

**Main functionalities:**
* Football club creation
* Assigning players and coaches to specific club
* Retrieving staff info from club
* Statistics

There are different functionalities to manage system assigned to admin and user.

## Launching and usage

* Download the project to your local machine
```bash
git clone https://github.com/moRR3no/ClubManagement.git
```
* Launch the app with class named [AppApplication.java](https://github.com/moRR3no/ClubManagement/blob/d1663d384b3b3c0895f62937aba7916898d57164/src/main/java/com/clubmanagement/app/AppApplication.java) 

* Open the app in your browser (f.e. GET all clubs)
```bash
http://localhost:8080/clubs
```
Here you can use different requests (GET, POST, PUT, DELETE).
*  To see current database state go to MySQL WorkBench and put login credentials as mentioned in [application.properties](https://github.com/moRR3no/ClubManagement/blob/d1663d384b3b3c0895f62937aba7916898d57164/src/main/resources/application.properties) file.

## Version control: 
- system: GIT
- branches:
  - master – approved latest version
  - develop – improving features
