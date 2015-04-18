Web Project
===========

**Used technologies:**
* Java Core
* Servlets/JSP
* JDBC
* JNDI - to obtain local DataSource

Simple Web Project which gets a clear vision of how to use JDBC, implement DAO layer,
implement Controller layer and integrate it with view. Also a simple example of how to get 
javax.mysql.DataSourse instance through JNDI exists there.
Project's data model consists of two entities Shop and Item. One shop can have many items.
Database script you can find in /res/shop_service_db_script

To run project - deploy it in Tomcat. Then go to
http://localhost:8080/WebProject


