FROM openjdk:8

WORKDIR /logservice/bin

ENV PORT 6000

COPY /target/classes /logservice/bin/classes
COPY /target/dependency /logservice/bin/dependency
RUN mkdir keyscerts
COPY keyscerts /logservice/bin/keyscerts

CMD ["java","-cp","./classes:./dependency/*","edu.escuelaing.arep.secure.app.LogService.LogServiceApp"]