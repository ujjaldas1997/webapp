# webapp
A spring boot project demonstrating connection of mongodb database with authentication, maintaining user informations

### Run the application
Go to `localhost:8080`, a login page will appear if the user has not logged in previously

### Invalid credentials
![invalid credentials](https://raw.githubusercontent.com/ujjaldas1997/Data_images/master/webapp/invalid_credentials.png)

### List all the users available in database
![all users](https://raw.githubusercontent.com/ujjaldas1997/Data_images/master/webapp/all_users.png)

### Login and go to dashboard & change your details if necessary
![dashboard](https://raw.githubusercontent.com/ujjaldas1997/Data_images/master/webapp/dashboard.png)

### Provide your details and signup
![signup](https://github.com/ujjaldas1997/Data_images/blob/master/webapp/signup.png?raw=true)



## Note-
The mongodb service should be active
```
● mongod.service - MongoDB Database Server
   Loaded: loaded (/lib/systemd/system/mongod.service; disabled; vendor preset: enabled)
   Active: active (running) since Wed 2019-03-27 09:16:47 IST; 1 weeks 1 days ago
     Docs: https://docs.mongodb.org/manual
 Main PID: 14665 (mongod)
    Tasks: 29
   Memory: 109.2M
      CPU: 29min 9.146s
   CGroup: /system.slice/mongod.service
           └─14665 /usr/bin/mongod --config /etc/mongod.conf
```
