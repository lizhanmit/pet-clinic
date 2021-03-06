# Spring Pet Clinic Project

## Project Structure

```
pet-clinic (root)
|
|-- pet-clinic-data
|-- pet-clinic-web
```

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

11. For "pet-clinic", "Run As" -> "Maven build..." -> set "Goals" as `package` -> Run. Then get the following in console.

```
...
[INFO] pet-clinic 0.0.1-SNAPSHOT .......................... SUCCESS [  0.586 s]
[INFO] pet-clinic-data .................................... SUCCESS [  0.718 s]
[INFO] pet-clinic-web 0.0.1-SNAPSHOT ...................... SUCCESS [ 10.582 s]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
...
```

---

## Maven Release Plugin

Maven Release Plugin is used to create releases of your artifacts. Releasing a project is made in two steps: prepare and perform.

1. Add "maven-release-plugin" and "scm" in "pet-clinic" pom.xml.

```xml
<plugin>
	<groupId>org.apache.maven.plugins</groupId>
	<artifactId>maven-release-plugin</artifactId>
	<configuration>
		<goals>install</goals>
		<autoVersionSubmodules>true</autoVersionSubmodules>
	</configuration>
</plugin>
```

SCM refers to Source Control Management.

```xml
<scm>
	<developerConnection>scm:git:git@github.com:lizhanmit/pet-clinic.git</developerConnection>
	<tag>HEAD</tag>
</scm>
```

2. In terminal, `mvn release:prepare`. Then get the following.

```
...
[INFO] Release preparation complete.
...
[INFO] pet-clinic ......................................... SUCCESS [ 56.711 s]
[INFO] pet-clinic-data .................................... SKIPPED
[INFO] pet-clinic-web ..................................... SKIPPED
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
...
```

**Troubleshooting**

Problem

```
...
[ERROR] The git-tag command failed.
[ERROR] Command output:
[ERROR] fatal: tag 'pet-clinic-0.0.1' already exists
...
```

Solution

i. In terminal, `git fetch --tags`.

ii. In terminal, `mvn release:clean`. Then get the following.

```
...
[INFO] Cleaning up after release...
...
[INFO] pet-clinic ......................................... SUCCESS [  0.361 s]
[INFO] pet-clinic-data .................................... SKIPPED
[INFO] pet-clinic-web ..................................... SKIPPED
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
...
```

3. In terminal, `mvn release:perform`. Then get the following.

```
...
[INFO] Cleaning up after release...
...
[INFO] pet-clinic ......................................... SUCCESS [01:51 min]
[INFO] pet-clinic-data .................................... SKIPPED
[INFO] pet-clinic-web ..................................... SKIPPED
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
...
```

**Troubleshooting**

Problem

```
...
[ERROR] The git-push command failed.
...
[ERROR] git@github.com: Permission denied (publickey).
[ERROR] fatal: Could not read from remote repository.
...
```

Reason: No SSH Key on this machine.


Solution

i. [Generating a new SSH key and adding it to the ssh-agent](https://help.github.com/articles/generating-a-new-ssh-key-and-adding-it-to-the-ssh-agent/)

ii. [Adding a new SSH key to your GitHub account](https://help.github.com/articles/adding-a-new-ssh-key-to-your-github-account/)

iii. ([Error: Permission denied (publickey)](https://help.github.com/articles/error-permission-denied-publickey/))

---

## Bootstrap Code for Startup Processes

Create a bootstrap class to execute startup processes, e.g. data loading or initialization. 

1. Create "bootstrap" package under "pet-clinic-web". 
2. Create "DataLoader" class under "bootstrap" package. 
3. Make the class implement `CommandLineRunner`. (This is Spring Boot specific way whereas there are other different ways.)
4. Annotate `@Component` for the class. 
5. Override `run()` method and write bootstrap code in it.

Another way: 

Step 1. and 2. are the same as the above. 

3. Make the class implement `ApplicationListener<ContextRefreshedEvent>`.
4. Annotate `@Component` for the class.  
5. Override `onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent)` method and write bootstrap code in it.

---

## Class Explanation

### pet-clinic-data -> com.zhandev.petclinic.service.map

- "OwnerServiceMap", "PetServiceMap" and "VetServiceMap" class are implementations of corresponding service interface under "com.zhandev.petclinic.service" package. 
- As these service implementations have common property and methods, so we extract an abstract service class - "AbstractMapService" - making them extend it. 