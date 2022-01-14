# pfseven-smdb
A project issued by **Project Future 7** powered by ReGeneration. This assignment aimed to familiarize us with the Spring
Boot framework as well as to many good development practices, learned during the second week of training.

**The task** was to develop a **Sample Movie Database (SMDB)** using the Spring Boot framework. An online database of
information related to films, television programs - including cast, production crew, plot summaries, genre, ratings,
among others.

# Functionality
## Domain Model
Our system consists of several entities with the most basic being the Person, Movie, Series, Episode and Occupation.

![pfseven-smdb_uml_domain_2022-01-14](https://user-images.githubusercontent.com/10975341/149506543-1b51d74d-5723-47c7-916a-b9dbda3487d8.png)

## Sample Data Generation
We have generated some corresponding sample data to feed the services under development. They can be found in the 
bootstrap package created by several CommandLineRunner classes. More specifically we are initializing our database with 
20 people, 10 movies, 2 series and 4 episodes (2 for each series).

## Basic Architecture
For every domain class, we have created the corresponding class in every basic architecture layer. There is support for 
all basic actions and at least three retrieving actions per domain class.

## Search
The site's visitor can freely search throughout the entire set of domain classes. The results indicate the type of 
returning information. Every domain class have a dedicated controller to serve the respective content. Depending on the 
domain class, it returns all associated content.

## Data Backup
The system provides a functionality to export the database data to CSV files. The functionality is triggered by a 
REST call.

## Reports
The system support the following reports:
1) Return the top X high-rated content.
2) Return all content associated with a given individual regardless of his/her contributing role.
3) ~~Return all content associated with a given individual for a given contributing role.~~
4) Return all content for a given genre.
5) Return the numbers of shows per genre.
6) Return the numbers of shows per year per genre.
7) ~~Return all content associated with a given individual organized per genre.~~

# Non-functional Qualities
## Logging

## Software Quality
Every call always return a valid JSON document including the cases where something went wrong, due to either a 
development bug or system reasons.

Depending on the type of the call (GRUD actions), the proper HTTP code is returned:
- 200 OK
- 201 Created
- 202 Accepted
- 204 No Content
- 400 Bad Request
- 401 Unauthorized
- 403 Forbidden
- 404 Not Found
- 500 Internal Server Error
