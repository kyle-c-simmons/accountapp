# Account application

Account application. Stores accounts with first name, surname and account numbers.

## Getting Started

The project is split into 2 parts. Frontend and backend. The backend is written with Java spring boot which contains all the API code 
with MongoDB. The frontend contains the Vue.js and the website code.

* 1) > git clone https://github.com/kyle-c-simmons/accountapp/new/master
* 2) Put the project into an IDE (Eclipse or IntelliJ IDEA etc.)

Default application ports:
Frontend: localhost:8080
Backend: localhost:8090

### Installing

Install the following:
* Install Vue.js
* Install Java
* Install Maven 3+
* Install Mongodb

#### Frontend:
To startup the frontend, go into the frotend directory in the terminal and enter the following:

>npm install

>npm run dev

#### Backend:
To startup the backend, go into the SRC directory in the IDE. Open up the AccountAppApplication class and run the class to execute the 
backend. 

The next step is to run the mongoDB server. This is where all the API data will be stored. Once the mongoDB server is up and running choose a location for the Mongodb database inside the project. Open up the SRC directory, go into Resources and then applications.properties. 

This will contain the following:

> server.port=8090

> spring.data.mongodb.uri=mongodb://localhost:27017/accountapp

The server port can be configured to open the API on a different port. However, were interested in the line below.

> localhost:27017/accountapp

This is the url for the mongoDB database. Change that url to your MongoDB database location. Once done, the project should be ready to start.

## Built With

* HTML5
* CSS3
* SCSS
* Vue.js
* Javascript
* Java7
* Maven
* Spring boot
* MongoDB

## Images

### Account application

![GitHub app image](https://github.com/kyle-c-simmons/accountapp/blob/master/images/app.png)

### Search buttons

![GitHub search image](https://github.com/kyle-c-simmons/accountapp/blob/master/images/search.png)

### Edit users

![GitHub edit image](https://github.com/kyle-c-simmons/accountapp/blob/master/images/edit.png)

### Storing data in the API

![GitHub api image](https://github.com/kyle-c-simmons/accountapp/blob/master/images/api.png)


## Authors

* **Kyle Simmons** - [Github - kyle-c-simmons](https://github.com/kyle-c-simmons)

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details
