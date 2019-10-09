Spring boot server

## Overview 
This service depends on a mongodb running on port 27017. The docker-compose would ordinarily launch everything, but is incompatible with my current java setup due to a classpath issue.

You could just run the two seperately, using `mongod` and running the main class `BootServer`.

See the swagger docs running on http://localhost:8080/truck/swagger-ui.html as well as the included postman collection, and video at https://www.youtube.com/watch?v=6TtzVROETV4&feature=youtu.be
