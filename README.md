# Getting Started

This is the resources' server, it will contain Data.

Users can't request data unless they are authenticated in Authorization Server

It uses a volatile DB H2 to store data (currently we have one table Utilisateur holding users' details).

DB is populated when server is set up (SQL script : resources/data.sql)



To run this project locally you'll need Java 11 .


1. To run in project dir:

mvnw spring-boot:run 

