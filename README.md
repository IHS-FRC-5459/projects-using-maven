# projects-using-maven

This project was created to show how to use Maven as a build tool for robotics components.  Here's the link for maven
  * Apache-Maven project - http://maven.apache.org/
  
The files named __pom.xml__ control the building.  Managing the way it builds is a pain in the neck, but maven makes it easier.  Using Maven, you can : 
  * Build all the projects and create the __artifacts__ (jars) from the sources 
  * Automatically run the test cases
  * Easily upgrade libraries (jars) that the project depends on.
  * Easily add new projects.
  
  
The top level project is called : ihsfirst-2017

The sub-project underneath is in folder ihsfirst-2017/strongback and contains sources from the project "Strongback".
Using maven, from the top level (ihsfirst) run the following command to build ALL the projects referenced in "pom.xml"
```
mvn clean compile
```

You will need to download and install Maven to use this from the command line.  Mars Eclipse has a 
maven plugin for importing projects.  If you have problems installing it from the directions in the http://apache.maven.org 
let me know.



Link to a [Different Readme][altreadme]

[altreadme]: (strongback/README.md)
