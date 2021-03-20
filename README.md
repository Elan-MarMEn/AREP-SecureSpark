# Secure services
This project focuses on briefly simulating how two different web services work, log sevice for logging control and Store service to (for the moment) only query data, these use different certificates and run on remote AWS machines. 

## Getting Started

Open your comand console or cmd and write or copy the comand below.

```
git clone https://github.com/Elan-MarMEn/AREP-SecureSpark.git
```

### Prerequisites

Make sure that you already have install Maven,java kit Development and GIT correctly. in he case that you don`t konow how to install use the links below:

* [How to install Maven](https://www.youtube.com/watch?v=RfCWg5ay5B0)
* [How to install GIT](https://git-scm.com/book/en/v2/Getting-Started-Installing-Git)
* [How to install Docker to Windows](https://docs.docker.com/docker-for-windows/install/)
* [How to install Docker to Linux](https://docs.docker.com/engine/install/ubuntu/)
* [How to install Docker-compose to Linux](https://www.digitalocean.com/community/tutorials/how-to-install-and-use-docker-compose-on-ubuntu-20-04-es)

## Compile and Running
Get in to your cmd and use the commands below

```
mvn clean install

mvn package
```

For get the javadoc use:

```
mvn javadoc:javadoc
```

## Architecture Security 

![](/img/arquitectura.png)

The security architecture is emphasized in the use of different certificates that are used by each of the services that are presented in the project. These certificates allow me to limit the access and consumption of these services, which, used on a larger scale, prevent each service, by itself, from being exposed and more vulnerable.


In addition to using these certificates, an md5 hash is implemented to encrypt the passwords of the users that in the long run gives me access control, establishing a pseudo-lock towards the second service.

## Video: Sample Running Remote

[Click to see the video](https://github.com/Elan-MarMEn/pruebita/raw/main/video/TestVideo.mkv)

## Local Running

If you want to run the appweb on a local port 
you must use the comand below for windows:
```
java  -cp target/classes;target/dependency/* edu.escuelaing.arep.secure.app.LogService.LogServiceApp
java  -cp target/classes;target/dependency/* edu.escuelaing.arep.secure.app.StoreService.StoreserviceApp
```
for Unix:
```
java $JAVA_OPTS -cp target/classes:target/dependency/* edu.escuelaing.arep.secure.app.LogService.LogServiceApp
java $JAVA_OPTS -cp target/classes:target/dependency/* edu.escuelaing.arep.secure.app.StoreService.StoreserviceApp
```

Use the next comand to know the result of the tests

```
mvn test
```

## Built With

* [Java 8](https://www.java.com/es/about/whatis_java.jsp) 
* [Maven](https://maven.apache.org/) - Dependency Management
* [Docker](https://www.docker.com/) - Image Container
* [Spark](http://sparkjava.com/) - Web framework


## Authors

* **Alan Marin** - *Initial work* - [Elan-MarMEn](https://github.com/Elan-MarMEn)


## License

This project is licensed under the General Public License (GNU) - see the [LICENSE.md](LICENSE.md) file for details
