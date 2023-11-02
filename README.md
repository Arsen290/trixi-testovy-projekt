# trixi-testovy-projekt
 
This Java application is designed to download data in XML format from the internet, process it, and store it in a SQL database. The data is extracted from a zipped XML file available at a specific URL, containing addresses in the town of Kopidlno. The application populates two database tables: 'obec' and 'cast obce,' where 'obec' stores code and name information, and 'cast obce' stores code, name, and the code of the related town. 

## Installation 
 
To run this application, you'll need to follow these steps: 
 
### Prerequisites 
 
Before you begin, ensure you have met the following requirements: 
 
- Java Development Kit (JDK) 17 or higher installed 
- Apache Maven for building the project 
- A PostgreSQL database set up 
 
### Step 1: Clone the Repository 
 
``` 
git clone https://github.com/yourusername/trixitest.git 
```

### Step 2: Build the Project 
<p>Navigate to the project directory and build it using Maven:</p>

Open the directory
```
cd trixitest 
```

Mvn install
```
mvn clean install 
```

### Step 3: Set Up the Database 

<p>Create a PostgreSQL database for the application. You can use the following configuration in your application.properties:</p>

``` 
spring.datasource.url=jdbc:postgresql://localhost:5432/trixi_db 
spring.datasource.username=postgres 
spring.datasource.password=yourpassword 
spring.datasource.driver-class-name=org.postgresql.Driver 
/** 
 *Make sure to replace yourpassword with your actual PostgreSQL password. 
 */
```

### Step 4: Run the Application 
You can run the application using the Spring Boot Maven plugin: 
 
```
mvn spring-boot:run 
```
<p>The application should now be accessible at http://localhost:8080. Use a web browser or tools like Postman to interact with it.</p>

## Usage 
<p>To use the application, perform a GET request to the /download endpoint. This triggers the download, XML processing, and database population.</p>

Example using cURL: 
 
```
curl http://localhost:8080/download 
```

<p>For more information on using the application, refer to the controller in the project.</p>

## Configuration 
<p>You can find configuration settings in the application.properties file.</p>
 
### License 
<p>This project is licensed under the MIT License - see the LICENSE.md file for details.</p>
 
### Credits 
<p>This project uses Spring Boot, PostgreSQL, and other open-source libraries.</p>

### Contact 
<p>For questions, feedback, or collaboration, you can contact me.</p>
