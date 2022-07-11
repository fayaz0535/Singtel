# todoproject

## Pre-requisites

1) Install JAVA JDK 18  [java download page](https://www.oracle.com/java/technologies/downloads/#jdk18-windows/)

> *Note*: Set JAVA_HOME pointing to installed directory of java example: C:/Program Files/Java/jdk-18.0.1 and "%JAVA_HOME%/bin" to the *PATH* variable

2) Install apache maven version v3.8.6 [Maven download page](https://maven.apache.org/download.cgi)

> *Note*: After extracting Files - Set MAVEN_HOME pointing to installed directory of Maven example: MAVEN_INST_DIR/apache-maven-3.8.6 and "%MAVEN_HOME%/bin" to the *PATH* variable

3) Install Latest Firefox v102 [Firefox download page](https://www.mozilla.org/en-US/firefox/new/)

4) Install ALLURE Commandline [Allure Commandline download page](https://repo.maven.apache.org/maven2/io/qameta/allure/allure-commandline/2.18.1/)

> Note: Download allure-commandline-2.18.1.zip & after unzipping files - execute allure.bat file by double clicking on it from bin directory  & set the allure bin directory in the PATH variable.

5) Install IntelliJ IDE [Intellij download page](https://www.jetbrains.com/idea/download/#section=windows)

6) Install Git for windows [Git download page](https://git-scm.com/download/win)

> **Note** : Complete `the pre-requisites` to run the test & follow below commands.

## **How to Run Test?**

1) Clone the git repository from intellij IDE & make use of URL https://github.com/fayaz0535/todoproject.git

> From Intellij IDE Main menu GIT-> Clone. It can be cloned to any directory on your local machine.

2) Open the POM file in the IDE & cross check plugin  **maven-compiler-plugin** section for tag **<execuable>** 
> **Note**: It should point to javac folder of Java installation directory otherwise the program might not compile & will lead to compilation errors.
			
			<plugin>
								<artifactId>maven-compiler-plugin</artifactId>
								<version>3.8.0</version>
								<configuration>
									<source>1.8</source>
									<target>1.8</target>
									<fork>true</fork>
									<executable>C:\Program Files\Java\jdk-18.0.1.1\bin\javac</executable>
								</configuration>
			</plugin>

3) Open Command line & from Project directory where POM file exists issue command **mvn clean install**

4) After the completion of Step 2  open the command line & from Project directory where POM file exists issue command "**allure serve allure-results**"
> **Note**: You should now be able to see the Test Execution Results in the browser

![image](https://user-images.githubusercontent.com/30147967/178237499-b09e8756-58b5-4ada-b44a-7368290eabfb.png)

![image](https://user-images.githubusercontent.com/30147967/178236884-0f2a15b0-9458-4540-b379-00d2a3d0b8fd.png)

![image](https://user-images.githubusercontent.com/30147967/178237248-b79f5064-7c42-4c69-83c3-850c798d07ac.png)


