# Dlocal-payment-Manager

Payment Manager Application:

RESTful application to manage and save data on Merchants and Sales transaction.
Exposing few REST end point to control the system, and using external API (fixer.io) for currency conversion.

**Usage**
   
1. Open terminal/Command line

2. Within the Jar folder location, use 
	Java -jar XXX.jar

3. Open http://localhost:8080/swagger-ui.html to see the available REST endpoint.

Need to configure MYSQL db with name=dlocaldb , username=root, password=dlocal.
please see DB configuration in application.properties

**Entities:**

There are two main entities which the system consist of:

**Merchant** -Simple entity representing Merchant in the system.

**Sale** - Represent a sale/transaction in the system.
	   each Sale consist of Merchant id,Transaction id and amount.
	   in addition, date and Unique Id is attache to the Sale schema.


**DB Schemas:**
Each one of the above entities represented by MySql table.


**REST Api Endpoint:**
The available methods can be view from Swagger Ui Dashboard.
When the application is Running, go to:

**http://localhost:8080/swagger-ui.html**

**Merchant** - Create, isExistById

**Sale** - create ,getBalance,  getSaleById


**Technology:**

* **Spring Boot 2** - The application is managed by Spring Boot 2.

* **Hibernate** implementation for JPA and MySql as the SQL server.

* **H2 DB** - used while for development purpose.

* **Server** - the application runs over Jetty, listening to port 8080.

* **Third party API- fixer.io:** - Used to get currency conversion rates in real time.

* **Cache management** - Spring boot Cache with Caffeine framework - store in cache currency rates. The cache expire time was set to 30 seconds after writing.





**Insert Sale records example:**

insert into SALE  (id, amount,creation_date,merchant_id,status,transaction_id)   values(1,100,'2018-06-20',1,1,10) ;

insert into SALE  (id, amount,creation_date,merchant_id,status,transaction_id)   values(2,200,'2018-06-20',1,1,20) ;

insert into SALE  (id, amount,creation_date,merchant_id,status,transaction_id)   values(3,300,'2018-06-20',1,1,30) ;

insert into SALE  (id, amount,creation_date,merchant_id,status,transaction_id)   values(4,500,'2018-06-20',1,1,40) ;

insert into SALE  (id, amount,creation_date,merchant_id,status,transaction_id)   values(5,500,'2018-06-20',1,1,50) ;

insert into SALE  (id, amount,creation_date,merchant_id,status,transaction_id)   values(6,600,'2018-06-20',1,1,60) ;

insert into SALE  (id, amount,creation_date,merchant_id,status,transaction_id)   values(7,700,'2018-06-20',1,1,70) ;

insert into SALE  (id, amount,creation_date,merchant_id,status,transaction_id)   values(8,800,'2018-06-20',1,1,80) ;

insert into SALE  (id, amount,creation_date,merchant_id,status,transaction_id)   values(9,900,'2018-06-20',1,1,90) ;

insert into SALE  (id, amount,creation_date,merchant_id,status,transaction_id)   values(10,1000,'2018-06-20’,1,1,100) ;



