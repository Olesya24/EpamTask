# Web service 
Task: Create a web service for working with ads.

The user can:

* Create advertisement;
* Remove advertisement;
* Search for advertisements by a unique identifier;
* Display all advertisements based on a unique user ID.

Domain models are stored in [Postgresql](https://www.postgresql.org/). 

Database: Task3

Tables with fields:
1. Advertisement
    * adID - unique identifier (id);
    * adTitle - title ;
    * adCategory;
    * adDescription;
    * adPhone;
    * adCreationDate;
    * authorId - foreign key (linked userId in table User)
2. User
   * userId;
   * userName;
   * userSurname;
   * userEmail;
   * userCategory - category (Individual Or legal entity).
   
The service is developed on the REST architecture, data saving are performed in JSON format.

__*Package DBUtils*__ stores  Postgresql connection 

```
URL = "jdbc:postgresql://localhost:5432/Task3";
USER = "postgres";
PASS = "hhh56ggg";
```

__*Package repositories*__ stores the database queries

__*Package controllers*__ stores controllers which handle GET and POST requests


## Create advertisement

__*POST /advertisements*__

200 - advertisement created

400 - bad request, can't create advertisement with such id

## Remove advertisement

__*DELETE /advertisements/{adId}*__

Parameters:

id - long id

200 - advertisement deleted

404 - not found, can't delete advertisement with such id


## Search for advertisements by a unique identifier

__*GET /advertisements/{adId}*__

Parameters:

id - long id

200 - returns advertisement with such id

404 - not found, there is no such advertisement

## Display all advertisements for user ID

__*GET /advertisements/{authorId}*__

Parameters:

id - long id

200 - returns list of advertisements for user

404 - not found, if list is empty

## Create user

__*POST /users*__

201 - created, user created

400 - bad request, can't create user with such id

## Remove user

__*DELETE /users/{userId}*__

Parameters:
id - long id

200 - user deleted

404 - not found, can't delete user with such id
