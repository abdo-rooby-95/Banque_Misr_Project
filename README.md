# Banque_Misr_Project: Automatic irrigation system
SpringBoot Microservice provides full automation for irrigation based functionalities,
* Prerequisites:
  1- Java (>= 8)
  2- Maven
  3- MySQL server
* How to run it:
  1 - Create DB on MySQL server then make sure you update 'application.properties' under 'BanqueMisrProject/src/main/resources' with your DB name, username, url and password
  2 - Build the executable file(JAR or WAR) -> clone the project then run -> mvn clean package(for Windows)
  3 - Run the excutable file like this -> java -jar BanqueMisrProject-1-0.0.1-SNAPSHOT.jar(for Windows)
