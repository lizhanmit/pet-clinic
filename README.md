# Spring Pet Clinic Project 

## Project Structure 

pet-clinic (root)
|
|- pet-clinic-data
|- pet-clinic-web

1. Create Maven modules under "pet-clinic" project.
2. Move Application.java and ApplicationTest.java to "pet-clinic-web" module. 
3. Move "static" folder, "templates" folder and "application.properties" file under "resources" folder of "pet-clinic" to "resources" folder of "pet-clinic-web".
4. Move "model" package to "pet-clinic-data" module.   
5. Move pom.xml "actuator", "thymeleaf", "web", "devtools", "test" dependency to "pet-clinic-web" pom.xml. 
6. Move pom.xml "data-jpa", "h2", "mysql", "lombok", "test" (copy this one) dependency to "pet-clinic-data" pom.xml. 
7. Add "pet-clinic-data" dependency in "pet-clinic-web" pom.xml. 

```xml
<dependency>
	<groupId>com.zhandev</groupId>
	<artifactId>pet-clinic-data</artifactId>
	<version>0.0.1-SNAPSHOT</version>
</dependency>
```

8. Add the following in "pet-clinic-data" pom.xml to avoid "Error: Unable to find main class" due to Spring Boot version >= 2.1. 

```xml
<build>
    <plugins>
        <plugin>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-maven-plugin</artifactId>
        <executions>
            <execution>
                <goals>
                    <goal>repackage</goal>
                </goals>
            </execution>
        </executions>
        </plugin>
    </plugins>
</build>

<properties>
    <spring-boot.repackage.skip>true</spring-boot.repackage.skip>
</properties>
```

9. Delete "src" folder of "pet-clinic".
10. For "pet-clinic", "Run As" -> "Maven clean". Then get the following in console.

```
...
[INFO] pet-clinic 0.0.1-SNAPSHOT .......................... SUCCESS [  0.179 s]
[INFO] pet-clinic-data .................................... SUCCESS [  0.007 s]
[INFO] pet-clinic-web 0.0.1-SNAPSHOT ...................... SUCCESS [  0.007 s]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
...
```

11. For "pet-clinic", "Run As" -> "Maven build..." -> set "Goals" as `package`. Then get the following in console.

```
...
[INFO] pet-clinic 0.0.1-SNAPSHOT .......................... SUCCESS [  0.586 s]
[INFO] pet-clinic-data .................................... SUCCESS [  0.718 s]
[INFO] pet-clinic-web 0.0.1-SNAPSHOT ...................... SUCCESS [ 10.582 s]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
```
