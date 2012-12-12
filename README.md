Sample app to get to know GWT, Guice, Gin, and Maven (and doesn't it seem like Maven should start with G to fit in?). RequestFactory is used on the client to get data from JPA on the server, from an H2 database. For the most part, we've tried to use fairly standard tools to make it clear how one can start a less-than-trivial project, but here and there we have embellished.

In an effort to get the page loading as quickly as possible, we're using a GWT split point to let part of the app load, then start asking the server for information about the user, if they are logged in, what we know about them, etc. If they are not logged in, either we let them read the data (as a guest user), or allow them to log in or create an account.

Data is loaded as needed, and is not yet cached on the client. In theory, the ProxySerializer of RequestFactory can be used to keep a local cache of data the server has provided in the past, but there is no obvious way to invalidate entries in the cache in response to feedback from the server (Operation.DELETE, Operation.UPDATE).

To build this, you will also need celltable-tools, currently just a snapshot build, available at https://github.com/niloc132/celltable-tools.

This project is built using CloudBee's BuildHive at https://buildhive.cloudbees.com/job/niloc132/job/tvguide-sample-parent/