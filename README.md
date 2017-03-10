# Hibernate_Advanced

* Make sure that mySQL db is installed with username as root and password as password.
* Also create a schema called Athena in the DB

For first time users of this program, changes to be made in the hibernate-cf.xml
```
Uncomment the line
<property name="hbm2ddl.auto">create</property>
And comment the line
<property name="hbm2ddl.auto">validate</property>

The create option in this scenario, will create the Employee and Address tables under Athena Schema
```

Once the tables are created revert the changes done in the above scenario 
```
comment the line
<property name="hbm2ddl.auto">create</property>
And Uncomment the line
<property name="hbm2ddl.auto">validate</property>
```


* Projections in Hibernate
* @Transient
* Update data in the tables by updating a view
