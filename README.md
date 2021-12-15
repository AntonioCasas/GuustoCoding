# GuustoCoding

Hi Alan and Felipe

Here is the code for the backend I was working on for the coding challenge.
My idea was to create microservices to handle the bussines logic, created an authorization microservice and a server that works as a gateway.
Some of the microservices comunicate to others and some others don't.

You can notice that I didnt make a front or complete the docker container for all of the services.
I already passed the time limit that I had to complete this and still have lots of more thing to learn to use all this properly.

Even when this didnt go as I expected, it was a great chance to put what I'm learning in practice.

Thanks a lot.
Regards

Here is an update with some info about the code itself.

As I didnt make it to the point of make the Dockers for deployment 
You would have to create a databse named "guusto" in postgres

Then run the "discoveryserver" as a spring boot app or just execute the main class in it.
Then you can run "users", "merchants", "account" and "codes" in this order (This are the logic services)
Then you can run "auth" which is for authentication 
And "zuulgateway" at the end as its the gateway server

Ran n this way the projects generate some test data on tables:
users
merchants
accounts

and will be ready for the next calls.

The next are the payload you can use to call the services using postman or other similar app : 


To authenticate :
localhost:8090/api/oauth/token
Authorization tab 
	 username : frontApp, 
	 password : 654321
Body tab : x-www-form-urlencoded
	username : admin,
	password : password,
	grant_type : password 

This because the clients need to be registered to talk to the services 

Collect the access_token from the response.
This token  need to be added as a bearer token on the next requests

Merchants :
List all the merchants on the DB 
GET : localhost:8090/api/merchant/merchants  

Gets one of the merchants
GET : localhost:8090/api/merchant/merchants/{merchantId}


Users : 
Gets one user by username
GET : localhost:8090/api/user/user/{username}

Accounts : 
Get one account based on the Id
GET : localhost:8090/api/account/account/{accountid}

updates an account 
PUT : localhost:8090/api/account/account
Body tab - raw (Json type)
{
    	"id": "1",
    	"user_id": "1",
    	"amount": "400.0"
}


