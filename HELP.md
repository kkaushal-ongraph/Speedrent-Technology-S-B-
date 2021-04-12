We Need to Insert Admin and User into role Table first.
  
INSERT INTO roles(name) VALUES('ROLE_USER');
INSERT INTO roles(name) VALUES('ROLE_ADMIN');

Create An account on signup api ===>

Url :localhost:8080/api/auth/signup
Type: POST

Body :
     {
    "username":"amitadmin",
    "password":"123456",
    "email":"admin@gmail.com",
    "role":["admin"]
}

SignIn to get Token ===>

Url : localhost:8080/api/auth/signin
Type: POST


Body : {
    "username":"amitadmin",
    "password":"123456"
}


Create Property ===>


Url: localhost:8080/api/property
Type: POST

Body :
     {
    "property_name":"1stOne"
}

Update Property ===>

Url: localhost:8080/api/property
Type: PUT

Body :
      {
     "id":1,
    "property_name":"UpdatedOne"
}


Get All Property ===>

Url: localhost:8080/api/property
Type: GET


Get Property By Id ===>

Url: localhost:8080/api/property/{id}
Type: GET



Approve Property (accessable via Admin Only) ===>


Url: localhost:8080/api/property/approve/{id}
Type: GET

*To Access Secured Api , you need to send Authorization in Header like this "Bearer {your_token}"
*In Case of Invalid Token we are throwing 401 error (UnAuthorized Access)
*In Case of Specific Role doesnot have access to that particular Api we are throwing 401 error (forbidden)
*When Property Id doesnot exist in case of Property Get By Id or Update Api , we are throwing 400 error (Bad Request)

